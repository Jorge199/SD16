package com.sd.isp.dao.session;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.isp.dao.base.BaseDaoImpl;
import com.sd.isp.domain.session.SessionDomain;

@Repository
public class SessionDaoImpl extends BaseDaoImpl<SessionDomain> implements ISessionDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public SessionDomain save(SessionDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public SessionDomain getById(Integer domainId) {
		return (SessionDomain) sessionFactory.getCurrentSession().get(SessionDomain.class, domainId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SessionDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SessionDomain.class);
		return criteria.list();
	}

}
