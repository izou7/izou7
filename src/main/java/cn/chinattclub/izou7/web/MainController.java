
package cn.chinattclub.izou7.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @ClassName:	MainController 
 * @Description:系統主頁控制类
 * @author:	zy
 * @date:	2014-11-9 下午8:00:36 
 *
 */
@Controller
public class MainController {
	
	@RequestMapping(value="index", method = RequestMethod.GET)
	public String loginPage() {
		return "site.main.index";
	}
	
	@RequestMapping(value="error", method = RequestMethod.GET)
	public String errorPage() {
		return "site.main.error";
	}
	


}
