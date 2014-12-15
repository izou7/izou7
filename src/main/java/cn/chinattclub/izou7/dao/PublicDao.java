package cn.chinattclub.izou7.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
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
		criteria.add(Restrictions.eq("user", user));
		criteria.addOrder(Order.desc("createTime"));
		return criteria.list();
	}

	/**
	 * 系统推荐
	 *
	 * @param tags
	 * @return
	 */
	public List<Public> recommend(String[] tags) {
		// TODO Auto-generated method stub.
		Criteria criteria = this.getCurrentSession().createCriteria(Public.class);
		Disjunction dis=Restrictions.disjunction();
		for (String tag : tags) {
			dis.add(Restrictions.like("tags", tag, MatchMode.ANYWHERE));
		}
		criteria.add(dis);
		criteria.setFirstResult(0);
		criteria.setMaxResults(10);
		return criteria.list();
	}
}
