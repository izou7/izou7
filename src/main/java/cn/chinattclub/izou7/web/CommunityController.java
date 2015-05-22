package cn.chinattclub.izou7.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chinattclub.izou7.dto.MemberDto;
import cn.chinattclub.izou7.entity.Community;
import cn.chinattclub.izou7.entity.CommunityDynamic;
import cn.chinattclub.izou7.entity.CommunityMember;
import cn.chinattclub.izou7.entity.Province;
import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.entity.UserInfo;
import cn.chinattclub.izou7.service.CityService;
import cn.chinattclub.izou7.service.CommunityDynamicService;
import cn.chinattclub.izou7.service.CommunityService;
import cn.chinattclub.izou7.service.ProvinceService;
import cn.chinattclub.izou7.service.TagService;
import cn.chinattclub.izou7.service.UserInfoService;
import cn.chinattclub.izou7.service.impl.CommunityMemberServiceImpl;
import cn.chinattclub.izou7.service.impl.UserInfoServiceImpl;
import cn.chinattclub.izou7.util.CommonUtil;
import cn.zy.commons.webdev.constant.ResponseStatusCode;
import cn.zy.commons.webdev.http.RestResponse;
import cn.zy.commons.webdev.vo.Page;

/**
 * 
 * 社区控制器
 *
 * @author zhangying.
 *         Created 2015-3-2.
 */
@Controller
@RequestMapping(value="/community")
public class CommunityController {

	private static final Logger logger = LoggerFactory
			.getLogger(CommunityController.class);
	
	@Resource
	private CommunityService communityServiceImpl; 
	
	@Resource
	private ProvinceService provinceServiceImpl; 
	
	@Resource
	private CityService cityServiceImpl; 
	
	@Resource
	private TagService tagServiceImpl; 
	
	@Resource
	private UserInfoService userInfoServiceImpl;
	
	@Resource
	private CommunityDynamicService communityDynamicServiceImpl;
	
	@Resource
	private Properties appConfig;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String indexPage(Model model) {
		return "site.community.index";
	}
	
	
	@RequestMapping(value = "manager", method = RequestMethod.GET)
	public String managerPage(Model model,Integer id,Integer index) {
		Page page = new Page();
		page.setIndex(index==null?0:index);
		List<Community> communities =  communityServiceImpl.getMyCommunities();
		if(id == null){
			if(communities!=null&&communities.size()>1){
				model.addAttribute("com",communities.get(0));
				id = communities.get(0).getId();
			}
		}else{
			for (Community community : communities) {
				if(community.getId()==id){
					model.addAttribute("com",community);
					break;
				}
			}
		}
		List<CommunityDynamic> dys = communityDynamicServiceImpl.findDynamics(page,id,null);
		model.addAttribute("dys",dys);
		model.addAttribute("page",page);
		model.addAttribute("communities",communities);
		return "site.community.manager";
	}
	
	@RequestMapping(value = "addPage", method = RequestMethod.GET)
	public String infoPage(Model model) {
		List<Province> provinces = provinceServiceImpl.findAll();
		model.addAttribute("provinces",provinces);
		model.addAttribute("userInfo",CommonUtil.getCurrentUser().getUserInfo());
//		model.addAttribute("tags", tagServiceImpl.list());
		return "site.community.info";
	}
	
	@RequestMapping(value = "editPage/{id}", method = RequestMethod.GET)
	public String editPage(Model model,@PathVariable("id") Integer id) {
		List<Province> provinces = provinceServiceImpl.findAll();
		Community community = communityServiceImpl.findById(id);
		if(community.getAdmin().getId()!=CommonUtil.getCurrentUser().getId()){
			logger.warn(community.getAdmin().getUsername()+"有盗链行为，请注意！");
			return "site.main.error";
		}
		model.addAttribute("com",community);
		model.addAttribute("provinces",provinces);
		model.addAttribute("tags", tagServiceImpl.list());
		model.addAttribute("userInfo",CommonUtil.getCurrentUser().getUserInfo());
		return "site.community.info";
	}
	
	
//	@RequestMapping(value = "listPage", method = RequestMethod.GET)
//	public String listPage(Model model) {
//		List<Community> communities =  communityServiceImpl.getMyCommunities();
//		model.addAttribute("communities",communities);
//		return "site.community.list";
//	}
	
