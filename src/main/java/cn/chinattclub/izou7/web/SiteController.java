package cn.chinattclub.izou7.web;

import java.util.Date;
import java.util.List;

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

import cn.chinattclub.izou7.entity.Province;
import cn.chinattclub.izou7.entity.Site;
import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.entity.UserInfo;
import cn.chinattclub.izou7.service.CityService;
import cn.chinattclub.izou7.service.ProvinceService;
import cn.chinattclub.izou7.service.SiteService;
import cn.chinattclub.izou7.service.TagService;
import cn.chinattclub.izou7.service.UserInfoService;
import cn.chinattclub.izou7.service.UserService;
import cn.chinattclub.izou7.util.CommonUtil;
import cn.zy.commons.webdev.constant.ResponseStatusCode;
import cn.zy.commons.webdev.http.RestResponse;

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
	
	@Resource
	private CityService cityServiceImpl;
	
	@Resource
	private UserInfoService userInfoServiceImpl;
	
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String indexPage(Model model) {
		List<Province> provinces = provinceServiceImpl.findAll();
		User user = userServiceImpl.findByUsername(CommonUtil.getCurrentUser().getUsername());
		UserInfo userInfo  = user.getUserInfo();
		model.addAttribute("tags", tagServiceImpl.list());
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("provinces", provinces);
		return "site.site.info";
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
	public RestResponse addSite(@RequestBody @Valid Site site, BindingResult br) throws  ClassNotFoundException  {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String message = "新增场地成功！";
		if(!CommonUtil.validateDto(response,br,site.getClass().getName().toString())){
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
		}else{
			site.setCreateTime(new Date());
			site.setCity(cityServiceImpl.getCity(site.getCityId()));
			site.setUserId(CommonUtil.getCurrentUser().getId());
			if(site.isSelf()){
				UserInfo userInfo = userServiceImpl.findByUsername(CommonUtil.getCurrentUser().getUsername()).getUserInfo();
				userInfo.setRealName(site.getRealName());
				userInfo.setPhone(site.getPhone());
				userInfo.setCompany(site.getCompany());
				userInfo.setPosition(site.getPosition());
				userInfoServiceImpl.update(userInfo);
			}
			siteServiceImpl.save(site);
			response.setMessage(message);
		}
		response.setStatusCode(statusCode);
		return response;
	}

	
}
