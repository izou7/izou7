package cn.chinattclub.izou7.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 创业者controller
 * @author zy
 *
 */
@Controller
@RequestMapping(value="/entrepreneur")
public class EntrepreneurController {

	private static final Logger logger = LoggerFactory
			.getLogger(EntrepreneurController.class);

	
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String indexPage(Model model) {
		return "site.entrepreneur.index";
	}

	
}
