package cn.chinattclub.izou7.web;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.chinattclub.izou7.dto.ActivityDto;
import cn.chinattclub.izou7.dto.ActivityFormDto;
import cn.chinattclub.izou7.dto.ActivityTicketDto;
import cn.chinattclub.izou7.dto.CalendarDto;
import cn.chinattclub.izou7.dto.UserDto;
import cn.chinattclub.izou7.entity.Activity;
import cn.chinattclub.izou7.entity.ActivityArticle;
import cn.chinattclub.izou7.entity.ActivityGuestsSetting;
import cn.chinattclub.izou7.entity.ActivityPoster;
import cn.chinattclub.izou7.entity.ActivityArticle;
import cn.chinattclub.izou7.entity.ActivitySchedule;
import cn.chinattclub.izou7.entity.ActivityTicket;
import cn.chinattclub.izou7.entity.ApplyTemplate;
import cn.chinattclub.izou7.entity.City;
import cn.chinattclub.izou7.entity.Image;
import cn.chinattclub.izou7.entity.Province;
import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.enumeration.GuestRegistrationStatus;
import cn.chinattclub.izou7.service.ActivityArticleService;
import cn.chinattclub.izou7.service.ActivityGuestsService;
import cn.chinattclub.izou7.service.ActivityGuestsSettingService;
import cn.chinattclub.izou7.service.ActivityScheduleService;
import cn.chinattclub.izou7.service.ActivityService;
import cn.chinattclub.izou7.service.ActivityTicketService;
import cn.chinattclub.izou7.service.ApplyTemplateService;
import cn.chinattclub.izou7.service.CityService;
import cn.chinattclub.izou7.service.ProvinceService;
import cn.chinattclub.izou7.service.UserService;
import cn.zy.commons.webdev.constant.ResponseStatusCode;
import cn.zy.commons.webdev.http.RestResponse;

/**
 * 
 * @ClassName:	AcitityController
 * @Description:活动控制类
 * @author:	zy
 * @date:	2014-11-9 下午8:00:36 
 *
 */
@Controller
@RequestMapping(value="/activity")
public class ActivityController {
	
	private static final Logger log = LoggerFactory.getLogger(ActivityController.class);
	
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Resource
	private ActivityService activityServiceImpl;
	
	@Resource
	private ActivityArticleService activityArticleServiceImpl;
	
	@Resource
	private ProvinceService provinceServiceImpl; 
	
	@Resource
	private CityService cityServiceImpl; 
	
	@Resource
	private UserService userServiceImpl; 
	
	@Resource
	private ActivityScheduleService activityScheduleServiceImpl; 
	
	@Resource
	private ApplyTemplateService applyTemplateServiceImpl; 
	
	@Resource
	private ActivityTicketService activityTicketServiceImpl; 
	
	@Resource
	private ActivityGuestsService activityGuestsServiceImpl; 
	
