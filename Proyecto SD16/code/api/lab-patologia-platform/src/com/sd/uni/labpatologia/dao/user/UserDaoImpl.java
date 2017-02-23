package com.sd.uni.labpatologia.dao.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.uni.labpatologia.dao.base.BaseDaoImpl;
import com.sd.uni.labpatologia.domain.user.UserDomain;
import com.sd.uni.labpatologia.exception.PatologyException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

@Repository
public class UserDaoImpl extends BaseDaoImpl<UserDomain> implements IUserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public UserDomain save(UserDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public UserDomain getById(Integer domainId) {
		return (UserDomain) sessionFactory.getCurrentSession().get(UserDomain.class, domainId);
	}

	@Override
	public List<UserDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserDomain.class);
		return criteria.list();
	}

	@Override
	public List<UserDomain> find(String textToFind, int page, int maxItems) throws PatologyException {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserDomain.class, "user").createAlias("user._rol", "rol");;
		if (textToFind != null) {
			Map<String, String> map = obtenerQuery(textToFind);
			if (map.containsKey("text")) {
				String text = map.get("text");
				Criterion propertyCriterion = Restrictions.disjunction()
						.add(Restrictions.ilike("_name", "%" + text + "%"))
						.add(Restrictions.ilike("_registrationNumber", "%" + text + "%"))
						.add(Restrictions.ilike("_lastName", "%" + text + "%"))
						.add(Restrictions.ilike("_userName", "%" + text + "%"));
				Criterion idCriterion = null;
				if (StringUtils.isNumeric(text)) {
					idCriterion = Restrictions.disjunction().add(Restrictions.eq("_id", Integer.valueOf(text)));
				}
				if (idCriterion != null) {
					criteria.add(Restrictions.or(propertyCriterion, idCriterion));
				} else {
					criteria.add(propertyCriterion);
				}
			}if (map.containsKey("sort")) {
				String sort = (map.get("sort"));
				if(sort.equals("_name") || sort.equals("_registrationNumber") || sort.equals("_userName")){
					if (map.containsKey("order")){
						String order = (map.get("order"));
						if(order.equals("desc")){
							criteria.addOrder(Order.desc(sort).ignoreCase());
						}else{
							criteria.addOrder(Order.asc(sort).ignoreCase());
						}
					}else{
						criteria.addOrder(Order.asc(sort).ignoreCase());
						criteria.addOrder(Order.asc(sort).ignoreCase());
					}
				}else if(sort.equals("_rol")){
					if (map.containsKey("order")){
						String order = (map.get("order"));
						if(order.equals("desc")){
							criteria.addOrder(Order.desc("rol._name"));
						}else{
							criteria.addOrder(Order.asc("rol._name"));
						}
					}else{
						criteria.addOrder(Order.desc("rol._name"));
					}
				}
			}else{
				criteria.addOrder(Order.asc("_name").ignoreCase());
			}
		}else{
			criteria.addOrder(Order.asc("_name"));
		}
		
		criteria.setFirstResult(page * maxItems);
		criteria.setMaxResults(maxItems);
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<UserDomain> users = criteria.list();
		return users;
	}

	public UserDomain getByUsername(String name) {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("select * from user where username=:name");
		query.addEntity(UserDomain.class);
		query.setString("name", name);
		return (UserDomain) query.uniqueResult();
	}

	/**
	 * Creo un diccionario con clave valor En donde clave=columna de la bd y
	 * valor=valor a buscar
	 * 
	 * @throws PatologyException
	 */
	private Map<String, String> obtenerQuery(String textToFind) throws PatologyException {
		String[] params = textToFind.split("&");
		Map<String, String> map = new HashMap<String, String>();
		try {
			for (String param : params) {
				String name = param.split("=")[0];
				String value = param.split("=")[1];
				map.put(name, value);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new PatologyException("Formato de ruta invalido", e);
		}
		return map;
	}
}
