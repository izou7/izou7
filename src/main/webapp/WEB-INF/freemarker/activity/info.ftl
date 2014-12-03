  <style>
  	.glyphicon{
  		cursor: pointer
  	}
  	.jumbotron p{
  		font-size:14px;
  	}
  	.panel-heading a{
  		float:right;
  	}
  </style>
  <link rel='stylesheet' href='${ (project.staticDomain)! }/libs/fullcalendar/fullcalendar.css' />
  <!-- Generic page styles -->
  <!-- 主要内容 -->
  <div class="container content">
  <!--页头-->
    <div class="page-header">
		<h1>${(activity.name)!}</h1>
		<input type="hidden" id="id" value="${(activity.id)!}">
	</div>
	<div class="jumbotron">
		<div class="row">
			<div class="col-lg-5"><img src="/static/images/Chrysanthemum.jpg" width="100%" height="250"></div>
			<div class="col-lg-7">
			<p>
				标签：${(activity.tags)!}
			</p>
			<p>
				活动地点：${(activity.city.province.name)!} ${(activity.city.city)!} ${(activity.place)!} 
			</p>
			<p>
				活动时间：${(activity.startTime?string('yyyy-MM-dd'))!} 到 ${(activity.endTime?string('yyyy-MM-dd'))!} 
			</p>
			<p>
				活动人数：${(activity.headCount)!} 
			</p>
			<p>
				活动介绍：${(activity.introduction)!} 
			</p>
			<p>
				是否公开：
				<#if (activity.opene)?? && activity.opened == "true" >
				是
				<#else>
				否
				</#if> 
			</p>
			<p>
				活动主页：${(activity.homepage)!} 
			</p>
			</div>
		</div>
	</div>
	<div class="panel panel-default">
	  <div class="panel-heading">
	  	文章列表
	  	<a href="activity?step=SECOND&activityId=${(activity.id)!}">编辑</a>
	  </div>
	  <div class="panel-body">
	  <div class="row">
			<div class="col-lg-12">
				<div class="table-responsive">
					  <table class="table table-bordered">
						<thead>
						  <tr>
							<th>标题</th>
							<th>标签</th>
							<th>摘要</th>
							<th>地址</th>
						  </tr>
						</thead>
						<tbody >
						<#list (activity.articles)! as article>
							<tr>
								<td>${(article.title)!}</td>
								<td>${(article.tags)!}</td>
								<td>${(article.summary)!}</td>
								<td>${(article.url)!}</td>
							</tr>
						</#list>
						</tbody>
					  </table>
					</div>
			</div>
		</div>	  
	  </div>
	</div>
	<div class="panel panel-default">
	  <div class="panel-heading">日历
	  <a href="activity?step=THIRD&activityId=${(activity.id)!}">编辑</a>
	  </div>
	  <div class="panel-body">
	  <div class="row">
			<div class="col-lg-12">
				<div id="calendar"></div>
			</div>
		</div>	  
	  </div>
	</div>
	<div class="panel panel-default">
	  <div class="panel-heading">报名模板
	  <a href="activity?step=FOURTH&activityId=${(activity.id)!}">编辑</a>
	  </div>
	  <div class="panel-body">
	  <div class="row">
	  <#if (activity.template)??>
	 	<div class="col-xs-6 col-md-3">
		    <a href="#" name="template" class="thumbnail" data_id="${(activity.template.id)!}">
		      <img src="${(activity.template.url)!}" data-src="holder.js/100%x180"  alt="${(activity.template.name)!}">
		    </a>
	     </div>	  
	  </#if>
		</div>	  
	  </div>
	</div>
	<div class="panel panel-default">
	  <div class="panel-heading">票务信息
	   <a href="activity?step=FIFTH&activityId=${(activity.id)!}">编辑</a>
	  </div>
	  <div class="panel-body">
	  <#list (activity.tickets)! as ticket>
	  <div class="row">
	  	<div class="col-lg-5">
	  		<p>
			类型：
			<#if (ticket.free)?? && ticket.free = false>
		  		 收费
		  	<#else>
		  		免费
		  	</#if>
			</p>
	  	</div>
	  	<div class="col-lg-5">
	  		<p>
			价格：${(ticket.price)!}
			</p>
	  	</div>
	  </div>
	  <div class="row">
	  	<div class="col-lg-5">
	  		<p>
			限额：${(ticket.limit)!}
			</p>
	  	</div>
	  	<div class="col-lg-5">
	  		<p>
			票种说明：${(ticket.introduction)!}
			</p>
	  	</div>
	  </div>
	  <div class="row">
	  	<div class="col-lg-5">
	  		<p>
			售票时间：${(ticket.ticketSaleStartTime?string('yyyy-MM-dd'))!}到${(ticket.ticketSaleEndTime?string('yyyy-MM-dd'))!}
			</p>
	  	</div>
	  	<div class="col-lg-5">
	  		<p>
			有效期：${(ticket.ticketValidStartTime?string('yyyy-MM-dd'))!}到${(ticket.ticketValidEndTime?string('yyyy-MM-dd'))!}
			</p>
	  	</div>
	  </div>
	  </#list>
	  </div>
	</div>
	
	<div class="panel panel-default">
	  <div class="panel-heading">嘉宾列表
	  	<a href="activity?step=SIXTH&activityId=${(activity.id)!}">编辑</a>
	  </div>
	  <div class="panel-body">
	  	<div class="row">
	  		<div class="col-lg-10">
	  		<#list (activity.settings)! as setting>
			  	需求嘉宾人数：${(setting.guestNumber)!}
			  	<BR>
			  	报名期限：${(setting.guestRegistrationDeadline)!} (请求发出在几天内)
		  	</#list>
	  		</div>
	  	</div>
	  	<div class="row">
		<div class="col-lg-10">
			 <div class="table-responsive">
			  <table class="table table-bordered">
				<thead>
				  <tr>
					<th>姓名</th>
					<th>职业</th>
					<th>公司</th>
					<th>方向</th>
					<th>联系方式</th>
					<th>顺序</th>
				  </tr>
				</thead>
				<tbody>
				<#list activity.guests as guest>
					<tr>
						<td>${(guest.name)!}</td>
						<td>${(guest.position)!}</td>
						<td>${(guest.company)!}</td>
						<td>${(guest.researchArea)!}</td>
						<td>${(guest.phone)!}</td>
						<td>${(guest.rank)!}</td>
					  </tr>
				</#list>
				</tbody>
			  </table>
			</div>
		</div>	  	  
		</div>
	  </div>
	</div>
	<div class="panel panel-default">
	  <div class="panel-heading">开放合作
	  <a href="activity?step=SEVENTH&activityId=${(activity.id)!}">编辑</a>
	  </div>
	  <div class="panel-body">
		<div class="col-lg-10">
		 <div class="table-responsive">
		  <table class="table table-bordered">
			<thead>
			  <tr>
				<th>微信ID</th>
				<th>公众号名称</th>
				<th>描述信息</th>
				<th>是否创建者</th>
			  </tr>
			</thead>
			<tbody>
			<#list (activity.cooperations) as rcpl>
			  <tr>
				<td>${(rcpl.wechatId)!}</td>
				<td>${(rcpl.publicName)!}</td>
				<td>${(rcpl.description)!}</td>
				<td>
				<#if (rcpl.mine)! == true>
					是
				<#else>
					否
				</#if>
				</td>
			  </tr>								
			</#list>
			</tbody>
		  </table>
		</div>	  	  
	  </div>
	</div>
	</div>
	<div class="panel panel-default">
	  <div class="panel-heading">众筹信息
	  <a href="activity?step=EIGHTH&activityId=${(activity.id)!}">编辑</a>
	  </div>
	  <div class="panel-body">
	  <div class="row">
	  	<div class="col-lg-10">
		<div class="table-responsive">
		  <table class="table table-bordered">
			<thead>
			  <tr>
				<th>支付金额</th>
				<th>名额</th>
				<th>回报内容</th>
				<th>回报时间</th>
			  </tr>
			</thead>
			<tbody id="rewardTBody">
			<#list (activity.rewards)! as reward>
				<tr>
					<td>${(reward.amount)!}</td>
					<td>${(reward.limit)!}</td>
					<td>${(reward.reward)!}</td>
					<td>${(reward.days)!}</td>
				</tr>
			</#list>
			</tbody>
		  </table>
		</div>	  		
	  	</div>
	  </div>
	  

	  <#list (activity.cfSettings)! as setting>
	  <div class="row">
	  	<div class="col-lg-5">
	  		<p>
			回报时间：${(setting.rewardStartTime)!}到${(setting.rewardEndTime)!}
			</p>
	  	</div>
	  	<div class="col-lg-5">
	  		<p>
			支持金额：${(setting.amount)!}
			</p>
	  	</div>
	  </div>
	  <div class="row">
	  	<div class="col-lg-5">
	  		<p>
			回报内容：${(setting.reward)!}
			</p>
	  	</div>
	  	<div class="col-lg-5">
	  		<p>
			名额：${(setting.limit)!}
			</p>
	  	</div>
	  </div>
	  </#list>
	  </div>
	</div>	

	
  </div>
  

<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
<script src="${ (project.staticDomain)! }/libs/fullcalendar/lib/jquery-ui.custom.min.js"></script>
<script src='${ (project.staticDomain)! }/libs/fullcalendar/fullcalendar.js'></script>
<script src="${ (project.staticDomain)! }/libs/bootstrap/js/bootstrap.js"></script>
<script src="${ (project.staticDomain)! }/js/activity/info.js"></script> 



