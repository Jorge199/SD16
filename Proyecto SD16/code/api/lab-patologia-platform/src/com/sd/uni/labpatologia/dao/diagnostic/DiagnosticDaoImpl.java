package com.sd.uni.labpatologia.dao.diagnostic;

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
import com.sd.uni.labpatologia.domain.diagnostic.DiagnosticDomain;
import com.sd.uni.labpatologia.exception.PatologyException;

@Repository
public class DiagnosticDaoImpl extends BaseDaoImpl<DiagnosticDomain> implements IDiagnosticDao {
	@Autowired
	private SessionFactory _sessionFactory;

	@Override
	public DiagnosticDomain save(DiagnosticDomain domain) {
		_sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public DiagnosticDomain getById(Integer domainId) throws PatologyException {
		if (null != domainId) {
			return (DiagnosticDomain) _sessionFactory.getCurrentSession().get(DiagnosticDomain.class, domainId);
		} else {
			throw new PatologyException("El ID no puede ser null");
		}
	}

	@Override
	public List<DiagnosticDomain> findAll() {
		final Criteria criteria = _sessionFactory.getCurrentSession().createCriteria(DiagnosticDomain.class);
		return criteria.list();
	}

	public int getCount() {
		final Criteria criteria = _sessionFactory.getCurrentSession().createCriteria(DiagnosticDomain.class);
		return criteria.list().size();
	}
	
	@Override
	public List<DiagnosticDomain> find(String textToFind, int page, int maxItems) {
		Session session = _sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(DiagnosticDomain.class);
		if (textToFind != null){
			Map<String, String> map = obtenerQuery(textToFind);
			if (map.containsKey("text")) {
				String text = map.get("text");
				Criterion propertyCriterion = Restrictions.disjunction()
						.add(Restrictions.ilike("_name", "%" + text + "%"))
						.add(Restrictions.ilike("_description", "%" + text + "%"));
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
				if(sort.equals("_name") || sort.equals("_description")){
					if (map.containsKey("order")){
						String order = (map.get("order"));
						if(order.equals("desc")){
							criteria.addOrder(Order.desc(sort).ignoreCase());
						}else{
							criteria.addOrder(Order.asc(sort).ignoreCase());
						}
					}else{
						criteria.addOrder(Order.asc(sort).ignoreCase());
					}
				}
			}
			
		}
		criteria.addOrder(Order.asc("_name").ignoreCase());
		criteria.setFirstResult(page*maxItems);
		criteria.setMaxResults(maxItems);
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<DiagnosticDomain> diagnostic = criteria.list();
		return diagnostic;
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