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
  					<img src="${ (project.staticDomain)! }/images/shop.jpg" alt="" />
  					<div class="carousel-caption">
  						<button type="button" class="btn btn-success btn-lg"    >App下载马上就来</button>
  					</div>
  				</div>
  				<div class="item">
  					<img src="${ (project.staticDomain)! }/images/subway.jpg" alt="" />
  					<div class="carousel-caption"></div>
  				</div>
  				<div class="item">
  					<img src="${ (project.staticDomain)! }/images/sunset.jpg" alt="" />
  					<div class="carousel-caption"></div>
  				</div>
  				<div class="item">
  					<img src="${ (project.staticDomain)! }/images/wood.jpg" alt="" />
  					<div class="carousel-caption"></div>
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
				活动时间：${(activity.startTime?string('yyyy-MM-dd'))!} 到 ${(activity.endTime?string('yyyy-MM-dd'))!} 
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
				活动时间：${(activity.startTime?string('yyyy-MM-dd'))!} 到 ${(activity.endTime?string('yyyy-MM-dd'))!} 
			</p>
	      </div>
	    </div>
	  </div>
	</#list>
	</div>  
</div>
</div>
  		
<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
<script src="${ (project.staticDomain)! }/libs/bootstrap/js/bootstrap.js"></script>