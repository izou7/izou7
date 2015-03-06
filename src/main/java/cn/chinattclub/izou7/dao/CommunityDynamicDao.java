package cn.chinattclub.izou7.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.chinattclub.izou7.entity.CommunityDynamic;
import cn.zy.commons.dao.hibernate.AdvancedHibernateDao;
import cn.zy.commons.webdev.vo.Page;

@Repository
public class CommunityDynamicDao extends AdvancedHibernateDao<CommunityDynamic>{

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param communityId
	 * @return
	 */
	public long findDynamicsCount(int communityId,String content) {
		// TODO Auto-generated method stub.
		// TODO Auto-generated method stub.
		Criteria criteria = this.getCurrentSession().createCriteria(CommunityDynamic.class,"cd");
		criteria.add(Restrictions.eq("cd.community.id", communityId));
		if(StringUtils.isNotBlank(content)||StringUtils.isNotEmpty(content)){
			criteria.add(Restrictions.like("cd.content", "%"+content+"%"));
		}
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
	public List<CommunityDynamic> findDynamics(Page page, int communityId,String content) {
		// TODO Auto-generated method stub.
		Criteria criteria = this.getCurrentSession().createCriteria(CommunityDynamic.class,"cd");
		criteria.add(Restrictions.eq("cd.community.id", communityId));
		if(StringUtils.isNotBlank(content)||StringUtils.isNotEmpty(content)){
			criteria.add(Restrictions.like("cd.content", "%"+content+"%"));
		}
		criteria.addOrder(Order.asc("cd.createTime"));
		return criteria.setFirstResult(page.getIndex()*page.getSize()).setMaxResults(page.getSize()).list();
	}
	
	
}
