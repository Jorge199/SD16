package com.sd.uni.labpatologia.dao.report;

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
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.uni.labpatologia.dao.base.BaseDaoImpl;
import com.sd.uni.labpatologia.domain.report.ReportDomain;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.util.DiagnosticEnum;

@Repository
public class ReportDaoImpl extends BaseDaoImpl<ReportDomain> implements IReportDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ReportDomain save(ReportDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public ReportDomain getById(Integer domainId) throws PatologyException {
		if (null != domainId) {
			try{
			return (ReportDomain) sessionFactory.getCurrentSession().get(ReportDomain.class, domainId);
			}catch(Exception e){
				throw new PatologyException( "No existe el reporte con id "+domainId,e);
			}
		} else {
			throw new PatologyException("El ID no puede ser null");
		}
	}

	@Override
	public List<ReportDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ReportDomain.class);
		return criteria.list();
	}

	@Override
	public List<ReportDomain> find(String textToFind, int page, int maxItems) throws PatologyException {
		Date minDate, maxDate;
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ReportDomain.class);
		if (textToFind != null){
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Map<String, String> map = obtenerQuery(textToFind);

			if (map.containsKey("diagnostic")) { // si quiere filtrar por
													// diagnostico
				criteria.add(Restrictions.eq("_diagnostic", DiagnosticEnum.valueOf( map.get("diagnostic"))));
			}

			if (map.containsKey("start") && map.containsKey("end")) { // si quiere buscar entre fechas
				try {
					minDate = formatter.parse(map.get("start"));
					Calendar c = Calendar.getInstance();
					c.setTime(formatter.parse(map.get("end")));
					c.add(Calendar.DATE, 1);
					maxDate = c.getTime();
					// System.out.println("desde" + minDate + "hasta " + maxDate);
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
		}
		
		criteria.setFirstResult(page*maxItems);
		criteria.setMaxResults(maxItems);
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<ReportDomain> reports = criteria.list();
		return reports;

	}
	
	@Override
	public List<ReportDomain> find(String textToFind) throws PatologyException {
		Date minDate, maxDate;
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ReportDomain.class);
		if (textToFind != null){
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Map<String, String> map = obtenerQuery(textToFind);

			if (map.containsKey("diagnostic")) { // si quiere filtrar por
													// diagnostico
				criteria.add(Restrictions.eq("_diagnostic", DiagnosticEnum.valueOf( map.get("diagnostic"))));
			}

			if (map.containsKey("start") && map.containsKey("end")) { // si quiere buscar entre fechas
				try {
					minDate = formatter.parse(map.get("start"));
					Calendar c = Calendar.getInstance();
					c.setTime(formatter.parse(map.get("end")));
					c.add(Calendar.DATE, 1);
					maxDate = c.getTime();
					// System.out.println("desde" + minDate + "hasta " + maxDate);
					criteria.add(Restrictions.between("_date", minDate, maxDate));
				} catch (ParseException e) {
					throw new PatologyException("Formato de ruta invalido", e);
				}
			} else if (map.containsKey("date")) { // si quiere filtrar por una fecha especifica
				try {
					criteria.add(Restrictions.eq("_date", formatter.parse(map.get("date"))));
				} catch (ParseException e) {
					throw new PatologyException("Formato de ruta invalido", e);
				}
			}
		}
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<ReportDomain> reports = criteria.list();
		return reports;
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
