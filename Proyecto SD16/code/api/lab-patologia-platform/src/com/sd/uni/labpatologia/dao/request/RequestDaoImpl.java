package com.sd.uni.labpatologia.dao.request;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.uni.labpatologia.dao.base.BaseDaoImpl;
import com.sd.uni.labpatologia.domain.request.RequestDomain;

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
	public RequestDomain getById(Integer domainId) {
		return (RequestDomain) sessionFactory.getCurrentSession().get(RequestDomain.class, domainId);
	}

	@Override
	public List<RequestDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RequestDomain.class);
		return criteria.list();
	}

}