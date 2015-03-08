package cn.chinattclub.izou7.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chinattclub.izou7.dto.DynamicDto;
import cn.chinattclub.izou7.dto.MemberDto;
import cn.chinattclub.izou7.entity.Community;
import cn.chinattclub.izou7.entity.CommunityDynamic;
import cn.chinattclub.izou7.service.CommunityDynamicService;
import cn.chinattclub.izou7.service.CommunityService;
import cn.zy.commons.webdev.constant.ResponseStatusCode;
import cn.zy.commons.webdev.http.RestResponse;
import cn.zy.commons.webdev.vo.Page;

/**
 * 
 * 动态控制器
 *
 * @author zhangying.
 *         Created 2015-3-2.
 */
@Controller
@RequestMapping(value="/dynamic")
public class CommunityDynamicController {

	private static final Logger logger = LoggerFactory
			.getLogger(CommunityDynamicController.class);
	
	@Resource
	private CommunityDynamicService communityDynamicServiceImpl;
	
	@Resource
	private CommunityService communityServiceImpl;
	
	
	@RequestMapping(value = "dynamicPage", method = RequestMethod.GET)
	public String listPage(Model model,int communityId) {
		Community com = communityServiceImpl.findById(communityId);
		model.addAttribute("id",com.getId());
		model.addAttribute("name",com.getName());
		return "site.dynamic.list";
	}
	/**
	 * 
	 * 获取当前社区下的动态
	 *
	 * @param id
	 * @return
	*/
	@RequestMapping(value="{communityId}/list", method = RequestMethod.GET)
	@ResponseBody
	public RestResponse list(Model model ,@PathVariable("communityId") int communityId,String content,int index) {
		List<DynamicDto> dds = new ArrayList<>();
		RestResponse response = new RestResponse();
		Page page = new Page();
		page.setIndex(index);
		List<MemberDto> mds = new ArrayList<>();
		List<CommunityDynamic> CommunityDynamics = communityDynamicServiceImpl.findDynamics(page,communityId,content);
		for (CommunityDynamic cd : CommunityDynamics) {
			DynamicDto dt = new DynamicDto();
			dt.setContent(cd.getContent());
			dt.setCreateTime(cd.getCreateTime());
			dt.setId(cd.getId());
			dt.setUsername(cd.getUser().getUsername());
			dds.add(dt);
		}
		response.setStatusCode(ResponseStatusCode.OK);
		response.getBody().put("dds",dds);
		response.getBody().put("page",page);
		return response;
	}
	/**
	 * 
	 * 删除动态
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public RestResponse delete(@PathVariable("id") Integer id)  {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String message = "删除动态成功！";
		communityDynamicServiceImpl.delete(id);
		response.setStatusCode(statusCode);
		return response;
	}	
	
}
