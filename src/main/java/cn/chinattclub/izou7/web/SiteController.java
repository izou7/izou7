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
import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.service.ActivityService;
import cn.chinattclub.izou7.service.SiteService;
import cn.chinattclub.izou7.service.SponsorService;
import cn.chinattclub.izou7.service.UserService;
import cn.zy.commons.webdev.constant.ResponseStatusCode;
import cn.zy.commons.webdev.http.RestResponse;
import cn.zy.commons.webdev.vo.Page;

/**
 * 
 * @ClassName: MainController
 * @Description:场地控制类
 * @author: zy
 * @date: 2015-01-31 下午8:00:36
 * 
 */
@Controller
@RequestMapping(value="/site")
public class SiteController {

	private static final Logger logger = LoggerFactory
			.getLogger(SiteController.class);

	@Resource
	private SiteService siteServiceImpl;
	
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String indexPage(Model model) {
		return "site.site.index";
	}

	
}
