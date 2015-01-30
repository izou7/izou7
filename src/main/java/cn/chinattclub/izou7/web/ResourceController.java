package cn.chinattclub.izou7.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @ClassName: ResourceController
 * @Description:活动资源控制类
 * @author: zy
 * @date: 2014-11-9 下午8:00:36
 * 
 */
@Controller
@RequestMapping("resource")
public class ResourceController {

	private static final Logger logger = LoggerFactory
			.getLogger(ResourceController.class);
	
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String list(Model model  ) {
		return "site.resource.index";
	}
	
	
}
