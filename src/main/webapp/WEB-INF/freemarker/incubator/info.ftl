<link rel="stylesheet" href="${ (project.staticDomain)! }/libs/AmazeUI-2.1.0/css/amazeui.min.css">
<link rel="stylesheet" href="${ (project.staticDomain)! }/libs/AmazeUI-2.1.0/css/app.css">
<link rel="stylesheet" href="${ (project.staticDomain)! }/css/incubator/info.css">
<div  class="container" >
	<div class="row littlePoster" >
		<div class="col-sm-2">
			<img src="${(incubator.littlePosterUrl)!}">
		</div>
		<div class="col-sm-10">
			<h3>${(incubator.name)!}</h3>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<p>${(incubator.detailedIntroduction)!}</p>
		</div>
	</div>
	<div class="row bigPoster">
		<img src="${(incubator.bigPosterUrl)!}">
	</div>
	<div class="row">
		<div class="col-sm-6">
			<p>地址:${(incubator.address)!}</p>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div data-am-widget="map" class="am-map am-map-default" data-name="云适配"
			data-address="${(incubator.address)!}" data-longitude="" data-latitude=""
			data-scaleControl="" data-zoomControl="true" data-setZoom="17" data-icon="http://amuituku.qiniudn.com/mapicon.png">
		  <div id="bd-map"></div>
		</div>
		</div>
	</div>
</div>


<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
<script src="${ (project.staticDomain)! }/libs/AmazeUI-2.1.0/js/amazeui.min.js"></script>
<script src="${ (project.staticDomain)! }/libs/bootstrap/js/bootstrap.js"></script>
<script src="${ (project.staticDomain)! }/libs/bootstrap-paginator/bootstrap-paginator.js"></script>

