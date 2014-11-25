package cn.chinattclub.izou7.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.chinattclub.izou7.entity.ActivityGuestsSetting;
import cn.chinattclub.izou7.entity.Public;
import cn.zy.commons.dao.hibernate.AdvancedHibernateDao;

@Repository
public class ActivityGuestsSettingDao extends AdvancedHibernateDao<ActivityGuestsSetting>{

	@SuppressWarnings("unchecked")
	public List<ActivityGuestsSetting> getUnfixedActivity() {
		Criteria criteria = this.getCurrentSession().createCriteria(ActivityGuestsSetting.class);
		criteria.add(Restrictions.eq("over", false));
		return criteria.list();
	}

}
