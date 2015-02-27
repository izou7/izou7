package cn.chinattclub.izou7.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.chinattclub.izou7.entity.Image;
import cn.chinattclub.izou7.service.TagService;

/**
 * 
 * @ClassName:	UploadController
 * @Description:上传控制类
 * @author:	zy
 * @date:	2014-11-9 下午8:00:36 
 *
 */
@Controller
@RequestMapping()
public class UploadController {
	
	private static final Logger log = LoggerFactory.getLogger(UploadController.class);
	
	@Resource
	private Properties appConfig;
	
	/**
	 * 
	 * 文件上传
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public  Map upload(MultipartHttpServletRequest request, HttpServletResponse response) {
		Iterator<String> itr = request.getFileNames();
		String fileType = "activity";
		if(request.getParameterValues("fileType").length>0){
			fileType = request.getParameterValues("fileType")[0];
		}
		MultipartFile mpf;
		List<Image> list = new LinkedList<>();
		while (itr.hasNext()) {
			mpf = request.getFile(itr.next());
			String newFilenameBase = UUID.randomUUID().toString();
			String originalFileExtension = mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."));
			String newFilename = newFilenameBase + originalFileExtension;
			String storageDirectory = appConfig.get("storageDirectory").toString().trim()+"images/"+fileType;
			File newFile = new File(storageDirectory + "/" + newFilename);
			Image image = new Image();
			try {
				mpf.transferTo(newFile);
				image.setName(newFile.getName());
//				image.setUrl(appConfig.get("storageIP").toString() + "images/"+fileType  +"/"+ newFilename);
				image.setUrl("http://localhost:8080/static/file/images/"+fileType +"/"+ newFilename);
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
	
}
