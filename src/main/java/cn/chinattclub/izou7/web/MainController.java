package cn.chinattclub.izou7.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chinattclub.izou7.dto.ActivityListDto;
import cn.chinattclub.izou7.dto.ActivityQueryDto;
import cn.chinattclub.izou7.dto.RegistUserDto;
import cn.chinattclub.izou7.entity.Activity;
import cn.chinattclub.izou7.entity.Agency;
import cn.chinattclub.izou7.entity.Contact;
import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.entity.UserInfo;
import cn.chinattclub.izou7.service.ActivityService;
import cn.chinattclub.izou7.service.AgencyService;
import cn.chinattclub.izou7.service.ContactService;
import cn.chinattclub.izou7.service.UserService;
import cn.chinattclub.izou7.util.CommonUtil;
import cn.zy.commons.webdev.constant.ResponseStatusCode;
import cn.zy.commons.webdev.http.RestResponse;
import cn.zy.commons.webdev.vo.Page;

/**
 * 
 * @ClassName: MainController
 * @Description:系統主頁控制类
 * @author: zy
 * @date: 2014-11-9 下午8:00:36
 * 
 */
@Controller
public class MainController {

	private static final Logger logger = LoggerFactory
			.getLogger(MainController.class);

	@Resource
	private UserService userServiceImpl;
	
	@Resource
	private ActivityService activityServiceImpl;
	
	@Resource
	private ContactService contactServiceImpl;
	
	@Resource
	private AgencyService agencyServiceImpl;
	
	@RequestMapping(value = {"/index","/"}, method = RequestMethod.GET)
	public String indexPage(Model model,Page page,ActivityQueryDto query) {
		return "site.community.index";
	}

	
	
	@RequestMapping(value = "error", method = RequestMethod.GET)
	public String errorPage() {
		return "site.main.error";
	}

	/**
	 * 
	 * 注册页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "regist", method = RequestMethod.GET)
	public String registPage() {
		return "site.main.regist";
	}

	/**
	 * 
	 * 注册
	 * 
	 * @return
	 
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public String regist(Model model, @Valid RegistUserDto dto, BindingResult br) {
		String modelPage = "site.main.regist";
		String error = "";
		if (br.hasErrors()) {
			error = br.getAllErrors().get(0).getDefaultMessage();
		} else {
			if (!dto.getPassword().equals(dto.getPassword2())) {
				error = "密码两次输入不一致";
			} else {
				if (userServiceImpl.exists(dto.getUsername())) {
					error = "该邮箱已经被注册";
				} else {
					User user = new User();
					user.setUsername(dto.getUsername());
					user.setPassword(dto.getPassword());
					userServiceImpl.createUser(user);
					UserInfo userInfo = new UserInfo();
					userInfo.setEmail(dto.getUsername());
					
					User loginUser = new User();
					loginUser.setUsername(dto.getUsername());
					loginUser.setPassword(dto.getPassword());
					RestResponse response = login(loginUser);
					if(response.getStatusCode()!=ResponseStatusCode.OK){
						error = response.getMessage();
					}
					modelPage = "redirect:/index";
				}
			}
		}
		model.addAttribute("error", error);
		return modelPage;
	}
*/
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse login(@RequestBody User user) {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String msg = "登录成功！";
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(
				user.getUsername(), user.getPassword());
		try {
			currentUser.login(token);
		} catch (UnknownAccountException uae) {
			msg = "用户名不存在！";
			logger.error("用户名【" + user.getUsername() + "】不存在！", uae);
			statusCode = ResponseStatusCode.UNAUTHORIZED;
		} catch (IncorrectCredentialsException ice) {
			msg = "密码错误！";
			logger.error("用户【" + user.getUsername() + "】密码错误！", ice);
			statusCode = ResponseStatusCode.UNAUTHORIZED;
		} catch (LockedAccountException lae) {
			msg = "用户已经被锁定不能登录，请与管理员联系！";
			logger.error("用户【" + user.getUsername() + "】被锁定！", lae);
			statusCode = ResponseStatusCode.UNAUTHORIZED;
		} catch (ExcessiveAttemptsException eae) {
			msg = "错误次数过多！";
			logger.error("用户【" + user.getUsername() + "】错误次数过多！", eae);
			statusCode = ResponseStatusCode.UNAUTHORIZED;
		} catch (AuthenticationException ae) {
			logger.error("用户【" + user.getUsername() + "】其他登陆错误！", ae);
			msg = "其他的登录错误！";
			statusCode = ResponseStatusCode.UNAUTHORIZED;
		}
		response.setMessage(msg);
		response.setStatusCode(statusCode);
		return response;
	}
	
	/**
	 * 
	 * 联系我们
	 *
	 * @return
	 */
	@RequestMapping(value = "contact", method = RequestMethod.GET)
	public String contactUs() {
		return "site.main.contact";
	}
	@RequestMapping(value = "contact", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse addContactUs(@RequestBody @Valid Contact contact,BindingResult br) throws SecurityException, ClassNotFoundException {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String message = "添加联系成功";
		if(!CommonUtil.validateDto(response,br,contact.getClass().getName().toString())){
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
		}else{
			contactServiceImpl.add(contact);
		}
		response.setStatusCode(statusCode);
		return response;
	}
	/**
	 * 
	 * 加入我们
	 *
	 * @return
	 */
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String joinUs() {
		return "site.main.join";
	}
	/**
	 * 
	 * 代理
	 *
	 * @return
	 */
	@RequestMapping(value = "agency", method = RequestMethod.GET)
	public String agency() {
		return "site.main.agency";
	}
	
	
	@RequestMapping(value = "agency", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse addAgency(@RequestBody @Valid Agency agency,BindingResult br) throws SecurityException, ClassNotFoundException {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String message = "添加代理成功";
		if(!CommonUtil.validateDto(response,br,agency.getClass().getName().toString())){
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
		}else{
			agencyServiceImpl.add(agency);
		}
		response.setStatusCode(statusCode);
		return response;
	}
	
	
	
	
}
