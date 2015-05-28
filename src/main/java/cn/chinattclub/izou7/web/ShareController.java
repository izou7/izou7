
package cn.chinattclub.izou7.web;

import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.chinattclub.izou7.entity.Activity;
import cn.chinattclub.izou7.entity.CommunityDynamic;
import cn.chinattclub.izou7.service.ActivityService;
import cn.chinattclub.izou7.service.CommunityDynamicService;

/**
 * 
 * app分享控制类
 *
 * @author zhangying.
 *         Created 2014-11-17.
 */
@Controller
@RequestMapping("share")
public class ShareController {
	
	@Resource
	private ActivityService activityServiceImpl;
	
	@Resource
	private CommunityDynamicService communityDynamicServiceImpl;
	
	
	
	@RequestMapping(value = "dynamic/{id}", method = RequestMethod.GET)
	public String dynamicPage(Model model,@PathVariable int id) {
		CommunityDynamic dn = communityDynamicServiceImpl.findById(id);
		model.addAttribute("dn",dn);
		return "raw.share.dynamic";
	}
	
	@RequestMapping(value = "activity/{id}", method = RequestMethod.GET)
	public String activityPage(Model model,@PathVariable int id) {
		Calendar cal = Calendar.getInstance();
		Activity activity = activityServiceImpl.findALLById(id);
		cal.setTime(activity.getStartTime());
		int week = cal.get(Calendar.DAY_OF_WEEK);
		String weekStr = "";
		if(week==7){
			weekStr = "六";
		}else if (week==1){
			weekStr = "日";
		}else if (week==2){
			weekStr = "一";
		}else if (week==3){
			weekStr = "二";
		}else if (week==4){
			weekStr = "三";
		}else if (week==5){
			weekStr = "四";
		}else if (week==6){
			weekStr = "五";
		}
		model.addAttribute("act",activity);
		model.addAttribute("week",weekStr);
		return "raw.share.activity";
	}
}
