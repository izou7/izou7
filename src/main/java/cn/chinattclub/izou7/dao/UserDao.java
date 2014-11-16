package cn.chinattclub.izou7.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.chinattclub.izou7.entity.User;
import cn.zy.commons.dao.hibernate.AdvancedHibernateDao;
/**
 * 
 * @author ZY
 *
 */
@Repository
public class UserDao  extends AdvancedHibernateDao<User>{

    public User findByUsername(String username) {
    	Criteria criteria = this.getCurrentSession().createCriteria(
				User.class);
    	criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("locked", false));
		return criteria.uniqueResult()==null?null:(User)criteria.uniqueResult();
    }
}
