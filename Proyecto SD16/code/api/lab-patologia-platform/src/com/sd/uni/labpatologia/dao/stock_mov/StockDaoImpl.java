package com.sd.uni.labpatologia.dao.stock_mov;

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
import com.sd.uni.labpatologia.domain.stock_mov.StockDomain;
import com.sd.uni.labpatologia.exception.PatologyException;
@Repository
public class StockDaoImpl  extends BaseDaoImpl<StockDomain> implements IStockDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public StockDomain save(StockDomain domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		return domain;
	}
	@Override
	public StockDomain getById(Integer domainId) throws PatologyException {
		if (null != domainId) {
			return (StockDomain) sessionFactory.getCurrentSession().get(StockDomain.class, domainId);
		} else {
			throw new PatologyException("El ID no puede ser null");
		}
	}
	
	@Override
	public List<StockDomain> findAll() {
		final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StockDomain.class);
		return criteria.list();
	}

	@Override
	public List<StockDomain> find(String textToFind) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(StockDomain.class);
		Criterion propertyCriterion = Restrictions.disjunction().add(Restrictions.ilike("_name", "%"+textToFind+"%"));
				
		Criterion idCriterion = null;
		if (StringUtils.isNumeric(textToFind)) {
			idCriterion = Restrictions.eq("_id", Integer.valueOf(textToFind));
		}

		if (null != idCriterion) {
			criteria.add(Restrictions.or(propertyCriterion, idCriterion));
		} else {
			criteria.add(propertyCriterion);
		}
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<StockDomain> requests = criteria.list();
		return requests;
	}

}
