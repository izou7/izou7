package cn.chinattclub.izou7.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.chinattclub.izou7.entity.Public;
import cn.chinattclub.izou7.entity.User;
import cn.zy.commons.dao.hibernate.AdvancedHibernateDao;
/**
 * 活动基本信息DAO
 * @author ZY
 *
 */
@Repository
public class PublicDao  extends AdvancedHibernateDao<Public>{
	
	@SuppressWarnings("unchecked")
	public List<Public> listByUser(User user){
		Criteria criteria = this.getCurrentSession().createCriteria(Public.class);
		criteria.add(Restrictions.eq("user", user.getId()));
		criteria.addOrder(Order.desc("createTime"));
		return criteria.list();
	}
}
