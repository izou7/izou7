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
	private UserInfoService userInfoServiceImpl; 
	
	@Resource
	private ActivityCooperationService activityCooperationServiceImpl; 
	
	@Resource
	private PublicService publicServiceImpl; 
	
	@Resource
	private ActivityCrowdfundingSettingService activityCrowdfundingSettingServiceImpl; 
	
	@Resource
	private ActivityCrowdfundingRewardService activityCrowdfundingRewardServiceImpl; 
	
	@Resource
	private BankService bankServiceImpl; 
	
	@Resource
	private Properties appConfig;
	
	@Resource
	private TagService tagServiceImpl;
	
	/**
	 * 主办方主页
	 * @return
	 */
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String sponsorPage() {
		return "site.activity.index";
	}
	
	/**
	 * 
	 * 我的活动页面
	 *
	 * @return
	 */
	@RequestMapping(value="/myActivities", method = RequestMethod.GET)
	public String myActivityPage() {
		return "site.activity.myActivity";
	}
	
	/**
	 * 
	 * 活动列表
	 *
	 * @return
	 */
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String listPage(Model model ,Page page,ActivityQueryDto query) {
		query.setStatus(1);
		List<Activity> activitys = activityServiceImpl.findActivitys(page,query);
		model.addAttribute("activities",activitys);
		model.addAttribute("name",query.getName());
		return "site.activity.list";
	}
	
	
