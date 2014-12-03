
package cn.chinattclub.izou7.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.chinattclub.izou7.service.UserService;

/**
 * 
 * @ClassName:	UserController 
 * @Description:用户控制类
 * @author:	zy
 * @date:	2014-11-9 下午8:00:36 
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userServiceImpl;
	
//	@RequestMapping(value="logout", method = RequestMethod.GET)
//	public String logoutPage() {
//		Subject subject = SecurityUtils.getSubject();
//		subject.logout();
//		return "site.main.index";
//	}
	/**
	 * 登录页
	 * @return
	 */
//	@RequestMapping(value="login", method = RequestMethod.GET)
//	public String loginPage() {
//		return "raw.login.login";
//	}
	
	/**
	 * 登录
	 * @param user
	 * @return
	 */
//	@RequestMapping(value="login", method = RequestMethod.POST)
//	@ResponseBody
//	public RestResponse login(User user) {
//		RestResponse response = new RestResponse();
//		int statusCode = ResponseStatusCode.OK;
//		String msg = "登录成功！";
//		Subject currentUser = SecurityUtils.getSubject();
//		UsernamePasswordToken token = new UsernamePasswordToken(
//				user.getUsername(), user.getPassword());
//		try {
//			currentUser.login(token);
//		} catch (UnknownAccountException uae) {
//			msg = "用户名不存在系统！";
//			statusCode = ResponseStatusCode.UNAUTHORIZED;
//		} catch (IncorrectCredentialsException ice) {
//			msg = "密码错误！";
//			statusCode = ResponseStatusCode.UNAUTHORIZED;
//		} catch (LockedAccountException lae) {
//			msg = "用户已经被锁定不能登录，请与管理员联系！";
//			statusCode = ResponseStatusCode.UNAUTHORIZED;
//		} catch (ExcessiveAttemptsException eae) {
//			msg = "错误次数过多！";
//			statusCode = ResponseStatusCode.UNAUTHORIZED;
//		} catch (AuthenticationException ae) {
//			msg = "其他的登录错误！";
//			statusCode = ResponseStatusCode.UNAUTHORIZED;
//		}
//		response.setMessage(msg);
//		response.setStatusCode(statusCode);
//		response.getBody().put("key", userServiceImpl.findByUsername(user.getUsername()).getKey());
//		return response;
//
//	}

}
