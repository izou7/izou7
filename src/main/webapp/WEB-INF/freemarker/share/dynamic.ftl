<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <link rel="stylesheet" href="${ (project.staticDomain)! }/libs/share-dynamic/css/base.css">
    <script src="${ (project.staticDomain)! }/libs/share-dynamic/js/zepto.min.js"></script>
    <title>分享动态</title>
    <style>
    .clear{clear:both;float:none;} 
    </style>
    <script>
    var time = "${(dn.createTime)?long}";
    var timeStr;
      //图片展示处理
         $(function(){
		         $('.list-c .pic-d .bo>div a').each(function(){
		          var la = $(this)
		          var img = $(this).attr('style');
		          img = img.split("(");
		          img = img[1].split(")")
		          var image = new Image();
		      	  image.onload = function(){
		          if(image.width>image.height){
		           la.css("background-size","auto 100%")
		          }
		      }
		      image.src = "http://"+window.location.host+img[0];
		      console.info(image.src);
		      timeStr = long2desc(time);
		      $("#time").html(timeStr);
           })
         });

         function long2desc(time){
         	var now = new Date().getTime();
         	var diff = (now - time)/1000;
         	if(diff<60){
         		return "刚刚";
         	}
         	if(diff<3600){
         		var min = diff/60;
         		return parseInt(min)+"分钟前";
         	}
         	if(diff<3600*24){
         		var hour = diff/3600;
         		return parseInt(hour)+"小时前";
         	}
         	if(diff<3600*48){
         		return "昨天";
         	}else{
         		var day = diff/3600/24;
         		return parseInt(day) + "天前";
         	}
         }
    </script>
