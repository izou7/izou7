package cn.chinattclub.izou7.web;

import java.util.Date;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chinattclub.izou7.entity.Guest;
import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.entity.UserInfo;
import cn.chinattclub.izou7.service.GuestService;
import cn.chinattclub.izou7.service.TagService;
import cn.chinattclub.izou7.service.UserInfoService;
import cn.chinattclub.izou7.service.UserService;
import cn.chinattclub.izou7.util.CommonUtil;
import cn.zy.commons.webdev.constant.ResponseStatusCode;
import cn.zy.commons.webdev.http.RestResponse;

/**
 * 
 * @ClassName: GuestController
 * @Description:嘉宾控制类
 * @author: zy
 * @date: 2015-01-31 下午8:00:36
 * 
 */
@Controller
@RequestMapping(value="/guest")
public class GuestController {

	private static final Logger logger = LoggerFactory
			.getLogger(GuestController.class);
	
	@Resource
	private TagService tagServiceImpl;

	@Resource
	private UserService userServiceImpl;
	
	@Resource
	private UserInfoService userInfoServiceImpl;
	
	@Resource
	private GuestService guestServiceImpl;
	
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String indexPage(Model model) {
		User user = userServiceImpl.findByUsername(CommonUtil.getCurrentUser().getUsername());
		UserInfo userInfo  = user.getUserInfo();
		model.addAttribute("tags", tagServiceImpl.list());
		model.addAttribute("userInfo", userInfo);
		return "site.guest.info";
	}
	
	/**
	 * 
	 * TODO 新增
	 *
	 * @param publicObj
	 * @param br
	 * @return
	 * @throws ClassNotFoundException
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse addGuest(@RequestBody @Valid Guest guest, BindingResult br) throws  ClassNotFoundException  {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String message = "新嘉宾地成功！";
		if(!CommonUtil.validateDto(response,br,guest.getClass().getName().toString())){
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
		}else{
			guest.setCreateTime(new Date());
			guest.setUserId(CommonUtil.getCurrentUser().getId());
			if(guest.isSelf()){
				UserInfo userInfo = userServiceImpl.findByUsername(CommonUtil.getCurrentUser().getUsername()).getUserInfo();
				userInfo.setRealName(guest.getRealName());
				userInfo.setPhone(guest.getPhone());
				userInfo.setCompany(guest.getCompany());
				userInfo.setPosition(guest.getPosition());
				userInfoServiceImpl.update(userInfo);
			}
			guestServiceImpl.save(guest);
			response.setMessage(message);
		}
		response.setStatusCode(statusCode);
		return response;
	}

	
}