//	@RequestMapping(value="/activitys", method = RequestMethod.GET)
//	@ResponseBody
//	public RestResponse findActivitys(int index) {
//		Page page = new Page();
//		page.setIndex(index);
//		RestResponse response = new RestResponse();
//		int statusCode = ResponseStatusCode.OK;
//		Subject currentUser = SecurityUtils.getSubject();
//		ActivityQueryDto query = new ActivityQueryDto();
//		query.setStatus(1);
//		List<Activity> deployedActivitys = activityServiceImpl.findActivitys(page,query);
//		List<ActivityListDto> alds = new ArrayList<ActivityListDto>();
//		for (Activity act : deployedActivitys) {
//			ActivityListDto dto = new ActivityListDto();
//			dto.setId(act.getId());
//			dto.setDeployTime(act.getCreateTime());
//			dto.setName(act.getName());
//			dto.setPoster(act.getPosterUrl());
//			dto.setUpdateTime(act.getUpdateTime());
//			alds.add(dto);
//		}
//		response.getBody().put("activitys", alds);
//		response.getBody().put("page", page);
//		response.setStatusCode(statusCode);
//		return response;
//		
//	}
	
	/**
	 * 
	 * 活动页面分发
	 *
	 * @param model
	 * @param dto
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="/activity", method = RequestMethod.GET)
	public String activityDispatch(Model model ,ActivityDto dto ) throws ParseException {
		String view = "site.main.error";
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
			view = activityPublicPage(model,dto);
			break;
		case EIGHTH:
			view = activityCrowdfundingPage(model,dto);
			break;
		case SUCCESS:
			view = activitySuccessPage(model,dto);
			break;
		default:
			break;
		}
		return view;
	}
	private String activitySuccessPage(Model model, ActivityDto dto) {
		// TODO Auto-generated method stub
		model.addAttribute("url", "http://localhost:8080/activity/info/1/"+dto.getActivityId());
		Activity activity = activityServiceImpl.findById(dto.getActivityId());
		if(activity.getTemplate()!=null){
			model.addAttribute("content",activity.getTemplate().getContent());
		}
		return "site.activity.success";
	}

	/**
	 * 第八步 众筹
	 * @param model
	 * @param dto
	 * @return
	 */
	private String activityCrowdfundingPage(Model model, ActivityDto dto) {
		// TODO Auto-generated method stub
		ActivityCrowdfundingSetting setting = activityCrowdfundingSettingServiceImpl.findByActivityId(dto.getActivityId());
		List<ActivityCrowdfundingReward> rewards =  activityCrowdfundingRewardServiceImpl.findByActivityId(dto.getActivityId());
		model.addAttribute("id",dto.getActivityId());
		model.addAttribute("setting", setting);
		model.addAttribute("rewards", rewards);
		model.addAttribute("banks", bankServiceImpl.list());
		return "site.activity.crowdfunding";
	}
	/**
	 * 第七步 开放合作
	 * @param model
	 * @param dto
	 * @return
	 */
	private String activityPublicPage(Model model, ActivityDto dto) {
		// TODO Auto-generated method stub
		List<ActivityCooperation> cpts = activityCooperationServiceImpl.findByActivityId(dto.getActivityId());
		List<Public> recommendPublics = publicServiceImpl.recommend(dto.getActivityId());
		model.addAttribute("id",dto.getActivityId());
		model.addAttribute("cpts", cpts);
		model.addAttribute("rcpls", recommendPublics);
		model.addAttribute("tags", tagServiceImpl.list());
		return "site.activity.cooperation";
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
		Set<ActivityGuestsSetting> settings = activity.getSettings();
		model.addAttribute("id",dto.getActivityId());
		model.addAttribute("guests",activityGuestsServiceImpl.getGuestsByActivityId(dto.getActivityId()));
		/**系统推荐*/
		model.addAttribute("rcds",userInfoServiceImpl.recommend(dto.getActivityId()));
		model.addAttribute("setting",settings.isEmpty()?null:settings.iterator().next());
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
		Set<ActivityTicket> tickets = activity.getTickets();
		model.addAttribute("id",dto.getActivityId());
		model.addAttribute("ticket",tickets.isEmpty()?null:tickets.iterator().next());
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
		model.addAttribute("tags", tagServiceImpl.list());
		return "site.activity.articles";
	}
	/**
	 * 第一步 基本信息
	 * @param model
	 * @param dto
	 * @return
	 * @throws ParseException 
	 */
	public String activityPage(Model model ,ActivityDto dto) throws ParseException{
		List<Province> provinces = provinceServiceImpl.findAll();
		model.addAttribute("provinces",provinces);
		if(dto.getActivityId()!=null){
			Activity activity = activityServiceImpl.findById(dto.getActivityId());
			model.addAttribute("activity", activity);
		}else{
			Calendar cal = Calendar.getInstance();
			ActivityFormDto aDto = new ActivityFormDto();
			aDto.setCity(51);
			cal.add(Calendar.DAY_OF_YEAR, 7);
			aDto.setStartTime(df.format(cal.getTime()));
			cal.add(Calendar.DAY_OF_YEAR, 3);
			aDto.setEndTime(df.format(cal.getTime()));
			aDto.setHeadCount(100);
			aDto.setIntroduction("<p>活动介绍。。。</p>");
			aDto.setName("我的活动");
			aDto.setOpened(true);
			aDto.setPlace("中关村科技大厦");
			aDto.setPosterUrl("/static/images/default_poster.png");
			aDto.setTags("其他");
			aDto.setType(ActivityExecuteType.SAVE);
			Subject currentUser = SecurityUtils.getSubject();
			User user = userServiceImpl.findByUsername(currentUser.getPrincipal().toString());
			City city = cityServiceImpl.getCity(aDto.getCity());
			Activity activity = aDto.convert(null);
			activity.setCity(city);  
			activity.setUser(user);
			activityServiceImpl.add(activity);
			model.addAttribute("activity", activity);
		}
		model.addAttribute("tags",tagServiceImpl.list());
		return "site.activity.activity";
	}
	
	/**
	 * 更新活动
	 * @param dto
	 * @return
	 * @throws ParseException
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 */
	@RequestMapping(value="/update", method = RequestMethod.GET)
	@ResponseBody
	public RestResponse update(@Valid ActivityFormDto dto, BindingResult br) throws ParseException, SecurityException, ClassNotFoundException {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		if(!CommonUtil.validateDto(response,br,dto.getClass().getName().toString())){
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
		}else{
			City city = cityServiceImpl.getCity(dto.getCity());
			Activity originalActivity = activityServiceImpl.findALLById(dto.getId()); 
			Activity activity = dto.convert(originalActivity);
			activity.setCity(city);  
			activityServiceImpl.update(activity);
			response.getBody().put("id",activity.getId());
		}
		response.setStatusCode(statusCode);
		return response;
		
	}
	/**
	 * 新增活动
	 * @param dto
	 * @return
	 * @throws ParseException
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 */
	@RequestMapping(value="/add", method = RequestMethod.GET)
	@ResponseBody
	public RestResponse add(@Valid ActivityFormDto dto, BindingResult br) throws ParseException, SecurityException, ClassNotFoundException {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		if(!CommonUtil.validateDto(response,br,dto.getClass().getName().toString())){
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
		}else{
			Subject currentUser = SecurityUtils.getSubject();
			User user = userServiceImpl.findByUsername(currentUser.getPrincipal().toString());
			City city = cityServiceImpl.getCity(dto.getCity());
			Activity activity = dto.convert(null);
//			if(StringUtils.isNotBlank(dto.getPosterUrl())){
//				ActivityPoster poster = new ActivityPoster();
//				poster.setActivity(activity);
//				poster.setPoster(dto.getPosterUrl());
//				poster.setCreateTime(new Date());
//				Set<ActivityPoster> posters = new HashSet<>();
//				posters.add(poster);
//				activity.setActivityPosters(posters);
//			}
			activity.setCity(city);
			activity.setUser(user);
			activityServiceImpl.add(activity);
			response.getBody().put("id",activity.getId());
		}
		response.setStatusCode(statusCode);
		return response;
		
	}
	
	/**
	 * 新增用户
	 * @param dtos
	 * @return
	 */
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
				image.setUrl(appConfig.get("storageIP").toString() + "images/" + newFilename);
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
                 article.setUrl(appConfig.get("storageIP").toString() + "articles/" + newFilename);
                 article.setName(newFile.getName());
                 article.setActivity(id);
                 article.setCreateTime(new Date());
                 boolean result = activityArticleServiceImpl.validateNum(article);
                 if(result){
                	 activityArticleServiceImpl.add(article);
                 }else{
                	 article.setError("文章已超过最大数量限制！");
                 }
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
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 */
	@RequestMapping(value = "{activityId}/ticket", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse addActivityTicket(@PathVariable int activityId,@Valid ActivityTicketDto ticket, BindingResult br) throws ParseException, SecurityException, ClassNotFoundException {
		RestResponse response = new RestResponse();
		String message ;
		int statusCode = ResponseStatusCode.OK;
		if(!CommonUtil.validateDto(response,br,ticket.getClass().getName().toString())){
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
		}else{
			if(ticket.getId()!=null){
				ActivityTicket activityTicket = ticket.convert(activityTicketServiceImpl.findByActivityId(activityId));
				if(ticket.getType().equals(ActivityExecuteType.DEPLOY)){
					updateActivityStatus(activityId,1);
				}
				activityTicketServiceImpl.update(activityTicket);
			}else{
				ActivityTicket activityTicket = ticket.convert(null);
				activityTicket.setCreateTime(new Date());
				activityTicketServiceImpl.add(activityTicket);
			}
			response.setMessage("更新活动增加票务信息成功!");
		}
		
		response.setStatusCode(statusCode);
		return response;
	}
	
	/**
	 * 获取活动嘉宾
	 * @param activityId
	 * @return
	 */
	@RequestMapping(value = "{activityId}/guests", method = RequestMethod.GET)
	@ResponseBody
	public RestResponse addActivityTicket(@PathVariable int activityId)  {
		RestResponse response = new RestResponse();
		response.getBody().put("guests", activityGuestsServiceImpl.getGuestsByActivityId(activityId));
		response.setMessage("获取活动嘉宾信息成功!");
		response.setStatusCode(ResponseStatusCode.OK);
		return response;
	}
	/**
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 */
	@RequestMapping(value = "{activityId}/setting", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse addActivityGuestsSetting(@PathVariable int activityId,@Valid ActivityGuestsSetting setting, BindingResult br) throws SecurityException, ClassNotFoundException  {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		if(!CommonUtil.validateDto(response,br,setting.getClass().getName().toString())){
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
		}else{
			if(setting.getGuestNumber()!=null||setting.getGuestRegistrationDeadline()!=null){
				setting.setActivity(activityId);
				activityGuestsSettingServiceImpl.addOrUpdate(setting);
			}
		}
		response.setStatusCode(statusCode);
		return response;
	}
	/**
	 * 嘉宾顺序调整
	 * @param activityId
	 * @param guestId
	 * @param up
	 * @return
	 */
	@RequestMapping(value = "{activityId}/guest/{guestId}", method = RequestMethod.PUT)
	@ResponseBody
	public RestResponse adjustActivityGuest(@PathVariable int activityId,@PathVariable int guestId,String up)  {
		RestResponse response = new RestResponse();
		activityGuestsServiceImpl.execSequence(activityId,guestId,Boolean.valueOf(up));
		response.setStatusCode(ResponseStatusCode.OK);
		return response;
	}
	/**
	 * 
	 * 删除活动嘉宾
	 *
	 * @param activityId
	 * @param guestId
	 * @return
	 */
	@RequestMapping(value = "{activityId}/guest/{guestId}", method = RequestMethod.DELETE)
	@ResponseBody
	public RestResponse deleteActivityGuest(@PathVariable int activityId,@PathVariable int guestId)  {
		RestResponse response = new RestResponse();
		activityGuestsServiceImpl.delete(guestId);
		response.setStatusCode(ResponseStatusCode.OK);
		return response;
	}
	/**
	 * 新增活动嘉宾
	 * @param activityId
	 * @param guest
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 */
	@RequestMapping(value = "{activityId}/guest", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse addActivityGuest(@PathVariable int activityId,@Valid GuestDto guest, BindingResult br) throws SecurityException, ClassNotFoundException  {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		if(!CommonUtil.validateDto(response,br,guest.getClass().getName().toString())){
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
		}else{
			ActivityGuest aGuest = guest.convert();
			aGuest.setActivity(activityId);
			int maxRank = activityGuestsServiceImpl.getMaxRank(activityId);
			aGuest.setRank(maxRank+1);
			aGuest.setSource(true);
			aGuest.setType(1);
			aGuest.setStatus(GuestRegistrationStatus.NOTSEND);
			activityGuestsServiceImpl.add(aGuest);
		}
		response.setStatusCode(statusCode);
		return response;
	}
	
	/**
	 * 
	 * 增加系统嘉宾
	 *
	 * @param activityId
	 * @param userInfoId
	 * @return
	 */
	@RequestMapping(value = "{activityId}/sysGuest/{sysGuestId}", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse addActivitySysGuest(@PathVariable int activityId,@PathVariable int sysGuestId) {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String message = "新增系统推荐嘉宾成功";
		if(validateSysGuest(activityId,sysGuestId)){
			ActivityGuest aGuest = new ActivityGuest();
			UserInfo uInfo = userInfoServiceImpl.findById(sysGuestId);
			String careerInfo = uInfo.getCareerInfo();
			Map<String,Object> careerMap = new HashMap<>();
			if(StringUtils.isNotBlank(careerInfo)){
				careerMap = JsonConverter.parse(careerInfo,Map.class);
			}
			aGuest.setName(uInfo.getRealName());
			aGuest.setPosition(careerMap.get("position")!=null?careerMap.get("position").toString():"");
			aGuest.setCompany(careerMap.get("company")!=null?careerMap.get("position").toString():"");
			aGuest.setResearchArea(careerMap.get("researchArea")!=null?careerMap.get("researchArea").toString():"");
			aGuest.setPhone(uInfo.getPhone());
			aGuest.setIntroduction(uInfo.getIntroduction());
			aGuest.setUser(uInfo.getUser());
			int maxRank = activityGuestsServiceImpl.getMaxRank(activityId);
			aGuest.setRank(maxRank+1);
			aGuest.setSource(true);
			aGuest.setType(1);
			aGuest.setStatus(GuestRegistrationStatus.NOTSEND);
			aGuest.setActivity(activityId);
			aGuest.setCreateTime(new Date());
			activityGuestsServiceImpl.add(aGuest);
		}else{
			message = "系统推荐嘉宾已添加，添加失败";
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
		}
		response.setMessage(message);
		response.setStatusCode(statusCode);
		return response;
	}
	/**
	 * 验证系统推荐嘉宾是否已经存在
	 *
	 * @param activityId
	 * @param sysGuestId
	 * @return
	 */
	private boolean validateSysGuest(int activityId, int sysGuestId) {
		// TODO Auto-generated method stub.
		return activityGuestsServiceImpl.validateSysGuest(activityId,sysGuestId);
	}

	/**
	 * 新增活动开发合作
	 * @param activityId
	 * @param guest
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 */
	@RequestMapping(value = "{activityId}/cooperation", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse addActivityCooperation(@PathVariable int activityId,@Valid ActivityCooperation cooperation, BindingResult br) throws SecurityException, ClassNotFoundException  {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String message = "新增公众号成功！";
		if(!CommonUtil.validateDto(response,br,cooperation.getClass().getName().toString())){
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
		}else{
			if(activityCooperationServiceImpl.validateCooperation(activityId,cooperation.getWechatId())){
				cooperation.setActivity(activityId);
				cooperation.setStatus(InvitedStatus.SEND);
				cooperation.setType(1);
				cooperation.setCreateTime(new Date());
				activityCooperationServiceImpl.add(cooperation);
			}else{
				statusCode = ResponseStatusCode.CONFLICT;
				message = "该公众号微信ID已存在，添加失败！";		
			}
		}
		response.setMessage(message);
		response.setStatusCode(statusCode);
		return response;
	}
	/**
	 * 
	 * @param activityId
	 * @param publicId
	 * @return
	 */
	@RequestMapping(value = "{activityId}/cooperation/{publicId}", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse addActivityCooperationByPublic(@PathVariable int activityId,@PathVariable int publicId)  {
		RestResponse response = new RestResponse();
		String msg = "添加开放合作成功！";
		int statusCode = ResponseStatusCode.OK;
		Public pbl = publicServiceImpl.getPublicById(publicId);
		ActivityCooperation cprt = new ActivityCooperation();
		if(activityCooperationServiceImpl.validateCooperation(activityId,pbl.getWechatId())){
			cprt.setActivity(activityId);
			cprt.setCreateTime(new Date());
			cprt.setDescription(pbl.getDescription());
			cprt.setMine(pbl.isMine());
			cprt.setPublicName(pbl.getPublicName());
			cprt.setTags(pbl.getTags());
			cprt.setType(1);
			cprt.setStatus(InvitedStatus.SEND);
			cprt.setWechatId(pbl.getWechatId());
			activityCooperationServiceImpl.add(cprt);
		}else{
			statusCode = ResponseStatusCode.CONFLICT;
			msg = "该公众号已被添加，添加失败！";
		}
		
		response.setStatusCode(statusCode);
		response.setMessage(msg);
		return response;
	}


	/**
	 * 获取活动开发合作
	 * @param activityId
	 * @return
	 */
	@RequestMapping(value = "{activityId}/cooperations", method = RequestMethod.GET)
	@ResponseBody
	public RestResponse findActivityCooperation(@PathVariable int activityId)  {
		RestResponse response = new RestResponse();
		List<ActivityCooperation> cpts = activityCooperationServiceImpl.findByActivityId(activityId);
		response.setStatusCode(ResponseStatusCode.OK);
		response.getBody().put("cpts", cpts);
		return response;
	}
	
	/**
	 * 删除开发合作
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "cooperation/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public RestResponse addActivityCooperation(@PathVariable int id)  {
		RestResponse response = new RestResponse();
		activityCooperationServiceImpl.delete(id);
		response.setStatusCode(ResponseStatusCode.OK);
		return response;
	}
	
	/**
	 * 新增众筹设置
	 * @param activityId
	 * @param setting
	 * @return
	 */
	@RequestMapping(value = "{activityId}/activityCrowdfunding/setting", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse addActivityCooperation(@PathVariable int activityId,ActivityCrowdfundingSettingDto settingDto)  {
		RestResponse response = new RestResponse();
		ActivityCrowdfundingSetting setting = settingDto.convert();
		setting.setActivity(activityId);
		activityCrowdfundingSettingServiceImpl.addOrUpdate(setting);
		response.setStatusCode(ResponseStatusCode.OK);
		return response;
	}
	
	/**
	 * 新增回报
	 * @param activityId
	 * @param rewardDto
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "{activityId}/activityCrowdfunding/reward", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse addActivityCooperationReward(@PathVariable int activityId,ActivityCrowdfundingRewardDto rewardDto) throws ParseException  {
		RestResponse response = new RestResponse();
		ActivityCrowdfundingReward reward = rewardDto.convert();
		reward.setActivity(activityId);
		activityCrowdfundingRewardServiceImpl.add(reward);
		response.setStatusCode(ResponseStatusCode.OK);
		return response;
	}
	
	/**
	 * 获取活动下的所有回报设置
	 * @param activityId
	 * @return
	 */
	@RequestMapping(value = "{activityId}/activityCrowdfunding/rewards", method = RequestMethod.GET)
	@ResponseBody
	public RestResponse findActivityCooperationRewards(@PathVariable int activityId){
		RestResponse response = new RestResponse();
		List<ActivityCrowdfundingReward> rewards = activityCrowdfundingRewardServiceImpl.findByActivityId(activityId);
		response.getBody().put("rewards", rewards);
		response.setStatusCode(ResponseStatusCode.OK);
		return response;
	}
	
	/**
	 * 删除回报设置
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "activityCrowdfunding/reward/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public RestResponse deleteActivityCooperationReward(@PathVariable int id){
		RestResponse response = new RestResponse();
		activityCrowdfundingRewardServiceImpl.delete(id);
		response.setStatusCode(ResponseStatusCode.OK);
		return response;
	}
	
	/**
	 * 获取当前用户的活动/待发布的
	 * @param dtos
	 * @return
	 */
	@RequestMapping(value="/activitys/status/{status}", method = RequestMethod.GET)
	@ResponseBody
	public RestResponse findDeployedActivitys(@PathVariable int status,int index) {
		Page page = new Page();
		page.setIndex(index);
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		Subject currentUser = SecurityUtils.getSubject();
		User user = userServiceImpl.findByUsername(currentUser.getPrincipal().toString());
		ActivityQueryDto query = new ActivityQueryDto();
		query.setStatus(status);
		query.setUserId(user.getId());
		List<Activity> deployedActivitys = activityServiceImpl.findActivitys(page,query);
		List<ActivityListDto> alds = new ArrayList<ActivityListDto>();
		for (Activity act : deployedActivitys) {
			ActivityListDto dto = new ActivityListDto();
			dto.setId(act.getId());
			dto.setDeployTime(act.getCreateTime());
			dto.setName(act.getName());
			dto.setPoster(act.getPosterUrl());
			dto.setUpdateTime(act.getUpdateTime());
			alds.add(dto);
		}
		response.getBody().put("activitys", alds);
		response.getBody().put("page", page);
		response.setStatusCode(statusCode);
		return response;
		
	}
	
	/**
	 * 
	 * 更新活动状态
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}/status", method = RequestMethod.PUT)
	@ResponseBody
	public RestResponse updateActivityStatus(@PathVariable int id,int status) {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		Activity act = activityServiceImpl.findById(id);
		act.setStatus(status);
		activityServiceImpl.update(act);
		response.setStatusCode(statusCode);
		return response;
		
	}
	
	/**
	 * 删除活动
	 * @param activityId
	 * @return
	 */
	@RequestMapping(value="/{activityId}", method = RequestMethod.DELETE)
	@ResponseBody
	public RestResponse deleteActivity(@PathVariable int activityId) {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		activityServiceImpl.delete(activityId);
		response.setStatusCode(statusCode);
		return response;
	}
	
	/**
	 * 活动基本信息
	 * @param model
	 * @param activityId
	 * @return
	 */
	@RequestMapping(value="/{activityId}", method = RequestMethod.GET)
	public String activityInfo(Model model,@PathVariable int activityId) {
		Activity activity = activityServiceImpl.findALLById(activityId);
		model.addAttribute("activity",activity);
		return "site.activity.info";
	}
	/**
	 * 活动基本信息
	 * @param model
	 * @param activityId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="/info/{type}/{activityId}", method = RequestMethod.GET)
	public String activityInfo4OutSide(Model model,@PathVariable int activityId,@PathVariable int type) {
		Activity activity = activityServiceImpl.findALLById(activityId);
		model.addAttribute("activity",activity);
		model.addAttribute("type",type);
		return "site.activity.info";
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
