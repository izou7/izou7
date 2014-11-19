package cn.chinattclub.izou7.web;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chinattclub.izou7.dto.UserInfoDto;
import cn.chinattclub.izou7.entity.Province;
import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.entity.UserInfo;
import cn.chinattclub.izou7.service.ProvinceService;
import cn.chinattclub.izou7.service.UserInfoService;
import cn.chinattclub.izou7.service.UserService;
import cn.chinattclub.izou7.util.CommonUtil;
import cn.zy.commons.webdev.http.RestResponse;


@Controller
@RequestMapping(value="/userInfo")
public class UserInfoController {
	@Resource 
	private UserInfoService userInfoServiceImpl;
	
	@Resource
	private UserService userServiceImpl;
	
	@Resource
	private ProvinceService ProvinceServiceImpl;
	
	@RequestMapping(value="/get", method = RequestMethod.GET)
	public String getUserInfo(Model model) {
		User user = CommonUtil.getCurrentUser();
		
		UserInfo userInfo = user.getUserInfo();
		List<Province> provinces = ProvinceServiceImpl.findAll();
		
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("provinces", provinces);
		return "site.userInfo.info";
	}
	
	/**
	@RequestMapping(value="/add", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse addUserInfo(@RequestBody UserInfo userInfo) {
		
		RestResponse response = new RestResponse();
		
		try{
			userInfoServiceImpl.addUserInfo(userInfo);
			response.setMessage("添加信息成功");
			response.setStatusCode(200);
		}catch(Exception e){
			response.setMessage("添加信息失败，内部错误");
			response.setStatusCode(500);
		}
		return response;
	}
	**/
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse updateUserInfo(@RequestBody UserInfoDto userInfoDto) {

		RestResponse response = new RestResponse();
		
		try{
			if(userInfoDto.getId()==null){
				userInfoServiceImpl.addUserInfo(userInfoDto);
				response.setMessage("添加信息成功");
				response.setStatusCode(200);
			}else{
				userInfoServiceImpl.updateUserInfo(userInfoDto,userInfoDto.getId());
				response.setMessage("修改信息成功");
				response.setStatusCode(200);
			}
		}catch(Exception e){
			response.setMessage("失败，内部错误");
			response.setStatusCode(500);
		}
		return response;
	}
	

}
