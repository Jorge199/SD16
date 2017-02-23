package com.sd.uni.labpatologia.dao.laboratory;

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
import com.sd.uni.labpatologia.domain.laboratory.LaboratoryDomain;
import com.sd.uni.labpatologia.exception.PatologyException;

@Repository
public class LaboratoryDaoImpl extends BaseDaoImpl<LaboratoryDomain> implements ILaboratoryDao {
	@Autowired
	private SessionFactory _sessionFactory;

	@Override
	public LaboratoryDomain save(LaboratoryDomain domain) {
		_sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public LaboratoryDomain getById(Integer domainId) throws PatologyException {
		if (null != domainId) {
			return (LaboratoryDomain) _sessionFactory.getCurrentSession().get(LaboratoryDomain.class, domainId);
		} else {
			throw new PatologyException("El ID no puede ser null");
		}
	}

	@Override
	public List<LaboratoryDomain> findAll() {
		final Criteria criteria = _sessionFactory.getCurrentSession().createCriteria(LaboratoryDomain.class);
		return criteria.list();
	}

	@Override
	public List<LaboratoryDomain> find(String textToFind, int page, int maxItems) {
		Session session = _sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(LaboratoryDomain.class);
		Criterion propertyCriterion = Restrictions.disjunction().add(Restrictions.ilike("_name", textToFind))
				.add(Restrictions.ilike("_address", textToFind)).add(Restrictions.ilike("_email", textToFind))
				.add(Restrictions.ilike("_phone", textToFind));
		Criterion idCriterion = null;
		if (StringUtils.isNumeric(textToFind)) {
			idCriterion = Restrictions.eq("_id", Integer.valueOf(textToFind));
		}

		if (idCriterion != null) {
			criteria.add(Restrictions.or(propertyCriterion, idCriterion));
		} else {
			criteria.add(propertyCriterion);
		}
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<LaboratoryDomain> laboratories = criteria.list();
		return laboratories;
	}

	

}
