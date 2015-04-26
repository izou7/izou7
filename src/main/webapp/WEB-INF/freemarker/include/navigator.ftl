	<div class="header">
		<div class="inner clearfix">
			<div class="logo">
				<a href="index.html"><img src="${ (project.staticDomain)! }/images/logo.png"></a>
			</div>
			<div class="fl nav">                                                                  
				<span class="fl s1">
					<a href="/community/index">我是创业社区</a>
					<a href="/entrepreneur/index">我是创业者</a>
				</span>
 
				<#if realName??>                                                           
				<span class="fr s4">
					<a href="" class="btn"></a>
					<div class="menu_box">
						<a href="/userInfo/get">个人资料</a>
						<!--  <a href="">我发起的活动</a>-->
						<!--  <a href="/community/listPage">我的社区</a>-->
						<a href="/user/logout">退出</a>
					</div>
				</span>                                                          
				<span class="fr s2">
					<a href="/community/manager">管理中心</a>
				</span>
				<span class="fr s3" style="margin-left:45%;float:none;">
					<a href="/service">付费服务</a>
				</span>
				<#else>  
				<span class="fr s3" style="margin-left:55%;float:none;">
					<a href="/service">付费服务</a>
				</span>				
				<span class="fr s3">
					<a href="/login.jsp">登陆</a>
				</span>
				</#if>
			</div>
		</div>
	</div>