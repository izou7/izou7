package cn.chinattclub.izou7.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.chinattclub.izou7.entity.Activity;
import cn.zy.commons.dao.hibernate.AdvancedHibernateDao;
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
		criteria.add(Restrictions.le("id", activityId));
		criteria.setFetchMode("act.city", org.hibernate.FetchMode.JOIN);
		return (Activity)criteria.uniqueResult();
	}
}
