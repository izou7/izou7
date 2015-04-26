<style>
.tz_zk_item .tz_list{
	padding-bottom:0px;
}
._p2{
 font-size:14px;
 color:#3b3b3b;

}
.box{
	font-size:12px;
}
.hf{
	font-size:10px;
}
.spanTime{
	color:#3b3b3b;
}
</style>
<link rel="stylesheet" type="text/css" href="${ (project.staticDomain)! }/libs/jPaginate/css/style.css" media="screen"/>
<body >
<div class="pl_w">
		<div class="inner">
			<div class="modal_top">
				<div class="cjsq_btn">
					<a href="/community/addPage">创建社区</a>
				</div>
				<div class="sq_inner">
					<ul class="clearfix">
					<input type="hidden" id="communityId" value="${(com.id)!}"/>
					<#list communities as comm>
						<#if comm.id == com.id>
							<li id="com${(comm.id)!}" name="communityLi" class="on" data_id="${(comm.id)!}">
						<#else>
							<li id="com${(comm.id)!}" name="communityLi" data_id="${(comm.id)!}" >
						</#if>
							<div class="hd">
								<a href="/community/editPage/${(comm.id)!}" class="edit_btn">编辑</a>
								<a name="deleteComBtn" data_id="${(comm.id)!}" href="#" class="delete_btn">删除</a>
							</div>
							<div name="communityArea" class="bd clearfix">
								<div class="img fl">
									<img src="${(comm.poster)!}" style="width:75px;height:75px;">
									<!--  
									<a href="">换一下</a>
									-->
								</div>
								<div class="r_text fl">
								<#if comm.name?length gt 8>
									<p class="p1">${comm.name?substring(0,8)}...</p>
								<#else>
									<p class="p1">${comm.name}</p>
								</#if>
									<p class="p2">发布时间：${(comm.createTime)!}<br/>修改时间：${(comm.createTime)!}</p>
								</div>
							</div>
							
						</li>
					</#list>
					</ul>
				</div>
			</div>
			<div class="tab_content" style="display:block">
				<div class="cygl">
					
					<#if (com.communityMembers)?size == 0>
					<div class="hd">成员管理(暂无成员)</div>
					<#else>
					<div class="hd">成员管理</div>							
					</#if>
					<div class="bd">
						<ul class="clearfix">
							<#list com.communityMembers as mem>
							<#if mem.status == 0>
								<li id="mem${(mem.id)!}">
									<img src="${(mem.member.userInfo.headPicture)!}">
									<p>${(mem.member.userInfo.realName)!}</p>
									<div class="mask_bg mask_bg_h" style="display:block!important;"></div>
									<div class="mask_text mask_text_tg">待审核</div>
									<div class="user_info">
										
										<div class="t clearfix">
										<img src="${(mem.member.userInfo.headPicture)!}" class="fl">
										<p class="p1">
											<strong>${(mem.member.userInfo.realName)!}</strong>
										</p>
										<p class="p2">
											<span>${(mem.member.userInfo.sex)?string("女","男")}</span>
											<span>${(mem.member.userInfo.birthday)!}</span>
											<span>${(mem.member.userInfo.city.city)!}</span>
										</p>
										<p class="p3">
											<span class="s1">${(mem.member.userInfo.phone)!"未知"}</span></br>
											<span class="s2">${(mem.member.userInfo.email)!"未知"}</span>
										</p>
									</div>
									<div class="b">
									<#if (mem.member.userInfo.introduction)?? && (mem.member.userInfo.introduction)!="">
										<#if mem.member.userInfo.introduction?length gt 25>
											<p>${mem.member.userInfo.introduction?substring(0,25)}...</p>
										<#else>
											<p>${(mem.member.userInfo.introduction)!}</p>
										</#if>
									<#else>
										<p>这家伙很懒，什么都没有留下...</p>
									</#if>
									</div>
									<div class="f">
										<a name="passBtn" data_id="${(mem.id)!}" href="#">通过</a>&nbsp;&nbsp;&nbsp;&nbsp;
										<a name="noPassBtn" data_id="${(mem.id)!}" href="#">不通过</a>
										<i class="arr"></i>
									</div>
									</div>
								</li>
							<#else>
							<li id="mem${(mem.id)!}">
								<img src="${(mem.member.userInfo.headPicture)!}">
								<p>${(mem.member.userInfo.realName)!}</p>
								<div class="mask_bg"></div>
								<div class="user_info">
									<div class="t clearfix">
										<img src="${(mem.member.userInfo.headPicture)!}" class="fl">
										<p class="p1">
											<strong>${(mem.member.userInfo.realName)!}</strong>
										</p>
										<p class="p2">
											<span>${(mem.member.userInfo.sex)?string("女","男")}</span>
											<span>${(mem.member.userInfo.birthday)!}</span>
											<span>${(mem.member.userInfo.city.city)!}</span>
										</p>
										<p class="p3">
											<span class="s1">${(mem.member.userInfo.phone)!"未知"}</span></br>
											<span class="s2">${(mem.member.userInfo.email)!"未知"}</span>
										</p>
									</div>
									<div class="b">
									<#if (mem.member.userInfo.introduction)?? && (mem.member.userInfo.introduction)!="">
										<#if mem.member.userInfo.introduction?length gt 25>
											<p>${mem.member.userInfo.introduction?substring(0,25)}...</p>
										<#else>
											<p>${(mem.member.userInfo.introduction)!}</p>
										</#if>
									<#else>
										<p>这家伙很懒，什么都没有留下...</p>
									</#if>
									</div>
									<div class="f">
										<a name="deleteMemBtn" data_id="${(mem.id)!}" href="#">删除会员</a>
										<i class="arr"></i>
									</div>
								</div>
							</li>
							</#if>
							</#list>
							<!--  
							<li class="more_li">
								<a href="javascript:;">more</a>
							</li>
							-->
						</ul>
					</div>
				</div>
				<div class="tzgl_zk_box">
					<#if dys?size == 0>
					<div class="tit">帖子管理(暂无帖子)</div>
					<#else>
					<div class="tit">帖子管理</div>								
					</#if>
					<div class="tz_zk_item">
						<div class="tz_list">
							<ul>
							
							<#list dys as dyn> 
								<li id="dyn${(dyn.id)!}" data_id="${(dyn.id)!}">
									<div class="clearfix">
									<!--  
										<img src="${(dyn.user.userInfo.headPicture)!}" class="fl img" style="widht:67px!important;height:67px;border-radius:50%;">
										-->
										<div class="fl con">
											<div class="title clearfix">
												<p class="fl p1">${(dyn.user.userInfo.realName)!}: <span class="_p2">${(dyn.content)!}</span></p>
												<a href="javascript:;" class="fr xl_btn" data="false"></a>
												<p class="fr p1"><span class="spanTime">${(dyn.createTime)!}</span>&nbsp;&nbsp; <a name="dynDeleteBtn" href="#" class="delete_btn">删除</a></p>
											</div>
											<!--  
											<div class="text">
												<p>停下脚步，只为走的更远。停下脚步，只为走的更远。停下脚步，只为走的更远。停下脚步，只为走的更远。停下脚步，只为走的更远。停下脚步，只为走的更远。</p>
												<div class="delete_box"><a href="javascript:;" class="delete_btn">删除</a></div>
											</div>
											-->
										</div>
									</div>
									<div class="hf">
										<#list dyn.communityDynamicMessages as mes>
										<div class="box " id="mes${(mes.id)!}">
										<div class="name">${(mes.user.userInfo.realName)!}：
										<#if mes.toUser??>
											<span class="s">回复</span>  ${(mes.toUser.userInfo.realName)!}
										</#if>
										<span class="_p2">${(mes.content)!}</span>&nbsp;&nbsp;&nbsp;&nbsp;<span class="spanTime">${(mes.createTime)!}</span>&nbsp;&nbsp; <a name="deleteMesBtn" data_id="${(mes.id)!}" href="javascript:;" class="delete_btn">删除</a>
										<!--  
											<span class="time">${(mes.createTime)!}</span>                <a href="" class="delete">删除</a>  </div>
											<div class="text">
												<p>${(mes.content)!}</p>
											</div>
											-->
										</div>
										</div>
										</#list>
										<!--  
										<a href="pl_more.html" class="look_more">查看更多</a>
										-->
									</div>
								</li>
								</#list>
							</ul>
						</div>
					</div>
					<#if dys?size gt 0>
		                <div id="pager" style="font-family:none;">                   
		                </div>
				 </#if>
					
				</div>
			</div>
		</div>
	</div>
<div id="confirmBox" class="pop_box pop_edit pop_edit_name">
		<div class="hd">
			<span class="tit">删除操作</span>
		</div>
		<div class="bd">
			<div class="clearfix">
				<label>确定要进行该删除操作？</label>
				<input id="tempData" type="hidden" data_type="" data_value=""/>
			</div>
		</div>
		<div class="ft">
			<a href="javascript:;" class="cancel_btn">否</a>
			<a id="deleteBtn" href="javascript:void(0);" class="sure_btn">是</a>
		</div>
	</div>

</body>
<script src="${ (project.staticDomain)! }/libs/jPaginate/jquery-1.3.2.js" type="text/javascript"></script>
<script src="${ (project.staticDomain)! }/libs/jPaginate/jquery.paginate.js" type="text/javascript"></script>
<script src="${ (project.staticDomain)! }/js/common.js"></script>
<script src="${ (project.staticDomain)! }/js/community/manager.js"></script>
<script type="text/javascript">
var count = "${(page.count)!}";
var start = "${(page.index)!}";
</script>
