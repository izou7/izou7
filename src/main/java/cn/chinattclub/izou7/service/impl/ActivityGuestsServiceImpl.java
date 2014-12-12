package cn.chinattclub.izou7.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.chinattclub.izou7.comparator.RankComparator;
import cn.chinattclub.izou7.dao.ActivityGuestsDao;
import cn.chinattclub.izou7.dao.ActivityGuestsSettingDao;
import cn.chinattclub.izou7.entity.Activity;
import cn.chinattclub.izou7.entity.ActivityGuest;
import cn.chinattclub.izou7.entity.ActivityGuestsSetting;
import cn.chinattclub.izou7.service.ActivityGuestsService;
import cn.chinattclub.izou7.service.ActivityGuestsSettingService;
import cn.chinattclub.izou7.service.ActivityService;
import cn.chinattclub.izou7.web.ActivityController;

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
	
	private static final Logger logger = LoggerFactory.getLogger(ActivityGuestsServiceImpl.class);

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
		Set<ActivityGuest> tgs = activity.getGuests();
		ActivityGuest guest = dao.get(guestId);
		int rank = guest.getRank();
		List<ActivityGuest> guests = new ArrayList<ActivityGuest>();
		guests.addAll(tgs);
		Collections.sort(guests,new RankComparator());
		for(int i=0;i<guests.size();i++){
			if(guests.get(i).getRank()==rank){
				if(up){
					if(i==0){
						logger.warn("该嘉宾【"+guestId+"】的排名已处最高级，上调失败");
					}else{
						int tempRank =  guests.get(i-1).getRank();
						guests.get(i-1).setRank(rank);
						guests.get(i).setRank(tempRank);
					}
				}else{
					if(i==guests.size()-1){
						logger.warn("该嘉宾【"+guestId+"】的排名已处最低级，下调失败");
					}else{
						int tempRank =  guests.get(i+1).getRank();
						guests.get(i+1).setRank(rank);
						guests.get(i).setRank(tempRank);
					}
				}
				break;
			}
		}
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
	public List<ActivityGuest> getGuestsByActivityId(int activityId) {
		return dao.getGuestsByActivityId(activityId);
	}

	@Override
	public void delete(int guestId) {
		// TODO Auto-generated method stub.
		dao.delete(guestId);
	}

	@Override
	public boolean validateSysGuest(int activityId, int sysGuestId) {
		// TODO Auto-generated method stub.
		List<ActivityGuest> ags = dao.findByHQL("from ActivityGuest ag where ag.activity=?",0,0,activityId);
		for (ActivityGuest activityGuest : ags) {
			if(activityGuest.getUser().getUserInfo().getId()==sysGuestId){
				return false;
			}
		}
		return true;
	}
}
