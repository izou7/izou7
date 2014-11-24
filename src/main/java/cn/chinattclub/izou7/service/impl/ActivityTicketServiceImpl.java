package cn.chinattclub.izou7.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.ActivityTicketDao;
import cn.chinattclub.izou7.entity.ActivityTicket;
import cn.chinattclub.izou7.service.ActivityTicketService;
/**
 * 活动票务业务逻辑类
 * @author ZY
 *
 */
@Service
public class ActivityTicketServiceImpl implements ActivityTicketService {

	@Resource
	private ActivityTicketDao dao;
	
	@Override
	public ActivityTicket findByActivityId(int activityId) {
		// TODO Auto-generated method stub
		String hql = "from ActivityTicket as ticket where ticket.activity=?";
		List<ActivityTicket> tickets = dao.findByHQL(hql, 0, 1, activityId);
		if(tickets!=null&&tickets.size()>0){
			return tickets.get(0);
		}else{
			return null;
		}
	}
	
	
}
