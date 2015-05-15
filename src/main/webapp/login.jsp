<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--  
<html>
<head>
    <title>登录</title>
    <style>.error{color:red;}</style>
</head>
<body>

<div class="error">${error}</div>
<form action="" method="post">
    用户名：<input type="text" name="username"><br/>
    密码：<input type="password" name="password"><br/>
    <input type="submit" value="登录">
</form>

</body>
</html>
-->
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
    <!-- 
    <link rel="icon" href="../../favicon.ico">
 	-->
    <title>TT家族  登录</title>
	<link rel="icon" href="/static/images/icon.png"/>
	<link rel="stylesheet" type="text/css" href="/static/css/main.css?125">
  </head>

<body class="bg494949">
<div class="header">
		<div class="inner clearfix">
			<div class="logo">
				<a href="/community/index"><img src="/static/images/logo.png"></a>
			</div>
			<div class="fl nav">                                                                  
				<span class="fl s1">
					<a href="/entrepreneur/index">我是创业社区</a>
					<a href="/community/index">我是创业者</a>
				</span>                                                            
				<span class="fr s3" style="margin-left:55%;float:none;">
					<a href="/service">付费服务</a>
				</span>
			</div>
		</div>
	</div>
	<div class="login_w">
		<div class="login_wrap">
			<div class="inner">
				<div class="hd clearfix">
					<span class="fl">用户登录</span>
					<!-- 
					<a href="reg.html" class="fr">我还没注册</a>
					 -->
				</div>
				<div class="bd">
					<form action="" method="post">
						<div class="text user_text">
							<input type="username" name="username" required  placeholder="手机号">
						</div>
						<div class="text pw_text">
							<input type="password" name="password"  required placeholder="密码">
						</div>
						<!--  
						<div class="forget_box">
							<a href="">忘记密码?</a>
						</div>
						-->
						<div class="login_btn">
							<input type='submit' value="">
						</div>
					</form>
				</div>
				<!--  
				<div class="ft clearfix">
					<span>其他登录方式</span>
					<a href="" class="qq_btn"></a>
					<a href="" class="wx_btn"></a>
					<a href="" class="wb_btn"></a>
				</div>
				-->
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="inner">
			<p class="p1">    
				<a href="/contact">联系我们</a>
				|
				<a href="/join">加入我们</a>
				|
				<a href="/agency">代理政策</a>
			</p>
			<p class="p2">               
				<a href="" class="a1">QQ登录</a>
				<a href="" class="a2">微信登录</a>
				<a href="" class="a3">微博登录</a>
			</p>
			<p class="p3">               
				QQ群：107317233    公司地址：中关村发展大厦
			</p>
		</div>
	</div>
</body>
</html>
