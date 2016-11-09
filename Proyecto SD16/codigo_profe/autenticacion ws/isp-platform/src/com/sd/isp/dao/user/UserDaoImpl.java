package com.sd.isp.dao.user;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.isp.dao.base.BaseDaoImpl;
import com.sd.isp.domain.user.UserDomain;

@Repository
public class UserDaoImpl extends BaseDaoImpl<UserDomain> implements IUserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public UserDomain save(UserDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;

	}

	@Override
	public UserDomain getById(Integer domainId) {
		return (UserDomain) sessionFactory.getCurrentSession().get(UserDomain.class, domainId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserDomain.class);
		return criteria.list();
	}

	@Override
	public UserDomain getByToken(String token) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserDomain.class);
		criteria.add(Restrictions.ilike("_token", token));

		return (UserDomain) criteria.uniqueResult();
	}
}
