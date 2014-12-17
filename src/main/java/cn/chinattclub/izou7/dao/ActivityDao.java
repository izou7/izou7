package cn.chinattclub.izou7.dao;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.chinattclub.izou7.dto.ActivityQueryDto;
import cn.chinattclub.izou7.entity.Activity;
import cn.zy.commons.dao.hibernate.AdvancedHibernateDao;
import cn.zy.commons.webdev.vo.Page;
/**
 * 活动基本信息DAO
 * @author ZY
 *
 */
@Repository
public class ActivityDao  extends AdvancedHibernateDao<Activity>{

	public List<Activity> getUnfixedActivity() {
		Criteria criteria = this.getCurrentSession().createCriteria(Activity.class);
		criteria.createAlias("settings", "s").add(Restrictions.eq("s.over", false));
		criteria.add(Restrictions.le("startTime", new Date()));
		return criteria.list();
	}

	public Integer findCountByHQL(String hql,Object... params) {
		Query query = this.getCurrentSession().createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return ((Long) query.iterate().next()).intValue();
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param activityId
	 * @return
	 */
	public Activity findAllById(int activityId) {
		// TODO Auto-generated method stub.
		Criteria criteria = this.getCurrentSession().createCriteria(Activity.class,"act");
		criteria.add(Restrictions.eq("id", activityId));
		criteria.setFetchMode("city", FetchMode.JOIN);
		criteria.setFetchMode("articles", FetchMode.JOIN);
		criteria.setFetchMode("guests", FetchMode.JOIN);
		criteria.setFetchMode("tickets", FetchMode.JOIN);
//		criteria.setFetchMode("rewards", FetchMode.JOIN);
//		criteria.setFetchMode("cfSettings", FetchMode.JOIN);
		criteria.addOrder(Order.asc("createTime"));
		return (Activity)criteria.uniqueResult();
	}

	/**
	 * 查询活动列表
	 *
	 * @param page
	 * @param query
	 */
	public List<Activity> findActivitys(Page page, ActivityQueryDto query) {
		// TODO Auto-generated method stub.
		Criteria criteria = this.getCurrentSession().createCriteria(Activity.class,"act");
		if(query.getUserId()!=null){
			criteria.add(Restrictions.eq("act.user.id", query.getUserId()));
		}
		if(query.getStatus()!=null){
			criteria.add(Restrictions.eq("act.status", query.getStatus()));
		}
		if(StringUtils.isNotBlank(query.getName())){
			criteria.add(Restrictions.like("name", "%"+query.getName()+"%"));
		}
		criteria.addOrder(Order.asc("createTime"));
		return criteria.setFirstResult(page.getIndex()*page.getSize()).setMaxResults(page.getSize()).list();
	}
	/**
	 * 查询活动列表count
	 *
	 * @param page
	 * @param query
	 */
	public int findActivitysCount(ActivityQueryDto query) {
		// TODO Auto-generated method stub.
		Criteria criteria = this.getCurrentSession().createCriteria(Activity.class,"act");
		if(query.getUserId()!=null){
			criteria.add(Restrictions.eq("act.user.id", query.getUserId()));
		}
		if(query.getStatus()!=null){
			criteria.add(Restrictions.eq("act.status", query.getStatus()));
			
		}
		criteria.setProjection(Projections.rowCount());
		return Integer.parseInt(criteria.uniqueResult().toString());
	}
}
