  <style>
  	#tagsDiv button{
  	  margin:5px;
  	}
  </style>
  <!-- Generic page styles -->
<link rel="stylesheet" href="${ (project.staticDomain)! }/libs/bootstrap-multiselect/bootstrap-multiselect.css">
<link rel="stylesheet" href="${ (project.staticDomain)! }/libs/jqueryFileUpload/css/style.css">
<link rel="stylesheet" href="http://blueimp.github.io/Gallery/css/blueimp-gallery.min.css">
<link rel="stylesheet" href="${ (project.staticDomain)! }/libs/jqueryFileUpload/css/jquery.fileupload.css">
<link rel="stylesheet" href="${ (project.staticDomain)! }/libs/jqueryFileUpload/css/jquery.fileupload-ui.css">
<noscript><link rel="stylesheet" href="${ (project.staticDomain)! }/libs/jqueryFileUpload/css/jquery.fileupload-noscript.css"></noscript>
<noscript><link rel="stylesheet" href="${ (project.staticDomain)! }/libs/jqueryFileUpload/css/jquery.fileupload-ui-noscript.css"></noscript>
<link rel="stylesheet" href="${ (project.staticDomain)! }/libs/FixedNavigationTutorial/css/style.css">
<ul id="navigation" style="position:absolute;top:20%;" >
    <li ><a href="activity?step=FIRST&activityId=${ id! }" title="活动基本信息">活动基本信息</a></li>
    <li ><a href="activity?step=SECOND&activityId=${ id! }" title="文章列表">文章列表</a></li>
    <li ><a href="activity?step=THIRD&activityId=${ id! }" title="日历">日历</a></li>
    <li ><a href="activity?step=FOURTH&activityId=${ id! }" title="报名模板">报名模板</a></li>
    <li ><a href="activity?step=FIFTH&activityId=${ id! }" title="票务信息">票务信息</a></li>
    <li ><a href="activity?step=SIXTH&activityId=${ id!}" title="嘉宾列表">嘉宾列表</a></li>
    <li ><a href="activity?step=SEVENTH&activityId=${ id! }" title="开放合作">开放合作</a></li>
</ul>
  <!-- 主要内容 -->
  <div class="container content">
  <!--页头-->
    <div class="page-header">
		<h1>发布活动</h1>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
		<h3 class="panel-title">上传文章</h3>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" role="form" id="fileupload" action="add" method="POST" enctype="multipart/form-data">
			<input type="hidden" id="id" name="id" value="${id!}">
			    <!-- Redirect browsers with JavaScript disabled to the origin page -->
			   
		        <noscript><input type="hidden" name="redirect" value="https://blueimp.github.io/jQuery-File-Upload/"></noscript>
		        <div class="form-group">
		        	<label class="col-lg-2 control-label" for="poster">上传文章：</label>
			        <!-- The fileupload-buttonbar contains buttons to add/delete files and start/cancel the upload -->
			        <div class="row fileupload-buttonbar col-lg-10">
			            <div class="col-lg-6">
			                <!-- The fileinput-button span is used to style the file input field as button -->
			                <span class="btn btn-success fileinput-button">
			                    <i class="glyphicon glyphicon-plus"></i>
			                    <span>上传文章</span>
			                    <input type="file" name="files[]" multiple>
			                </span>
			            </div>
			        </div>
			        <input type="hidden" id="posterUrl" name="posterUrl" value="">
			</div>
	        <div class="form-group">
				<label class="col-lg-2 control-label" ></label>
				<div class="col-lg-10">
				  <!-- The table listing the files available for upload/download -->
	        		<table id="filesTable" role="presentation" class="table table-striped"><tbody class="files"></tbody></table>
				</div>
		  	</div>
				  	
			</form>
			
		</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
		<h3 class="panel-title">文章列表</h3>
		</div>
		<div class="panel-body">
			 <div class="form-group">
				<div class="col-lg-12">
					 <div class="table-responsive">
					  <table class="table table-bordered">
						<thead>
						  <tr>
							<th>标题</th>
							<th>标签</th>
							<th>摘要</th>
							<th>下载</th>
							<th>操作</th>
						  </tr>
						</thead>
						<tbody id="tbodyId">
							<#list articles! as article>
							<tr>
								<td>${(article.title)!}</td>
								<td>${(article.tags)!}</td>
								<td>${(article.summary)!}</td>
								<td><a href="${(article.url)!}"><span class="glyphicon glyphicon-download-alt"></span></a></td>
								<td><button type="button" name="delBtn" class="btn btn-info" data_id="${(article.id)}">删除</button></td>
							</tr>
							</#list>
						  <tr>
						  </tr>
						</tbody>
					  </table>
					</div>
				</div>
			</div>
			 <div class="form-group">
			 	<div class="col-lg-10">
				 
				</div>
				<!--
				<div class="col-lg-2">
				  <button type="button" class="btn btn-info btn-block" onclick="javascript:location.href='activity?step=FIRST&activityId=${id!}';">上一步</button>
				</div>
				-->
				<div class="col-lg-2">
				  <button type="button" id="deployBtn" class="btn btn-info btn-block" >发布</button>
				</div>
				<!--
				<div class="col-lg-2">
				  <button type="button" class="btn btn-info btn-block" onclick="javascript:location.href='activity?step=THIRD&activityId=${id!}';">下一步</button>
				</div>
				-->
			 </div>
		</div>
	</div>
  </div>

			
