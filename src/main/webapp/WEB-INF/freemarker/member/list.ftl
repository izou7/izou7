  <style>
  	.glyphicon{
  		cursor: pointer
  	}
  </style>
  <link href="${ (project.staticDomain)! }/libs/bootstrap-paginator/bootstrap-combined.min.css" rel="stylesheet">
  <!-- Generic page styles -->
  <!-- 主要内容 -->
  <div class="container content">
  <input type="hidden" id="id" name="id" value="${ (com.id)! }">
  <!--页头-->
    <div class="page-header">
		<h1>${(com.name)!}</h1>
	</div>
	<div class="row">
	<!-- Tab panes -->
	<div class="tab-content">
	  <div role="tabpanel" class="tab-pane active" id="memberTable">
		  <div class="col-lg-12">
			 <div class="table-responsive">
			  <table class="table table-bordered margin-top10" >
				<thead>
				  <tr>
					<th>图像</th>
					<th>用户名</th>
					<th>简介</th>
					<th>进入论坛时间</th>
					<th>联系电话</th>
					<th>操作</th>
				  </tr>
				</thead>
				<tbody id="memberTBody">
				
				</tbody>
			  </table>
			</div>
			<div class="modal-footer">
				<div id="memberPaginator"></div>
			</div>	
		  </div>
	  </div>
	</div>
	</div>
  </div>
<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
<script src="${ (project.staticDomain)! }/libs/bootstrap/js/bootstrap.js"></script>
<script src="${ (project.staticDomain)! }/libs/Zebra_Dialog/js/zebra_dialog.js"></script>
<script src="${ (project.staticDomain)! }/libs/bootstrap-paginator/bootstrap-paginator.js"></script>
<script src="${ (project.staticDomain)! }/js/utils/DateUtil.js"></script>
<script src="${ (project.staticDomain)! }/js/member/list.js"></script>



