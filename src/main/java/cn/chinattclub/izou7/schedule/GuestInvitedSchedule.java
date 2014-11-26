package cn.chinattclub.izou7.schedule;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.chinattclub.izou7.entity.Activity;
import cn.chinattclub.izou7.entity.ActivityGuests;
import cn.chinattclub.izou7.entity.ActivityGuestsSetting;
import cn.chinattclub.izou7.enumeration.GuestRegistrationStatus;
import cn.chinattclub.izou7.service.ActivityGuestsService;
import cn.chinattclub.izou7.service.ActivityGuestsSettingService;
import cn.chinattclub.izou7.service.ActivityService;
import cn.chinattclub.izou7.util.CommonUtil;

@Component
public class GuestInvitedSchedule {
	
	@Resource
	private ActivityGuestsSettingService activityGuestsSettingServiceImpl;
	
	@Resource
	private ActivityGuestsService activityGuestsServiceImpl;
	
	@Resource
	private ActivityService activityServiceImpl;
	
	@Scheduled(fixedRate = 5000)
	void inviteGuest(){
		List<Activity> activities = activityServiceImpl.getUnfixedActivity();
		
		//List<ActivityGuestsSetting> activityGuestsSettings = activityGuestsSettingServiceImpl.getUnfixedActivity();
		
		for(Activity activity:activities){
			List<ActivityGuests> fixedGuests = activityGuestsServiceImpl.getFixedGuests(activity);
			ActivityGuestsSetting activityGuestsSetting = activity.getSettings().get(0);
			if (fixedGuests.size()>=activityGuestsSetting.getGuestNumber()){
				activityGuestsSetting.setOver(true);
				activityGuestsSettingServiceImpl.update(activityGuestsSetting);
				continue;
			}
			int toSendNumber = activityGuestsSetting.getGuestNumber() - fixedGuests.size();
			List<ActivityGuests> sendingGuests = activityGuestsServiceImpl.getSendingGuests(activity);
			for (ActivityGuests sendingGuest:sendingGuests){
				if (new Date().getTime() - sendingGuest.getNotifyTime().getTime()>24*3600*1000*activityGuestsSetting.getGuestRegistrationDeadline()){
					sendingGuest.setStatus(GuestRegistrationStatus.REFUSED);
					activityGuestsServiceImpl.update(sendingGuest);
				}else{
					toSendNumber--;
				}
			}
			List<ActivityGuests> waitingGuests = activityGuestsServiceImpl.getWaitingGuests(activity);
			for (ActivityGuests waitingGuest:waitingGuests){
				if(toSendNumber<=0){
					break;
				}
				CommonUtil.sendEmail("邀请", "来吧", waitingGuest.getEmail());
				waitingGuest.setStatus(GuestRegistrationStatus.SEND);
				waitingGuest.setNotifyTime(new Date());
				activityGuestsServiceImpl.update(waitingGuest);
				toSendNumber--;
			}
		}
	}
	
}
