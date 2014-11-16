      <style>
      	body{
      		padding-top:50px;
      	}
      	.carousel{
      		height:400px;
      		background-color:#000;
      	}
      	.carousel .item{
      		height:400px;
      		background-color:#000;
      	}
      	.carousel img{
      		width:100%;
      	}
      	.btn-outline{
      		border-color:#563d7c;
      		background-color:transparent;
      		color:#563d7c;
      	}
      	.summary {
      		padding:15px 15px 15px 15px;

      	}

      </style>
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
  						<button type="button" class="btn btn-default btn-lg btn-outline" >点我下载</button>
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
  		
  		<script type="text/javascript">
			requirejs( ["${ (project.staticDomain)! }/js/login/login.js"] );
		</script>