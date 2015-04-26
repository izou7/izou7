package cn.chinattclub.izou7.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chinattclub.izou7.dto.MemberDto;
import cn.chinattclub.izou7.entity.CommunityMember;
import cn.chinattclub.izou7.entity.User;
import cn.chinattclub.izou7.service.CommunityMemberService;
import cn.chinattclub.izou7.service.CommunityService;
import cn.chinattclub.izou7.util.CommonUtil;
import cn.zy.commons.webdev.constant.ResponseStatusCode;
import cn.zy.commons.webdev.http.RestResponse;
import cn.zy.commons.webdev.vo.Page;

/**
 * 
 * 成员控制器
 *
 * @author zhangying.
 *         Created 2015-3-2.
 */
@Controller
@RequestMapping(value="/member")
public class MemberController {

	private static final Logger logger = LoggerFactory
			.getLogger(MemberController.class);
	
	@Resource
	private CommunityMemberService communityMemberServiceImpl;
	@Resource
	private CommunityService communityServiceImpl;
	
	@RequestMapping(value = "listPage", method = RequestMethod.GET)
	public String listPage(Model model,int communityId) {
		model.addAttribute("com",communityServiceImpl.findById(communityId));
		return "site.member.list";
	}
	
	/**
	 * 
	 * 获取当前用户的社区列表
	 *
	 * @param id
	 * @return
	*/
	@RequestMapping(value="list/{communityId}", method = RequestMethod.GET)
	@ResponseBody
	public RestResponse list(Model model ,@PathVariable("communityId") int communityId,int index) {
		RestResponse response = new RestResponse();
		Page page = new Page();
		page.setIndex(index);
		List<MemberDto> mds = new ArrayList<>();
		List<CommunityMember> communityMembers = communityMemberServiceImpl.findCommunityMember(page,communityId);
		for (CommunityMember cm : communityMembers) {
			MemberDto dto = new MemberDto();
			dto.setId(cm.getId());
			dto.setUserId(cm.getMember().getId());
			dto.setAddDate(cm.getCreateTime());
			if(cm.getMember().getUserInfo()!=null){
				dto.setHeadPictureUrl(cm.getMember().getUserInfo().getHeadPictureUrl());
				dto.setIntroduction(cm.getMember().getUserInfo().getIntroduction());
				dto.setPhone(cm.getMember().getUserInfo().getPhone());
			}else{
				dto.setHeadPictureUrl("默认图");
			}
			if(StringUtils.isBlank(dto.getHeadPictureUrl())){
				dto.setHeadPictureUrl("默认图");
			}
			dto.setUsername(cm.getMember().getUsername());
			mds.add(dto);
		}
		User currentUser = CommonUtil.getCurrentUser();
		response.setStatusCode(ResponseStatusCode.OK);
		response.getBody().put("mds",mds);
		response.getBody().put("page",page);
		response.getBody().put("currentUserId",currentUser.getId());
		return response;
	}
	/**
	 * 
	 * 删除成员
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public RestResponse delete(@PathVariable("id") Integer id)  {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String message = "删除成员成功！";
		communityMemberServiceImpl.deleteMember(id);
		response.setStatusCode(statusCode);
		return response;
	}	
	/**
	 * 
	 * 审核通过
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "{id}/{pass}", method = RequestMethod.PUT)
	@ResponseBody
	public RestResponse audit(@PathVariable("id") Integer id,@PathVariable("pass") int pass)  {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String message = "审核成员成功！";
		communityMemberServiceImpl.execPassMember(id,pass);
		response.setStatusCode(statusCode);
		return response;
	}	
}
