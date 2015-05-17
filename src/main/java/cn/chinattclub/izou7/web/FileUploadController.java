package cn.chinattclub.izou7.web;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.chinattclub.izou7.dto.ActivityCrowdfundingRewardDto;
import cn.chinattclub.izou7.dto.ActivityCrowdfundingSettingDto;
import cn.chinattclub.izou7.dto.ActivityDto;
import cn.chinattclub.izou7.dto.ActivityFormDto;
import cn.chinattclub.izou7.dto.ActivityListDto;
import cn.chinattclub.izou7.dto.ActivityQueryDto;
import cn.chinattclub.izou7.dto.ActivityTicketDto;
import cn.chinattclub.izou7.dto.CalendarDto;
import cn.chinattclub.izou7.dto.GuestDto;
import cn.chinattclub.izou7.dto.UserDto;
import cn.chinattclub.izou7.entity.Activity;
import cn.chinattclub.izou7.entity.ActivityArticle;
import cn.chinattclub.izou7.entity.ActivityCooperation;
import cn.chinattclub.izou7.entity.ActivityCrowdfundingReward;
import cn.chinattclub.izou7.entity.ActivityCrowdfundingSetting;
import cn.chinattclub.izou7.entity.ActivityGuest;
import cn.chinattclub.izou7.entity.ActivityGuestsSetting;
import cn.chinattclub.izou7.entity.ActivitySchedule;
import cn.chinattclub.izou7.entity.ActivityTicket;
import cn.chinattclub.izou7.entity.ApplyTemplate;
import cn.chinattclub.izou7.entity.City;
import cn.chinattclub.izou7.entity.Image;
import cn.chinattclub.izou7.entity.Province;
import cn.chinattclub.izou7.entity.Public;
import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.entity.UserInfo;
import cn.chinattclub.izou7.enumeration.ActivityExecuteType;
import cn.chinattclub.izou7.enumeration.GuestRegistrationStatus;
import cn.chinattclub.izou7.enumeration.InvitedStatus;
import cn.chinattclub.izou7.service.ActivityArticleService;
import cn.chinattclub.izou7.service.ActivityCooperationService;
import cn.chinattclub.izou7.service.ActivityCrowdfundingRewardService;
import cn.chinattclub.izou7.service.ActivityCrowdfundingSettingService;
import cn.chinattclub.izou7.service.ActivityGuestsService;
import cn.chinattclub.izou7.service.ActivityGuestsSettingService;
import cn.chinattclub.izou7.service.ActivityScheduleService;
import cn.chinattclub.izou7.service.ActivityService;
import cn.chinattclub.izou7.service.ActivityTicketService;
import cn.chinattclub.izou7.service.ApplyTemplateService;
import cn.chinattclub.izou7.service.BankService;
import cn.chinattclub.izou7.service.CityService;
import cn.chinattclub.izou7.service.ProvinceService;
import cn.chinattclub.izou7.service.PublicService;
import cn.chinattclub.izou7.service.TagService;
import cn.chinattclub.izou7.service.UserInfoService;
import cn.chinattclub.izou7.service.UserService;
import cn.chinattclub.izou7.util.CommonUtil;
import cn.zy.commons.util.json.JsonConverter;
import cn.zy.commons.webdev.constant.ResponseStatusCode;
import cn.zy.commons.webdev.http.RestResponse;
import cn.zy.commons.webdev.vo.Page;

/**
 * 
 * @ClassName:	AcitityController
 * @Description:活动控制类
 * @author:	zy
 * @date:	2014-11-9 下午8:00:36 
 *
 */
@Controller
@RequestMapping(value="/fileUpload")
public class FileUploadController {
	
	private static final Logger log = LoggerFactory.getLogger(FileUploadController.class);
	
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	

	@Resource
	private Properties appConfig;
	
	/**
	 * 
	 * 图片上传
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public  RestResponse uploadImage(Model model,MultipartHttpServletRequest request, HttpServletResponse response) {
		String message = "上传成功！";
		RestResponse result = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf;
		//List<Image> list = new LinkedList<>();
		List<String> list = new LinkedList<>();
		while (itr.hasNext()) {
			mpf = request.getFile(itr.next());
			String newFilenameBase = UUID.randomUUID().toString();
			Image image = new Image();
			try {
				String originalFileExtension = mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."));
				String newFilename = newFilenameBase + originalFileExtension;
				String storageDirectory = appConfig.get("storageDirectory").toString().trim()+"images";
				File newFile = new File(storageDirectory + "/" + newFilename);
			
				mpf.transferTo(newFile);
				if(!CommonUtil.isImage(newFile)){
					message = "图片格式不合法，请重新上传！";
					statusCode = ResponseStatusCode.FORBIDDEN;
				}else  if(newFile.length()>2000000){
					message = "图片大小超过2M，请重新上传！";
					statusCode = ResponseStatusCode.FORBIDDEN;
				}else{
					image.setName(newFile.getName());
					image.setUrl(appConfig.get("storageIP").toString() + "images/" + newFilename);
				}
			} catch(IOException e) {
				log.error("Could not upload file "+mpf.getOriginalFilename(), e);
				message = "上传异常！";
				statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
			}
			//list.add(image);
			list.add(image.getUrl());
			//list.add("http://img.my.csdn.net/uploads/201304/25/1366872410_6530.png");
		}
		result.setMessage(message);
		result.getBody().put("urls", list);
		result.setStatusCode(statusCode);
		return result;
	}
}
