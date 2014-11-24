  <style>
  	.selectedTemplate{
  	border:5px solid #428bca;
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
		<h3 class="panel-title">票务信息</h3>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" role="form">
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="type">类型：</label>
				<div class="col-sm-6">
				  <div class="checkbox">
						<label>
						  <input type="radio" name="free" value="true" checked> 免费
						</label>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<label>
						  <input type="radio" name="free" value="false"> 收费
						</label>
					</div>
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="price">价格：</label>
				<div class="col-sm-2">
				  <input class="form-control" type="text" name="price" >
				</div>
				<div class="col-sm-1">
				  元
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="limit">限额：</label>
				<div class="col-sm-2">
				  <input class="form-control" type="text" name="limit" id="limit" >
				</div>
				<div class="col-sm-1">
				  张
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="time">售票时间：</label>
				<div class="col-sm-2" >
				  <input class="form-control " type="text" name="ticketSaleStartTime" id="ticketSaleStartTime" style="width:220px;">
				</div>
				<span class="col-sm-2 text-center" >到</span>
				<div class="col-sm-2">
				  <input class="form-control" type="text" name="ticketSaleEndTime"  id="ticketSaleEndTime" style="width:220px;margin-left:-63px;">
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="time">有效期：</label>
				<div class="col-sm-2" >
				  <input class="form-control " type="text" name="ticketValidStartTime" id="ticketValidStartTime" style="width:220px;">
				</div>
				<span class="col-sm-2 text-center" >到</span>
				<div class="col-sm-2">
				  <input class="form-control" type="text" name="ticketValidEndTime" id="ticketValidEndTime" style="width:220px;margin-left:-63px;">
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="introduction">票种说明：</label>
				<div class="col-sm-6">
				  <textarea class="form-control" rows="4" name="introduction" placeholder="票种说明"></textarea>
				</div>
			  </div>
			 <div class="form-group">
				<div class="col-sm-4">
				 
				</div>
				<div class="col-sm-2">
				  <button type="button" class="btn btn-info btn-block" onclick="javascript:location.href='activity?step=FOURTH&activityId=${id!}'">上一步</button>
				</div>
				<div class="col-sm-2">
				  <button type="button" class="btn btn-info btn-block" >下一步</button>
				</div>
			 </div>
			</form>
		</div>
		
	</div>
  </div>

<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
<script src="${ (project.staticDomain)! }/libs/Zebra_Dialog/js/zebra_dialog.js"></script>
<script src="${ (project.staticDomain)! }/libs/My97DatePicker/WdatePicker.js"></script>
<script src="${ (project.staticDomain)! }/js/common.js"></script>
<script src="${ (project.staticDomain)! }/js/activity/ticket.js"></script> 


