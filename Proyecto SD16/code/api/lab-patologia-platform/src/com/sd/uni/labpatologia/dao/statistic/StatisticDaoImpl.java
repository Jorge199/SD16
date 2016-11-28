package com.sd.uni.labpatologia.dao.statistic;

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
import com.sd.uni.labpatologia.domain.statistic.StatisticDomain;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.util.DiagnosticEnum;
import com.sd.uni.labpatologia.util.SexEnum;

@Repository
public class StatisticDaoImpl extends BaseDaoImpl<StatisticDomain> implements IStatisticDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public StatisticDomain save(StatisticDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public StatisticDomain getById(Integer domainId) throws PatologyException {
		if (null != domainId) {
			try {
				return (StatisticDomain) sessionFactory.getCurrentSession().get(StatisticDomain.class, domainId);
			} catch (Exception e) {
				throw new PatologyException("No existe la estadistica con id " + domainId, e);
			}
		} else {
			throw new PatologyException("El ID no puede ser null");
		}
	}

	@Override
	public List<StatisticDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StatisticDomain.class);
		return criteria.list();
	}

	@Override
	public List<StatisticDomain> find(String textToFind, int page, int maxItems) throws PatologyException {
		Date minDate, maxDate;
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(StatisticDomain.class);
		if (textToFind != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Map<String, String> map = obtenerQuery(textToFind);

			if (map.containsKey("startAge") && map.containsKey("endAge")) {
				criteria.add(Restrictions.between("_patientAge", map.get("startAge"), map.get("endAge")));
			}
			if (map.containsKey("diagnostic")) { // si quiere filtrar por
													// diagnostico
				criteria.add(Restrictions.eq("_diagnostic", DiagnosticEnum.valueOf(map.get("diagnostic").toUpperCase())));
			}
			if (map.containsKey("sex")) {
				criteria.add(Restrictions.eq("_sex", SexEnum.valueOf(map.get("sex").toUpperCase())));
			}

			if (map.containsKey("start") && map.containsKey("end")) { // si quiere buscar entre fechas
				try {
					minDate = formatter.parse(map.get("start"));
					Calendar c = Calendar.getInstance();
					c.setTime(formatter.parse(map.get("end")));
					c.add(Calendar.DATE, 1);
					maxDate = c.getTime();
					// System.out.println("desde" + minDate + "hasta " +
					// maxDate);
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

		criteria.setFirstResult(page * maxItems);
		criteria.setMaxResults(maxItems);
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<StatisticDomain> statistics = criteria.list();
		return statistics;

	}

	@Override
	public List<StatisticDomain> find(String textToFind) throws PatologyException {
		Date minDate, maxDate;
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(StatisticDomain.class);
		if (textToFind != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Map<String, String> map = obtenerQuery(textToFind);
			if (map.containsKey("startAge") && map.containsKey("endAge")) {
				criteria.add(Restrictions.between("_patientAge", Integer.parseInt(map.get("startAge")), Integer.parseInt(map.get("endAge"))));
			}
			if (map.containsKey("diagnostic")) { // si quiere filtrar por diagnostico
				criteria.add(Restrictions.eq("_diagnostic", DiagnosticEnum.valueOf(map.get("diagnostic").toUpperCase())));
			}
			if (map.containsKey("sex")) {
				criteria.add(Restrictions.eq("_sex", SexEnum.valueOf(map.get("sex").toUpperCase())));
			}
			if (map.containsKey("start") && map.containsKey("end")) { // si quiere buscar entre fechas
				try {
					minDate = formatter.parse(map.get("start"));
					Calendar c = Calendar.getInstance();
					c.setTime(formatter.parse(map.get("end")));
					c.add(Calendar.DATE, 1);
					maxDate = c.getTime();
					// System.out.println("desde" + minDate + "hasta " +
					// maxDate);
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
		List<StatisticDomain> statistics = criteria.list();
		return statistics;
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
