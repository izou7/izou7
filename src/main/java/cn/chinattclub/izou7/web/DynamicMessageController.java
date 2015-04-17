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
import cn.chinattclub.izou7.dto.MessageDto;
import cn.chinattclub.izou7.entity.CommunityDynamicMessage;
import cn.chinattclub.izou7.service.CommunityDynamicMessageService;
import cn.chinattclub.izou7.util.CommonUtil;
import cn.zy.commons.webdev.constant.ResponseStatusCode;
import cn.zy.commons.webdev.http.RestResponse;

/**
 * 
 * 动态留言控制器
 *
 * @author zhangying.
 *         Created 2015-3-2.
 */
@Controller
@RequestMapping(value="/dynamicMessage")
public class DynamicMessageController {

	private static final Logger logger = LoggerFactory
			.getLogger(DynamicMessageController.class);
	
	@Resource
	private CommunityDynamicMessageService communityDynamicMessageServiceImpl;
	
	
	
	/**
	 * 
	 * 动态下的留言
	 *
	 * @param id
	 * @return
	*/
	@RequestMapping(value="{dynamicId}", method = RequestMethod.GET)
	@ResponseBody
	public RestResponse list(Model model ,@PathVariable("dynamicId") int dynamicId) {
		RestResponse response = new RestResponse();
		List<MessageDto> dtos = new ArrayList<>();
		List<CommunityDynamicMessage> messages = communityDynamicMessageServiceImpl.findMessage(dynamicId);
		for (CommunityDynamicMessage cdm : messages) {
			MessageDto dto = new MessageDto();
			dto.setId(cdm.getId());
			dto.setCreateTime(cdm.getCreateTime());
			dto.setUsername(cdm.getUser().getUsername());
			dto.setToUsername(cdm.getToUser().getUsername());
			dto.setContent(cdm.getContent());
			dtos.add(dto);
		}
		response.setStatusCode(ResponseStatusCode.OK);
		response.getBody().put("messages",dtos);
		return response;
	}
	/**
	 * 
	 * 删除留言
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public RestResponse delete(@PathVariable("id") Integer id)  {
		RestResponse response = new RestResponse();
		int statusCode = ResponseStatusCode.OK;
		String message = "删除留言成功！";
		CommunityDynamicMessage dynamicMessage = communityDynamicMessageServiceImpl.findById(id);
		
		if(dynamicMessage.getCommunityDynamic().getCommunity().getAdmin().getId()!=CommonUtil.getCurrentUser().getId()){
			logger.warn(dynamicMessage.getCommunityDynamic().getCommunity().getAdmin().getUsername()+"有盗链行为，请注意！");
			response.setMessage("内部异常");
			response.setStatusCode(ResponseStatusCode.BAD_REQUEST);
			return response;
		}
		communityDynamicMessageServiceImpl.delete(id);
		response.setStatusCode(statusCode);
		return response;
	}	
	
}
