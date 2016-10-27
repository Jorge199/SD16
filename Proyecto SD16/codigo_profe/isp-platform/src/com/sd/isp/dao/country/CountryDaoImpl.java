package com.sd.isp.dao.country;

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

import com.sd.isp.dao.base.BaseDaoImpl;
import com.sd.isp.domain.location.country.CountryDomain;

@Repository
public class CountryDaoImpl extends BaseDaoImpl<CountryDomain> implements ICountryDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public CountryDomain save(CountryDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public CountryDomain getById(Integer domainId) {
		return (CountryDomain) sessionFactory.getCurrentSession().get(CountryDomain.class, domainId);
	}

	@Override
	public List<CountryDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CountryDomain.class);
		return criteria.list();
	}

	
	public List<CountryDomain> find(String textToFind) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(CountryDomain.class);
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
		List<CountryDomain> countries = criteria.list();
		return countries;
	}

	public List<CountryDomain> find2(String textToFind) {
		Integer id = null;
		if (StringUtils.isNumeric(textToFind)) {
			id = Integer.valueOf(textToFind);
		}
		Query q = sessionFactory.getCurrentSession().createQuery("from CountryDomain where _name like :parameter or _id=:id");
		q.setParameter("parameter", "%" + textToFind + "%");
		q.setParameter("id", id);
		return q.list();
	}

}
