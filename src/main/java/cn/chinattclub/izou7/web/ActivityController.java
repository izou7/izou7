
package cn.chinattclub.izou7.web;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
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

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.chinattclub.izou7.dto.ActivityDto;
import cn.chinattclub.izou7.dto.ActivityFormDto;
import cn.chinattclub.izou7.dto.UserDto;
import cn.chinattclub.izou7.entity.Activity;
import cn.chinattclub.izou7.entity.ActivityArticle;
import cn.chinattclub.izou7.entity.ActivityPoster;
import cn.chinattclub.izou7.entity.Article;
import cn.chinattclub.izou7.entity.City;
import cn.chinattclub.izou7.entity.Image;
import cn.chinattclub.izou7.entity.Province;
import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.service.ActivityArticleService;
import cn.chinattclub.izou7.service.ActivityService;
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
			break;
		case FOURTH:
			break;
		case FIFTH:
			break;
		case SIXTH:
			break;
		case SEVENTH:
			break;
		default:
			break;
		}
		return view;
	}
	
	/**
	 * 第二步
	 * @param model
	 * @param dto
	 * @return
	 */
	public String activityArticlesPage(Model model ,ActivityDto dto){
		if(dto.getActivityId()!=null){
			List<ActivityArticle> articles = activityArticleServiceImpl.findArticlesById(dto.getActivityId());
			model.addAttribute("articles", articles);
		}
		return "site.activity.articles";
	}
	/**
	 * 第一步
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
				image.setUrl(appConfig.get("storageImageUrl").toString().trim() + "/" + newFilename);
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
	@RequestMapping(value = "/uploadArticles", method = RequestMethod.POST)
	@ResponseBody
    public  Map uploadArticles(MultipartHttpServletRequest request, HttpServletResponse response) {
        Iterator<String> itr = request.getFileNames();
        MultipartFile mpf;
        List<Article> list = new LinkedList<>();
        String sbs = request.getParameter("sb");
        while (itr.hasNext()) {
            mpf = request.getFile(itr.next());
            String newFilenameBase = UUID.randomUUID().toString();
            String originalFileExtension = mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."));
            String newFilename = newFilenameBase + originalFileExtension;
            String storageDirectory = appConfig.get("storageDirectory").toString().trim()+"articles";
            File newFile = new File(storageDirectory + "/" + newFilename);
            Article article = new Article();
            try {
                mpf.transferTo(newFile);
//                image.setName(newFile.getName());
//                image.setUrl(appConfig.get("storageImageUrl").toString().trim() + "/" + newFilename);
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

}
