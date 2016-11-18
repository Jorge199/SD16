package com.sd.uni.labpatologia.dao.article_movement;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.uni.labpatologia.dao.base.BaseDaoImpl;
import com.sd.uni.labpatologia.domain.article_movement.ArticleMovementDomain;
import com.sd.uni.labpatologia.exception.PatologyException;
@Repository
public class ArticleMovementDaoImpl  extends BaseDaoImpl<ArticleMovementDomain> implements IArticleMovementDao {
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
			return (ArticleMovementDomain) sessionFactory.getCurrentSession().get(ArticleMovementDomain.class, domainId);
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
	public List<ArticleMovementDomain> find(String textToFind, int page, int maxItems) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ArticleMovementDomain.class);
		Criterion propertyCriterion = Restrictions.disjunction().add(Restrictions.ilike("_name", "%"+textToFind+"%"));
		if (textToFind != null){
			Criterion idCriterion = null;
			if (StringUtils.isNumeric(textToFind)) {
				idCriterion = Restrictions.eq("_id", Integer.valueOf(textToFind));
			}
			if (null != idCriterion) {
				criteria.add(Restrictions.or(propertyCriterion, idCriterion));
			} else {
				criteria.add(propertyCriterion);
			}
		}
		criteria.setFirstResult(page*maxItems);
		criteria.setMaxResults(maxItems);
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<ArticleMovementDomain> articleMovements = criteria.list();
		return articleMovements;
	}

}
