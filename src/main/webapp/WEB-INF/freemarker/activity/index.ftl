<link rel="stylesheet" href="${ (project.staticDomain)! }/libs/bootstrap-paginator/bootstrap-combined.min.css">
<link rel="stylesheet" href="${ (project.staticDomain)! }/libs/AmazeUI-2.1.0/css/amazeui.min.css">
<link rel="stylesheet" href="${ (project.staticDomain)! }/libs/AmazeUI-2.1.0/css/app.css">
<link rel="stylesheet" href="${ (project.staticDomain)! }/css/activity/index.css">
<body style="background-color: #f6f6f6">
<div data-am-widget="slider" class="am-slider am-slider-c3" data-am-slider='{&quot;controlNav&quot;:false}'>
  <ul class="am-slides">
    <li>
      <img src="${ (project.staticDomain)! }/images/sunset.jpg">
      <div class="am-slider-desc">
        <div class="am-slider-counter">
          <span class="am-active">1</span>/4</div>各种发现活动 / 最感兴趣的活动 / 最有深度的活动 / 某人也去的活动</div>
    </li>
    <li>
      <img src="${ (project.staticDomain)! }/images/subway.jpg">
      <div class="am-slider-desc">
        <div class="am-slider-counter">
          <span class="am-active">2</span>/4</div>遇见大牛 / 认识同行 / 发起聚会</div>
    </li>
    <li>
      <img src="${ (project.staticDomain)! }/images/shop.jpg">
      <div class="am-slider-desc">
        <div class="am-slider-counter">
          <span class="am-active">3</span>/4</div>各种发现活动 / 最感兴趣的活动 / 最有深度的活动 / 某人也去的活动</div>
    </li>
    <li>
      <img src="${ (project.staticDomain)! }/images/wood.jpg">
      <div class="am-slider-desc">
        <div class="am-slider-counter">
          <span class="am-active">4</span>/4</div>遇见大牛 / 认识同行 / 发起聚会</div>
    </li>
  </ul>
</div>

<div class="container">
	<div data-am-widget="slider" class="am-slider am-slider-b3 recommend" data-am-slider='{&quot;controlNav&quot;:false}'>
	  <ul class="am-slides">
	    <li>
	    <#list activities as activity>
	    	<#if activity_index < 4 >
	    	<div class="thumbnail grid">
		      <a href="/activity/info/1/${(activity.id)!}">
		      	<img src="${(activity.posterUrl)!}" class="img-rounded">
		      </a>
		      <div class="caption title">
		      <h3 >
		      <a href="/activity/info/1/${(activity.id)!}" title="${(activity.name)!}">
		      <#if ((activity.name!?length) > 25)>
		      	${(activity.name?substring(0,25))!}...
		      <#else>
		      	${(activity.name)!}
		      </#if>
		      </a>
		      </h3>
				<p>
					活动时间：${(activity.startTime?string('yyyy-MM-dd HH:mm:ss'))!} 
				</p>
				<p>
					活动地点：
					<#if ((activity.place!?length) > 30)>
			      	${(activity.place?substring(0,30))!}...
			      <#else>
			      	${(activity.place)!}
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
		      <a href="/activity/info/1/${(activity.id)!}" >
		      	<img src="${(activity.posterUrl)!}" class="img-rounded">
		      </a>
		      <div class="caption title">
		      <h3>
		        <a href="/activity/info/1/${(activity.id)!}" title="${(activity.name)!}" >
		      	<#if ((activity.name!?length) > 25)>
		      	${(activity.name?substring(0,25))!}...
		      <#else>
		      	${(activity.name)!}
		      </#if>
		      </a>
		      </h3>
				<p>
					活动时间：${(activity.startTime?string('yyyy-MM-dd HH:mm:ss'))!} 
				</p>
				<p>
					活动地点：
					<#if ((activity.place!?length) > 30)>
			      	${(activity.place?substring(0,30))!}...
			      <#else>
			      	${(activity.place)!}
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
		      <a href="/activity/info/1/${(activity.id)!}" style="height:150px;margin:0px;">
		      	<img src="${(activity.posterUrl)!}" class="img-rounded">
		      </a>
		      <div class="caption title">
		      <h3 >
		       <a href="/activity/info/1/${(activity.id)!}" title="${(activity.name)!}">
		        <#if ((activity.name!?length) > 25)>
		      	${(activity.name?substring(0,25))!}...
		      <#else>
		      	${(activity.name)!}
		      </#if>
		      </a>
		      </h3>
				<p>
					活动时间：${(activity.startTime?string('yyyy-MM-dd HH:mm:ss'))!} 
				</p>
				<p>
					活动地点：
				<#if ((activity.place!?length) > 30)>
			      	${(activity.place?substring(0,30))!}...
			      <#else>
			      	${(activity.place)!}
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


<div id="activities" class="container list" >


</div>
<div class="container">
	<div class="row">
		<div class="modal-footer">
					<div id="paginator" ></div>
				</div>
	</div>
</div>
</body>

<script src="${ (project.staticDomain)! }/libs/jquery/jquery-2.0.3.js"></script>
<script src="${ (project.staticDomain)! }/libs/AmazeUI-2.1.0/js/amazeui.min.js"></script>
<script src="${ (project.staticDomain)! }/libs/bootstrap/js/bootstrap.js"></script>
<script src="${ (project.staticDomain)! }/libs/bootstrap-paginator/bootstrap-paginator.js"></script>
<script src="${ (project.staticDomain)! }/libs/Zebra_Dialog/js/zebra_dialog.js"></script>
<script src="${ (project.staticDomain)! }/js/activity/index.js"></script>
