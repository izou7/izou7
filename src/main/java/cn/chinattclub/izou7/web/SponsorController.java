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
import cn.chinattclub.izou7.entity.Sponsor;
import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.entity.UserInfo;
import cn.chinattclub.izou7.service.CityService;
import cn.chinattclub.izou7.service.ProvinceService;
import cn.chinattclub.izou7.service.SponsorService;
import cn.chinattclub.izou7.service.TagService;
import cn.chinattclub.izou7.service.UserInfoService;
import cn.chinattclub.izou7.service.UserService;
import cn.chinattclub.izou7.util.CommonUtil;
import cn.zy.commons.webdev.constant.ResponseStatusCode;
import cn.zy.commons.webdev.http.RestResponse;

/**
 * 
 * @ClassName: SponsorController
 * @Description:赞助商控制类
 * @author: zy
 * @date: 2015-01-31 下午8:00:36
 * 
 */
@Controller
@RequestMapping(value="/sponsor")
public class SponsorController {

	private static final Logger logger = LoggerFactory
			.getLogger(SponsorController.class);

	@Resource
	private SponsorService sponsorServiceImpl;
	
	@Resource
	private ProvinceService provinceServiceImpl;
	
	@Resource
	private TagService tagServiceImpl;
	
	@Resource
	private UserService userServiceImpl;
	
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
		return "site.sponsor.info";
	}
	
	/**
	 * 
	 * TODO 新增
	 *
	 * @param sponsor
	 * @param br
	 * @return
	 * @throws ClassNotFoundException
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse addSponsor(@RequestBody @Valid Sponsor sponsor, BindingResult br) throws  ClassNotFoundException  {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String message = "新增赞助商成功！";
		if(!CommonUtil.validateDto(response,br,sponsor.getClass().getName().toString())){
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
		}else{
			sponsor.setCreateTime(new Date());
			sponsor.setUserId(CommonUtil.getCurrentUser().getId());
			UserInfo userInfo = userServiceImpl.findByUsername(CommonUtil.getCurrentUser().getUsername()).getUserInfo();
			userInfo.setRealName(sponsor.getRealName());
			userInfo.setPhone(sponsor.getPhone());
			userInfoServiceImpl.update(userInfo);
			sponsorServiceImpl.save(sponsor);
			response.setMessage(message);
		}
		response.setStatusCode(statusCode);
		return response;
	}

	
}
