package cn.chinattclub.izou7.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.ActivityScheduleDao;
import cn.chinattclub.izou7.entity.ActivitySchedule;
import cn.chinattclub.izou7.service.ActivityScheduleService;
/**
 * 文章业务逻辑类
 * @author ZY
 *
 */
@Service
public class ActivityScheduleServiceImpl implements ActivityScheduleService {

	@Resource
	private ActivityScheduleDao dao;

	@Override
	public List<ActivitySchedule> findById(int id) {
		// TODO Auto-generated method stub
		return dao.findByHQL("from ActivitySchedule as sch where sch.activity=?",0,1000,id);
	}

	@Override
	public void add(ActivitySchedule schedule) {
		// TODO Auto-generated method stub
		dao.save(schedule);
	}

	@Override
	public void delete(int scheduleId) {
		// TODO Auto-generated method stub
		dao.delete(scheduleId);
	}

	@Override
	public List<ActivitySchedule> find(int id, Date start, Date end) {
		// TODO Auto-generated method stub
		return dao.findByHQL("from ActivitySchedule as sch where sch.activity=? and startTime>=? and endTime<=?",0,1000,id,start,end);
	}

	@Override
	public ActivitySchedule get(int id) {
		// TODO Auto-generated method stub
		return dao.get(id);
	}

	@Override
	public void update(ActivitySchedule as) {
		// TODO Auto-generated method stub
		dao.update(as);
	}
	
	
}
