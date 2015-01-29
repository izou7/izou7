package cn.chinattclub.izou7.web;

import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chinattclub.izou7.entity.Incubator;
import cn.chinattclub.izou7.service.IncubatorService;
import cn.zy.commons.webdev.constant.ResponseStatusCode;
import cn.zy.commons.webdev.http.RestResponse;
import cn.zy.commons.webdev.vo.Page;

/**
 * 
 * @ClassName: MainController
 * @Description:孵化器控制类
 * @author: zy
 * @date: 2014-11-9 下午8:00:36
 * 
 */
@Controller
@RequestMapping("service")
public class ServiceController {

	private static final Logger logger = LoggerFactory
			.getLogger(ServiceController.class);
	
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String list(Model model  ) {
		return "site.service.index";
	}
	
	
}
