package com.sd.uni.labpatologia.dao.rol;


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
import com.sd.uni.labpatologia.domain.rol.RolDomain;

@Repository
public class RolDaoImpl extends BaseDaoImpl<RolDomain> implements IRolDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public RolDomain save(RolDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public RolDomain getById(Integer domainId) {
		return (RolDomain) sessionFactory.getCurrentSession().get(RolDomain.class, domainId);
	}

	@Override
	public List<RolDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RolDomain.class);
		return criteria.list();
	}

	
	public List<RolDomain> find(String textToFind) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(RolDomain.class);
		Criterion nameCriterion =Restrictions.ilike("_name", textToFind);
		Criterion idCriterion = null;
		if (StringUtils.isNumeric(textToFind)) {
			idCriterion=Restrictions.eq("_id", Integer.valueOf(textToFind));
		}
		
		if(idCriterion!=null){
			criteria.add(Restrictions.or(nameCriterion, idCriterion));
		}else{
			criteria.add(nameCriterion);
		}
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<RolDomain> rols = criteria.list();
		return rols;
	}

	public List<RolDomain> find2(String textToFind) {
		Integer id = null;
		if (StringUtils.isNumeric(textToFind)) {
			id = Integer.valueOf(textToFind);
		}
		Query q = sessionFactory.getCurrentSession().createQuery("from RolDomain where _name like :parameter or _id=:id");
		q.setParameter("parameter", "%" + textToFind + "%");
		q.setParameter("id", id);
		return q.list();
	}

}