	/**
	 * 
	 * 获取当前用户的社区列表
	 *
	 * @param id
	 * @return
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	@ResponseBody
	public RestResponse findMyCommunities() {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String msg = "获取社区成功！";
		List<Community> communities =  communityServiceImpl.getMyCommunities();
		response.setMessage(msg);
		response.setStatusCode(statusCode);
		response.getBody().put("communities",communities);
		return response;

	}
	 */
	/**
	 * 
	 * 更新
	 *
	 * @param community
	 * @param br
	 * @return
	 * @throws ClassNotFoundException
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public RestResponse updateCommunity(@RequestBody @Valid Community com, BindingResult br) throws  ClassNotFoundException  {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String message = "更新社区成功！";
		if(!CommonUtil.validateDto(response,br,com.getClass().getName().toString())){
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
		}else{
			Community oldCommunity = communityServiceImpl.findById(com.getId());
			if(oldCommunity.getAdmin().getId()!=CommonUtil.getCurrentUser().getId()){
				logger.warn(oldCommunity.getAdmin().getUsername()+"有盗链行为，请注意！");
				response.setMessage("内部异常");
				response.setStatusCode(ResponseStatusCode.BAD_REQUEST);
				return response;
			}
			if(StringUtils.isNotBlank(com.getAddress())){
				oldCommunity.setAddress(com.getAddress());
			}
			oldCommunity.setCity(cityServiceImpl.getCity(com.getCityId()));
			oldCommunity.setDescription(com.getDescription());
			oldCommunity.setName(com.getName());
			oldCommunity.setTags(com.getTags());
//			oldCommunity.setPublicNumber(com.getPublicNumber());
			if(StringUtils.isNotBlank(com.getPoster())){
				oldCommunity.setPoster(com.getPoster());
			}
//			oldCommunity.setPhone(com.getPhone());
//			oldCommunity.setRealName(com.getRealName());
			oldCommunity.setPrice(com.getPrice());
			communityServiceImpl.update(oldCommunity);
//			UserInfo userInfo = CommonUtil.getCurrentUser().getUserInfo();
//			userInfo.setRealName(com.getRealName());
//			userInfo.setPhone(com.getPhone());
//			userInfoServiceImpl.update(userInfo);
			response.setMessage(message);
		}
		response.setStatusCode(statusCode);
		return response;
	}
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
	public RestResponse addCommunity(@RequestBody @Valid Community community, BindingResult br) throws  ClassNotFoundException  {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String message = "新增社区成功！";
		if(!CommonUtil.validateDto(response,br,community.getClass().getName().toString())){
			statusCode = ResponseStatusCode.INTERNAL_SERVER_ERROR;
		}else{
			if(StringUtils.isBlank(community.getPoster())){
				community.setPoster(appConfig.get("defaultCommunityImgPath").toString());
			}
			if(community.getCityId()!=0){
				community.setCity(cityServiceImpl.getCity(community.getCityId()));
			}
			community.setAdmin(CommonUtil.getCurrentUser());
			community.setCreateTime(new Date());
			communityServiceImpl.add(community);
//			UserInfo userInfo = CommonUtil.getCurrentUser().getUserInfo();
//			userInfo.setRealName(community.getRealName());
//			userInfo.setPhone(community.getPhone());
//			userInfoServiceImpl.update(userInfo);
			response.setMessage(message);
		}
		response.setStatusCode(statusCode);
		return response;
	}
	
	/**
	 * 
	 * 删除社区
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public RestResponse delete(@PathVariable("id") Integer id)  {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String message = "删除社区成功！";
		Community community = communityServiceImpl.findById(id);
		if(community.getAdmin().getId()!=CommonUtil.getCurrentUser().getId()){
			logger.warn(community.getAdmin().getUsername()+"有盗链行为，请注意！");
			response.setMessage("内部异常");
			response.setStatusCode(ResponseStatusCode.BAD_REQUEST);
			return response;
		}
		communityServiceImpl.delete(id);
		response.setStatusCode(statusCode);
		return response;
	}
	
	/**
	 * 
	 * 社区详情（不包含帖子和留言）
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public RestResponse info(@PathVariable("id") Integer id) {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String msg = "获取社区详情成功！";
		Community community =  communityServiceImpl.findById(id);
		if(community.getAdmin().getId()!=CommonUtil.getCurrentUser().getId()){
			logger.warn(community.getAdmin().getUsername()+"有盗链行为，请注意！");
			response.setMessage("内部异常");
			response.setStatusCode(ResponseStatusCode.BAD_REQUEST);
			return response;
		}
		response.setMessage(msg);
		response.setStatusCode(statusCode);
		response.getBody().put("community",community);
		return response;
	}
	
	/**
	 * 
	 * 帖子page
	 *
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "postsPage", method = RequestMethod.GET)
	public String postsPage(Model model,@PathVariable("id") Integer id) {
		Community community = communityServiceImpl.findById(id);
		if(community.getAdmin().getId()!=CommonUtil.getCurrentUser().getId()){
			logger.warn(community.getAdmin().getUsername()+"有盗链行为，请注意！");
			return "site.main.error";
		}
		model.addAttribute("com",community);
		return "site.community.posts";
	}
	
	/**
	 * 
	 * 获取社区中
	 *
	 * @param id
	 * @return
	*/
	@RequestMapping(value="{communityId}/posts/list", method = RequestMethod.GET)
	@ResponseBody
	public RestResponse postsList(Model model ,@PathVariable("communityId") int communityId,int index) {
		RestResponse response = new RestResponse();
		Page page = new Page();
		page.setIndex(index);
//		List<CommunityMember> communityMembers = communityMemberServiceImpl.findCommunityMember(page,communityId);
		User currentUser = CommonUtil.getCurrentUser();
		response.setStatusCode(ResponseStatusCode.OK);
//		response.getBody().put("mds",communityMembers);
		response.getBody().put("page",page);
		return response;
	}
}
