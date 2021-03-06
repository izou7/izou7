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
@RequestMapping("incubator")
public class IncubatorController {

	private static final Logger logger = LoggerFactory
			.getLogger(IncubatorController.class);
	
	@Resource
	private IncubatorService incubatorServiceImpl;
	
	@RequestMapping(value="/incubatorsPage", method = RequestMethod.GET)
	public String list(Model model  ) {
		return "site.incubator.list";
	}
	
	@RequestMapping(value="/incubatorPage", method = RequestMethod.GET)
	public String info(Model model ,int id) {
		model.addAttribute("incubator",incubatorServiceImpl.get(id));
		return "site.incubator.info";
	}
	
	@RequestMapping(value="/incubators", method = RequestMethod.GET)
	@ResponseBody
	public RestResponse incubators(int index) {
		RestResponse response = new RestResponse();
		Page page = new Page();
		page.setIndex(index);
		page.setSize(5);
		List<Incubator> incubators = incubatorServiceImpl.find(page);
		response.getBody().put("incubators", incubators);
		response.getBody().put("page", page);
		response.setStatusCode(ResponseStatusCode.OK);
		return response;
	}

	
}
