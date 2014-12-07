/**
 * 
 */
package cn.chinattclub.izou7.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.service.UserService;


/**
 * 
 * @author zy
 * 
 */
public class RequestAnalyzerInterceptor extends HandlerInterceptorAdapter {
	
	@Resource 
	private UserService userServiceImpl;
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle
	 * (javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated()){
			String realName = "";
			User user = userServiceImpl.findByUsername(subject.getPrincipal().toString());
			if(user.getUserInfo()==null){
				realName = user.getUsername();
			}else{
				realName = user.getUserInfo().getRealName();
				
			}
			request.setAttribute("realName", realName);
		}
		return true;
	}

}
