  <style>
  	.glyphicon{
  		cursor: pointer
  	}
  </style>
  <!-- Generic page styles -->
  <!-- 主要内容 -->
  <div class="container content">
  <!--页头-->
    <div class="page-header">
		<h1>${(activity.name)!}</h1>
	</div>
	<div class="jumbotron">
		<div class="row">
			<div class="col-lg-5"><img src="/static/images/Chrysanthemum.jpg" width="100%" height="270"></div>
			<div class="col-lg-7">
			<p>
				标签：${(activity.tags)!}
			</p>
			<p>
				活动地点：${(activity.name)!}
			</p>
			</div>
		</div>
	</div>	
	<div class="jumbotron">
	  <h1>Hello, world!</h1>
	  <p>...</p>
	  <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
	</div>	
	<div class="jumbotron">
	  <h1>Hello, world!</h1>
	  <p>...</p>
	  <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
	</div>	
	<div class="jumbotron">
	  <h1>Hello, world!</h1>
	  <p>...</p>
	  <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
	</div>	
  </div>
  

<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
<script src="${ (project.staticDomain)! }/libs/bootstrap/js/bootstrap.js"></script>
<script src="${ (project.staticDomain)! }/js/activity/info.js"></script> 



