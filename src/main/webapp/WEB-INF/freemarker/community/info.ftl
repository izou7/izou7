<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" href="${ (project.staticDomain)! }/libs/jqueryJcrop/css/jquery.Jcrop.css" type="text/css" />
	<title>社区</title>
<style>
.tag{
	display: inline-block;
	background-color: silver;
	color: #fff;
	border-radius:20px;
	height: 22px;
	line-height: 22px;
	padding: 0 10px;
	margin-bottom: 5px;
}
.tag2{
	display: inline-block;
	background-color: #e62f17;
	color: #fff;
	border-radius:20px;
	height: 22px;
	line-height: 22px;
	padding: 0 10px;
	margin-bottom: 5px;
}
select{
	width: 568px;
	height: 38px;
	line-height: 20px;
	padding: 8px;
	border-radius: 3px;
	border: 1px solid #dcdcdc;
}
.btn_box2{
 text-align:center;
 }
.btn_box2 input{
	width: 253px;
    height: 42px;
    color: #fff;
    border: 0 none;
    margin: 0 auto;
    font-family: "微软雅黑";
    background-color:#e62f17;
    -moz-border-radius: 3px;      /* Gecko browsers */
    -webkit-border-radius: 3px;   /* Webkit browsers */
    border-radius:3px;            /* W3C syntax */
    cursor:pointer;
   
}
</style>
</head>
<body>
	<div class="cjsq_w">
		<div class="inner">
			<div class="hd">
				
				<#if (com.id)??>
						<span>修改空间</span>
					<#else>
						<span>创建空间</span>
					</#if>
			</div>
			<input type="hidden" id="id" name="id" value="${ (com.id)! }">
			<div class="bd">
				<form action="/fileUpload/upload" method="POST" enctype="multipart/form-data" target='frameFile'>
					<dl>
						<dt>空间信息</dt>
						<!--  
						<dd>
							<a class="tag" href="/community/addPage" value="众创空间">众创空间</a>&nbsp;&nbsp;<a class="tag" href="#" value="品牌社群">品牌社群</a>
							<input type="hidden" id="tags" name="tags" value="${(com.tags)!}">
						</dd>
						-->
						<dd>
							<input name="name"  id="name" type="text" class="text" placeholder="社区名称" value="${(com.name)!}">
						</dd>
						<dd>
						<select id="province" name="province" >
						<option>所有</option>
						  <#list provinces! as province>
						  		<#if (com.city.province.name)! == province.name >
						  			<option value="${(province.id)!}" selected>${(province.name)!}</option>
						  		<#else>
						  			<option value="${(province.id)!}">${(province.name)!}</option>
						  		</#if>
						  </#list>
						  </select>
						</dd>
						<dd>
						<select id="city" name="city"  >
						<option>所有</option>
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
						</dd>
						<dd>
						<input name="address"  id="address" type="text" class="text" placeholder="详细地址" value="${(com.address)!}">
						</dd>
						<dd>
						
							<select id="free" >
							<#if (com.id)??>
								<#if (com.price)?? && com.price==0>
									<option selected>免费</option>
									<option>收费</option>
								<#else>
									<option >免费</option>
									<option selected>收费</option>
								</#if>
							<#else>
								<option selected>免费</option>
								<option>收费</option>
							</#if>
							
							
							
							</select>
						</dd>
						<dd>
						<#if (com.id)??>
						<#if (com.price)?? && com.price==0>
								<input name="price"  id="price" type="text" class="text" style="display:none;" placeholder="价格(元)" value="${(com.price)!0}元">
							<#else>
								<input name="price"  id="price" type="text" class="text" placeholder="价格(元)" value="${(com.price)!0}元">
							</#if>
						<#else>
							<input name="price"  id="price" type="text" class="text" style="display:none;" placeholder="价格(元)" value="${(com.price)!0}元">
						</#if>
						</dd>
						<!--
						<dd>
						<input name="poster"  id="poster" type="text" class="text" placeholder="海报地址" value="${(com.poster)!}">
						</dd>
						-->
						<dd>
						<input type="file" name="pic" id="fileInput" value="添加图片" />  
						</dd>
						<dd>
						<#if (com.id)??>
							<img id="posterUrl" src="${(com.poster)!}" style="width:300px;height:180px;">
						<#else>
							<img id="posterUrl" src="${(com.poster)!}" style="width:300px;height:180px;display:none;">
						</#if>
						
						</dd>
						  <!--  
						<dd>
							<input type="file" class="text" value="海报">
						</dd>
						<dd>
							<img src="" style="width:252px;height:149px;"
						</dd>
						-->
						<dd>
							<textarea id="description" placeholder="介绍" >${(com.description)!}</textarea>
						</dd>
						<dd>
							<textarea id="benefits" placeholder="福利" >${(com.benefits)!}</textarea>
						</dd>
					</dl>
					
					<div class="btn_box2" >
					<#if (com.id)??>
						<input id="saveBtn" type="button" value="确认修改">
					<#else>
						<input id="saveBtn" type="button" value="保存">
					</#if>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
<script>
	var tags = "${(com.tags)!}";
</script>
	
<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.min.js"></script>
<script src="${ (project.staticDomain)! }/libs/ajaxfileupload/ajaxfileupload.js"></script>
<script src="${ (project.staticDomain)! }/js/common.js"></script>
<script src="${ (project.staticDomain)! }/js/community/info.js"></script>