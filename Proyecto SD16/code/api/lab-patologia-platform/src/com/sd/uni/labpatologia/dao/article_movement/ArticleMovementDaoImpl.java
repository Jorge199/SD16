package com.sd.uni.labpatologia.dao.article_movement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.EnumUtils;
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
import com.sd.uni.labpatologia.domain.article_movement.ArticleMovementDomain;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.util.DiagnosticEnum;
import com.sd.uni.labpatologia.util.MovementTypeEnum;

@Repository
public class ArticleMovementDaoImpl extends BaseDaoImpl<ArticleMovementDomain> implements IArticleMovementDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ArticleMovementDomain save(ArticleMovementDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public ArticleMovementDomain getById(Integer domainId) throws PatologyException {
		if (null != domainId) {
			return (ArticleMovementDomain) sessionFactory.getCurrentSession().get(ArticleMovementDomain.class,
					domainId);
		} else {
			throw new PatologyException("El ID no puede ser null");
		}
	}

	@Override
	public List<ArticleMovementDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ArticleMovementDomain.class);
		return criteria.list();
	}

	@Override
	public List<ArticleMovementDomain> find(String textToFind, int page, int maxItems) throws PatologyException {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ArticleMovementDomain.class, "articleMovement")
				.createAlias("articleMovement._article", "article");
		Date minDate, maxDate;
		Criterion propertyCriterion = Restrictions.disjunction();

		if (textToFind != null) {
			// Criterion articleCriterion =
			// Restrictions.disjunction().add(Restrictions.ilike("article._name",
			// "%" + textToFind + "%"));
			/*
			 * if(EnumUtils.isValidEnum(MovementTypeEnum.class,
			 * textToFind.toUpperCase())){
			 * criteria.add(Restrictions.disjunction().add(Restrictions.eq(
			 * "_movement_type",
			 * MovementTypeEnum.valueOf(textToFind.toUpperCase())))); }
			 */
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Map<String, String> map = obtenerQuery(textToFind);
			// Agrego o quito alrededor de 150 anhos al min y max date
			minDate = new Date(Calendar.getInstance().getTime().getTime() - 5000000000000l);
			maxDate = new Date(Calendar.getInstance().getTime().getTime() + 5000000000000l);
			if (map.containsKey("type")) {
				criteria.add(Restrictions.eq("_movement_type", MovementTypeEnum.valueOf(map.get("type"))));
			}
			if (map.containsKey("start")) {
				try {
					minDate = formatter.parse(map.get("start"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if (map.containsKey("end")) {
				Calendar c = Calendar.getInstance();
				try {
					c.setTime(formatter.parse(map.get("end")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				c.add(Calendar.DATE, 1);
				maxDate = c.getTime();
			}

			if (map.containsKey("sort")) {
				String sort = (map.get("sort"));
				if (sort.equals("_date") || sort.equals("_movement_type") || sort.equals("_quantity")) {
					if (map.containsKey("order")) {
						String order = (map.get("order"));
						if (order.equals("desc")) {
							criteria.addOrder(Order.desc(sort));
						} else {
							criteria.addOrder(Order.asc(sort));
						}
					} else {
						criteria.addOrder(Order.desc("_id"));
					}

				} else if (sort.equals("_article")) {
					if (map.containsKey("order")) {
						String order = (map.get("order"));
						if (order.equals("desc")) {
							criteria.addOrder(Order.desc("article._name"));
						} else {
							criteria.addOrder(Order.asc("article._name"));
						}
					} else {
						criteria.addOrder(Order.desc("article._name"));
					}
				}else{
					criteria.addOrder(Order.desc("_id"));
				}
			}else{
				criteria.addOrder(Order.desc("_id"));
			}
			// if (map.containsKey("start") && map.containsKey("end")) {
			// try {
			/*
			 * minDate = formatter.parse(map.get("start")); Calendar c =
			 * Calendar.getInstance();
			 * c.setTime(formatter.parse(map.get("end"))); c.add(Calendar.DATE,
			 * 1); maxDate = c.getTime();
			 */
			System.out.println("desde" + minDate + "hasta " + maxDate);
			criteria.add(Restrictions.between("_date", minDate, maxDate));
			/*
			 * } catch (ParseException e) { throw new
			 * PatologyException("Formato de ruta invalido", e); }
			 */
			// }

			criteria.add(Restrictions.or(propertyCriterion));

		}
		if (page != 0 && maxItems != 0) {
			criteria.setFirstResult(page * maxItems);
			criteria.setMaxResults(maxItems);
		}
		
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<ArticleMovementDomain> articleMovements = criteria.list();
		return articleMovements;
	}

	@Override
	public List<ArticleMovementDomain> find(String textToFind) throws PatologyException {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ArticleMovementDomain.class, "articleMovement")
				.createAlias("articleMovement._article", "article");
		Date minDate, maxDate;
		Criterion propertyCriterion = Restrictions.disjunction();

		if (textToFind != null) {
			Criterion articleCriterion = Restrictions.disjunction()
					.add(Restrictions.ilike("article._name", "%" + textToFind + "%"));
			/*
			 * if(EnumUtils.isValidEnum(MovementTypeEnum.class,
			 * textToFind.toUpperCase())){
			 * criteria.add(Restrictions.disjunction().add(Restrictions.eq(
			 * "_movement_type",
			 * MovementTypeEnum.valueOf(textToFind.toUpperCase())))); }
			 */
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Map<String, String> map = obtenerQuery(textToFind);
			// Agrego o quito alrededor de 150 anhos al min y max date
			minDate = new Date(Calendar.getInstance().getTime().getTime() - 5000000000000l);
			maxDate = new Date(Calendar.getInstance().getTime().getTime() + 5000000000000l);
			if (map.containsKey("type")) {
				criteria.add(Restrictions.eq("_movement_type", MovementTypeEnum.valueOf(map.get("type"))));
			}
			if (map.containsKey("start")) {
				try {
					minDate = formatter.parse(map.get("start"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if (map.containsKey("end")) {
				Calendar c = Calendar.getInstance();
				try {
					c.setTime(formatter.parse(map.get("end")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				c.add(Calendar.DATE, 1);
				maxDate = c.getTime();
			}
			// if (map.containsKey("start") && map.containsKey("end")) {
			// try {
			/*
			 * minDate = formatter.parse(map.get("start")); Calendar c =
			 * Calendar.getInstance();
			 * c.setTime(formatter.parse(map.get("end"))); c.add(Calendar.DATE,
			 * 1); maxDate = c.getTime();
			 */
			System.out.println("desde" + minDate + "hasta " + maxDate);
			criteria.add(Restrictions.between("_date", minDate, maxDate));
			/*
			 * } catch (ParseException e) { throw new
			 * PatologyException("Formato de ruta invalido", e); }
			 */
			// }

			criteria.add(Restrictions.or(propertyCriterion, articleCriterion));

		}
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<ArticleMovementDomain> articleMovements = criteria.list();
		return articleMovements;
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
