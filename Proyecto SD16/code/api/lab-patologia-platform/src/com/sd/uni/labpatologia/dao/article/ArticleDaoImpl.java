package com.sd.uni.labpatologia.dao.article;

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
import com.sd.uni.labpatologia.domain.article.ArticleDomain;
import com.sd.uni.labpatologia.exception.PatologyException;
@Repository
public class ArticleDaoImpl  extends BaseDaoImpl<ArticleDomain> implements IArticleDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ArticleDomain save(ArticleDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}
	@Override
	public ArticleDomain getById(Integer domainId) throws PatologyException {
		if (null != domainId) {
			return (ArticleDomain) sessionFactory.getCurrentSession().get(ArticleDomain.class, domainId);
		} else {
			throw new PatologyException("El ID no puede ser null");
		}
	}
	
	@Override
	public List<ArticleDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ArticleDomain.class);
		return criteria.list();
	}

	@Override
	public List<ArticleDomain> find(String textToFind, int page, int maxItems) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ArticleDomain.class);
		if (textToFind != null){
			Criterion propertyCriterion = Restrictions.disjunction().add(Restrictions.ilike("_name", "%"+textToFind+"%")).add(
					Restrictions.ilike("_description", "%"+textToFind+"%")).add(
					Restrictions.ilike("_units", "%"+textToFind+"%"));	
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
		List<ArticleDomain> requests = criteria.list();
		return requests;
	}

}
