  <style>
  	#tagsDiv button{
  	  margin:5px;
  	}
  
  </style>
  <!-- Generic page styles -->
<link rel="stylesheet" href="${ (project.staticDomain)! }/libs/jqueryFileUpload/css/style.css">
<!--
<link rel="stylesheet" href="http://blueimp.github.io/Gallery/css/blueimp-gallery.min.css">
-->
<link rel="stylesheet" href="${ (project.staticDomain)! }/libs/jqueryFileUpload/css/jquery.fileupload.css">
<link rel="stylesheet" href="${ (project.staticDomain)! }/libs/jqueryFileUpload/css/jquery.fileupload-ui.css">
<noscript><link rel="stylesheet" href="${ (project.staticDomain)! }/libs/jqueryFileUpload/css/jquery.fileupload-noscript.css"></noscript>
<noscript><link rel="stylesheet" href="${ (project.staticDomain)! }/libs/jqueryFileUpload/css/jquery.fileupload-ui-noscript.css"></noscript>
  <!-- 主要内容 -->

  <div class="container content">
  <!--页头-->
    <div class="page-header">
		<h1>添加场地</h1>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
		<h3 class="panel-title">基本信息</h3>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" role="form" id="fileupload" action="add" method="POST" enctype="multipart/form-data">
			<input type="hidden" id="id" name="id" value="${ (activity.id)! }">
			  <div class="form-group">
				<label class="col-sm-2 control-label">标签：</label>
				<div id="tagsDiv" class="col-sm-6">
				<#list tags as tag>
				<button type="button" class="btn btn-sm btn-info" value="${(tag.name)!}">${(tag.name)!}</button>
				</#list>
				</div>
				<input type="hidden" id="tags" name="tags" value="${(site.tags)!}" >
				<div id="tagsError" class="col-sm-4">
				</div>
			  </div>
			  <div class="form-group" >
				<label class="col-sm-2 control-label" for="name">名称：</label>
				<div class="col-sm-6">
				  <input class="form-control" type="text" id="name" name="name" placeholder="名称" value="${(site.name)!}" required>
				</div>
			  </div>
			  
			   <div class="form-group">
				<label class="col-lg-2 control-label" for="place">地址：</label>
				<div class="col-lg-2">
				<input class="form-control" type="text" id="address" name="address" placeholder="地址" value="${(site.address)!}" required>
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="place"></label>
				<div class="col-sm-6">
				  <input class="form-control" type="text" name="introduction"  id="introduction" placeholder="简介" value="${(site.introduction)!}" required>
				</div>
			  </div>		
			   		        <!-- Redirect browsers with JavaScript disabled to the origin page -->
		        <noscript><input type="hidden" name="redirect" value="https://blueimp.github.io/jQuery-File-Upload/"></noscript>
		        <div class="form-group">
		        	<label class="col-lg-2 control-label" for="poster">上传海报：</label>
			        <!-- The fileupload-buttonbar contains buttons to add/delete files and start/cancel the upload -->
			        <div class="row fileupload-buttonbar col-lg-6">
			            <div class="col-lg-6">
			                <!-- The fileinput-button span is used to style the file input field as button -->
			                <span class="btn btn-success fileinput-button">
			                    <i class="glyphicon glyphicon-plus"></i>
			                    <span>上传海报</span>
			                    <input type="file" name="files[]" multiple>
			                </span>
			            </div>
			        </div>
			        <input type="hidden" id="posterUrl" name="posterUrl" value="${(activity.posterUrl)!}">
			</div>
	        <div class="form-group">
				<label class="col-lg-2 control-label" ></label>
				<div class="col-lg-6">
				  <!-- The table listing the files available for upload/download -->
	        		<table role="presentation" class="table table-striped"><tbody class="files"></tbody></table>
				</div>
		  	</div>
				  	
			 <div class="form-group">
				<div class="col-lg-4">
				 
				</div>
				<div class="col-lg-2">
				  <button  id="saveBtn" type="button" class="btn btn-info btn-block" >保存</button>
				</div>
			 </div>
			</form>
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
            <p class="size">Processing...</p>
            <div class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0"><div class="progress-bar progress-bar-success" style="width:0%;"></div></div>
        </td>
        <td>
            {% if (!i && !o.options.autoUpload) { %}
                <button class="btn btn-primary start" disabled>
                    <i class="glyphicon glyphicon-upload"></i>
                    <span>Start</span>
                </button>
            {% } %}
            {% if (!i) { %}
                <button class="btn btn-warning cancel">
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
                {% if (file.url) { $("#posterUrl").val(file.url);%}
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
                <button class="btn btn-warning cancel">
                    <i class="glyphicon glyphicon-ban-circle"></i>
                    <span>Cancel</span>
                </button>
            {% } %}
        </td>
    </tr>
{% } %}
</script>
<script>
var tags = "${(site.tags)!}";
</script>
<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
<script src="${ (project.staticDomain)! }/libs/jquery/jquery-migrate-1.2.1.min.js"></script>
<!--
<script src="${ (project.staticDomain)! }/libs/sidr-package-1.2.1/jquery.sidr.min.js"></script>
-->
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

<script src="${ (project.staticDomain)! }/libs/jquery-form/jquery.form.js"></script>
<script src="${ (project.staticDomain)! }/libs/Zebra_Dialog/js/zebra_dialog.js"></script>
<script src="${ (project.staticDomain)! }/js/common.js"></script>
