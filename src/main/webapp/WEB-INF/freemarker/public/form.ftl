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
		<h1>录入合作信息</h1>
	</div>
	<div class="panel panel-default">
				<div class="panel-heading">
		<h3 class="panel-title">合作信息</h3>
		</div>
		<div class="panel-body">
		  <form class="form-horizontal" id="publicForm" action="public" method="POST">
		  	<div class="form-group">
			    <div class="form-group">
						<label class="col-sm-2 control-label" for="name">微信ID：</label>
						<div class="col-sm-4">
						  <input class="form-control" type="text" name="wechatId"  id="wechatId" placeholder="公众账号微信ID" >
						</div>
				</div>
			    <div class="form-group">
						<label class="col-sm-2 control-label" for="publicName">公众号名称：</label>
						<div class="col-sm-4">
						  <input class="form-control" type="text" name="publicName"  id="publicName" placeholder="公众号名称" >
						</div>
				</div>
			    <div class="form-group">
						<label class="col-sm-2 control-label" for="weibo">微博：</label>
						<div class="col-sm-4">
						  <input class="form-control" type="text" name="weibo"  id="weibo" placeholder="微博" >
						</div>
				</div>
			    <div class="form-group">
						<label class="col-sm-2 control-label" for="company">公司：</label>
						<div class="col-sm-4">
						  <input class="form-control" type="text" name="company"  id="company" placeholder="公司" >
						</div>
				</div>
			    <div class="form-group">
						<label class="col-sm-2 control-label" for="website">网址：</label>
						<div class="col-sm-4">
						  <input class="form-control" type="text" name="website"  id="website" placeholder="网站" >
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
						<label class="col-sm-2 control-label" for="description">合作需求：</label>
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