	@Resource
	private ActivityGuestsSettingService activityGuestsSettingServiceImpl; 
	
	
	
	
	@Resource
	private Properties appConfig;
	/**
	 * 主办方主页
	 * @return
	 */
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String sponsorPage() {
		return "site.activity.index";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	@ResponseBody
	public RestResponse add(ActivityFormDto dto) throws ParseException {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String msg = "操作成功！";
		Subject currentUser = SecurityUtils.getSubject();
		User user = userServiceImpl.findByUsername(currentUser.getPrincipal().toString());
		City city = cityServiceImpl.getCity(dto.getCity());
		Activity activity = dto.convert(null);
		if(StringUtils.isNotBlank(dto.getPosterUrl())){
			ActivityPoster poster = new ActivityPoster();
			poster.setActivity(activity);
			poster.setPoster(dto.getPosterUrl());
			poster.setCreateTime(new Date());
			List<ActivityPoster> posters = new ArrayList<>();
			posters.add(poster);
			activity.setActivityPosters(posters);
		}
		activity.setCity(city);
		activity.setUser(user);
		activity.setStatus(0);
		activityServiceImpl.add(activity);
		response.setMessage(msg);
		response.setStatusCode(statusCode);
		response.getBody().put("id",activity.getId());
		return response;
		
	}
	@RequestMapping(value="/addUser", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse addUser(@RequestBody List<UserDto> dtos) {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String msg = "操作成功！";
		Subject currentUser = SecurityUtils.getSubject();
		
		response.setMessage(msg);
		response.setStatusCode(statusCode);
		return response;

	}
	/**
	 * 
	 * 活动页面分发
	 *
	 * @param model
	 * @param dto
	 * @return
	 */
	@RequestMapping(value="/activity", method = RequestMethod.GET)
	public String activityDispatch(Model model ,ActivityDto dto ) {
		List<Province> provinces = provinceServiceImpl.findAll();
		model.addAttribute("provinces",provinces);
		String view = "site.activity.activity";
		switch (dto.getStep()) {
		case FIRST:
			view = activityPage(model,dto);
			break;
		case SECOND:
			view = activityArticlesPage(model,dto);
			break;
		case THIRD:
			view = activityCalendarPage(model,dto);
			break;
		case FOURTH:
			view = activityApplyTemplatePage(model,dto);
			break;
		case FIFTH:
			view = activityTickedPage(model,dto);
			break;
		case SIXTH:
			view = activityGuestPage(model,dto);
			break;
		case SEVENTH:
			break;
		default:
			break;
		}
		return view;
	}
	/**
	 * 第六步 邀请嘉宾
	 * @param model
	 * @param dto
	 * @return
	 */
	private String activityGuestPage(Model model, ActivityDto dto) {
		// TODO Auto-generated method stub
		Activity activity = activityServiceImpl.findById(dto.getActivityId());
		List<ActivityGuestsSetting> settings = activity.getSettings();
		model.addAttribute("id",dto.getActivityId());
		model.addAttribute("guests",activity.getGuests());
		model.addAttribute("setting",(settings!=null&&settings.size()>0)?settings.get(0):null);
		return "site.activity.guests";
	}

	/**
	 * 第五步 票务信息
	 * @param model
	 * @param dto
	 * @return
	 */
	private String activityTickedPage(Model model, ActivityDto dto) {
		// TODO Auto-generated method stub
		Activity activity = activityServiceImpl.findById(dto.getActivityId());
		List<ActivityTicket> tickets = activity.getTickets();
		model.addAttribute("id",dto.getActivityId());
		model.addAttribute("ticket",(tickets!=null&&tickets.size()>0)?tickets.get(0):null);
		return "site.activity.ticket";
	}

	/**
	 * 第四步 报名模板
	 * @param model
	 * @param dto
	 * @return
	 */
	private String activityApplyTemplatePage(Model model, ActivityDto dto) {
		// TODO Auto-generated method stub
		model.addAttribute("id",dto.getActivityId());
		model.addAttribute("templates",applyTemplateServiceImpl.list());
		Activity activity = activityServiceImpl.findById(dto.getActivityId());
		ApplyTemplate template = activity.getTemplate()==null?null:activity.getTemplate();
		model.addAttribute("tmp",template);
		return "site.activity.template";
	}

	/**
	 * 第三步 日程
	 * @param model
	 * @param dto
	 * @return
	 */
	private String activityCalendarPage(Model model, ActivityDto dto) {
		// TODO Auto-generated method stub
		model.addAttribute("id",dto.getActivityId());
		return "site.activity.calendar";
	}

	/**
	 * 第二步 上传文章
	 * @param model
	 * @param dto
	 * @return
	 */
	public String activityArticlesPage(Model model ,ActivityDto dto){
		if(dto.getActivityId()!=null){
			List<ActivityArticle> articles = activityArticleServiceImpl.findArticlesById(dto.getActivityId());
			model.addAttribute("articles", articles);
			model.addAttribute("id", dto.getActivityId());
		}
		return "site.activity.articles";
	}
	/**
	 * 第一步 基本信息
	 * @param model
	 * @param dto
	 * @return
	 */
	public String activityPage(Model model ,ActivityDto dto){
		if(dto.getActivityId()!=null){
			Activity activity = activityServiceImpl.findById(dto.getActivityId());
			model.addAttribute("activity", activity);
		}
		return "site.activity.activity";
	}
	
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
	public  Map upload(MultipartHttpServletRequest request, HttpServletResponse response) {
		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf;
		List<Image> list = new LinkedList<>();
		while (itr.hasNext()) {
			mpf = request.getFile(itr.next());
			String newFilenameBase = UUID.randomUUID().toString();
			String originalFileExtension = mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."));
			String newFilename = newFilenameBase + originalFileExtension;
			String storageDirectory = appConfig.get("storageDirectory").toString().trim()+"images";
			File newFile = new File(storageDirectory + "/" + newFilename);
			Image image = new Image();
			try {
				mpf.transferTo(newFile);
				image.setName(newFile.getName());
				image.setUrl(appConfig.get("storageDirectory").toString().substring(appConfig.get("storageDirectory").toString().indexOf("static")) + "images/" + newFilename);
			} catch(IOException e) {
				log.error("Could not upload file "+mpf.getOriginalFilename(), e);
				image.setError("上传失败！");
			}
			list.add(image);
		}
		Map<String, Object> files = new HashMap<>();
		files.put("files", list);
		return files;
	}
	/**
	 * 
	 * 文章上传
	 *
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/uploadArticles", method = RequestMethod.POST)
	@ResponseBody
    public  Map uploadArticles(MultipartHttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        Iterator<String> itr = request.getFileNames();
        MultipartFile mpf;
        List<ActivityArticle> list = new LinkedList<>();
        while (itr.hasNext()) {
            mpf = request.getFile(itr.next());
            String newFilenameBase = UUID.randomUUID().toString();
            String originalFileExtension = mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."));
            String originalFileName = mpf.getOriginalFilename().substring(0,mpf.getOriginalFilename().lastIndexOf("."));
            ActivityArticle article = new ActivityArticle();
            try {
            	 int id = Integer.parseInt(request.getParameter("id").toString());
            	 String title = new String(request.getParameter("title"+originalFileName).getBytes("ISO8859-1"),"UTF-8"); 
                 String[] tags = request.getParameterValues("multiple"+originalFileName);
                 
                 for (int i=0;i<tags.length;i++) {
                 	tags[i] = new String(tags[i].getBytes("ISO8859-1"),"UTF-8");
     			}
                 String newFilename = newFilenameBase + originalFileExtension;
                 String storageDirectory = appConfig.get("storageDirectory").toString().trim()+"articles";
                 File newFile = new File(storageDirectory + "/" + newFilename);
                 mpf.transferTo(newFile);
                 article.setTags(convertTags(tags));
                 article.setTitle(title);
                 article.setUrl(appConfig.get("storageDirectory").toString().substring(appConfig.get("storageDirectory").toString().indexOf("static")) + "articles/" + newFilename);
                 article.setName(newFile.getName());
                 article.setActivity(id);
                 article.setCreateTime(new Date());
                 activityArticleServiceImpl.add(article);
            } catch(IOException e) {
                log.error("Could not upload file "+mpf.getOriginalFilename(), e);
                article.setError("上传失败！");
            }
            list.add(article);
        }
        Map<String, Object> files = new HashMap<>();
        files.put("files", list);
        return files;
	}
	/**
	 * 获取文章列表
	 * @param arcitityId
	 * @return
	 */
	@RequestMapping(value = "/articles", method = RequestMethod.GET)
	@ResponseBody
	public RestResponse findArticles(int arcitityId){
		RestResponse response = new RestResponse();
		List<ActivityArticle> articles = activityArticleServiceImpl.findArticlesById(arcitityId);
		response.setMessage("获取文章成功!");
		response.setStatusCode(ResponseStatusCode.OK);
		response.getBody().put("articles", articles);
		return response;
	}
	/**
	 * 删除文章
	 * @param articleId
	 * @return
	 */
	@RequestMapping(value = "/article/{articleId}", method = RequestMethod.DELETE)
	@ResponseBody
	public RestResponse deleteArticle(@PathVariable int articleId){
		RestResponse response = new RestResponse();
		activityArticleServiceImpl.delete(articleId);
		log.info("删除文章【"+articleId+"】成功!");
		response.setMessage("删除文章成功!");
		response.setStatusCode(ResponseStatusCode.OK);
		return response;
	}
	
	/**
	 * 获取活动的日程
	 * @param activityId
	 * @param start
	 * @param end
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "{activityId}/calendars", method = RequestMethod.GET)
	@ResponseBody
	public List<ActivitySchedule> findCalendars(@PathVariable int activityId,Long start,Long end) throws ParseException{
		List<CalendarDto> cals = new ArrayList<>();
		List<ActivitySchedule> ass = activityScheduleServiceImpl.find(activityId, new Date(start), new Date(end));
		return ass;
	}
	/**
	 * 新增日程
	 * @param activityId
	 * @param calendar
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "{activityId}/calendar", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse addCalendar(@PathVariable int activityId,CalendarDto calendar) throws ParseException{
		RestResponse response = new RestResponse();
		ActivitySchedule as = new ActivitySchedule();
		as.setActivity(activityId);
		as.setContent(calendar.getTitle());
		as.setStartTime(df.parse(calendar.getStart()));
		as.setEndTime(df.parse(calendar.getEnd()));
		as.setCreateTime(new Date());
		activityScheduleServiceImpl.add(as);
		response.setMessage("新增日程成功!");
		response.setStatusCode(ResponseStatusCode.OK);
		return response;
	}
	/**
	 * 更新日程
	 * @param calendarId
	 * @param dto
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "calendar/{calendarId}", method = RequestMethod.PUT)
	@ResponseBody
	public RestResponse updateCalendar(@PathVariable int calendarId,@RequestBody CalendarDto dto) throws ParseException{
		RestResponse response = new RestResponse();
		ActivitySchedule as = activityScheduleServiceImpl.get(calendarId);
		as.setContent(dto.getTitle());
		as.setStartTime(df.parse(dto.getStart()));
		as.setEndTime(df.parse(dto.getEnd()));
		activityScheduleServiceImpl.update(as);
		response.setMessage("更新日程成功!");
		response.setStatusCode(ResponseStatusCode.OK);
		return response;
	}
	/**
	 * 删除日程
	 * @param calendarId
	 * @return
	 */
	@RequestMapping(value = "calendar/{calendarId}", method = RequestMethod.DELETE)
	@ResponseBody
	public RestResponse deleteCalendar(@PathVariable int calendarId) {
		RestResponse response = new RestResponse();
		activityScheduleServiceImpl.delete(calendarId);
		response.setMessage("删除日程成功!");
		response.setStatusCode(ResponseStatusCode.OK);
		return response;
	}
	/**
	 * 更新活动报名模板
	 * @param activityId
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "{activityId}/template/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public RestResponse updateActivityTemplate(@PathVariable int activityId,@PathVariable int id) {
		RestResponse response = new RestResponse();
		String message ;
		Activity activity = activityServiceImpl.findById(activityId);
		ApplyTemplate template = applyTemplateServiceImpl.get(id);
		activity.setTemplate(template);
		activityServiceImpl.update(activity);
		message = "更新活动【"+activityId+"】报名模板【"+id+"】成功!";
		log.info(message);
		response.setMessage("更新活动报名模板成功!");
		response.setStatusCode(ResponseStatusCode.OK);
		return response;
	}
	/**
	 * 更新活动增加票务信息
	 * @param activityId
	 * @param ActivityTicket
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "{activityId}/ticket", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse addActivityTicket(@PathVariable int activityId,ActivityTicketDto ticket) throws ParseException {
		RestResponse response = new RestResponse();
		String message ;
		ActivityTicket activityTicket = ticket.convert();
		if(ticket.getId()!=null){
			activityTicketServiceImpl.update(activityTicket);
		}else{
			activityTicketServiceImpl.add(activityTicket);
		}
		message = "更新活动【"+activityId+"】增加票务信息成功!";
		log.info(message);
		response.setMessage("更新活动增加票务信息成功!");
		response.setStatusCode(ResponseStatusCode.OK);
		return response;
	}
	/**
	 * 转换tags数组
	 * @param tags
	 * @return
	 */
	private String convertTags(String[] tags){
		StringBuilder tagsStr = new StringBuilder();
		for (int i=0;i<tags.length;i++) {
			if(i==tags.length-1){
				tagsStr.append(tags[i]);
			}else{
				tagsStr.append(tags[i]).append(",");
			}
		}
		return tagsStr.toString();
	}

}
