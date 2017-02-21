package com.sd.uni.labpatologia.dao.doctor;

import java.util.List;

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

	public int getCount() {
		final Criteria criteria = _sessionFactory.getCurrentSession().createCriteria(DoctorDomain.class);
		return criteria.list().size();
	}
	
	@Override
	public List<DoctorDomain> find(String textToFind, int page, int maxItems) {
		Session session = _sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(DoctorDomain.class);
		if (textToFind != null){
			Criterion propertyCriterion = Restrictions.disjunction().add(Restrictions.ilike("_name", "%"+textToFind+"%"))
					.add(Restrictions.ilike("_last_name", "%"+textToFind+"%"))
					.add(Restrictions.ilike("_address", "%"+textToFind+"%"))
					.add(Restrictions.ilike("_phone", "%"+textToFind+"%"))
					.add(Restrictions.ilike("_speciality", "%"+textToFind+"%"))
					.add(Restrictions.ilike("_email", "%"+textToFind+"%"))
					.add(Restrictions.ilike("_ci", "%"+textToFind+"%"));	
			Criterion idCriterion = null;
			if (StringUtils.isNumeric(textToFind)) {
				idCriterion = Restrictions.eq("_id", Integer.valueOf(textToFind));
			}
			if (idCriterion != null) {
				criteria.add(Restrictions.or(propertyCriterion, idCriterion));
			} else {
				criteria.add(propertyCriterion);
			}
			
		}
		criteria.addOrder(Order.asc("_last_name").ignoreCase());
		criteria.addOrder(Order.asc("_name").ignoreCase());
		criteria.setFirstResult(page*maxItems);
		criteria.setMaxResults(maxItems);
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<DoctorDomain> doctors = criteria.list();
		return doctors;
	}

	

}