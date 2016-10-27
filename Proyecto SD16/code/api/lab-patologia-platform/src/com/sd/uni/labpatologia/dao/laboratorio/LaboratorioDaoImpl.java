package com.sd.uni.labpatologia.dao.laboratorio;

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
import com.sd.uni.labpatologia.domain.laboratorio.LaboratorioDomain;
import com.sd.uni.labpatologia.exception.PatologyException;

@Repository
public class LaboratorioDaoImpl extends BaseDaoImpl<LaboratorioDomain> implements ILaboratorioDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public LaboratorioDomain save(LaboratorioDomain domain) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public LaboratorioDomain getById(Integer domainId) throws PatologyException {
		if (null != domainId) {
			return (LaboratorioDomain) sessionFactory.getCurrentSession().get(LaboratorioDomain.class, domainId);
		} else {
			throw new PatologyException("El ID no puede ser null");
		}
	}

	@Override
	public List<LaboratorioDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LaboratorioDomain.class);
		return criteria.list();
	}

	@Override
	public List<LaboratorioDomain> find(String textToFind) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(LaboratorioDomain.class);
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
		List<LaboratorioDomain> labs = criteria.list();
		return labs;
	}

	public List<LaboratorioDomain> find2(String textToFind) {
		Integer id = null;
		if (StringUtils.isNumeric(textToFind)) {
			id = Integer.valueOf(textToFind);
		}
		Query q = sessionFactory.getCurrentSession().createQuery(
				"from LaboratorioDomain where _name like :parameter or _address like :parameter or _email like :parameter or _phone like :parameter or _id=:id");
		q.setParameter("parameter", "%" + textToFind + "%");
		q.setParameter("id", id);
		return q.list();
	}

}
