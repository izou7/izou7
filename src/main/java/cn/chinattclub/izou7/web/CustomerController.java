package cn.chinattclub.izou7.web;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chinattclub.izou7.entity.Customer;
import cn.chinattclub.izou7.service.CustomerService;
import cn.chinattclub.izou7.util.CommonUtil;
import cn.zy.commons.webdev.constant.ResponseStatusCode;
import cn.zy.commons.webdev.http.RestResponse;

/**
 * 
 * 社区控制器
 *
 * @author zhangying.
 *         Created 2015-3-2.
 */
@Controller
@RequestMapping(value="/customer")
public class CustomerController {

	private static final Logger logger = LoggerFactory
			.getLogger(CustomerController.class);
	
	
	
	@Resource
	private CustomerService customerServiceImpl;
	

	
	/**
	 * 
	 * 新增
	 *
	 * @param community
	 * @param br
	 * @return
	 * @throws ClassNotFoundException
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse addCommunity(@RequestBody @Valid Customer customer, BindingResult br) throws  ClassNotFoundException  {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String message = "新增客户成功！";
		if(!CommonUtil.validateDto(response,br,customer.getClass().getName().toString())){
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
		}else{
			customerServiceImpl.add(customer);
			response.setMessage(message);
		}
		response.setStatusCode(statusCode);
		return response;
	}
	

	@RequestMapping(value="finish", method = RequestMethod.GET)
	public String finish(Model model  ) {
		return "site.customer.finish";
	}
	
}
