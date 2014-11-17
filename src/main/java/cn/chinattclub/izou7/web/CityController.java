
package cn.chinattclub.izou7.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chinattclub.izou7.entity.City;
import cn.chinattclub.izou7.service.CityService;
import cn.zy.commons.webdev.constant.ResponseStatusCode;
import cn.zy.commons.webdev.http.RestResponse;

/**
 * 
 * 城市控制类
 *
 * @author zhangying.
 *         Created 2014-11-17.
 */
@Controller
@RequestMapping("city")
public class CityController {
	
	@Resource
	private CityService cityServiceImpl;
	
	/**
	 * 
	 * 通过省ID获取城市
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	@ResponseBody
	public RestResponse findCityByProvince(@PathVariable("id") int id) {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String msg = "获取城市成功！";
		List<City> citys = cityServiceImpl.findCityIdByProvince(id);
		response.setMessage(msg);
		response.setStatusCode(statusCode);
		response.getBody().put("city",citys);
		return response;

	}
}
