  <style>
  	.glyphicon{
  		cursor: pointer
  	}
  </style>
  <!-- Generic page styles -->
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
			<form class="form-horizontal" role="form">
			<input type="hidden" id="id" name="id" value="${id!}">
		   <div class="form-group">
			<label class="col-sm-2 control-label" for="guestNumber">需求嘉宾人数：</label>
			<div class="col-sm-2">
			  <input class="form-control" type="text" id="guestNumber" name="guestNumber" value="${(setting.guestNumber)!}">
			</div>
			<div class="col-sm-1">
			 <span> 人</span>
			</div>
		   </div>
		   <div class="form-group">
			<label class="col-sm-2 control-label" for="guestRegistrationDeadline">报名期限：</label>
			<div class="col-sm-2">
			  <input class="form-control" type="text" id="guestRegistrationDeadline" name="guestRegistrationDeadline" value="${(setting.guestRegistrationDeadline)!}" >
			</div>
			<div class="col-sm-2">
			  请求发出在几天内
			</div>
		   </div>
		   </form>
		   <form class="form-horizontal" role="form">
			  <div class="form-group">
				<div class="col-lg-6">
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
				<div class="col-sm-2">
				 
				</div>
				<div class="col-sm-2">
				  <button type="button" class="btn btn-info btn-block" onclick="javascript:location.href='deploy4.html'">上一步</button>
				</div>
				<div class="col-sm-2">
				  <button type="button" class="btn btn-info btn-block" onclick="javascript:location.href='deploy6.html'">下一步</button>
				</div>
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
						<div class="col-lg-6">
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
								<tbody>
								<#list rcds as rcd>
								  <tr>
									<td>${(rcd.name)!}</td>
									<td>${(rcd.position)!}</td>
									<td>${(rcd.company)!}</td>
									<td>${(rcd.researchArea)!}</td>
									<td>${(rcd.phone)!}</td>
									<td><button type="button" class="btn btn-info" >添加</button></td>
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
	    Panel content
	  </div>
	</div>
  </div>

<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
<script src="${ (project.staticDomain)! }/libs/jquery-form/jquery.form.js"></script>
<script src="${ (project.staticDomain)! }/libs/Zebra_Dialog/js/zebra_dialog.js"></script>
<script src="${ (project.staticDomain)! }/js/activity/guests.js"></script> 



