package cn.chinattclub.izou7.web;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chinattclub.izou7.dto.PublicDto;
import cn.chinattclub.izou7.entity.Public;
import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.service.PublicService;
import cn.chinattclub.izou7.util.CommonUtil;
import cn.zy.commons.webdev.constant.ResponseStatusCode;
import cn.zy.commons.webdev.http.RestResponse;

@Controller
@RequestMapping(value="/public")
public class PublicController {
	
	@Resource 
	private PublicService publicServiceImpl;
	
	/**
	 * 
	 * 公众号介绍页面
	 *
	 * @param model
	 * @param dto
	 * @return
	 */
	@RequestMapping(value="/description", method = RequestMethod.GET)
	public String introducePublic(Model model) {
		return "site.public.description";
	}
	
	/**
	 * 
	 * 公众号表单页面
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/form", method = RequestMethod.GET)
	public String publicPage(Model model) {
		return "site.public.form";
	}
	
	
	@RequestMapping(value = "/public", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse addPublic(@Valid Public publicObj, BindingResult br) throws  ClassNotFoundException  {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String message = "新增公众号成功！";
		if(!CommonUtil.validateDto(response,br,publicObj.getClass().getName().toString())){
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
		}else{
			if(publicServiceImpl.validate(publicObj.getWechatId())){
				publicObj.setCreateTime(new Date());
				publicObj.setUser(CommonUtil.getCurrentUser());
				publicServiceImpl.save(publicObj);
			}else{
				statusCode = ResponseStatusCode.CONFLICT;
				message = "该公众号微信ID已存在，添加失败！";		
			}
			response.setMessage(message);
		}
		response.setStatusCode(statusCode);
		return response;
	}
	
	
	@RequestMapping(value="/import", method = RequestMethod.GET)
	public String importPublic(Model model ,PublicDto dto) {
		
		publicServiceImpl.importPublic(dto);
		
		return "site.public.share";
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String listPublic(Model model) {
		User user = CommonUtil.getCurrentUser();
		List<Public> publicList = publicServiceImpl.listPublic(user);
		model.addAttribute("publicList",publicList);
		return "site.public.list";
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public RestResponse deletePublic(@PathVariable String id) {
		
		RestResponse response = new RestResponse();
		int publicId = 0;
		if(StringUtils.isNotBlank(id)){
			try{
				publicId = Integer.parseInt(id);
				publicServiceImpl.deletePublic(publicId);
				response.setMessage("删除成功");
				response.setStatusCode(200);
			}catch(Exception e){
				response.setMessage("删除失败，内部错误");
				response.setStatusCode(500);
				return response;
			}
		}else{
			response.setMessage("删除失败，参数有误");
			response.setStatusCode(500);
		}
		return response;
	}
	
	@RequestMapping(value="/show", method = RequestMethod.GET)
	public String showPublic(Model model, int publicId) {
		Public pub = publicServiceImpl.getPublicById(publicId);
		model.addAttribute("public",pub);
		return "site.public.info";
	}
}
