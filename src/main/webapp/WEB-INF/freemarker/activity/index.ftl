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
  						<button type="button" class="btn btn-default btn-lg btn-outline" onclick="javascript:location.href='/activity/activity?step=FIRST'">发布活动</button>
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
  		<!--编辑器-->
  		
  		<!-- 主要内容 -->
  		<div class="container summary">
  			<div class="col-sm-12 text-center" >
  				<h3 style="font-size: 22px;color:#4B535D;margin-bottom:30px;">JOIN OVER <strong>10,000+</strong> COMPANIES AND FREELANCERS</h3>
  			</div>
  			<div class="row">
  				<div class="col-sm-4 text-center" >
  					<p class="lead">Thank you for breaking the mold on time tracking. I’m really impressed. First app I’ve really loved in awhile.</p>
  					<h6>Matt Everson, Astuteo</h6>
  				</div>
  				<div class="col-sm-4 text-center" >
  					<p class="lead">I just started using your application and I just had to write to tell you how great I think it is. Perfect simple interface, easy to navigate, intuitive and reliable.</p>
  					<h6>Matt Everson, Astuteo</h6>
  				</div>
  				<div class="col-sm-4 text-center" >
  					<p class="lead">I’m impressed. You’ve really cracked the code for how a time tracking app should be designed.</p>
  					<h6>Matt Everson, Astuteo</h6>
  				</div>
  			</div>
  		</div>
  		<script type="text/javascript">
			requirejs( ["${ (project.staticDomain)! }/js/activity/index.js"] );
		</script>