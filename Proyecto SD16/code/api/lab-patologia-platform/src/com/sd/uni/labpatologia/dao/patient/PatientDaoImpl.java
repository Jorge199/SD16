package com.sd.uni.labpatologia.dao.patient;

import java.text.SimpleDateFormat;
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
import com.sd.uni.labpatologia.domain.patient.PatientDomain;
import com.sd.uni.labpatologia.exception.PatologyException;

@Repository
public class PatientDaoImpl extends BaseDaoImpl<PatientDomain> implements IPatientDao {
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public PatientDomain save(PatientDomain domain) {
		sessionFactory.getCurrentSession().save(domain);
		return domain;
	}

	@Override
	public PatientDomain getById(Integer domainId)throws PatologyException {
		return (PatientDomain) sessionFactory.getCurrentSession().get(PatientDomain.class, domainId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PatientDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PatientDomain.class);
		return criteria.list();
	}
	@Override
	public List<PatientDomain> find(String textToFind) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PatientDomain.class);
		//SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criterion propertyCriterion = Restrictions.disjunction().add(Restrictions.ilike("_name", textToFind))
		.add(Restrictions.ilike("_lastName", textToFind)).add(Restrictions.ilike("_document", textToFind))
		.add(Restrictions.ilike("_sex", textToFind)).add(Restrictions.ilike("_address", textToFind)).add(Restrictions.ilike("_phone", textToFind));
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
		List<PatientDomain> patients = criteria.list();
		return patients;
	}

}
