package com.sd.uni.labpatologia.dao.study_type;

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
import com.sd.uni.labpatologia.domain.study_type.StudyTypeDomain;
import com.sd.uni.labpatologia.exception.PatologyException;

@Repository
public class StudyTypeDaoImpl extends BaseDaoImpl<StudyTypeDomain> implements IStudyTypeDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public StudyTypeDomain save(StudyTypeDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public StudyTypeDomain getById(Integer domainId) throws PatologyException {
		if (null != domainId) {
			return (StudyTypeDomain) sessionFactory.getCurrentSession().get(StudyTypeDomain.class, domainId);
		}
		else{
			throw new PatologyException("El ID no puede ser null");
		}
	}

	@Override
	public List<StudyTypeDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StudyTypeDomain.class);
		return criteria.list();
	}

	@Override
	public List<StudyTypeDomain> find(String textToFind, int page, int maxItems) throws PatologyException {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(StudyTypeDomain.class);
		
		if (!textToFind.equals("all")){
			Criterion propertyCriterion = Restrictions.disjunction().add(Restrictions.ilike("_name", textToFind))
					.add(Restrictions.ilike("_description", textToFind));
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
		
		criteria.setFirstResult(page*maxItems);
		criteria.setMaxResults(maxItems);
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<StudyTypeDomain> studies = criteria.list();
		return studies;
	}

}
