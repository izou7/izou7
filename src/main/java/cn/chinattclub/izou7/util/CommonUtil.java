package cn.chinattclub.izou7.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.service.UserService;



/**
 * TODO 通用工具类
 *
 * @author zhangying.
 *         Created 2014-4-18.
 */
@Component
public class CommonUtil {
	
	public static  DateFormat df = new SimpleDateFormat("yyyyMMdd");
	private static UserService userService;
	
	@Resource
	public void setUserService(UserService userService) {
		CommonUtil.userService = userService;
	}
	
	public static User getCurrentUser(){
		Subject currentUser = SecurityUtils.getSubject();
		String username = currentUser.getPrincipal().toString();
		return userService.findByUsername(username);
	}
	
}
