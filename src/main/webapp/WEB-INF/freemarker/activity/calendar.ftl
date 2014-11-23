  <style>
  	#tagsDiv button{
  	  margin:5px;
  	}
  </style>
  <!-- Generic page styles -->
  <link rel='stylesheet' href='${ (project.staticDomain)! }/libs/fullcalendar/fullcalendar.css' />
  <!-- 主要内容 -->
  <div class="container content">
  <!--页头-->
    <div class="page-header">
		<h1>发布活动</h1>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
		<h3 class="panel-title">活动日程</h3>
		<button type="hidden" id="modalTrigger" class="btn btn-info collapse"  data-toggle="modal" data-target="#addModal"></button>
		<input type="hidden" id="id" name="id" value="${id!}">
		</div>
		<div class="panel-body">
			
			  <div class="form-group form-group-lg">
				<div id='calendar'></div>
			  </div>
			  <div class="form-group form-group-lg">
				<div class="col-lg-8">
				 
				</div>
				<div class="col-lg-2">
				  <button type="button" class="btn btn-info btn-block" onclick="javascript:location.href='activity?step=SECOND&activityId=${id!}';">上一步</button>
				</div>
				<div class="col-lg-2">
				  <button type="button" class="btn btn-info btn-block" onclick="javascript:location.href='activity?step=FOURTH&activityId=${id!}';">下一步</button>
				</div>
			 </div>
		</div>			
	</div>
  </div>
<!--modal-->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">日程</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" role="form" id="calendarForm"  method="POST" action="${id!}/calendar">
		  <input type="hidden"  id="calendarId" value="" >
		  <div class="form-group">
		    <label for="content" class="col-sm-2 control-label">内容</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="title" name="title" placeholder="内容" required >
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="start" class="col-sm-2 control-label">开始时间</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="start" name="start" placeholder="开始时间" required>
		    </div>
		  </div>
 		 <div class="form-group">
		    <label for="end" class="col-sm-2 control-label">结束时间</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="end"  name="end" placeholder="结束时间" required>
		    </div>
		  </div>
		  <button type="submit" id="submitBtn" class="btn btn-primary collapse">提交</button>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" id="closeBtn" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" id="addBtn" class="btn btn-primary">添加</button>
        <button type="button" id="delBtn" class="btn btn-primary collapse">删除</button>
        <button type="button" id="editBtn" class="btn btn-primary collapse">保存</button>
      </div>
    </div>
  </div>
</div>
<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
<script src="${ (project.staticDomain)! }/libs/fullcalendar/lib/jquery-ui.custom.min.js"></script>
<script src='${ (project.staticDomain)! }/libs/fullcalendar/fullcalendar.js'></script>
<script src="${ (project.staticDomain)! }/js/activity/calendar.js"></script>
<script src="${ (project.staticDomain)! }/js/common.js"></script>
<script src="${ (project.staticDomain)! }/libs/bootstrap/js/bootstrap.js"></script>
<script src="${ (project.staticDomain)! }/libs/Zebra_Dialog/js/zebra_dialog.js"></script>
 
<script src="${ (project.staticDomain)! }/js/utils/dateUtil.js"></script>
<script src="${ (project.staticDomain)! }/libs/My97DatePicker/WdatePicker.js"></script>
<script src="${ (project.staticDomain)! }/libs/jquery-form/jquery.form.js"></script>



