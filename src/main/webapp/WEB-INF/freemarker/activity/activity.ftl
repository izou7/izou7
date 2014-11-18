  <style>
  	#tagsDiv button{
  	  margin:5px;
  	}
  </style>
  <!-- Generic page styles -->
<link rel="stylesheet" href="${ (project.staticDomain)! }/libs/jqueryFileUpload/css/style.css">
<!-- CSS to style the file input field as button and adjust the Bootstrap progress bars -->
<link rel="stylesheet" href="${ (project.staticDomain)! }/libs/jqueryFileUpload/css/jquery.fileupload.css">
  <!-- 主要内容 -->
  <div class="container content">
  <!--页头-->
    <div class="page-header">
		<h1>发布活动</h1>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
		<h3 class="panel-title">基本信息</h3>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" role="form">
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="name">标签：</label>
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
			  </div>
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="name">活动名称：</label>
				<div class="col-sm-6">
				  <input class="form-control" type="text" id="name" placeholder="活动名称" required>
				</div>
			  </div>
			   <div class="form-group">
				<label class="col-lg-2 control-label" for="site">活动地点：</label>
				<div class="col-lg-2">
				  <select id="province" name="province" class="form-control" >
				  <option value="0">请选择</option>
				  <#list provinces! as province>
				  		<#if (activity.city.province.name)! == province.name >
				  			<option value="${(province.id)!}" selected>${(province.name)!}</option>
				  		<#else>
				  			<option value="${(province.id)!}">${(province.name)!}</option>
				  		</#if>
				  </#list>
				  </select>
				</div>
				<div class="col-lg-2">
				  <select id="city" name="city" class="form-control" >
					<option>请选择</option>
				  </select>
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="address"></label>
				<div class="col-sm-6">
				  <input class="form-control" type="text" id="address" placeholder="详细地址" required>
				</div>
			  </div>		
			  <div class="form-group">
				<label class="col-lg-2 control-label" for="time">活动时间：</label>
				<div class="col-lg-2" >
				  <input class="form-control " type="text" id="startTime" style="width:220px;">
				</div>
				<span class="col-lg-2 text-center" >到</span>
				<div class="col-lg-2">
				  <input class="form-control" type="text" id="endTime" style="width:220px;margin-left:-63px;">
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-lg-2 control-label" for="num">活动人数：</label>
				<div class="col-lg-6">
				  <input class="form-control" type="text" id="num" placeholder="活动人数">
				</div>
			  </div>
			  <!--  			  
			  <div class="form-group">
				<label class="col-lg-2 control-label" for="tag">活动标签：</label>
				<div class="col-lg-6">
				  <input id="tags_1" id="tag" type="text" class="tags form-control" value="原装设计,微电影" />
				</div>
			  </div>
			  -->
			  <div class="form-group">
				<label class="col-lg-2 control-label" for="introduction">活动介绍：</label>
				<div class="col-lg-6">
				  <textarea class="form-control" rows="4" id="introduction" placeholder="活动介绍"></textarea>
				</div>
			  </div>
			  <div class="form-group">
				  <label class="col-lg-2 control-label" for="poster">上传海报：</label>
				  <div class="col-lg-4">
					  <span class="btn btn-success fileinput-button">
					        <i class="glyphicon glyphicon-plus"></i>
					        <span>上传海报...</span>
					        <!-- The file input field used as target for the file upload widget -->
					        <input id="fileupload" type="file" name="files[]" multiple="">
					  </span>
				  </div>
			  <!-- 
				<label class="col-lg-2 control-label" for="poster">上传海报：</label>
				<div class="col-lg-1">
				<button type="button" class="btn btn-info">上传海报</button>
				<input type="file" name="fileField" class="file" id="fileField" size="18" />
				</div>
				<div class="col-lg-4">
					<h6 class="help-block">支持jpg、jpeg、png、gif格式，大小不超过2M。建议尺寸：400 X 220px</h6>
					
				</div>
				-->
			 </div>
			 <div class="form-group">
				<label class="col-lg-2 control-label" for="attachment"></label>
				<div class="col-lg-6">
					<div id="progress" class="progress">
        				<div class="progress-bar progress-bar-success"></div>
   					</div>	
				</div>
			 </div>
			 <div class="form-group">
				<label class="col-lg-2 control-label" for="attachment"></label>
				<div class="col-lg-10">
					<div id="files" class="files"></div>
				</div>
			 </div>
			 <div class="form-group">
				<label class="col-lg-2 control-label" for="attachment">上传附件：</label>
				<div class="col-lg-10">
					<input type="file" id="attachment" class="btn btn-primary" >
					<h6 class="help-block">支持jpg、jpeg、png、gif格式，大小不超过2M。建议尺寸：400 X 220px</h6>
				</div>
			 </div>
			 <div class="form-group">
				<label class="col-lg-2 control-label" for="isPublic">是否公开：</label>
				<div class="col-lg-10">
					<div class="checkbox">
						<label>
						  <input type="radio" name="isPublic"> 是
						</label>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<label>
						  <input type="radio" name="isPublic"> 否
						</label>
					</div>
					
				</div>
			 </div>	
			 <div class="form-group">
				<label class="col-lg-2 control-label" for="homeUrl">活动主页地址：</label>
				<div class="col-lg-6">
				  <input class="form-control" type="text" id="homeUrl" placeholder="活动主页地址">
				</div>
			 </div>	
			 <div class="form-group">
				<div class="col-lg-6">
				 
				</div>
				<div class="col-lg-2">
				  <button type="button" class="btn btn-info btn-block" onclick="javascript:location.href='deploy2.html'">下一步</button>
				</div>
			 </div>
			<!--
			 <div class="form-group">
			 <label class="col-lg-2 control-label" for="inputFile">相关链接：</label>
				<div class="col-lg-6">
					 <div class="table-responsive">
					  <table class="table table-bordered">
						<thead>
						  <tr>
							<th>序号</th>
							<th>链接</th>
							
						  </tr>
						</thead>
						<tbody>
						  <tr>
							<td>1</td>
							<td>www.baidu.com</td>
						  </tr>
						  <tr>
							<td>2</td>
							<td>www.sogou.com</td>
						  </tr>
						  <tr>
							<td>3</td>
							<td>www.google.com</td>
						  </tr>
						</tbody>
					  </table>
					</div>
				</div>
				<div class="col-lg-4">
					<button type="button" class="btn btn-info"><span class="glyphicon glyphicon-plus"></span></button>
					<button type="button" class="btn btn-info"><span class="glyphicon glyphicon-minus"></span></button>
				</div>
			</div>
			-->
			</form>
		</div>
	</div>
  </div>
