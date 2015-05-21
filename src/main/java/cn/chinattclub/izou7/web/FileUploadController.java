package cn.chinattclub.izou7.web;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.chinattclub.izou7.entity.Image;
import cn.chinattclub.izou7.util.CommonUtil;
import cn.zy.commons.webdev.constant.ResponseStatusCode;
import cn.zy.commons.webdev.http.RestResponse;

/**
 * 
 * @ClassName:	FileUploadController
 * @Description:文件上传
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
				list.add(image.getUrl());
			} catch(IOException e) {
				log.error("Could not upload file "+mpf.getOriginalFilename(), e);
				message = "上传异常！";
				statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
			}
		}
		result.setMessage(message);
		result.getBody().put("urls", list);
		result.setStatusCode(statusCode);
		return result;
	}
}
