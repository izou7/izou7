  <style>
  	.glyphicon{
  		cursor: pointer;
  	}
  </style>
  <!-- Generic page styles -->
  <!-- 主要内容 -->
  <div class="container content">
  <!--页头-->
    <div class="page-header">
		<h1>我的社区</h1>
	</div>
	<div class="row">
	
	<!-- Tab panes -->
	<div class="tab-content">
	  <div role="tabpanel" class="tab-pane active">
		  <div class="col-lg-12">
			 <div class="table-responsive">
			  <table class="table table-bordered margin-top10" >
				<thead>
				  <tr>
					<th>社区名称</th>
					<th>所属城市</th>
					<th>标签</th>
					<th>简介</th>
					<th>创建时间</th>
					<th>操作</th>
				  </tr>
				</thead>
				<tbody>
				<#list communities as com>
					<tr>
					  <td >${(com.name)!}</td>
					  <td >${(com.city.province.name)!},${(com.city.city)!}</td>
					  <td >${(com.tags)!}</td>
					  <td >
					  <#if com.description?length gt 16 >
					 	 ${(com.description[0..15])!}...
					  <#else>
					  	${(com.description)!}
					  </#if>
					  </td>
					  <td >${(com.createTime)?string("yyyy-MM-dd HH:mm:ss")}</td>
					  <td >
						  <a href="editPage/${(com.id)!}" title="编辑"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
						  &nbsp;&nbsp;
						  <a href="/member/listPage?communityId=${(com.id)!}" title="成员"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></a>
						  &nbsp;&nbsp;
						  <a id="delete" data_id="${(com.id)!}" href="#" title="删除"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
						  &nbsp;&nbsp;
						  <a href="/dynamic/dynamicPage?communityId=${(com.id)!}" title="动态"><span class="glyphicon glyphicon-file" aria-hidden="true"></span></a>
					  </td>
					</tr>
				</#list>
				</tbody>
			  </table>
			</div>
		  </div>
	  </div>
	</div>
	</div>
  </div>

<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
<script src="${ (project.staticDomain)! }/libs/bootstrap/js/bootstrap.js"></script>
<script src="${ (project.staticDomain)! }/libs/Zebra_Dialog/js/zebra_dialog.js"></script>
<script src="${ (project.staticDomain)! }/js/community/list.js"></script>





