package com.sd.uni.labpatologia.dao.doctor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.uni.labpatologia.dao.base.BaseDaoImpl;
import com.sd.uni.labpatologia.domain.doctor.DoctorDomain;
import com.sd.uni.labpatologia.exception.PatologyException;

@Repository
public class DoctorDaoImpl extends BaseDaoImpl<DoctorDomain> implements IDoctorDao {
	@Autowired
	private SessionFactory _sessionFactory;

	@Override
	public DoctorDomain save(DoctorDomain domain) {
		_sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public DoctorDomain getById(Integer domainId) throws PatologyException {
		if (null != domainId) {
			return (DoctorDomain) _sessionFactory.getCurrentSession().get(DoctorDomain.class, domainId);
		} else {
			throw new PatologyException("El ID no puede ser null");
		}
	}

	@Override
	public List<DoctorDomain> findAll() {
		final Criteria criteria = _sessionFactory.getCurrentSession().createCriteria(DoctorDomain.class);
		return criteria.list();
	}

	public int getCount() {
		final Criteria criteria = _sessionFactory.getCurrentSession().createCriteria(DoctorDomain.class);
		return criteria.list().size();
	}
	
	@Override
	public List<DoctorDomain> find(String textToFind, int page, int maxItems) {
		Session session = _sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(DoctorDomain.class);
		if (textToFind != null){
			Map<String, String> map = obtenerQuery(textToFind);
			if (map.containsKey("text")) {
				String text = map.get("text");
				Criterion propertyCriterion = Restrictions.disjunction().add(Restrictions.ilike("_name", "%"+text+"%"))
						.add(Restrictions.ilike("_last_name", "%"+text+"%"))
						.add(Restrictions.ilike("_address", "%"+text+"%"))
						.add(Restrictions.ilike("_phone", "%"+text+"%"))
						.add(Restrictions.ilike("_speciality", "%"+text+"%"))
						.add(Restrictions.ilike("_email", "%"+text+"%"))
						.add(Restrictions.ilike("_ci", "%"+text+"%"));	
				Criterion idCriterion = null;
				if (StringUtils.isNumeric(text)) {
					idCriterion = Restrictions.eq("_id", Integer.valueOf(text));
				}
				if (idCriterion != null) {
					criteria.add(Restrictions.or(propertyCriterion, idCriterion));
				} else {
					criteria.add(propertyCriterion);
				}
			}
			if (map.containsKey("sort")) {
				String sort = (map.get("sort"));
				if(sort.equals("_name") || sort.equals("_last_name") || sort.equals("_sex") || sort.equals("_ci") || sort.equals("_address") || sort.equals("_speciality") || sort.equals("_email") || sort.equals("_phone")){
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
				}
			}else{
				criteria.addOrder(Order.asc("_name").ignoreCase());
				criteria.addOrder(Order.asc("_last_name").ignoreCase());
			}
			
			
		}else{
			criteria.addOrder(Order.asc("_name").ignoreCase());
			criteria.addOrder(Order.asc("_last_name").ignoreCase());
		}
		//criteria.addOrder(Order.asc("_last_name").ignoreCase());
		//criteria.addOrder(Order.asc("_name").ignoreCase());
		criteria.setFirstResult(page*maxItems);
		criteria.setMaxResults(maxItems);
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<DoctorDomain> doctors = criteria.list();
		return doctors;
	}
	
	/**
	 * Creo un diccionario con clave valor En donde clave=columna de la bd y
	 * valor=valor a buscar
	 */
	private Map<String, String> obtenerQuery(String textToFind) {
		String[] params = textToFind.split("&");
		Map<String, String> map = new HashMap<String, String>();
		try {
			for (String param : params) {
				String name = param.split("=")[0];
				String value = param.split("=")[1];
				map.put(name, value);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		return map;
	}

	

}