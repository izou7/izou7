<style>

</style>

<!--
<div class="container margintop40">
	<div class="row">
		<div class="col-sm-offset-2 col-lg-12">
			<form class="form-horizontal" role="form" action="regist" method="POST">
			  <div class="form-group">
			    <label for="username" class="col-sm-2 control-label">用户名：</label>
			    <div class="col-sm-4">
			      <input type="input" name="username" class="form-control"  placeholder="用户名">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="password" class="col-sm-2 control-label">密码：</label>
			    <div class="col-sm-4">
			      <input type="password" class="form-control" name="password"  placeholder="密码">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="password" class="col-sm-2 control-label">再次输入密码：</label>
			    <div class="col-sm-4">
			      <input type="password" class="form-control" name="password2"  placeholder="密码">
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-8">
			      <button type="submit" class="btn btn-info">注册</button><code>${error!}</code>
			    </div>
			  </div>
			</form>
		</div>
	</div>
</div> 
-->
<div class="login_w ">
	<div class="login_wrap reg_wrap">
		<div class="inner">
			<div class="hd clearfix">
				<span class="fl">用户注册</span>
				<a href="login.html" class="fr">我已有账户</a>
			</div>
			<div class="bd">
				<form action="registSecond" method="GET">
					<div class="text ">
						<input type="text" >
						<label>手机号</label>
					</div>
					<div class="text" style="width:150px">
						<input type="text" style="width:130px">
						<label>验证码</label>
					</div>
					<div >
					<button type="button" name="">获取验证码</button>
					</div>
					<div class="text ">
						<input type="text" >
						<label>密码</label>
					</div>
					<div class="text ">
						<input type="text" >
						<label>确认密码</label>
					</div>
					<div class="login_btn">
						<input type='submit' value="">
					</div>
				</form>
			</div>
		</div>
	</div>
</div>


<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
<script src="${ (project.staticDomain)! }/libs/bootstrap/js/bootstrap.js"></script>
<script src="${ (project.staticDomain)! }/libs/jquery-form/jquery.form.js"></script>
<script src="${ (project.staticDomain)! }/js/common.js"></script>
<script src="${ (project.staticDomain)! }/js/main/regist.js"></script>