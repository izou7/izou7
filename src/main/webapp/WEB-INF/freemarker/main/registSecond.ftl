	<style>
	.sexSpan{
		margin-right:20px;
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
	select{
	width: 568px;
	height: 38px;
	line-height: 20px;
	padding: 8px;
	border-radius: 3px;
	border: 1px solid #dcdcdc;
	margin-bottom:10px
}
	</style>
	<div class="cjsq_w">
		<div class="inner">
			<div class="hd">
				<span>完善个人资料</span>
			</div>
			<div class="bd">
					<dl>
						<dd>
							<input name="name"  id="name" type="text" class="text" placeholder="真实姓名" value="">
						</dd>
						<select id="province" name="province" style="">
						  <#list provinces! as province>
						  		<#if (com.city.province.name)! == province.name >
						  			<option value="${(province.id)!}" selected>${(province.name)!}</option>
						  		<#else>
						  			<option value="${(province.id)!}">${(province.name)!}</option>
						  		</#if>
						  </#list>
						  </select>
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
						<input name="company"  id="company" type="text" class="text" placeholder="公司名称" value="">
						</dd>
						<dd>
						<input name="position"  id="position" type="text" class="text" placeholder="担任职位" value="">
						</dd>
						<dd>
						<input type="radio" name="sex" value="0" checked><span class="sexSpan">男</span>
						<input type="radio" name="sex" value="1"><span class="sexSpan">女</span>
						</dd>
					</dl>
					
					<div class="btn_box2" >
						<input id="saveBtn" type="button" value="进入TT家族">
					</div>
			</div>
		</div>
	</div>

<script>
	var phone = "${(user.phone)!}";
	var password = "${(user.password)!}";
</script>
	
<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.min.js"></script>
<script src="${ (project.staticDomain)! }/js/common.js"></script>
<script src="${ (project.staticDomain)! }/js/main/registSecond.js"></script>
