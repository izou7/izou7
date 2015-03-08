<style>
#tagsDiv button {
	margin: 5px;
}

.start {
	width: 89px;
}

.table-striped>tbody>tr {
	background-color: #FFFFFF !important;
}

.table>tbody>tr>td {
	border-top: none !important;
}
</style>
<!-- 主要内容 -->

<div class="container content">
	<!--页头-->
	<div class="page-header">
		<h1>
		<#if (com.id)??>
			更新社区
		<#else>
			添加社区
		</#if>
		
		</h1>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">基本信息</h3>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" role="form" id="fileupload"
				action="add" method="POST" enctype="multipart/form-data">
				<input type="hidden" id="id" name="id" value="${ (com.id)! }">
				<div class="form-group">
					<label class="col-sm-2 control-label">标签：</label>
					<div id="tagsDiv" class="col-sm-6">
						<#list tags as tag>
						<button type="button" class="btn btn-sm btn-info"
							value="${(tag.name)!}">${(tag.name)!}</button>
						</#list>
					</div>
					<input type="hidden" id="tags" name="tags" value="${(com.tags)!}">
					<div id="tagsError" class="col-sm-4"></div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="name">社区名称：</label>
					<div class="col-sm-6">
						<input class="form-control" type="text" id="name" name="name"
							placeholder="名称" value="${(com.name)!}" required>
					</div>
				</div>
				<div class="form-group">
				<label class="col-lg-2 control-label" for="place">地址：</label>
				<div class="col-lg-2">
				  <select id="province" name="province" class="form-control" >
				  <#list provinces! as province>
				  		<#if (com.city.province.name)! == province.name >
				  			<option value="${(province.id)!}" selected>${(province.name)!}</option>
				  		<#else>
				  			<option value="${(province.id)!}">${(province.name)!}</option>
				  		</#if>
				  </#list>
				  </select>
				</div>
				<div class="col-lg-2">
				  <select id="city" name="city" class="form-control" >
				  <#if (com.city.province.citys)??>
					<#list (com.city.province.citys) as city>
						<#if (com.city.city)! == city.city >
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
					<label class="col-sm-2 control-label" ></label>
					<div class="col-sm-6">
						<input class="form-control" type="text" id="address" name="address"
							placeholder="地址" value="${(com.address)!}" required>
					</div>
				</div>			  
				<div class="form-group">
					<label class="col-sm-2 control-label" for=description>简介：</label>
					<div class="col-sm-6">
						<textarea class="form-control" id="description" rows="5"
							placeholder="简介">${(com.description)!}</textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-6"></div>
					<div class="col-lg-2">
						<button id="saveBtn" type="button" class="btn btn-info btn-block">保存</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<script>
	var tags = "${(com.tags)!}";
</script>
<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
<script
	src="${ (project.staticDomain)! }/libs/jquery/jquery-migrate-1.2.1.min.js"></script>
<script
	src="${ (project.staticDomain)! }/libs/bootstrap/js/bootstrap.js"></script>

<script
	src="${ (project.staticDomain)! }/libs/Zebra_Dialog/js/zebra_dialog.js"></script>
<script src="${ (project.staticDomain)! }/js/common.js"></script>
<script src="${ (project.staticDomain)! }/js/community/info.js"></script>
