  <style>
  	#tagsDiv button{
  	  margin:5px;
  	}
  </style>
  <!-- 主要内容 -->
  <div class="container content">
  <!--页头-->
    <div class="page-header">
		<h1>我录入的合作信息</h1>
	</div>

	<div class="panel-body">
		<form id="deletes" action="deletes" method="post">
			<table class="table table-hover table-bordered text-center" id="list-searched">
				<thead>
				<tr>
					<th class="text-center" style="width:80px">微信ID</th>
					<th class="text-center" style="width:80px">公众号名称</th>
					<th class="text-center" style="width:80px">公众号标签</th>
					<th class="text-center" style="width:130px">描述信息</th>
					<th class="text-center" style="width:50px">是否创建者</th>
					<th class="text-center" style="width:110px">操作</th>
				</tr>
				<#list publicList as public>
					<tr>
						<td style="width:80px">${(public.wechatId)!}</td>
						<td style="width:80px">${(public.publicName)!}</td>
						<td style="width:130px">${(public.tags)!}</td>
						<td style="width:80px">${(public.description)!}</td>
						<td style="width:50px">
							<#if (public.mine==false)>否
							<#else> 是
							</#if>
						</td>
						<td style="width:110px"><input type='button' class="btn btn-info"  name='browse' value='浏览' data='${(public.id)!}'/>
						<input type='button' class="btn btn-info margin-left20"  name='delete' value='删除' data='${(public.id)!}'/></td>
					</tr>
				</#list>	
				</thead>
			</table>
		</form>
		
		<!--<div class="table-header">
			<div class="display-inline-block pull-right margin-left10">
				<form class="form-inline pagination-form" role="form" action="list" method="get" id="paging-form" data-total-page="${(page.count)!}">
					<div class="form-group">
						<input type="hidden" value="${ (page.count)! }" id="hiddenCount">
						<input type="hidden" name="name" id="name" value="${name!}"/>
						<input type="text" style="width:40px" class="form-control width50 page-index" id="page-index" name="index"/>
					</div>
					<button type="submit" class="btn btn-primary">跳到此页</button>
				</form>
			</div>
			<div class="display-inline-block pull-right margin-left10">
				<ul class="pagination margin0 vertical-middle" data-target="#paging-form">
					<li><a href="#" class="prev">&laquo;</a></li>
		<#assign startIndex = 0>
		<#assign endIndex = (page.count-1)!0>
		<#if startIndex lt (page.index - 2)!0>
			<#assign startIndex = page.index-2>
		</#if>
		<#if endIndex gt (startIndex + 4)!0>
			<#assign endIndex = startIndex + 4>
		</#if>
		<#if (endIndex - 4) gt -1>
			<#assign startIndex = endIndex - 4>
		</#if>
		<#list startIndex..endIndex as index>
					<li <#if index == (page.index)!0>class="active"</#if>><a href="#">${(index+1)!}</a></li>
		</#list>
					<li><a href="#" class="next">&raquo;</a></li>
				</ul>
			</div>
		</div>
		<form id="deletes" action="deletes" method="post">
			<table class="table table-hover table-bordered text-center" id="list-searched">
				<thead>
				<tr>
					<th class="text-center" style="width:80px">微信ID</th>
					<th class="text-center" style="width:80px">公众号名称</th>
					<th class="text-center" style="width:80px">公众号标签</th>
					<th class="text-center" style="width:130px">描述信息</th>
					<th class="text-center" style="width:50px">是否创建者</th>
					<th class="text-center" style="width:110px">操作</th>
				</tr>
				</thead>
				<tbody>
			<#list publicList as public>
				<tr>
					<td style="width:80px">${(public.wechatId)!}</td>
						<td style="width:80px">${(public.publicName)!}</td>
						<td style="width:130px">${(public.tags)!}</td>
						<td style="width:80px">${(public.description)!}</td>
						<td style="width:50px">
							<#if (public.mine==false)>否
							<#else> 是
							</#if>
						</td>
						<td style="width:110px"><input type='button' class="btn btn-info" id='browse' name='browse' value='浏览'/>
								<input type='button' class="btn btn-info margin-left20" id='delete' name='delete' value='删除'/>
						</td>
				</tr>
			</#list>
				</tbody>
			</table>
		</form>-->
		
	</div>

  </div>
  
  
<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
<script src="${ (project.staticDomain)! }/libs/bootstrap/js/bootstrap.js"></script> 
<script src="${ (project.staticDomain)! }/libs/Zebra_Dialog/js/zebra_dialog.js"></script>
<script src="${ (project.staticDomain)! }/js/common.js"></script>
<script src="${ (project.staticDomain)! }/js/public/list.js"></script> 
<script type="text/javascript">
	
</script>
