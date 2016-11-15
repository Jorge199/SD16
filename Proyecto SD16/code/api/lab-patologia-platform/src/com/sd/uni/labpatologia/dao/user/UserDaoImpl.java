package com.sd.uni.labpatologia.dao.user;


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
import com.sd.uni.labpatologia.domain.user.UserDomain;


import com.sd.uni.labpatologia.exception.PatologyException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;


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

	@Override
	public List<UserDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserDomain.class);
		return criteria.list();
	}
	
	@Override
	public List<UserDomain> find(String textToFind, int page, int maxItems) throws PatologyException {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserDomain.class);
		if (textToFind != null){
			Criterion propertyCriterion = Restrictions.disjunction().add(Restrictions.ilike("_name", "%"+textToFind+"%"))
					.add(Restrictions.ilike("_lastName", "%"+textToFind+"%")).add(Restrictions.ilike("_userName", "%"+textToFind+"%"));
			Criterion idCriterion = null;
			if (StringUtils.isNumeric(textToFind)) {
				idCriterion=Restrictions.disjunction().add(Restrictions.eq("_id", Integer.valueOf(textToFind)))
						.add(Restrictions.ilike("_registrationNumber", Integer.valueOf(textToFind)));
				
			}
			
			if(idCriterion!=null){
				criteria.add(Restrictions.or(propertyCriterion, idCriterion));
			}else{
				criteria.add(propertyCriterion);
			}
		}
		
		criteria.setFirstResult(page*maxItems);
		criteria.setMaxResults(maxItems);
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<UserDomain> users = criteria.list();
		return users;
	}


}
