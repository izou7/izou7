  <style>
  	#tagsDiv button{
  	  margin:5px;
  	}
  </style>
  <!-- Generic page styles -->
  <!-- 主要内容 -->
  <div class="container content">
  <!--页头-->
    <div class="page-header">
		<h1>录入公众号</h1>
	</div>
	<div class="panel panel-default">
				<div class="panel-heading">
		<h3 class="panel-title">公众号信息</h3>
		</div>
		<div class="panel-body">
		  <form class="form-horizontal" id="publicForm" action="public" method="POST">
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
					<button type="button" class="btn btn-sm btn-info">原创设计</button>
					<button type="button" class="btn btn-sm btn-info">演唱会</button>
					<button type="button" class="btn btn-sm btn-info">红丝带</button>
					<button type="button" class="btn btn-sm btn-info">扶贫</button>
					<button type="button" class="btn btn-sm btn-info">助学</button>
					<button type="button" class="btn btn-sm btn-info">微电影</button>
					<button type="button" class="btn btn-sm btn-info">生活育儿</button>
					<button type="button" class="btn btn-sm btn-info">论坛</button>
					<button type="button" class="btn btn-sm btn-info">点映</button>
					<button type="button" class="btn btn-sm btn-info">首映</button>
					<button type="button" class="btn btn-sm btn-info">其他</button>
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
<script src="${ (project.staticDomain)! }/libs/My97DatePicker/WdatePicker.js"></script>
<script src="${ (project.staticDomain)! }/js/common.js"></script>
<script src="${ (project.staticDomain)! }/js/public/form.js"></script> 



