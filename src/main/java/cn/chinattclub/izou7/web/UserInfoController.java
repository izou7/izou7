package cn.chinattclub.izou7.web;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.entity.UserInfo;
import cn.chinattclub.izou7.service.UserInfoService;
import cn.zy.commons.webdev.http.RestResponse;


@Controller
@RequestMapping(value="/userInfo")
public class UserInfoController {
	@Resource 
	private UserInfoService userInfoService;
	
	@RequestMapping(value="/get", method = RequestMethod.GET)
	public String getUserInfo(Model model ,User user) {
		
		UserInfo userInfo = userInfoService.getUserInfo(user);
		model.addAttribute("userInfo", userInfo);
		return "site.userInfo.get";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse addUserInfo(@RequestBody UserInfo userInfo) {
		
		RestResponse response = new RestResponse();
		
		try{
			userInfoService.addUserInfo(userInfo);
			response.setMessage("添加信息成功");
			response.setStatusCode(200);
		}catch(Exception e){
			response.setMessage("添加信息失败，内部错误");
			response.setStatusCode(500);
		}
		return response;
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse updateUserInfo(@RequestBody UserInfo userInfo) {
		
		RestResponse response = new RestResponse();
		
		try{
			userInfoService.updateUserInfo(userInfo);
			response.setMessage("修改信息成功");
			response.setStatusCode(200);
		}catch(Exception e){
			response.setMessage("修改信息失败，内部错误");
			response.setStatusCode(500);
		}
		return response;
	}
	

}
