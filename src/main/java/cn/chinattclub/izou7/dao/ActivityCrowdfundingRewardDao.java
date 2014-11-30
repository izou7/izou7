package cn.chinattclub.izou7.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.chinattclub.izou7.entity.ActivityCrowdfundingReward;
import cn.zy.commons.dao.hibernate.AdvancedHibernateDao;
/**
 * 活动众筹DAO
 * @author ZY
 *
 */
@Repository
public class ActivityCrowdfundingRewardDao  extends AdvancedHibernateDao<ActivityCrowdfundingReward>{

	public List<ActivityCrowdfundingReward> findByActivityId(Integer activityId) {
		// TODO Auto-generated method stub
		Criteria criteria = this.getCurrentSession().createCriteria(
				ActivityCrowdfundingReward.class);
		criteria.add(Restrictions.eq("activity", activityId));
		return criteria.list();
	}
}
