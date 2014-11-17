package cn.chinattclub.izou7.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.chinattclub.izou7.dto.PublicDto;
import cn.chinattclub.izou7.service.PublicService;

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
}