<!-- The template to display files available for upload -->
<script id="template-upload" type="text/x-tmpl">
{% for (var i=0, file; file=o.files[i]; i++) { %}
    <tr class="template-upload fade">
        <td>
            <span class="preview"></span>
        </td>
        <td>
            <p class="name">{%=file.name%}</p>
            <strong class="error text-danger"></strong>
        </td>
		<td>
			<div class="input-group width150">
  				<span class="input-group-addon">标题</span>
  				<input  name="{%="title"+file.name.substring(0,file.name.lastIndexOf("."))%}" type="text" class="form-control" placeholder="标题">
			</div>
		</td>
<td>
	<div class="input-group btn-group width150">
	<span class="input-group-addon">标签</span>
	<select id="{%="multiple"+file.name.substring(0,file.name.indexOf("."))%}" name="{%="multiple"+file.name.substring(0,file.name.lastIndexOf("."))%}" class="multiselect" multiple="multiple">
	  <option value="原创设计">原创设计</option>
	  <option value="演唱会">演唱会</option>
	  <option value="红丝带">红丝带</option>
	  <option value="扶贫">扶贫</option>
	  <option value="助学">助学</option>
	  <option value="论坛">论坛</option>
	</select>
    </div>
</td>
        <td>
            <p class="size">Processing...</p>
            <div class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0"><div class="progress-bar progress-bar-success" style="width:0%;"></div></div>
        </td>
        <td>
            {% if (!i && !o.options.autoUpload) { %}
                <button class="btn btn-primary start" name="startBtn" disabled>
                    <i class="glyphicon glyphicon-upload"></i>
                    <span>Start</span>
                </button>
            {% } %}
            {% if (!i) { %}
                <button name="cancelBtn" class="btn btn-warning cancel">
                    <i class="glyphicon glyphicon-ban-circle"></i>
                    <span>Cancel</span>
                </button>
            {% } %}
        </td>
    </tr>
{% } %}
</script>
<!-- The template to display files available for download -->
<script id="template-download" type="text/x-tmpl">
{% for (var i=0, file; file=o.files[i]; i++) { %}
    <tr class="template-download fade">
        <td>
            <span class="preview">
                {% if (file.thumbnailUrl) { %}
                    <a href="{%=file.url%}" title="{%=file.name%}" download="{%=file.name%}" data-gallery><img src="{%=file.thumbnailUrl%}"></a>
                {% } %}
            </span>
        </td>
        <td>
            <p class="name">
                {% if (file.url) { %}
                    <a href="{%=file.url%}" title="{%=file.name%}" download="{%=file.name%}" {%=file.thumbnailUrl?'data-gallery':''%}>{%=file.name%}</a>
                {% } else { %}
                    <span>{%=file.name%}</span>
                {% } %}
            </p>
            {% if (file.error) { %}
                <div><span class="label label-danger">Error</span> {%=file.error%}</div>
            {% } %}
        </td>
        <td>
        </td>
        <td>
        </td>
        <td>
            <span class="size">{%=o.formatFileSize(file.size)%}</span>
        </td>
        <td>
            {% if (file.deleteUrl) { %}
                <button class="btn btn-danger delete" data-type="{%=file.deleteType%}" data-url="{%=file.deleteUrl%}"{% if (file.deleteWithCredentials) { %} data-xhr-fields='{"withCredentials":true}'{% } %}>
                    <i class="glyphicon glyphicon-trash"></i>
                    <span>Delete</span>
                </button>
                <input type="checkbox" name="delete" value="1" class="toggle">
            {% } else { %}
                <button name="cancelBtn" class="btn btn-warning cancel">
                    <i class="glyphicon glyphicon-ban-circle"></i>
                    <span>Cancel</span>
                </button>
            {% } %}
        </td>
    </tr>
{% } %}
</script>
<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
<script src="${ (project.staticDomain)! }/libs/jquery/jquery-migrate-1.2.1.min.js"></script>
<script src="${ (project.staticDomain)! }/libs/bootstrap-multiselect/bootstrap-multiselect.js"></script>
<!-- The jQuery UI widget factory, can be omitted if jQuery UI is already included -->
<script src="${ (project.staticDomain)! }/libs/jqueryFileUpload/js/vendor/jquery.ui.widget.js"></script>
<!-- The Templates plugin is included to render the upload/download listings -->
<script src="${ (project.staticDomain)! }/libs/jqueryFileUpload/js/tmpl.min.js"></script>
<!-- The Load Image plugin is included for the preview images and image resizing functionality -->
<script src="${ (project.staticDomain)! }/libs/jqueryFileUpload/js/load-image.all.min.js"></script>
<!-- The Canvas to Blob plugin is included for image resizing functionality -->
<script src="${ (project.staticDomain)! }/libs/jqueryFileUpload/js/canvas-to-blob.min.js"></script>
<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
<script src="${ (project.staticDomain)! }/libs/bootstrap/js/bootstrap.js"></script>
<!-- blueimp Gallery script -->
<script src="${ (project.staticDomain)! }/libs/jqueryFileUpload/js/jquery.blueimp-gallery.min.js"></script>
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
<!-- The File Upload user interface plugin -->
<script src="${ (project.staticDomain)! }/libs/jqueryFileUpload/js/jquery.fileupload-ui.js"></script>
<script src="${ (project.staticDomain)! }/libs/jqueryFileUpload/js/cors/jquery.xdr-transport.js"></script>

<script src="${ (project.staticDomain)! }/libs/jquery-form/jquery-form-20131225.min.js"></script>
<script src="${ (project.staticDomain)! }/libs/Zebra_Dialog/js/zebra_dialog.js"></script>
<script src="${ (project.staticDomain)! }/js/activity/articles.js"></script> 
