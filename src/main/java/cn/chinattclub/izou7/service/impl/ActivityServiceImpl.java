package cn.chinattclub.izou7.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.ActivityDao;
import cn.chinattclub.izou7.entity.Activity;
import cn.chinattclub.izou7.service.ActivityService;
import cn.zy.commons.webdev.vo.Page;
/**
 * 活动业务逻辑实现类
 * @author ZY
 *
 */
@Service
public class ActivityServiceImpl implements ActivityService {

	@Resource
	private ActivityDao dao;
	
	@Override
	public Activity findById(int id) {
		// TODO Auto-generated method stub
		return dao.get(id);
	}

	@Override
	public void update(Activity activity) {
		// TODO Auto-generated method stub
		dao.update(activity);
	}
	
	public void add(Activity activity){
		dao.save(activity);
	}

	@Override
	public List<Activity> getUnfixedActivity() {
		// TODO Auto-generated method stub
		return dao.getUnfixedActivity();
	}

	@Override
	public List<Activity> findActivitys(Page page,int id,int status) {
		// TODO Auto-generated method stub
		String hql = "from Activity act where act.user.id=? and act.status=?";
		String hqlCount = "select count(*) from Activity act where act.user.id=? and act.status=? "; 
		page.setRecordCount(dao.findCountByHQL(hqlCount,id,status));
		return dao.findByHQL(hql,page.getIndex()*page.getSize(),page.getSize(),id,status);
	}
}
