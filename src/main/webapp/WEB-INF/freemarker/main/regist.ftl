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
</div> <!-- /container -->


<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
  <script src="${ (project.staticDomain)! }/libs/bootstrap/js/bootstrap.js"></script>
<script src="${ (project.staticDomain)! }/libs/jquery-form/jquery.form.js"></script>
<script src="${ (project.staticDomain)! }/js/activity/regist.js"></script>