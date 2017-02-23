package com.sd.uni.labpatologia.dao.contact;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.uni.labpatologia.dao.base.BaseDaoImpl;
import com.sd.uni.labpatologia.domain.contact.ContactDomain;
import com.sd.uni.labpatologia.exception.PatologyException;
@Repository
public class ContactDaoImpl  extends BaseDaoImpl<ContactDomain> implements IContactDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ContactDomain save(ContactDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}
	@Override
	public ContactDomain getById(Integer domainId) throws PatologyException {
		if (null != domainId) {
			return (ContactDomain) sessionFactory.getCurrentSession().get(ContactDomain.class, domainId);
		} else {
			throw new PatologyException("El ID no puede ser null");
		}
	}
	
	@Override
	public List<ContactDomain> findAll() {
		return null;
	}

	@Override
	public List<ContactDomain> find(String textToFind, int page, int maxItems) {
		return null;
	}

}