<body>
    <div class="layout form app-down">
        <div class="bo">
            <img src="${ (project.staticDomain)! }/libs/share-activity/img/logo-icon.png" alt="" class="pic">
            <div class="flex">
                <p class="name">TT家族-找“有圈子”的创业空间</p>
                <div>
                    <span class="star"><i style="width:80%">★★★★★</i></span>
                    <span class="num">653万人下载</span>
                </div>
            </div>
            <div class="center-b">
                <button class="btn-f">立即下载</button>
            </div>
        </div>
    </div>
    
    <ul class="layout list-c">
      <li class="item-c" data-url="#">
        <div class="bo">
          <img src="${(dn.user.userInfo.headPicture)!}" alt="${(dn.user.userInfo.realName)!}" class="pic">
          <div class="flex">
            <div class="bo">
              <p class="name flex">${(dn.user.userInfo.realName)!}</p>
              <span class="com">${(dn.community.name)!}</span>
            </div>
            <p class="t1">${(dn.user.userInfo.position)!}</p>
            <p class="t1">${(dn.user.userInfo.company)!}</p>
          </div>
        </div>
        <div class="bd">
          <p class="txt-b">${(dn.content)!}</p>
          
            <#if dn.images??>
	            <#assign list=dn.images?split("&&")>
	            	<#if list?size==1>
	            	<div class="pic-d"><p style="background-image:url(${list[0]})" name="picture"></p></div>
	            	<#elseif list?size==2>
	            		<div class="pic-d pic2"><div class="bo"><div class="flex center"><a href="#" style="background-image:url(${list[0]})" name="picture"></a></div>
									<div class="flex center"><a href="#" style="background-image:url(${list[1]})" name="picture"></a></div>
									<div class="flex center"></div>
								</div>
							</div>
	            	<#elseif list?size==3>
	            		<div class="pic-d pic2">
								<div class="bo">
								<div class="flex center"><a href="#" style="background-image:url(${list[0]})" name="picture"></a></div>
									<div class="flex center"><a href="#" style="background-image:url(${list[1]})" name="picture"></a></div>
									<div class="flex center"><a href="#" style="background-image:url(${list[2]})" name="picture"></a></div>
								</div>
							</div>
	            	<#elseif list?size==4>
	            		<div class="pic-d pic4">
								<div class="bo">
								<div class="flex center"><a href="#" style="background-image:url(${list[0]})" name="picture"></a></div>
									<div class="flex center"><a href="#" style="background-image:url(${list[1]})" name="picture"></a></div>
									<div class="flex center"><a href="#" style="background-image:url(${list[2]})" name="picture"></a></div>
								</div>
								<div class="bo">
								<div class="flex center"><a href="#" style="background-image:url(${list[3]})" name="picture"></a></div>
									<div class="flex center"></div>
									<div class="flex center"></div>
								</div>
							</div>
	            	<#elseif list?size==5>
	            		<div class="pic-d pic4">
								<div class="bo">
								<div class="flex center"><a href="#" style="background-image:url(${list[0]})" name="picture"></a></div>
									<div class="flex center"><a href="#" style="background-image:url(${list[1]})" name="picture"></a></div>
									<div class="flex center"><a href="#" style="background-image:url(${list[2]})" name="picture"></a></div>
								</div>
								<div class="bo">
								<div class="flex center"><a href="#" style="background-image:url(${list[3]})" name="picture"></a></div>
									<div class="flex center"><a href="#" style="background-image:url(${list[4]})" name="picture"></a></div>
									<div class="flex center"></div>
								</div>
							</div>
	            	<#elseif list?size==6>
	            		<div class="pic-d pic4">
								<div class="bo">
								<div class="flex center"><a href="#" style="background-image:url(${list[0]})" name="picture"></a></div>
									<div class="flex center"><a href="#" style="background-image:url(${list[1]})" name="picture"></a></div>
									<div class="flex center"><a href="#" style="background-image:url(${list[2]})" name="picture"></a></div>
								</div>
								<div class="bo">
								<div class="flex center"><a href="#" style="background-image:url(${list[3]})" name="picture"></a></div>
									<div class="flex center"><a href="#" style="background-image:url(${list[4]})" name="picture"></a></div>
									<div class="flex center"><a href="#" style="background-image:url(${list[5	]})" name="picture"></a></div>
								</div>
							</div>
	            	</#if>
	            	<!--  
	            	<#if list?size==2>
	            		<div class="pic-d pic2"><div class="bo"><div class="flex center"><a href="#" style="background-image:url('+items[i].imagesUrl[0]+')" name="picture"></a></div>
									<div class="flex center"><a href="#" style="background-image:url('+items[i].imagesUrl[1]+')" name="picture"></a></div>
									<div class="flex center"></div>
								</div>
							</div>
	            	</#if>
	            	<#if list?size==3>
	            		<div class="pic-d pic2">
								<div class="bo">
								<div class="flex center"><a href="#" style="background-image:url('+items[i].imagesUrl[0]+')" name="picture"></a></div>
									<div class="flex center"><a href="#" style="background-image:url('+items[i].imagesUrl[1]+')" name="picture"></a></div>
									<div class="flex center"><a href="#" style="background-image:url('+items[i].imagesUrl[2]+')" name="picture"></a></div>
								</div>
							</div>;
	            	</#if>
	            	<#if list?size==4>
	            	<div class="pic-d pic4">
								<div class="bo">
								<div class="flex center"><a href="#" style="background-image:url('+items[i].imagesUrl[0]+')" name="picture"></a></div>
									<div class="flex center"><a href="#" style="background-image:url('+items[i].imagesUrl[1]+')" name="picture"></a></div>
									<div class="flex center"><a href="#" style="background-image:url('+items[i].imagesUrl[2]+')" name="picture"></a></div>
								</div>
								<div class="bo">
								<div class="flex center"><a href="#" style="background-image:url('+items[i].imagesUrl[3]+')" name="picture"></a></div>
									<div class="flex center"></div>
									<div class="flex center"></div>
								</div>
							</div>
	            	</#if>
	            	<#if list?size==5>
	            	<div class="pic-d pic4">
								<div class="bo">
								<div class="flex center"><a href="#" style="background-image:url('+items[i].imagesUrl[0]+')" name="picture"></a></div>
									<div class="flex center"><a href="#" style="background-image:url('+items[i].imagesUrl[1]+')" name="picture"></a></div>
									<div class="flex center"><a href="#" style="background-image:url('+items[i].imagesUrl[2]+')" name="picture"></a></div>
								</div>
								<div class="bo">
								<div class="flex center"><a href="#" style="background-image:url('+items[i].imagesUrl[3]+')" name="picture"></a></div>
									<div class="flex center"><a href="#" style="background-image:url('+items[i].imagesUrl[4]+')" name="picture"></a></div>
									<div class="flex center"></div>
								</div>
							</div>
	            	</#if>
	            	<#if list?size==6>
	            	<div class="pic-d pic4">
								<div class="bo">
								<div class="flex center"><a href="#" style="background-image:url('+items[i].imagesUrl[0]+')" name="picture"></a></div>
									<div class="flex center"><a href="#" style="background-image:url('+items[i].imagesUrl[1]+')" name="picture"></a></div>
									<div class="flex center"><a href="#" style="background-image:url('+items[i].imagesUrl[2]+')" name="picture"></a></div>
								</div>
								<div class="bo">
								<div class="flex center"><a href="#" style="background-image:url('+items[i].imagesUrl[3]+')" name="picture"></a></div>
									<div class="flex center"><a href="#" style="background-image:url('+items[i].imagesUrl[4]+')" name="picture"></a></div>
									<div class="flex center"><a href="#" style="background-image:url('+items[i].imagesUrl[5]+')" name="picture"></a></div>
								</div>
							</div>
	            	</#if>
	            	-->
	            	
            </#if>
            
        </div>
        <div class="rev-list">
        <#list dn.communityDynamicMessages as ms>
          <p class="item-r"><span class="name">${(ms.user.userInfo.realName)!}</span>回复<span class="name">${(ms.toUser.userInfo.realName)!}</span>：${(ms.content)!}</p>
        </#list>
        <!--  
          <p class="item-r"><span class="name">Kyrios</span>：您好，我收到了接受报名的短信,说有邮件进一步通知详情，但是没有收到。帮忙确认下发了吗？多谢多谢。</p>
          <p class="item-r"><span class="name">张大颖</span>：没问题</p>
          -->
        </div>
      </li>
    </ul>
</body>
</html>