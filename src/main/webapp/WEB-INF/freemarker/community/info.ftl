<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
</style>
</head>
<body>
	<div class="cjsq_w">
		<div class="inner">
			<div class="hd">
				<span>创建社区</span>
			</div>
			<input type="hidden" id="id" name="id" value="${ (com.id)! }">
			<div class="bd">
				<form>
					<dl>
						<dt>社区信息</dt>
						<dd>
							<a class="tag" href="/community/addPage" value="众创空间">众创空间</a>&nbsp;&nbsp;<a class="tag" href="#" value="品牌社群">品牌社群</a>
							<input type="hidden" id="tags" name="tags" value="${(com.tags)!}">
						</dd>
						<dd>
							<input name="name"  id="name" type="text" class="text" placeholder="社区名称" value="${(com.name)!}">
						</dd>
						<dd>
						<select id="province" name="province" >
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
					</dl>
					<dl>
						<dt>社区运营机构联系信息（供TT家族使用）</dt>
						<dd>
							<input id="realName" type="text" class="text" placeholder="联系人" value="${(userInfo.realName)!}">
						</dd>
						<dd>
							<input id="phone" type="text" class="text" placeholder="手机" value="${(userInfo.phone)!}">
						</dd>
						<dd>
							<input id="publicNumber" type="text" class="text" placeholder="微信公众号"  value="${(com.publicNumber)!}">
						</dd>
					</dl>
					<div class="btn_box" >
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
<div id="infoBox" class="pop_box pop_edit pop_edit_name">
		<div class="hd">
			<span class="tit" id="title">信息提示</span>
		</div>
		<div class="bd">
			<div class="clearfix">
				<label id="message"></label>
			</div>
		</div>
		<div class="ft">
			<a id="deleteBtn" href="javascript:hideMessage();" class="sure_btn">确认</a>
		</div>
	</div>	
<div class="mask"></div>
<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
<script src="${ (project.staticDomain)! }/js/common.js"></script>
<script src="${ (project.staticDomain)! }/js/community/info.js"></script>