package cn.chinattclub.izou7.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.chinattclub.izou7.entity.Activity;
import cn.chinattclub.izou7.service.ActivityService;
import cn.chinattclub.izou7.service.UserService;

/**
 * 
 * @ClassName: ShareController
 * @Description:外部控制类
 * @author: zy
 * @date: 2015-04-10 下午8:00:36
 * 
 */
@Controller
@RequestMapping(value="/outer")
public class OuterController {

	private static final Logger logger = LoggerFactory
			.getLogger(OuterController.class);

	@Resource
	private ActivityService activityServiceImpl;
	
	@Resource
	private UserService userServiceImpl;
	
	
	
	@RequestMapping(value = "activity/{id}", method = RequestMethod.GET)
	public String indexPage(Model model,@PathVariable("id") int id) {
		Activity act = activityServiceImpl.findById(id);
		model.addAttribute("act",act);
		return "raw.outer.share";
	}
	
	@RequestMapping(value = "password/{key}", method = RequestMethod.GET)
	public String indexPage(Model model,@PathVariable("key") String key) {
		userServiceImpl.updateAndDecodeUser(key);
		return "raw.outer.pwback";
	}
	
	
	
}
