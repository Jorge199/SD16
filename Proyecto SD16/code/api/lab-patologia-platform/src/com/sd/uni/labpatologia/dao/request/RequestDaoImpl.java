package com.sd.uni.labpatologia.dao.request;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.sd.uni.labpatologia.domain.request.RequestDomain;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.util.StatusEnum;

@Repository
public class RequestDaoImpl extends BaseDaoImpl<RequestDomain> implements IRequestDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public RequestDomain save(RequestDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public RequestDomain getById(Integer domainId) throws PatologyException{
		if (null != domainId) {
			try{
			return (RequestDomain) sessionFactory.getCurrentSession().get(RequestDomain.class, domainId);
			}catch(Exception e){
				throw new PatologyException( "No existe la ficha con id "+domainId, e);
			}
		} else {
			throw new PatologyException("El ID no puede ser null");
		}
	}

	@Override
	public List<RequestDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RequestDomain.class);
		return criteria.list();
	}

	public int getCount() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RequestDomain.class);
		return criteria.list().size();
	}
	
	@Override
	public List<RequestDomain> find(String textToFind, int page, int maxItems) throws PatologyException {
		Date minDate, maxDate;
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(RequestDomain.class, "request").createAlias("request._patient", "patient");
		
		
		if (textToFind != null){
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Map<String, String> map = obtenerQuery(textToFind);

			if (map.containsKey("patient")) { // si quiere filtrar por patient
				Criterion propertyCriterion = Restrictions.disjunction().add(Restrictions.ilike("patient._name", "%"+map.get("patient")+"%"))
				.add(Restrictions.ilike("patient._lastName", "%"+map.get("patient")+"%"))
				.add(Restrictions.ilike("patient._document", "%"+map.get("patient")+"%"));
				criteria.add(Restrictions.or(propertyCriterion));
			}
			
			if (map.containsKey("note")) { // si quiere filtrar por note
				criteria.add(Restrictions.ilike("_note", "%"+map.get("note")+"%"));
			}
			
			if (map.containsKey("code")) { // si quiere filtrar por code
				criteria.add(Restrictions.ilike("_code", "%"+map.get("code")+"%"));
			}
			
			if (map.containsKey("status")) { // si quiere filtrar por
				// diagnostico
				criteria.add(Restrictions.eq("_status", StatusEnum.valueOf( map.get("status"))));
			}
			if (map.containsKey("specimen")) { // si quiere filtrar por
				// especimen
				criteria.add(Restrictions.ilike("_specimen", "%"+map.get("specimen")+"%"));
			}

			if (map.containsKey("start") && map.containsKey("end")) { // si quiere buscar entre fechas
				try {
					minDate = formatter.parse(map.get("start"));
					Calendar c = Calendar.getInstance();
					c.setTime(formatter.parse(map.get("end")));
					c.add(Calendar.DATE, 1);
					maxDate = c.getTime();
					criteria.add(Restrictions.between("_date", minDate, maxDate));
				} catch (ParseException e) {
					throw new PatologyException("Formato de ruta invalido", e);
				}
			} else if (map.containsKey("date")) { // si quiere filtrar por una fecha
													// especifica
				try {
					criteria.add(Restrictions.eq("_date", formatter.parse(map.get("date"))));
				} catch (ParseException e) {
					throw new PatologyException("Formato de ruta invalido", e);
				}
			}
			
			if (map.containsKey("sort")) {
				String sort = (map.get("sort"));
				if(sort.equals("_code") || sort.equals("_date") || sort.equals("_status") || sort.equals("_specimen") || sort.equals("_studyType")){
					if (map.containsKey("order")){
						String order = (map.get("order"));
						if(order.equals("desc")){
							criteria.addOrder(Order.desc(sort));
						}else{
							criteria.addOrder(Order.asc(sort));
						}
					}else{
						criteria.addOrder(Order.desc("_id"));
					}
					
				}else if(sort.equals("_patient")){
					if (map.containsKey("order")){
						String order = (map.get("order"));
						if(order.equals("desc")){
							criteria.addOrder(Order.desc("patient._name"));
						}else{
							criteria.addOrder(Order.asc("patient._name"));
						}
					}else{
						criteria.addOrder(Order.desc("patient._name"));
					}
				}else if(sort.equals("_doctor")){
					criteria.createAlias("request._doctor", "doctor");
					if (map.containsKey("order")){
						String order = (map.get("order"));
						if(order.equals("desc")){
							criteria.addOrder(Order.desc("doctor._name"));
						}else{
							criteria.addOrder(Order.asc("doctor._name"));
						}
					}else{
						criteria.addOrder(Order.desc("doctor._name"));
					}
				}
				else{
					criteria.addOrder(Order.desc("_id"));
				}
			}
		}else{
			criteria.addOrder(Order.desc("_id"));
		}
		
		criteria.setFirstResult(page*maxItems);
		criteria.setMaxResults(maxItems);
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<RequestDomain> requests = criteria.list();
		return requests;

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
