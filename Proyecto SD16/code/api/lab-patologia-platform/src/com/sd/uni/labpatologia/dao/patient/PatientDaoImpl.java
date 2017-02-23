package com.sd.uni.labpatologia.dao.patient;

import java.text.SimpleDateFormat;
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
import com.sd.uni.labpatologia.domain.patient.PatientDomain;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.util.SexEnum;

@Repository
public class PatientDaoImpl extends BaseDaoImpl<PatientDomain> implements IPatientDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public PatientDomain save(PatientDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public PatientDomain getById(Integer domainId) throws PatologyException {
		return (PatientDomain) sessionFactory.getCurrentSession().get(PatientDomain.class, domainId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PatientDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PatientDomain.class);
		return criteria.list();
	}

	public int getCount() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PatientDomain.class);
		return criteria.list().size();
	}

	@Override
	public List<PatientDomain> find(String textToFind, int page, int maxItems) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PatientDomain.class);
		// SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		if (textToFind != null) {
			Map<String, String> map = obtenerQuery(textToFind);
			if (map.containsKey("text")) {
				String text = map.get("text");
				Criterion propertyCriterion = Restrictions.disjunction()
						.add(Restrictions.ilike("_name", "%" + text + "%"))
						.add(Restrictions.ilike("_lastName", "%" + text + "%"))
						.add(Restrictions.ilike("_document", "%" + text + "%"))
						.add(Restrictions.ilike("_address", "%" + text + "%"))
						.add(Restrictions.ilike("_phone", "%" + text + "%"));
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
				if(sort.equals("_name") || sort.equals("_lastName") || sort.equals("_sex") || sort.equals("_address") || sort.equals("_document") || sort.equals("_birthDate") || sort.equals("_phone")){
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
				criteria.addOrder(Order.asc("_lastName").ignoreCase());
			}
			
		}

		
		criteria.setFirstResult(page * maxItems);
		criteria.setMaxResults(maxItems);
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<PatientDomain> patients = criteria.list();
		return patients;
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
