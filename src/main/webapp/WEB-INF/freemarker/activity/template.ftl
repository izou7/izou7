  <style>
  	.selectedTemplate{
  	border:5px solid #428bca;
  	}
  </style>
  <link rel="stylesheet" href="${ (project.staticDomain)! }/libs/FixedNavigationTutorial/css/style.css">
  <!-- Generic page styles -->
  <ul id="navigation" >
    <li ><a href="activity?step=FIRST&activityId=${ id! }" title="基本信息"><h4>基本信息</h4></a></li>
    <li ><a href="activity?step=SECOND&activityId=${ id! }" title="文章列表"><h4>文章列表</h4></a></li>
    <li ><a href="activity?step=THIRD&activityId=${ id! }" title="日历"><h4>日历</h4></a></li>
    <li ><a href="activity?step=FOURTH&activityId=${ id! }" title="报名模板"><h4>报名模板</h4></a></li>
    <li ><a href="activity?step=FIFTH&activityId=${id! }" title="票务信息"><h4>票务信息</h4></a></li>
    <li ><a href="activity?step=SIXTH&activityId=${id! }" title="嘉宾列表"><h4>嘉宾列表</h4></a></li>
    <!--
    <li ><a href="activity?step=SEVENTH&activityId=${ id! }" title="开放合作">开放合作</a></li>
    -->
</ul>
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
				<div class="col-lg-8">
				 
				</div>
				<!--
				<div class="col-lg-2">
				  <button type="button" class="btn btn-info btn-block" onclick="javascript:location.href='activity?step=THIRD&activityId=${id!}';">上一步</button>
				</div>
				-->
				<div class="col-lg-2">
				  <button type="button" id="saveBtn" class="btn btn-info btn-block" >保存</button>
				</div>
				<div class="col-lg-2">
				  <button type="button" id="deployBtn" class="btn btn-info btn-block" >发布</button>
				</div>
				<!--
				<div class="col-lg-2">
				  <button type="button" id="nextBtn" class="btn btn-info btn-block" >下一步</button>
				</div>
				-->
			 </div>
		</div>			
	</div>
  </div>

<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
  <script src="${ (project.staticDomain)! }/libs/bootstrap/js/bootstrap.js"></script>
<script src="${ (project.staticDomain)! }/libs/Zebra_Dialog/js/zebra_dialog.js"></script>
<script src="${ (project.staticDomain)! }/js/activity/template.js"></script> 



