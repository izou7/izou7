<link rel="stylesheet" href="${ (project.staticDomain)! }/libs/AmazeUI-2.1.0/css/amazeui.min.css">
<link rel="stylesheet" href="${ (project.staticDomain)! }/libs/AmazeUI-2.1.0/css/app.css">
<link rel="stylesheet" href="${ (project.staticDomain)! }/css/main/index.css">
<body style="background-color: #f6f6f6">

<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  			<!-- Indicators -->
  			<ol class="carousel-indicators">
  				<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
  				<li data-target="#carousel-example-generic" data-slide-to="1"></li>
  				<li data-target="#carousel-example-generic" data-slide-to="2"></li>
  				<li data-target="#carousel-example-generic" data-slide-to="3"></li>
  			</ol>
  			<!-- Wrapper for slides -->
  			<div class="carousel-inner">
  				<div class="item active">
  					<img src="${ (project.staticDomain)! }/images/sunset.jpg" alt="" />
  					<div class="carousel-caption" >
  					<!--
  						<button type="button" class="btn btn-success btn-lg"    >App下载马上就来</button>
  						-->
  						<h3>APP下载</h3>
  						<h4>各种发现活动 / 最感兴趣的活动 / 最有深度的活动 / 某人也去的活动</h4>

  					</div>
  					
  				</div>
  				<div class="item">
  					<img src="${ (project.staticDomain)! }/images/subway.jpg" alt="" />
  					<div class="carousel-caption" >
  						<h3>精准连接各种人脉</h3>
  						<h4>遇见大牛 / 认识同行 / 发起聚会</h4>
  					</div>
  				</div>
  				<div class="item">
  					<img src="${ (project.staticDomain)! }/images/shop.jpg" alt="" />
  					<div class="carousel-caption">
  						<h3>APP下载</h3>
  						<h4>各种发现活动 / 最感兴趣的活动 / 最有深度的活动 / 某人也去的活动</h4>
  					</div>
  				</div>
  				<div class="item">
  					<img src="${ (project.staticDomain)! }/images/wood.jpg" alt="" />
  					<div class="carousel-caption">
  						<h3>精准连接各种人脉</h3>
  						<h4>遇见大牛 / 认识同行 / 发起聚会</h4>
  					</div>
  				</div>
  			</div>
  			<!-- Controls -->
  			<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
  				<span class="glyphicon glyphicon-chevron-left"></span>
  			</a> 
  			<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
  				<span class="glyphicon glyphicon-chevron-right"></span>
  			</a>

  		</div>
