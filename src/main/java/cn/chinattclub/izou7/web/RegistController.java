package cn.chinattclub.izou7.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.service.UserService;
import cn.zy.commons.webdev.http.RestResponse;

@Controller
@RequestMapping(value="/regist")
public class RegistController {
	@Resource 
	private UserService userService;
	
	@RequestMapping(value="/regist", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse regist(@RequestBody User user) {
		RestResponse response = new RestResponse();
		try{
			if(userService.exists(user)){
				response.setMessage("该用户已经存在");
				response.setStatusCode(508);
			}else{
				userService.createUser(user);
				response.setMessage("注册成功");
				response.setStatusCode(200);
			}
		}catch(Exception e){
			response.setMessage("注册失败");
			response.setStatusCode(500);
		}
		return response;
	}
}
