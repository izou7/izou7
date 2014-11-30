package cn.chinattclub.izou7.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.dao.ActivityGuestsDao;
import cn.chinattclub.izou7.dao.ActivityGuestsSettingDao;
import cn.chinattclub.izou7.entity.Activity;
import cn.chinattclub.izou7.entity.ActivityGuest;
import cn.chinattclub.izou7.entity.ActivityGuestsSetting;
import cn.chinattclub.izou7.service.ActivityGuestsService;
import cn.chinattclub.izou7.service.ActivityGuestsSettingService;
import cn.chinattclub.izou7.service.ActivityService;

/**
 * 用户业务逻辑类
 * @author ZY
 *
 */
@Service
public class ActivityGuestsServiceImpl implements ActivityGuestsService {
	@Resource
	private ActivityGuestsDao dao;
	
	@Resource
    private ActivityService activityServiceImpl;

	@Override
	public List<ActivityGuest> getFixedGuests(Activity activity) {
		return dao.getFixedGuests(activity);
	}
	
	@Override
	public List<ActivityGuest> getSendingGuests(Activity activity) {
		return dao.getSendingGuests(activity);
	}

	@Override
	public List<ActivityGuest> getWaitingGuests(Activity activity) {
		return dao.getWaitingGuests(activity);
	}

	@Override
	public void update(ActivityGuest sendingGuest) {
		dao.update(sendingGuest);
	}

	@Override
	public void execSequence(int activityId, int guestId, boolean up) {
		// TODO Auto-generated method stub
		Activity activity = activityServiceImpl.findById(activityId);
		List<ActivityGuest> guests = activity.getGuests();
		ActivityGuest guest = dao.get(guestId);
		int rank = guest.getRank();
		ActivityGuest waitGuest = null;
		if(up){
			guest.setRank(rank-1);
			for (ActivityGuest gst : guests) {
				if(gst.getRank()==(rank-1)){
					waitGuest =  gst;
					waitGuest.setRank(rank);
					break;
				}
			}
		}else{
			guest.setRank(rank+1);
			for (ActivityGuest gst : guests) {
				if(gst.getRank()==(rank+1)){
					waitGuest =  gst;
					waitGuest.setRank(rank);
					break;
				}
			}
		}
		update(guest);
		update(waitGuest);
	}

	@Override
	public void add(ActivityGuest aGuest) {
		// TODO Auto-generated method stub
		dao.save(aGuest);
	}

	@Override
	public int getMaxRank(int activityId) {
		// TODO Auto-generated method stub
		Activity activity = activityServiceImpl.findById(activityId);
		int maxRank = 0;
		for (ActivityGuest guest : activity.getGuests()) {
			if(guest.getRank()>maxRank){
				maxRank = guest.getRank();
			}
		}
		return maxRank;
	}

	@Override
	public Object getGuestsByActivityId(int activityId) {
		return dao.getGuestsByActivityId(activityId);
	}

	@Override
	public void delete(int guestId) {
		// TODO Auto-generated method stub.
		dao.delete(guestId);
	}
	
}
