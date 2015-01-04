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
<link rel="stylesheet" href="${ (project.staticDomain)! }/libs/FixedNavigationTutorial/css/style.css">
<link rel="stylesheet" href="${ (project.staticDomain)! }/libs/umeditor/themes/default/css/umeditor.css">
<noscript><link rel="stylesheet" href="${ (project.staticDomain)! }/libs/jqueryFileUpload/css/jquery.fileupload-noscript.css"></noscript>
<noscript><link rel="stylesheet" href="${ (project.staticDomain)! }/libs/jqueryFileUpload/css/jquery.fileupload-ui-noscript.css"></noscript>
  <!-- 主要内容 -->
<ul id="navigation" style="position:absolute;top:20%;" >
    <li ><a href="activity?step=FIRST&activityId=${ (activity.id)! }" title="活动基本信息">活动基本信息</a></li>
    <li ><a href="activity?step=SECOND&activityId=${ (activity.id)! }" title="文章列表">文章列表</a></li>
    <li ><a href="activity?step=THIRD&activityId=${ (activity.id)! }" title="日历">日历</a></li>
    <li ><a href="activity?step=FOURTH&activityId=${ (activity.id)! }" title="报名模板">报名模板</a></li>
    <li ><a href="activity?step=FIFTH&activityId=${ (activity.id)! }" title="票务信息">票务信息</a></li>
    <li ><a href="activity?step=SIXTH&activityId=${ (activity.id)! }" title="嘉宾列表">嘉宾列表</a></li>
    <!--
    <li ><a href="activity?step=SEVENTH&activityId=${ (activity.id)! }" title="开放合作">开放合作</a></li>
    -->
</ul>
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
			<form class="form-horizontal" role="form" id="fileupload" action="add" method="POST" enctype="multipart/form-data">
			<input type="hidden" id="id" name="id" value="${ (activity.id)! }">
			  <div class="form-group">
				<label class="col-sm-2 control-label">标签：</label>
				<div id="tagsDiv" class="col-sm-6">
					<button type="button" class="btn btn-sm btn-info" value="原创设计">原创设计</button>
					<button type="button" class="btn btn-sm btn-info" value="演唱会">演唱会</button>
					<button type="button" class="btn btn-sm btn-info" value="红丝带">红丝带</button>
					<button type="button" class="btn btn-sm btn-info" value="扶贫">扶贫</button>
					<button type="button" class="btn btn-sm btn-info" value="助学">助学</button>
					<button type="button" class="btn btn-sm btn-info" value="微电影">微电影</button>
					<button type="button" class="btn btn-sm btn-info" value="生活育儿">生活育儿</button>
					<button type="button" class="btn btn-sm btn-info" value="论坛">论坛</button>
					<button type="button" class="btn btn-sm btn-info" value="点映">点映</button>
					<button type="button" class="btn btn-sm btn-info" value="首映">首映</button>
					<button type="button" class="btn btn-sm btn-info" value="其他">其他</button>
				</div>
				<input type="hidden" id="tags" name="tags" value="${(activity.tags)!}" >
				<div id="tagsError" class="col-sm-4">
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="name">活动名称：</label>
				<div class="col-sm-6">
				  <input class="form-control" type="text" id="name" name="name" placeholder="活动名称" value="${(activity.name)!}" required>
				</div>
			  </div>
			   <div class="form-group">
				<label class="col-lg-2 control-label" for="place">活动地点：</label>
				<div class="col-lg-2">
				  <select id="province" name="province" class="form-control" >
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
				  <#if (activity.city.province.citys)??>
					<#list (activity.city.province.citys) as city>
						<#if (activity.city.city)! == city.city >
				  			<option value="${(city.id)!}" selected>${(city.city)!}</option>
				  		<#else>
				  			<option value="${(city.id)!}">${(city.city)!}</option>
				  		</#if> 
					</#list>
					<#else>
						<option value="51">北京市</option>
					</#if>
				  </select>
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="place"></label>
				<div class="col-sm-6">
				  <input class="form-control" type="text" name="place"  id="place" placeholder="详细地址" value="${(activity.place)!}" required>
				</div>
			  </div>		
			  <div class="form-group">
				<label class="col-lg-2 control-label" for="time">活动时间：</label>
				<div class="col-lg-2" >
				  <input class="form-control " type="text" name="startTime" id="startTime" style="width:220px;"  value="${(activity.startTime?string('yyyy-MM-dd HH:mm:ss'))!}" required>
				</div>
				<span class="col-lg-2 text-center" >到</span>
				<div class="col-lg-2">
				  <input class="form-control" type="text" id="endTime" name="endTime" value="${(activity.endTime?string('yyyy-MM-dd HH:mm:ss'))!}" style="width:220px;margin-left:-63px;" required>
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-lg-2 control-label" for="headCount">活动人数：</label>
				<div class="col-lg-6">
				  <input class="form-control" type="text" name="headCount" id="headCount" placeholder="活动人数"  value="${(activity.headCount)!0}" >
				</div>
			  </div>
			  
			  <div class="form-group">
				<label class="col-lg-2 control-label" for="introduction">活动介绍：</label>
				<div class="col-lg-6">
				  <input type="hidden" class="form-control" id="introduction" name="introduction" value="活动介绍。。。" ></textarea>
				  <script id="editor" type="text/plain" style="width:900px;height:300px;">
				  <#if (activity.introduction)?? >
				  	${(activity.introduction)!"<p>活动介绍。。。</p>"}
				  <#else>
				  <p>活动介绍。。。</p>
				  </#if>
				  
				  </script>
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
				<label class="col-lg-2 control-label" for="opened">是否公开：</label>
				<div class="col-lg-10">
					<div class="checkbox">
					<#if  (activity.opened)?? && (activity.opened)! == false>
						<label>
						  <input type="radio" name="opened" value="true" > 是
						</label>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<label>
						  <input type="radio" name="opened" value="false" checked> 否
						</label>					
					<#else>
						<label>
						  <input type="radio" name="opened" value="true" checked> 是
						</label>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<label>
						  <input type="radio" name="opened" value="false"> 否
						</label>					
					</#if>
					</div>
					
				</div>
			 </div>	
			 <div class="form-group">
				<label class="col-lg-2 control-label" for="homepage">活动主页地址：</label>
				<div class="col-lg-6">
				  <input class="form-control" type="text" id="homepage" name="homepage"  placeholder="活动主页地址" value="${(activity.homepage)!}" >
				</div>
			 </div>	
			 <div class="form-group">
				<div class="col-lg-4">
				 
				</div>
				<div class="col-lg-2">
				  <button  id="saveBtn" type="button" class="btn btn-info btn-block" >保存</button>
				</div>
				<div class="col-lg-2">
				  <button  id="deployBtn" type="button" class="btn btn-info btn-block" >发布</button>
				</div>
				<!--
				<div class="col-lg-2">
				  <button  id="nextBtn" type="button" class="btn btn-info btn-block" >下一步</button>
				</div>
				-->
			 </div>
			 <input type="hidden" id="type" name="type" value="NEXT"/>
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
var tags = "${(activity.tags)!}";
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
<script src="${ (project.staticDomain)! }/libs/My97DatePicker/WdatePicker.js"></script>
<script src="${ (project.staticDomain)! }/libs/umeditor/umeditor.config.js"></script>
<script src="${ (project.staticDomain)! }/libs/umeditor/umeditor.min.js"></script>
<script src="${ (project.staticDomain)! }/libs/umeditor/lang/zh-cn/zh-cn.js"></script>
<script src="${ (project.staticDomain)! }/js/activity/activity.js"></script> 