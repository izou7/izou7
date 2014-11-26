package cn.chinattclub.izou7.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.chinattclub.izou7.entity.Activity;
import cn.chinattclub.izou7.entity.ActivityGuests;
import cn.chinattclub.izou7.entity.ActivityGuestsSetting;
import cn.chinattclub.izou7.enumeration.GuestRegistrationStatus;
import cn.zy.commons.dao.hibernate.AdvancedHibernateDao;

@Repository
public class ActivityGuestsDao extends AdvancedHibernateDao<ActivityGuests> {

	@SuppressWarnings("unchecked")
	public List<ActivityGuests> getFixedGuests(Activity activity) {
		Criteria criteria = this.getCurrentSession().createCriteria(ActivityGuests.class);
		criteria.add(Restrictions.eq("activity", activity.getId()));
		criteria.add(Restrictions.eq("status", GuestRegistrationStatus.PASS));
		criteria.add(Restrictions.eq("type",1));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<ActivityGuests> getSendingGuests(Activity activity) {
		Criteria criteria = this.getCurrentSession().createCriteria(ActivityGuests.class);
		criteria.add(Restrictions.eq("activity", activity.getId()));
		criteria.add(Restrictions.eq("status", GuestRegistrationStatus.SEND));
		criteria.add(Restrictions.eq("type",1));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<ActivityGuests> getWaitingGuests(Activity activity) {
		Criteria criteria = this.getCurrentSession().createCriteria(ActivityGuests.class);
		criteria.add(Restrictions.eq("activity", activity.getId()));
		criteria.add(Restrictions.eq("status", GuestRegistrationStatus.NOTSEND));
		criteria.add(Restrictions.eq("type",1));
		criteria.addOrder(Order.asc("rank"));
		return criteria.list();
	}

}
