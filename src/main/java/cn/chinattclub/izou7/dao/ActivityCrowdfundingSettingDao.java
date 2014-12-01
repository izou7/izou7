package cn.chinattclub.izou7.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.chinattclub.izou7.entity.ActivityCrowdfundingSetting;
import cn.zy.commons.dao.hibernate.AdvancedHibernateDao;

/**
 * 活动众筹DAO
 * 
 * @author ZY
 * 
 */
@Repository
public class ActivityCrowdfundingSettingDao extends
		AdvancedHibernateDao<ActivityCrowdfundingSetting> {

	public ActivityCrowdfundingSetting findByActivityId(Integer activityId) {
		Criteria criteria = this.getCurrentSession().createCriteria(
				ActivityCrowdfundingSetting.class);
		criteria.add(Restrictions.eq("activity", activityId));
		return (ActivityCrowdfundingSetting)criteria.uniqueResult();
	}
}
