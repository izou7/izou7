package cn.chinattclub.izou7.web;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.chinattclub.izou7.entity.Province;
import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.entity.UserInfo;
import cn.chinattclub.izou7.service.ProvinceService;
import cn.chinattclub.izou7.service.SiteService;
import cn.chinattclub.izou7.service.TagService;
import cn.chinattclub.izou7.service.UserService;

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
	
	@Resource
	private TagService tagServiceImpl;

	@Resource
	private UserService userServiceImpl;
	
	@Resource
	private ProvinceService provinceServiceImpl;
	
	
	
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String indexPage(Model model) {
		List<Province> provinces = provinceServiceImpl.findAll();
		Subject subject = SecurityUtils.getSubject();
		String realName = "";
		User user = userServiceImpl.findByUsername(subject.getPrincipal().toString());
		UserInfo userInfo  = user.getUserInfo();
		model.addAttribute("tags", tagServiceImpl.list());
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("provinces", provinces);
		return "site.site.info";
	}

	
}
