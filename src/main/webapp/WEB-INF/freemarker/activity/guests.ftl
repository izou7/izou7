  <style>
  	.glyphicon{
  		cursor: pointer
  	}
  </style>
  <link rel="stylesheet" href="${ (project.staticDomain)! }/libs/FixedNavigationTutorial/css/style.css">
  <!-- Generic page styles -->
  <ul id="navigation" style="position:absolute;top:20%;" >
    <li ><a href="activity?step=FIRST&activityId=${id! }" title="活动基本信息">活动基本信息</a></li>
    <li ><a href="activity?step=SECOND&activityId=${id! }" title="文章列表">文章列表</a></li>
    <li ><a href="activity?step=THIRD&activityId=${id! }" title="日历">日历</a></li>
    <li ><a href="activity?step=FOURTH&activityId=${id! }" title="报名模板">报名模板</a></li>
    <li ><a href="activity?step=FIFTH&activityId=${id! }" title="票务信息">票务信息</a></li>
    <li ><a href="activity?step=SIXTH&activityId=${id! }" title="嘉宾列表">嘉宾列表</a></li>
    <li ><a href="activity?step=SEVENTH&activityId=${id! }" title="开放合作">开放合作</a></li>
</ul>
  <!-- 主要内容 -->
  <div class="container content">
  <!--页头-->
    <div class="page-header">
		<h1>发布活动</h1>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
		<h3 class="panel-title">邀请嘉宾</h3>
		</div>
		<div class="panel-body">
			<input type="hidden" id="id" value="${id!}">
			<form class="form-horizontal" role="form" id="settingForm" action="${id!}/setting" method="POST">
			<input type="hidden"  name="id" value="${(setting.id)!}">
		   <div class="form-group">
			<label class="col-sm-2 control-label" for="guestNumber">需求嘉宾人数：</label>
			<div class="col-sm-2">
			  <input class="form-control" type="number" id="guestNumber" name="guestNumber" value="${(setting.guestNumber)!5}" >
			</div>
			<div class="col-sm-1">
			 <span> 人</span>
			</div>
		   </div>
		   <div class="form-group">
			<label class="col-sm-2 control-label" for="guestRegistrationDeadline">报名期限：</label>
			<div class="col-sm-2">
			  <input class="form-control" type="number" id="guestRegistrationDeadline" name="guestRegistrationDeadline" value="${(setting.guestRegistrationDeadline)!2}" >
			</div>
			<div class="col-sm-2">
			  请求发出在几天内
			</div>
		   </div>
			  <div class="form-group">
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
							<th>调整顺序</th>
							<th>操作</th>
						  </tr>
						</thead>
						<tbody id="guestTBody">
						<#list guests as guest>
							<tr>
								<td>${(guest.name)!}</td>
								<td>${(guest.position)!}</td>
								<td>${(guest.company)!}</td>
								<td>${(guest.researchArea)!}</td>
								<td>${(guest.phone)!}</td>
								<td>${(guest.rank)!}</td>
								<td>
									<span name="upSpan" data_up="true" class="glyphicon glyphicon-arrow-up " data_id="${(guest.id)!}"></span>
									<span name="upSpan"  data_up="false" class="glyphicon glyphicon-arrow-down paddingleft20" data_id="${(guest.id)!}"></span>
								</td>
								<td><span id="delSpan" class="glyphicon glyphicon-remove"  data_id="${(guest.id)!}"></span></td>
							  </tr>
						</#list>
						</tbody>
					  </table>
					</div>
				</div>
			</div>
			 <div class="form-group">
				<div class="col-sm-6">
				</div>
				<!--
				<div class="col-sm-2">
				  <button type="button" class="btn btn-info btn-block" onclick="javascript:location.href='activity?step=FIFTH&activityId=${id!}';">上一步</button>
				</div>
				-->
				<!--
				<div class="col-sm-2">
				  <button type="button" class="btn btn-info btn-block">保存</button>
				</div>
				-->
				<div class="col-sm-2">
				  <button type="submit" name="subBtn" id="saveBtn"  class="btn btn-info btn-block" >保存</button>
				</div>
				<div class="col-sm-2">
				  <button type="submit" name="subBtn" id="deployBtn"  class="btn btn-info btn-block" >发布</button>
				</div>
				<!--
				<div class="col-sm-2">
				  <button type="submit" id="nextBtn" class="btn btn-info btn-block" >下一步</button>
				</div>
				-->
			 </div>
			 <input type="hidden" id="type" name="type" value="NEXT"/>
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
									<th>姓名</th>
									<th>职业</th>
									<th>公司</th>
									<th>方向</th>
									<th>联系方式</th>
									<th>操作</th>
								  </tr>
								</thead>
								<tbody id="sysTBody">
								<#list rcds as rcd>
								  <tr>
									<td>${(rcd.name)!}</td>
									<td>${(rcd.position)!}</td>
									<td>${(rcd.company)!}</td>
									<td>${(rcd.researchArea)!}</td>
									<td>${(rcd.phone)!}</td>
									<td><span id="sysAdd" class="glyphicon glyphicon-plus" data_id="${(rcd.id)!}"></span></td>
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
	  <form class="form-horizontal" id="guestForm" action="${id!}/guest" method="POST">
	  	<div class="form-group">
		    <div class="form-group">
					<label class="col-sm-2 control-label" for="name">姓名：</label>
					<div class="col-sm-4">
					  <input class="form-control" type="text" name="name"  id="name" placeholder="姓名" required>
					</div>
			</div>
		    <div class="form-group">
					<label class="col-sm-2 control-label" for="position">职位：</label>
					<div class="col-sm-4">
					  <input class="form-control" type="text" name="position"  id="position" placeholder="职位" required>
					</div>
			</div>
		    <div class="form-group">
					<label class="col-sm-2 control-label" for="company">公司：</label>
					<div class="col-sm-4">
					  <input class="form-control" type="text" name="company"  id="company" placeholder="公司" required>
					</div>
			</div>
		    <div class="form-group">
					<label class="col-sm-2 control-label" for="researchArea">研究方向：</label>
					<div class="col-sm-4">
					  <input class="form-control" type="text" name="researchArea"  id="researchArea" placeholder="研究方向" required>
					</div>
			</div>
		    <div class="form-group">
					<label class="col-sm-2 control-label" for="phone">手机号码：</label>
					<div class="col-sm-4">
					  <input class="form-control" type="text" name="phone"  id="phone" placeholder="手机号码" required>
					</div>
			</div>
		    <div class="form-group">
					<label class="col-sm-2 control-label" for="introduction">详细介绍：</label>
					<div class="col-sm-4">
					  <textarea class="form-control" rows="4" id="introduction" name="introduction" placeholder="详细介绍"></textarea>
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
<script src="${ (project.staticDomain)! }/js/activity/guests.js"></script> 



