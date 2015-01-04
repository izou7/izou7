  <style>
  	#tagsDiv button{
  	  margin:5px;
  	}
  </style>
  <!-- 主要内容 -->
  <div class="container content">
  <!--页头-->
    <div class="page-header">
		<h1>${(public.publicName)!}</h1>
	</div>

	<div class="panel-body">
		<table id="infoTable" class="table">
			<tr>
				<td>微信ID:</td>
				<td>${(public.wechatId)!}</td>
			</tr>
			<tr>
				<td>公司:</td>
				<td>${(public.company)!}</td>
			</tr>
			<tr>
				<td>微博:</td>
				<td>${(public.weibo)!}</td>
			</tr>
			<tr>
				<td>网址:</td>
				<td>${(public.website)!}</td>
			</tr>
			<tr>
				<td>合作需求:</td>
				<td>${(public.description)!}</td>
			</tr>
			<tr>
				<td>标签:</td>
				<td>${(public.tags)!}</td>
			</tr>
		</table>
	</div>

  </div>
  
  
<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
<script src="${ (project.staticDomain)! }/libs/bootstrap/js/bootstrap.js"></script> 
<script src="${ (project.staticDomain)! }/libs/Zebra_Dialog/js/zebra_dialog.js"></script>
<script src="${ (project.staticDomain)! }/libs/My97DatePicker/WdatePicker.js"></script> 
<script src="${ (project.staticDomain)! }/js/common.js"></script>
<script src="${ (project.staticDomain)! }/js/public/list.js"></script> 
<script type="text/javascript">
	
</script>
