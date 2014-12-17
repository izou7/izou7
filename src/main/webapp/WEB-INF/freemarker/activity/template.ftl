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
		<h3 class="panel-title">选择报名模板</h3>
		<input type="hidden" id="id" name="id" value="${id!}">
		</div>
		<div class="panel-body">
			  <div class="form-group form-group-lg">
				<div class="row">
				<#if (tmp.name)??>
					<#list templates as template>
						 <#if template.name==(tmp.name)!>
							 <div class="col-xs-6 col-md-3">
							    <a href="#" name="template" class="thumbnail selectedTemplate" data_id="${(template.id)!}">
							      <img src="${(template.url)!}" data-src="holder.js/100%x180" alt="${(template.name)!}">
							    </a>
						     </div>
						 <#else>
						 	<div class="col-xs-6 col-md-3">
							    <a href="#" name="template" class="thumbnail" data_id="${(template.id)!}">
							      <img src="${(template.url)!}" data-src="holder.js/100%x180"  alt="${(template.name)!}">
							    </a>
						     </div>
						 </#if>
					 </#list>
				<#else>
					<#list templates as template>
						<#if template_index==0>
							 <div class="col-xs-6 col-md-3">
							    <a href="#" name="template" class="thumbnail selectedTemplate" data_id="${(template.id)!}">
							      <img src="${(template.url)!}" data-src="holder.js/100%x180" alt="${(template.name)!}">
							    </a>
						     </div>
						 <#else>
						 	<div class="col-xs-6 col-md-3">
							    <a href="#" name="template" class="thumbnail" data_id="${(template.id)!}">
							      <img src="${(template.url)!}" data-src="holder.js/100%x180"  alt="${(template.name)!}">
							    </a>
						     </div>
						 </#if>
					 </#list>
				</#if>	 
				</div>
			  </div>
			  <div class="form-group form-group-lg">
				<div class="col-lg-6">
				 
				</div>
				<div class="col-lg-2">
				  <button type="button" class="btn btn-info btn-block" onclick="javascript:location.href='activity?step=THIRD&activityId=${id!}';">上一步</button>
				</div>
				<div class="col-lg-2">
				  <button type="button" id="deployBtn" class="btn btn-info btn-block" >发布</button>
				</div>
				<div class="col-lg-2">
				  <button type="button" id="nextBtn" class="btn btn-info btn-block" >下一步</button>
				</div>
			 </div>
		</div>			
	</div>
  </div>

<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
  <script src="${ (project.staticDomain)! }/libs/bootstrap/js/bootstrap.js"></script>
<script src="${ (project.staticDomain)! }/libs/Zebra_Dialog/js/zebra_dialog.js"></script>
<script src="${ (project.staticDomain)! }/js/activity/template.js"></script> 



