package cn.chinattclub.izou7.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.chinattclub.izou7.entity.Incubator;
import cn.zy.commons.dao.hibernate.AdvancedHibernateDao;
import cn.zy.commons.webdev.vo.Page;
/**
 * 
 * @author ZY
 *
 */
@Repository
public class IncubatorDao  extends AdvancedHibernateDao<Incubator>{
	
	/**
	 * 孵化器列表
	 */
	public List<Incubator> find(Page page){
		Criteria criteria = this.getCurrentSession().createCriteria(
				Incubator.class);
		criteria.add(Restrictions.eq("enable", true));
		criteria.addOrder(Order.asc("createTime"));
		return criteria.setFirstResult(page.getIndex()*page.getSize()).setMaxResults(page.getSize()).list();
	}
	
	public long findCount(){
		Criteria criteria = this.getCurrentSession().createCriteria(
				Incubator.class);
		criteria.add(Restrictions.eq("enable", true));
		criteria.setProjection(Projections.rowCount());
		return Integer.parseInt(criteria.uniqueResult().toString());
	}
}
