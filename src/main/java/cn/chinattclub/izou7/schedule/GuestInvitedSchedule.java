package cn.chinattclub.izou7.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class GuestInvitedSchedule {
	
	//@Resource
	//private ActivityGuestsSettingDao activityGuestsSettingDao;
	
	//@Resource
	//private ActivityGuestsDao activityGuestsDao;
	
	@Scheduled(fixedDelay = 5000, initialDelay = 1000)
	public void execInviteGuest(){
		System.out.println("---------------------");
//		List<ActivityGuestsSetting> activityGuestsSettings = activityGuestsSettingDao.getUnfixedActivity();
//		
//		for(ActivityGuestsSetting activityGuestsSetting:activityGuestsSettings){
//			List<ActivityGuests> fixedGuests = activityGuestsDao.getFixedGuests(activityGuestsSetting);
//			if (fixedGuests.size()>=activityGuestsSetting.getGuestNumber()){
//				activityGuestsSetting.setOver(true);
//				activityGuestsSettingDao.update(activityGuestsSetting);
//				continue;
//			}
//			int toSendNumber = activityGuestsSetting.getGuestNumber() - fixedGuests.size();
//			List<ActivityGuests> sendingGuests = activityGuestsDao.getSendingGuests(activityGuestsSetting);
//			for (ActivityGuests sendingGuest:sendingGuests){
//				if (new Date().getTime() - sendingGuest.getNotifyTime().getTime()>24*3600*1000*activityGuestsSetting.getGuestRegistrationDeadline()){
//					sendingGuest.setStatus(GuestRegistrationStatus.REFUSED);
//					activityGuestsDao.update(sendingGuest);
//				}else{
//					toSendNumber--;
//				}
//			}
//			List<ActivityGuests> waitingGuests = activityGuestsDao.getWaitingGuests(activityGuestsSetting);
//			for (ActivityGuests waitingGuest:waitingGuests){
//				if(toSendNumber<=0){
//					break;
//				}
//				CommonUtil.sendEmail("邀请", "来吧", waitingGuest.getEmail());
//				waitingGuest.setStatus(GuestRegistrationStatus.SEND);
//				waitingGuest.setNotifyTime(new Date());
//				activityGuestsDao.update(waitingGuest);
//				toSendNumber--;
//			}
//		}
	}
	
}
