package com.sd.uni.labpatologia.dao.user;


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
import com.sd.uni.labpatologia.domain.user.UserDomain;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;


@Repository
public class UserDaoImpl extends BaseDaoImpl<UserDomain> implements IUserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public UserDomain save(UserDomain domain) {
		domain=encryptPassword(domain);
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
	
	
	public UserDomain encryptPassword(UserDomain domain){
		MessageDigest md = null;
		String password = domain.getPassword();
	        try {
				md= MessageDigest.getInstance("SHA-512");
		        md.update(password.getBytes());
		        byte[] mb = md.digest();
		        String encPassword=String.valueOf(Hex.encodeHex(mb));
		        domain.setPassword(encPassword);
		        System.out.println(encPassword);
		        
	        } catch (NoSuchAlgorithmException e) {
	        	
	            System.out.println("Error");
	        }
	        
	        return domain;
	}

	
	public List<UserDomain> find2(String textToFind) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserDomain.class);
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
		List<UserDomain> users = criteria.list();
		return users;
	}

	public List<UserDomain> find(String textToFind) {
		Integer id = null;
		if (StringUtils.isNumeric(textToFind)) {
			id = Integer.valueOf(textToFind);
		}
		Query q = sessionFactory.getCurrentSession().createQuery("from UserDomain where _name like :parameter or _password like :parameter or _id=:id");
		q.setParameter("parameter", "%" + textToFind + "%");
		q.setParameter("id", id);
		return q.list();
	}

}
