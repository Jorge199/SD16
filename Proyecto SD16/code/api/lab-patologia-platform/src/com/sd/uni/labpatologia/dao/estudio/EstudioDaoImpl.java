package com.sd.uni.labpatologia.dao.estudio;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.uni.labpatologia.dao.base.BaseDaoImpl;
import com.sd.uni.labpatologia.domain.estudio.EstudioDomain;
import com.sd.uni.labpatologia.exception.PatologyException;

@Repository
public class EstudioDaoImpl extends BaseDaoImpl<EstudioDomain> implements IEstudioDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public EstudioDomain save(EstudioDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}

	@Override
	public EstudioDomain getById(Integer domainId) {
		return (EstudioDomain) sessionFactory.getCurrentSession().get(EstudioDomain.class, domainId);
	}

	@Override
	public List<EstudioDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EstudioDomain.class);
		return criteria.list();
	}

	@Override
	public List<EstudioDomain> find(String textToFind) throws PatologyException {
		// TODO Auto-generated method stub
		return null;
	}

}
