
package cn.chinattclub.izou7.web;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.chinattclub.izou7.dto.ActivityDto;
import cn.chinattclub.izou7.entity.Activity;
import cn.chinattclub.izou7.entity.Image;
import cn.chinattclub.izou7.entity.Province;
import cn.chinattclub.izou7.service.ActivityService;
import cn.chinattclub.izou7.service.ProvinceService;
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
	private ProvinceService provinceServiceImpl; 
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
		log.debug("uploadPost called");
        Iterator<String> itr = request.getFileNames();
        MultipartFile mpf;
        List<Image> list = new LinkedList<>();
        
        while (itr.hasNext()) {
            mpf = request.getFile(itr.next());
            log.debug("Uploading {}", mpf.getOriginalFilename());
            
            String newFilenameBase = UUID.randomUUID().toString();
            String originalFileExtension = mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."));
            String newFilename = newFilenameBase + originalFileExtension;
            String storageDirectory = "D:\\temp";
            String contentType = mpf.getContentType();
            File newFile = new File(storageDirectory + "/" + newFilename);
            try {
                mpf.transferTo(newFile);
                
//                BufferedImage thumbnail = Scalr.resize(ImageIO.read(newFile), 290);
//                String thumbnailFilename = newFilenameBase + "-thumbnail.png";
//                File thumbnailFile = new File(storageDirectory + "/" + thumbnailFilename);
//                ImageIO.write(thumbnail, "png", thumbnailFile);
//                
//                Image image = new Image();
//                image.setName(mpf.getOriginalFilename());
//                image.setThumbnailFilename(thumbnailFilename);
//                image.setNewFilename(newFilename);
//                image.setContentType(contentType);
//                image.setSize(mpf.getSize());
//                image.setThumbnailSize(thumbnailFile.length());
//                image = imageDao.create(image);
                Image image = new Image();
                image.setName(newFile.getName());
                image.setUrl(storageDirectory + "/" + newFilename);
                 
//                image.setThumbnailUrl("/thumbnail/"+image.getId());
//                image.setDeleteUrl("/delete/"+image.getId());
//                image.setDeleteType("DELETE");
                
                list.add(image);
                
            } catch(IOException e) {
                log.error("Could not upload file "+mpf.getOriginalFilename(), e);
            }
            
        }
        
        Map<String, Object> files = new HashMap<>();
        files.put("files", list);
        return files;
	}

}
