  <!-- Generic page styles -->
  <!-- 主要内容 -->
  <div class="container content">
  <!--页头-->
    <div class="page-header">
		<h1>恭喜您已发布成功！</h1>
	</div>
	<div class="row">
	  <div class="col-md-4">
	  	<input id="url" class="form-control" type="text" value="${(url)!}" >
	  </div>
	  <div class="col-md-2">
	  	 <button type="button" id="copyUrlBtn" class="btn btn-info btn-block" >复制网页地址</button>
	  </div>
	  <div class="col-md-2">
	  	<button type="button" id="seeBtn" class="btn btn-info btn-block" >去看看</button>
	  </div>
	</div>
	<BR>
	<div class="row">
	  <div class="col-md-4">
	  	<textarea id="contentText" class="form-control" rows="8"  >${content!}</textarea>
	  </div>
	  <div class="col-md-2">
	  	 <button type="button" id="copyFormBtn" class="btn btn-info btn-block" >复制报名表单</button>
	  </div>
	  <div class="col-md-2">
	  </div>
	</div>
  </div>

<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
<script src="${ (project.staticDomain)! }/libs/bootstrap/js/bootstrap.js"></script>
<script src="${ (project.staticDomain)! }/js/activity/success.js"></script> 



