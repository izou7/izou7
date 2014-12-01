  <style>
  	.glyphicon{
  		cursor: pointer
  	}
  </style>
  <link href="${ (project.staticDomain)! }/libs/bootstrap-paginator/bootstrap-combined.min.css" rel="stylesheet">
  <!-- Generic page styles -->
  <!-- 主要内容 -->
  <div class="container content">
  <!--页头-->
    <div class="page-header">
		<h1>我发起的活动</h1>
	</div>
	<div class="row">
	  <!-- Nav tabs -->
	<ul id="activityTab" class="nav nav-tabs" role="tablist">
	  <li role="presentation" class="active"><a href="#deployedActivity" role="tab" data-toggle="tab">我发布的</a></li>
	  <li role="presentation"><a href="#waitActivity" role="tab" data-toggle="tab">待发布的</a></li>
	</ul>
	
	<!-- Tab panes -->
	<div class="tab-content">
	  <div role="tabpanel" class="tab-pane active" id="deployedActivity">
		  <div class="col-lg-12">
			 <div class="table-responsive">
			  <table class="table table-bordered margin-top10" >
				<thead>
				  <tr>
					<th>活动海报</th>
					<th>发布时间</th>
					<th>最后修改时间</th>
					<th>活动名称</th>
					<th>操作</th>
				  </tr>
				</thead>
				<tbody id="deployedTBody">
				
				</tbody>
			  </table>
			</div>
			<div class="modal-footer">
				<div id="deployedPaginator"></div>
			</div>	
		  </div>
	  </div>
	  <div role="tabpanel" class="tab-pane" id="waitActivity">
		  <div class="col-lg-10">
			 <div class="table-responsive">
			  <table class="table table-bordered margin-top10" >
				<thead>
				  <tr>
					<th>活动海报</th>
					<th>发布时间</th>
					<th>最后修改时间</th>
					<th>活动名称</th>
					<th>操作</th>
				  </tr>
				</thead>
				<tbody id="waitTBody">
				
				</tbody>
			  </table>
			</div>
		  </div>	  
	  </div>
	</div>

	</div>
	
  </div>

<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
<script src="${ (project.staticDomain)! }/libs/bootstrap/js/bootstrap.js"></script>
<script src="${ (project.staticDomain)! }/libs/bootstrap-paginator/bootstrap-paginator.js"></script>
<script src="${ (project.staticDomain)! }/libs/Zebra_Dialog/js/zebra_dialog.js"></script>
<script src="${ (project.staticDomain)! }/js/activity/myActivitys.js"></script> 



