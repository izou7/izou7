<nav class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation" style="text-align: center;">
  		<div class="container">
  			<!-- Brand and toggle get grouped for better mobile display -->
  			<div class="navbar-header">
  				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
  					<span class="sr-only">Toggle navigation</span>
  				</button> 
  				<a class="navbar-brand" href="/index">TT家族</a>
  					<ul class="nav navbar-nav" id="nav">
  						<li >
  							<a  href="/entrepreneur/index">创业者</a>
  						</li>
  						<li >
  							<a  href="/activity/index">活动</a>
  						</li>
  						<li >
  							<a  href="#">孵化器</a>
  						</li>
  						<!--  
  						<li>
  							<a class="deployment" href="/public/description">合作伙伴</a>
  						</li>
  						-->
  					</ul>
  					<ul class="nav navbar-nav navbar-right">
  					<#if realName??>
  						<li class="dropdown">                                                                                                                           
  							<a href="#" class="dropdown-toggle" data-toggle="dropdown">${(realName)!}<span class="caret"></span></a>
  							<ul class="dropdown-menu" role="menu">
  								<li>
  									<a href="/userInfo/get">个人资料</a>
  								</li>
  								<li>
  									<a href="/activity/myActivities">我发起的活动</a>
  								</li>
  								<!--  
  								<li>
  									<a href="/public/list">我录入的合作信息</a>
  								</li>
  								-->
  								<li>
  									<a href="/user/logout">登出</a>
  								</li>
  							</ul>
  						</li>
  					<#else>
  						<li >
  						<a href="/login.jsp" >登录</a>
  						</li>
  						<li >
  						<a href="/regist" >注册</a>
  						</li>
  					</#if>
  						<li >
  						<a href="/activity/activity?step=FIRST" >添加活动</a>
  						</li>
  					</ul>
  				</div>
  				<!-- /.navbar-collapse -->
  			</div>
  			<!-- /.container-fluid -->
  		</nav>
