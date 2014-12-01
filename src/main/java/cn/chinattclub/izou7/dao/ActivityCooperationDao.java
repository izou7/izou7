package cn.chinattclub.izou7.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.chinattclub.izou7.entity.ActivityCooperation;
import cn.zy.commons.dao.hibernate.AdvancedHibernateDao;
/**
 * 活动合作基本信息DAO
 * @author ZY
 *
 */
@Repository
public class ActivityCooperationDao  extends AdvancedHibernateDao<ActivityCooperation>{
	
	public List<ActivityCooperation> findByActivityId(int activityId){
		Criteria criteria = this.getCurrentSession().createCriteria(ActivityCooperation.class);
		criteria.add(Restrictions.eq("activity", activityId));
		return criteria.list();
	}
}
