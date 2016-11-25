package com.sd.uni.labpatologia.dao.message;

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
import com.sd.uni.labpatologia.dao.message.IMessageDao;
import com.sd.uni.labpatologia.domain.doctor.DoctorDomain;
import com.sd.uni.labpatologia.domain.message.MessageDomain;
import com.sd.uni.labpatologia.exception.PatologyException;

@Repository
public class MessageDaoImpl extends BaseDaoImpl<MessageDomain> implements IMessageDao {
		@Autowired
		private SessionFactory _sessionFactory;

		@Override
		public MessageDomain save(MessageDomain domain) {
			_sessionFactory.getCurrentSession().saveOrUpdate(domain);
			return domain;
		}

		@Override
		public MessageDomain getById(Integer domainId) throws PatologyException {
			if (null != domainId) {
				return (MessageDomain) _sessionFactory.getCurrentSession().get(MessageDomain.class, domainId);
			} else {
				throw new PatologyException("El ID no puede ser null");
			}
		}

		@Override
		public List<MessageDomain> findAll() {
			Session session = _sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(DoctorDomain.class);
			Criterion propertyCriterion = Restrictions.disjunction().add(Restrictions.eq("_sent", "false")); 
			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
			List<MessageDomain> messages = criteria.list();
			return messages;
		}

		@Override
		public List<MessageDomain> find(String textToFind, int page, int maxItems) {
			return null;
		}
		

	}
