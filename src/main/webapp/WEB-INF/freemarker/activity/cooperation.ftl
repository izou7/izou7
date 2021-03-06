  <style>
  	.glyphicon{
  		cursor: pointer
  	}
  	#tagsDiv button{
  	  margin:5px;
  	}
  </style>
  <link rel="stylesheet" href="${ (project.staticDomain)! }/libs/FixedNavigationTutorial/css/style.css">
  <!-- Generic page styles -->
  <!-- 主要内容 -->
  <ul id="navigation" >
    <li ><a href="activity?step=FIRST&activityId=${ id! }" title="基本信息"><h4>基本信息</h4></a></li>
    <li ><a href="activity?step=SECOND&activityId=${id! }" title="文章列表"><h4>文章列表</h4></a></li>
    <li ><a href="activity?step=THIRD&activityId=${ id! }" title="日历"><h4>日历</h4></a></li>
    <li ><a href="activity?step=FOURTH&activityId=${ id! }" title="报名模板"><h4>报名模板</h4></a></li>
    <li ><a href="activity?step=FIFTH&activityId=${ id! }" title="票务信息"><h4>票务信息</h4></a></li>
    <li ><a href="activity?step=SIXTH&activityId=${ id! }" title="嘉宾列表"><h4>嘉宾列表</h4></a></li>
</ul>
  <div class="container content">
  <!--页头-->
    <div class="page-header">
		<h1>发布活动</h1>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
		<h3 class="panel-title">开放合作</h3>
		</div>
		<div class="panel-body">
			<input type="hidden" id="id" value="${id!}">
			<form class="form-horizontal" role="form" id="settingForm" action="${id!}/setting" method="POST">
			  <div class="form-group">
				<div class="col-lg-10">
					 <div class="table-responsive">
					  <table class="table table-bordered">
						<thead>
						  <tr>
							<th>微信ID</th>
							<th>公众号名称</th>
							<th>描述信息</th>
							<th>是否创建者</th>
							<th>操作</th>
						  </tr>
						</thead>
						<tbody id="cooperationTBody">
						<#list cpts as cpt>
							<tr>
								<td>${(cpt.wechatId)!}</td>
								<td>${(cpt.publicName)!}</td>
								<td>${(cpt.description)!}</td>
								<td>
								<#if (cpt.mine)! == true>
									是
								<#else>
									否
								</#if>
								</td>
								<td><span id="delSpan" class="glyphicon glyphicon-remove"  data_id="${(cpt.id)!}"></span></td>
							  </tr>
						</#list>
						</tbody>
					  </table>
					</div>
				</div>
			</div>
			 <div class="form-group">
				<div class="col-sm-8">
				</div>
				<!--
				<div class="col-sm-2">
				  <button type="button" class="btn btn-info btn-block" onclick="javascript:location.href='activity?step=SIXTH&activityId=${id!}';">上一步</button>
				</div>
				-->
				<div class="col-sm-2">
				  <button type="button" id="deployBtn" class="btn btn-info btn-block"  onclick="javascript:location.href='activity?step=SUCCESS&activityId=${id!}';" >发布</button>
				</div>
				<!--
				<div class="col-sm-2">
				  <button type="button"  class="btn btn-info btn-block" onclick="javascript:location.href='activity?step=EIGHTH&activityId=${id!}';" >下一步</button>
				</div>
				-->
			 </div>
			</form>
		</div>
	</div>
	<div class="panel panel-default">
	  <div class="panel-heading" name="title" style="cursor: pointer">
	  	<h3 class="panel-title">系统推荐</h3>
	  </div>
	  <div class="panel-body" >
		<div class="form-group">
						<div class="col-lg-10">
							 <div class="table-responsive">
							  <table class="table table-bordered">
								<thead>
								  <tr>
									<th>微信ID</th>
									<th>公众号名称</th>
									<th>描述信息</th>
									<th>是否创建者</th>
									<th>操作</th>
								  </tr>
								</thead>
								<tbody>
								<#list rcpls as rcpl>
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
									<td><span id="addSpan" class="glyphicon glyphicon-plus" data_id="${(rcpl.id)!}"></span></td>
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
	  <div class="panel-heading" name="title"  style="cursor: pointer">
	    <h3 class="panel-title">手动添加</h3>
	  </div>
	  <div class="panel-body">
	  <form class="form-horizontal" id="cooperationForm" action="${id!}/cooperation" method="POST">
	  	<div class="form-group">
		    <div class="form-group">
					<label class="col-sm-2 control-label" for="name">微信ID：</label>
					<div class="col-sm-4">
					  <input class="form-control" type="text" name="wechatId"  id="wechatId" placeholder="公众账号微信ID" required>
					</div>
			</div>
		    <div class="form-group">
					<label class="col-sm-2 control-label" for="publicName">公众号名称：</label>
					<div class="col-sm-4">
					  <input class="form-control" type="text" name="publicName"  id="publicName" placeholder="公众号名称" required>
					</div>
			</div>
		  <div class="form-group">
			<label class="col-sm-2 control-label">标签：</label>
			<div id="tagsDiv" class="col-sm-6">
				<#list tags as tag>
				<button type="button" class="btn btn-sm btn-info" value="${(tag.name)!}">${(tag.name)!}</button>
				</#list>
			</div>
			<input type="hidden" id="tags" name="tags" >
		  </div>
		    <div class="form-group">
					<label class="col-sm-2 control-label" for="description">详细介绍：</label>
					<div class="col-sm-4">
					  <textarea class="form-control" rows="4" id="description" name="description" placeholder="详细介绍"></textarea>
					</div>
			</div>
			<div class="form-group">
		    		<div class="col-sm-2"></div>
					<div class="col-sm-4">
						<input name="mine" type="checkbox" >
						本人维护的公众号
					</div>
			</div>
		    <div class="form-group">
		    		<div class="col-sm-4">
					</div>
					<div class="col-sm-2">
					  <button type="submit" id="add" class="btn btn-info btn-block" >添加</button>
					</div>
			</div>
		</div>
		</form>
	  </div>
	</div>
  </div>

<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
  <script src="${ (project.staticDomain)! }/libs/bootstrap/js/bootstrap.js"></script>
<script src="${ (project.staticDomain)! }/libs/jquery-form/jquery.form.js"></script>
<script src="${ (project.staticDomain)! }/libs/Zebra_Dialog/js/zebra_dialog.js"></script>
<script src="${ (project.staticDomain)! }/js/activity/cooperation.js"></script> 



