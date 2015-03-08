package cn.chinattclub.izou7.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.chinattclub.izou7.entity.CommunityMember;
import cn.zy.commons.dao.hibernate.AdvancedHibernateDao;
import cn.zy.commons.webdev.vo.Page;


/**
 * 社区成员实体类
 * 
 * @author ZY
 * 
 */
@Repository
public class CommunityMemberDao extends AdvancedHibernateDao<CommunityMember>{

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param communityId
	 * @return
	 */
	public long findMemberCount(int communityId) {
		// TODO Auto-generated method stub.
		Criteria criteria = this.getCurrentSession().createCriteria(CommunityMember.class,"cm");
		criteria.add(Restrictions.eq("cm.community.id", communityId));
		criteria.setProjection(Projections.rowCount());
		return Integer.parseInt(criteria.uniqueResult().toString());
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param page
	 * @param communityId
	 * @return
	 */
	public List<CommunityMember> findMember(Page page, int communityId) {
		// TODO Auto-generated method stub.
		Criteria criteria = this.getCurrentSession().createCriteria(CommunityMember.class,"cm");
		criteria.add(Restrictions.eq("cm.community.id", communityId));
		criteria.addOrder(Order.asc("createTime"));
		return criteria.setFirstResult(page.getIndex()*page.getSize()).setMaxResults(page.getSize()).list();
	}
	
}
