  <style>
  	.selectedTemplate{
  	border:5px solid #428bca;
  	}
  </style>
  <link rel="stylesheet" href="${ (project.staticDomain)! }/libs/FixedNavigationTutorial/css/style.css">
  <!-- Generic page styles -->
  <ul id="navigation" style="position:absolute;top:20%;" >
    <li ><a href="activity?step=FIRST&activityId=${ id! }" title="活动基本信息">活动基本信息</a></li>
    <li ><a href="activity?step=SECOND&activityId=${ id! }" title="文章列表">文章列表</a></li>
    <li ><a href="activity?step=THIRD&activityId=${ id! }" title="日历">日历</a></li>
    <li ><a href="activity?step=FOURTH&activityId=${ id! }" title="报名模板">报名模板</a></li>
    <li ><a href="activity?step=FIFTH&activityId=${ id! }" title="票务信息">票务信息</a></li>
    <li ><a href="activity?step=SIXTH&activityId=${ id! }" title="嘉宾列表">嘉宾列表</a></li>
    <!--
    <li ><a href="activity?step=SEVENTH&activityId=${ id! }" title="开放合作">开放合作</a></li>
    -->
</ul>
  <!-- 主要内容 -->
  <div class="container content">
  <!--页头-->
    <div class="page-header">
		<h1>发布活动</h1>
	</div>
	<div class="panel panel-default">
				<div class="panel-heading">
		<h3 class="panel-title">票务信息</h3>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" role="form" id="ticketForm" action="${id!}/ticket"  method="POST">
			<input class="form-control" type="hidden" id="id" name="activity" value="${id!}" >
			<input class="form-control" type="hidden" id="ticketId" name="id" value="${(ticket.id)!}" >
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="type">类型：</label>
				<div class="col-sm-6">
				  <div class="checkbox">
				  	<#if (ticket.free)?? && ticket.free = false>
				  		<label>
						  <input type="radio" name="free" value="true"> 免费
						</label>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<label>
						  <input type="radio" name="free" value="false"  checked> 收费
						</label>
				  	<#else>
				  		<label>
						  <input type="radio" name="free" value="true" checked> 免费
						</label>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<label>
						  <input type="radio" name="free" value="false" > 收费
						</label>
				  	</#if>
					</div>
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="price">价格：</label>
				<div class="col-sm-2">
				  <input class="form-control" type="number" name="price" value="${(ticket.price)!}" >
				</div>
				<div class="col-sm-1">
				  元
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="limit">限额：</label>
				<div class="col-sm-2">
				  <input class="form-control" type="number" name="limit" id="limit" value="${(ticket.limit)!}" >
				</div>
				<div class="col-sm-1">
				  张
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="time">售票时间：</label>
				<div class="col-sm-2" >
				  <input class="form-control " type="text" name="ticketSaleStartTime" id="ticketSaleStartTime" style="width:220px;" value="${(ticket.ticketSaleStartTime?string('yyyy-MM-dd'))!}">
				</div>
				<span class="col-sm-2 text-center" >到</span>
				<div class="col-sm-2">
				  <input class="form-control" type="text" name="ticketSaleEndTime"  id="ticketSaleEndTime" style="width:220px;margin-left:-63px;" value="${(ticket.ticketSaleEndTime?string('yyyy-MM-dd'))!}">
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="time">有效期：</label>
				<div class="col-sm-2" >
				  <input class="form-control " type="text" name="ticketValidStartTime" id="ticketValidStartTime" style="width:220px;"  value="${(ticket.ticketValidStartTime?string('yyyy-MM-dd'))!}">
				</div>
				<span class="col-sm-2 text-center" >到</span>
				<div class="col-sm-2">
				  <input class="form-control" type="text" name="ticketValidEndTime" id="ticketValidEndTime" style="width:220px;margin-left:-63px;"  value="${(ticket.ticketValidEndTime?string('yyyy-MM-dd'))!}">
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="introduction">票种说明：</label>
				<div class="col-sm-6">
				  <textarea class="form-control" rows="4" name="introduction" placeholder="票种说明" >${(ticket.introduction)!}</textarea>
				</div>
			  </div>
			 <div class="form-group">
			 	<div class="col-sm-4">
				</div>
				<!--
				<div class="col-sm-1">
				  <button type="button" class="btn btn-info btn-block" onclick="javascript:location.href='activity?step=FOURTH&activityId=${id!}'">上一步</button>
				</div>
				-->
				<div class="col-sm-2">
				  <button type="submit" name="subBtn" id="saveBtn"  class="btn btn-info btn-block" >保存</button>
				</div>
				<div class="col-sm-2">
				  <button type="submit" name="subBtn" id="deployBtn"  class="btn btn-info btn-block" >发布</button>
				</div>
				<!--
				<div class="col-sm-1">
				  <button type="submit" name="subBtn" id="nextBtn"  class="btn btn-info btn-block" >下一步</button>
				</div>
				-->
			 </div>
			 <input type="hidden" id="type" name="type" value="NEXT"/>
			</form>
		</div>
		
	</div>
  </div>
<script>
var free = "${(ticket.free?string('true','false'))!}";
</script>
<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
  <script src="${ (project.staticDomain)! }/libs/bootstrap/js/bootstrap.js"></script>
<script src="${ (project.staticDomain)! }/libs/jquery-form/jquery.form.js"></script>
<script src="${ (project.staticDomain)! }/libs/Zebra_Dialog/js/zebra_dialog.js"></script>
<script src="${ (project.staticDomain)! }/libs/My97DatePicker/WdatePicker.js"></script>
<script src="${ (project.staticDomain)! }/js/common.js"></script>
<script src="${ (project.staticDomain)! }/js/activity/ticket.js"></script> 



