package com.sd.uni.labpatologia.dao.rol;


import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.uni.labpatologia.dao.base.BaseDaoImpl;
import com.sd.uni.labpatologia.domain.rol.RolDomain;
import com.sd.uni.labpatologia.exception.PatologyException;

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

	
	@Override
	public List<RolDomain> find(String textToFind, int page, int maxItems) throws PatologyException {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(RolDomain.class);
		if (textToFind != null){
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
		}
		criteria.addOrder(Order.asc("_name"));
		criteria.setFirstResult(page*maxItems);
		criteria.setMaxResults(maxItems);
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<RolDomain> rols = criteria.list();
		return rols;
	}

}
