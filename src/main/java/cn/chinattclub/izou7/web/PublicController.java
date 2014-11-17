package cn.chinattclub.izou7.web;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chinattclub.izou7.dto.PublicDto;
import cn.chinattclub.izou7.entity.Public;
import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.service.PublicService;
import cn.zy.commons.webdev.http.RestResponse;

@Controller
@RequestMapping(value="/public")
public class PublicController {
	
	@Resource 
	private PublicService publicService;
	
	@RequestMapping(value="/import", method = RequestMethod.GET)
	public String importPublic(Model model ,PublicDto dto) {
		
		publicService.importPublic(dto);
		
		return "site.public.share";
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String listPublic(Model model ,User user) {
		
		List<Public> publicList = publicService.listPublic(user);
		model.addAttribute(publicList);
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
				publicService.deletePublic(publicId);
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
}
