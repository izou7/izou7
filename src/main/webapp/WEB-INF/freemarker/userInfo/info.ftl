  <style>
  	#tagsDiv button{
  	  margin:5px;
  	}
  </style>
  <!-- 主要内容 -->
  <div class="container content">
  <!--页头-->
    <div class="page-header">
		<h1>个人资料</h1>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
		<h3 class="panel-title">基本信息</h3>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" role="form">
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="name">真实姓名：</label>
				<div class="col-sm-6">
					<input class="form-control" type="text" id="realName" placeholder="真实姓名" value="${(userInfo.realName)!}">
			  	</div>
			  </div>
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="phone">手机：</label>
				<div class="col-sm-6">
				  <input class="form-control" type="text" id="phone" placeholder="手机号" value="${(userInfo.phone)!}">
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="email">电子邮箱：</label>
				<div class="col-sm-6">
				  <input class="form-control" type="text" id="email" placeholder="电子邮箱" value="${(userInfo.email)!}">
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="qq">qq号：</label>
				<div class="col-sm-6">
				  <input class="form-control" type="text" id="qq" placeholder="qq号" value="${(userInfo.qq)!}">
				</div>
			  </div>
			  
			  <div class="form-group">
				<label class="col-lg-2 control-label" for="time">生日：</label>
				<div class="col-lg-2" >
				  <input class="form-control " type="text" id="birthday" style="width:220px;" placeholder="生日" value="${(userInfo.birthday)!}">
				</div>
			  </div>
			  
			  <div class="form-group">
				<label class="col-lg-2 control-label" for="isPublic">性别：</label>
				<div class="col-lg-10">
					<div class="checkbox">
						<label>
						<#if (userInfo.sex)?? && (userInfo.sex) == true >
						  <input type="radio" name="sex" checked="checked" value="true"> 男
						<#else>
						  <input type="radio" name="sex" value="true"> 男
						</#if>
						</label>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<#if (userInfo.sex)?? && (userInfo.sex) == false >
						  <input type="radio" name="sex" checked="checked" value="false"> 女
						<#else>
						  <input type="radio" name="sex" value="false"> 女
						</#if>
					</div>
				</div>
			 </div>
			  
			  <div class="form-group">
				<label class="col-lg-2 control-label" for="site">所在城市：</label>
				<div class="col-lg-2">
				  <select id="province" name="province" class="form-control" >
				  <option value="0">请选择</option>
				  <#list provinces! as province>
				  		<#if (userInfo.city.province.name)! == province.name >
				  			<option value="${(province.id)!}" selected> ${(province.name)!} </option>
				  		<#else>
				  			<option value="${(province.id)!}" > ${(province.name)!} </option>
				  		</#if>
				  </#list>
				  </select>
				</div>
				<div class="col-lg-2">
				  <select id="city" name="city" class="form-control" >
					<option value="${(userInfo.city.id)!}">${(userInfo.city.city)!}</option>
				  </select>
				</div>
			  </div>
			  
			  <!--
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="interestField">感兴趣的领域：</label>
				<div id="tagsDiv" class="col-sm-6">
					<button type="button" class="btn btn-sm btn-info">原创设计</button>
					<button type="button" class="btn btn-sm btn-info">演唱会</button>
					<button type="button" class="btn btn-sm btn-info">红丝带</button>
					<button type="button" class="btn btn-sm btn-info">扶贫</button>
					<button type="button" class="btn btn-sm btn-info">助学</button>
					<button type="button" class="btn btn-sm btn-info">微电影</button>
					<button type="button" class="btn btn-sm btn-info">生活育儿</button>
					<button type="button" class="btn btn-sm btn-info">论坛</button>
					<button type="button" class="btn btn-sm btn-info">点映</button>
					<button type="button" class="btn btn-sm btn-info">首映</button>
					<button type="button" class="btn btn-sm btn-info">其他</button>
				</div>
			  </div>
			  
			  <div class="form-group">
				<label class="col-sm-2 control-label" for="interestCareer">感兴趣的职业：</label>
				<div id="tagsDiv" class="col-sm-6">
					<button type="button" class="btn btn-sm btn-info">原创设计</button>
					<button type="button" class="btn btn-sm btn-info">演唱会</button>
					<button type="button" class="btn btn-sm btn-info">红丝带</button>
					<button type="button" class="btn btn-sm btn-info">扶贫</button>
					<button type="button" class="btn btn-sm btn-info">助学</button>
					<button type="button" class="btn btn-sm btn-info">微电影</button>
					<button type="button" class="btn btn-sm btn-info">生活育儿</button>
					<button type="button" class="btn btn-sm btn-info">论坛</button>
					<button type="button" class="btn btn-sm btn-info">点映</button>
					<button type="button" class="btn btn-sm btn-info">首映</button>
					<button type="button" class="btn btn-sm btn-info">其他</button>
				</div>
			  </div>
			  -->
			  <div class="form-group">
				<label class="col-lg-2 control-label" for="introduction">个人介绍：</label>
				<div class="col-lg-6">
				  <textarea class="form-control" rows="4" id="introduction" placeholder="个人介绍">${(userInfo.introduction)!}</textarea>
				</div>
			  </div>
			  
			  <div class="form-group">
				<div class="col-lg-6">
				 
				</div>
				<div class="col-lg-2">
				  <button type="button" class="btn btn-info btn-block" id="save">保存</button>
				</div>
			 </div>
			</form>
		</div>
	</div>
  </div>
<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
<script src="${ (project.staticDomain)! }/libs/bootstrap/js/bootstrap.js"></script> 
<script src="${ (project.staticDomain)! }/libs/Zebra_Dialog/js/zebra_dialog.js"></script>
<script src="${ (project.staticDomain)! }/libs/My97DatePicker/WdatePicker.js"></script> 
<script src="${ (project.staticDomain)! }/js/common.js"></script>
<script src="${ (project.staticDomain)! }/js/userInfo/info.js"></script> 
<script type="text/javascript">
	var userInfoId = "${(userInfo.id)!}";
	console.info(userInfoId);
</script>