<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
<!-- The jQuery UI widget factory, can be omitted if jQuery UI is already included -->
<script src="${ (project.staticDomain)! }/libs/jqueryFileUpload/js/vendor/jquery.ui.widget.js"></script>
<!-- The Load Image plugin is included for the preview images and image resizing functionality -->
<script src="${ (project.staticDomain)! }/libs/jqueryFileUpload/js/load-image.all.min.js"></script>
<!-- The Canvas to Blob plugin is included for image resizing functionality -->
<script src="${ (project.staticDomain)! }/libs/jqueryFileUpload/js/canvas-to-blob.min.js"></script>
<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
<script src="${ (project.staticDomain)! }/libs/bootstrap/js/bootstrap.js"></script>
<script src="${ (project.staticDomain)! }/libs/jqueryFileUpload/js/jquery.iframe-transport.js"></script>
<!-- The basic File Upload plugin -->
<script src="${ (project.staticDomain)! }/libs/jqueryFileUpload/js/jquery.fileupload.js"></script>
<!-- The File Upload processing plugin -->
<script src="${ (project.staticDomain)! }/libs/jqueryFileUpload/js/jquery.fileupload-process.js"></script>
<!-- The File Upload image preview & resize plugin -->
<script src="${ (project.staticDomain)! }/libs/jqueryFileUpload/js/jquery.fileupload-image.js"></script>
<!-- The File Upload audio preview plugin -->
<script src="${ (project.staticDomain)! }/libs/jqueryFileUpload/js/jquery.fileupload-audio.js"></script>
<!-- The File Upload video preview plugin -->
<script src="${ (project.staticDomain)! }/libs/jqueryFileUpload/js/jquery.fileupload-video.js"></script>
<!-- The File Upload validation plugin -->
<script src="${ (project.staticDomain)! }/libs/jqueryFileUpload/js/jquery.fileupload-validate.js"></script>
<script src="${ (project.staticDomain)! }/js/common.js"></script>
<script src="${ (project.staticDomain)! }/libs/My97DatePicker/WdatePicker.js"></script>
<script src="${ (project.staticDomain)! }/js/activity/activity.js"></script> 
