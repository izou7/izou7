<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <link rel="stylesheet" href="${ (project.staticDomain)! }/libs/share-dynamic/css/base.css">
    <title>分享活动</title>
<body>
    <div class="layout form app-down">
        <div class="bo">
            <img src="${ (project.staticDomain)! }/libs/share-dynamic/img/logo-icon.png" alt="" class="pic">
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
    <div class="doing">
      <ul class="layout list-c">
         <#if act??>
	    	<#if act.user??>
	    	<li class="item-c bo" data-url="#">
          <div>
            <div class="date">
              <p class="week center">星期${week!}</p>
              <p class="day center">${(act.startTime)?string("dd/MM")}</p>
              <p class="num center">1场</p>
            </div>
          </div>
          <div class="flex r">
            <div class="bo">
              <img src="${(act.user.userInfo.headPicture)!}" alt="${(act.user.userInfo.realName)!}" class="pic">
              <div class="flex">
                <p class="name">${(act.user.userInfo.realName)!}</p>
                <p class="t1">${(act.user.userInfo.position)!}</p>
                <p class="t1">${(act.user.userInfo.company)!}</p>
              </div>
            </div>
            <p class="theme">${(act.name)!}</p>
            <div class="info">
              <p><i class="iconfont">&#xe606;</i> <time>${(act.startTime)?string("yyyy-MM-dd HH:mm")}</time></p>
              <p><i class="iconfont">&#xe608;</i>${(act.city.city)!} ${(act.place)!}</p>
            </div>
          </div>
        </li>
	    	<#else>
	    	<li class="item-c bo" data-url="#">
          <div>
            <div class="date">
              <p class="week center">星期${week!}</p>
              <p class="day center">${(act.startTime)?string("dd/MM")}</p>
              <p class="num center">1场</p>
            </div>
          </div>
          <div class="flex r">
            <div class="pic-b">
              <a href="${(act.homepage)!}"><img src="${(act.posterUrl)!}" alt=""></a>
              <p class="title center-b">${(act.name)!}</p>
            </div>
            <div class="info">
              <p><i class="iconfont">&#xe606;</i> <time>${(act.startTime)?string("yyyy-MM-dd HH:mm")}</time></p>
              <p><i class="iconfont">&#xe608;</i> ${(act.city.city)!} ${(act.place)!}</p>
            </div>
          </div>
        </li>
	    	</#if>
    	</#if>
        
        
      </ul>
    </div>
</body>
</html>