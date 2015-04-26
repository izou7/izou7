<header>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
</header>
<body style="background-color: #f6f6f6">
<div class="container bs-docs-container">
	<div class="row">
		<div class="col-md-9" role="main">
			<div class="bs-docs-section">
			<div class="bs-example" data-example-id="thumbnails-with-custom-content">
			    <div class="row">
			      <div class="col-sm-6 col-md-4">
			        <div class="thumbnail">
			          <img data-src="holder.js/100%x200" alt="100%x200" src="${(act.posterUrl)!}" data-holder-rendered="true" style="height: 200px; width: 100%; display: block;">
			          <div class="caption">
			          <p class="text-uppercase">名称：${(act.name)!}</p>
			          <p class="text-uppercase">标签：${(act.tags)!}</p>
			          <p class="text-uppercase">开始时间：${(act.startTime)!}~${(act.endTime)!}</p>
			          <p class="text-uppercase">地点：${(act.city.city)!}&nbsp;&nbsp;${(act.place)!}</p>
			          <#if act.user??>
			          <p class="text-uppercase">发起人：${(act.user.userInfo.realName)!}</p>
			          </#if>
			          
			          <!--  
			            <h3 id="thumbnail-label">Thumbnail label<a class="anchorjs-link" href="#thumbnail-label"><span class="anchorjs-icon"></span></a></h3>
			            <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
			            <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
			           -->
			          </div>
			        </div>
			      </div>
			    </div>
			  </div>
			</div>
		</div>
	</div>
</div>
</body>