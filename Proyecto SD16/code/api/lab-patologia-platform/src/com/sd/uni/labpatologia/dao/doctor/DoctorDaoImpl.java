package com.sd.uni.labpatologia.dao.doctor;

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
import com.sd.uni.labpatologia.domain.doctor.DoctorDomain;
import com.sd.uni.labpatologia.domain.study_type.StudyTypeDomain;
import com.sd.uni.labpatologia.exception.PatologyException;

@Repository
public class DoctorDaoImpl extends BaseDaoImpl<DoctorDomain> implements IDoctorDao {
	@Autowired
	private SessionFactory _sessionFactory;

	@Override
	public DoctorDomain save(DoctorDomain domain) {
		_sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public DoctorDomain getById(Integer domainId) throws PatologyException {
		if (null != domainId) {
			return (DoctorDomain) _sessionFactory.getCurrentSession().get(DoctorDomain.class, domainId);
		} else {
			throw new PatologyException("El ID no puede ser null");
		}
	}

	@Override
	public List<DoctorDomain> findAll() {
		final Criteria criteria = _sessionFactory.getCurrentSession().createCriteria(DoctorDomain.class);
		return criteria.list();
	}

	@Override
	public List<DoctorDomain> find(String textToFind) {
		Session session = _sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(DoctorDomain.class);
		Criterion propertyCriterion = Restrictions.disjunction().add(Restrictions.ilike("_name", textToFind))
				.add(Restrictions.ilike("_last_name", textToFind))
				.add(Restrictions.ilike("_address", textToFind))
				.add(Restrictions.ilike("_phone", textToFind))
				.add(Restrictions.ilike("_email", textToFind));				
		Criterion idCriterion = null;
		if (StringUtils.isNumeric(textToFind)) {
			idCriterion = Restrictions.eq("_ci", Integer.valueOf(textToFind));
		}
		if (idCriterion != null) {
			criteria.add(Restrictions.or(propertyCriterion, idCriterion));
		} else {
			criteria.add(propertyCriterion);
		}
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<DoctorDomain> doctors = criteria.list();
		return doctors;
	}

	

}