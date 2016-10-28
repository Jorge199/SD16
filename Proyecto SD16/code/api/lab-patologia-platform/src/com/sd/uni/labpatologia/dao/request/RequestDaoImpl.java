package com.sd.uni.labpatologia.dao.request;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.uni.labpatologia.dao.base.BaseDaoImpl;
import com.sd.uni.labpatologia.domain.request.RequestDomain;
import com.sd.uni.labpatologia.exception.PatologyException;

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
			return (RequestDomain) sessionFactory.getCurrentSession().get(RequestDomain.class, domainId);
		} else {
			throw new PatologyException("El ID no puede ser null");
		}
	}

	@Override
	public List<RequestDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RequestDomain.class);
		return criteria.list();
	}

	@Override
	public List<RequestDomain> find(String textToFind) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(RequestDomain.class);
		Criterion propertyCriterion = Restrictions.disjunction().add(Restrictions.ilike("_note", "%"+textToFind+"%"));
				
		Criterion idCriterion = null;
		if (StringUtils.isNumeric(textToFind)) {
			idCriterion = Restrictions.eq("_id", Integer.valueOf(textToFind));
		}

		if (null != idCriterion) {
			criteria.add(Restrictions.or(propertyCriterion, idCriterion));
		} else {
			criteria.add(propertyCriterion);
		}
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<RequestDomain> requests = criteria.list();
		return requests;
	}

}