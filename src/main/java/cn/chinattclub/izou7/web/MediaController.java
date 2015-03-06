package cn.chinattclub.izou7.web;

import java.util.Date;

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

import cn.chinattclub.izou7.entity.Media;
import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.entity.UserInfo;
import cn.chinattclub.izou7.service.MediaService;
import cn.chinattclub.izou7.service.TagService;
import cn.chinattclub.izou7.service.UserInfoService;
import cn.chinattclub.izou7.service.UserService;
import cn.chinattclub.izou7.util.CommonUtil;
import cn.zy.commons.webdev.constant.ResponseStatusCode;
import cn.zy.commons.webdev.http.RestResponse;

/**
 * 
 * @ClassName: MediaController
 * @Description:场地控制类
 * @author: zy
 * @date: 2015-01-31 下午8:00:36
 * 
 */
@Controller
@RequestMapping(value="/media")
public class MediaController {

	private static final Logger logger = LoggerFactory
			.getLogger(MediaController.class);
	
	@Resource
	private TagService tagServiceImpl;

	@Resource
	private UserService userServiceImpl;
	
	@Resource
	private UserInfoService userInfoServiceImpl;
	
	@Resource
	private MediaService mediaServiceImpl;
	
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String indexPage(Model model) {
		User user = userServiceImpl.findByUsername(CommonUtil.getCurrentUser().getUsername());
		UserInfo userInfo  = user.getUserInfo();
		model.addAttribute("tags", tagServiceImpl.list());
		model.addAttribute("userInfo", userInfo);
		return "site.media.info";
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
	public RestResponse addMedia(@RequestBody @Valid Media media, BindingResult br) throws  ClassNotFoundException  {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String message = "新增媒体成功！";
		if(!CommonUtil.validateDto(response,br,media.getClass().getName().toString())){
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
		}else{
			media.setCreateTime(new Date());
			media.setUserId(CommonUtil.getCurrentUser().getId());
			if(media.isSelf()){
				UserInfo userInfo = userServiceImpl.findByUsername(CommonUtil.getCurrentUser().getUsername()).getUserInfo();
				userInfo.setRealName(media.getRealName());
				userInfo.setPhone(media.getPhone());
				userInfo.setCompany(media.getCompany());
				userInfo.setPosition(media.getPosition());
				userInfoServiceImpl.update(userInfo);
			}
			mediaServiceImpl.save(media);
			response.setMessage(message);
		}
		response.setStatusCode(statusCode);
		return response;
	}

	
}
