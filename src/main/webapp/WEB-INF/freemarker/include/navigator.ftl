	<div class="header">
		<div class="inner clearfix">
			<div class="logo">
				<a href="/community/index"><img src="${ (project.staticDomain)! }/images/logo.png"></a>
			</div>
			<div class="fl nav">                                                                  
				
 				<span class="fl s1">
					<a href="/community/index">我是众创空间</a>
					<a href="/entrepreneur/index">我是创业者</a>
				</span>
				<#if realName??>  
				<!--                                                          
				<span class="fr s4">
					<a href="" class="btn"></a>
					<div class="menu_box">
						
						<a href="/user/logout">退出</a>
					</div>
				</span>  
				-->     
				                                                   
				<span class="fr s2">
					<a href="/user/logout">退出</a>
				</span>
				<span class="fr s2" style="">
					<a href="/service">付费服务</a>
				</span>
				<span class="fr s2">
					<a href="/community/manager">管理中心</a>
				</span>
				<#else>  
				
				<span class="fr s2">
					<a href="/login.jsp">登录</a>
				</span>
				<span class="fr s2" style="">
					<a href="/service">付费服务</a>
				</span>
				</#if>
			</div>
		</div>
	</div>