<div class="container">
	<div data-am-widget="slider" class="am-slider am-slider-b3 recommend" data-am-slider='{&quot;controlNav&quot;:false}'>
	  <ul class="am-slides">
	    <li>
	    <#list activities as activity>
	    	<#if activity_index < 4 >
	    	<div class="thumbnail grid">
		      <a href="/activity/info/1/${(activity.id)!}">
		      	<img src="${(activity.posterUrl)!}">
		      </a>
		      <div class="caption title">
		      <a href="/activity/info/1/${(activity.id)!}" title="${(activity.name)!}">
		      <#if ((activity.name!?length) > 30)>
		      	${(activity.name?substring(0,30))!}
		      <#else>
		      	${(activity.name)!}
		      </#if>
		      </a>
				<p>
					活动时间：${(activity.startTime?string('yyyy-MM-dd HH:mm:ss'))!} 
				</p>
				<p>
					活动地点：
					<#if ((activity.place!?length) > 30)>
			      	${(activity.place?substring(0,30))!}
			      <#else>
			      	${(activity.place)!}...
			      </#if> 
					
				</p>
		      </div>
		    </div>
	    	</#if>
		    </#list>
	    </li>
	    <li>
	    <#list activities as activity>
	    	<#if (activity_index>3) && (activity_index<8) >
	    	<div class="thumbnail grid">
		      <a href="/activity/info/1/${(activity.id)!}">
		      	<img src="${(activity.posterUrl)!}">
		      </a>
		      <div class="caption title">
		        <a href="/activity/info/1/${(activity.id)!}" title="${(activity.name)!}">
		      	<#if ((activity.name!?length) > 30)>
		      	${(activity.name?substring(0,30))!}
		      <#else>
		      	${(activity.name)!}
		      </#if>
		      </a>
				<p>
					活动时间：${(activity.startTime?string('yyyy-MM-dd HH:mm:ss'))!} 
				</p>
				<p>
					活动地点：
					<#if ((activity.place!?length) > 30)>
			      	${(activity.place?substring(0,30))!}
			      <#else>
			      	${(activity.place)!}...
			      </#if>
				</p>
		      </div>
		    </div>
	    	</#if>
		    </#list>
	    </li>
	    <li>
	    <#list activities as activity>
	    	<#if (activity_index > 7) && (activity_index < 12)>
	    	<div class="thumbnail grid">
		      <a href="/activity/info/1/${(activity.id)!}">
		      	<img src="${(activity.posterUrl)!}">
		      </a>
		      <div class="caption title">
		       <a href="/activity/info/1/${(activity.id)!}" title="${(activity.name)!}">
		        <#if ((activity.name!?length) > 30)>
		      	${(activity.name?substring(0,30))!}
		      <#else>
		      	${(activity.name)!}
		      </#if>
		      </a>
				<p>
					活动时间：${(activity.startTime?string('yyyy-MM-dd HH:mm:ss'))!} 
				</p>
				<p>
					活动地点：
				<#if ((activity.place!?length) > 30)>
			      	${(activity.place?substring(0,30))!}
			      <#else>
			      	${(activity.place)!}...
			      </#if>
				</p>
		      </div>
		    </div>
	    	</#if>
		    </#list>
	    </li>
	    
	  </ul>
	</div>
</div>
<div class="container content" >
	<div class="row" style="margin:0;">
	<h3>强力推荐</h3>
	</div>
	<div class="row">
	<#list activities as activity>
	  <div class="col-sm-4">
	    <div class="thumbnail">
	      <a href="/activity/info/1/${(activity.id)!}">
	      	<img src="${(activity.posterUrl)!}" >
	      </a>
	      <div class="caption">
	        <h3>${(activity.name)!}</h3>
			<p>
				活动地点：${(activity.city.province.name)!} ${(activity.city.city)!} ${(activity.place)!} 
			</p>
			<p>
				活动时间：${(activity.startTime?string('yyyy-MM-dd HH:mm:ss'))!} 到 ${(activity.endTime?string('yyyy-MM-dd HH:mm:ss'))!} 
			</p>
	      </div>
	    </div>
	  </div>
	</#list>
	</div>  
	<div class="row" style="margin:0;">
	<h3>即将开始</h3>
	</div>
	<div class="row">
	<#list activities as activity>
	  <div class="col-sm-4">
	    <div class="thumbnail">
	      <a href="/activity/info/1/${(activity.id)!}">
	      	<img src="${(activity.posterUrl)!}" >
	      </a>
	      <div class="caption">
	        <h3>${(activity.name)!}</h3>
			<p>
				活动地点：${(activity.city.province.name)!} ${(activity.city.city)!} ${(activity.place)!} 
			</p>
			<p>
				活动时间：${(activity.startTime?string('yyyy-MM-dd HH:mm:ss'))!} 到 ${(activity.endTime?string('yyyy-MM-dd HH:mm:ss'))!} 
			</p>
	      </div>
	    </div>
	  </div>
	</#list>
	</div>  
</div>
</div>
</body>
<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
<script src="${ (project.staticDomain)! }/libs/AmazeUI-2.1.0/js/amazeui.min.js"></script>
<script src="${ (project.staticDomain)! }/libs/bootstrap/js/bootstrap.js"></script>
