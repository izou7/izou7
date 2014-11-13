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
    <link rel="icon" href="../../favicon.ico">

    <title>登录</title>

    <!-- Bootstrap core CSS -->
    <link href="/static/libs/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/static/libs/login/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="/static/libs/login/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="/static/libs/login/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">

      <form class="form-signin" role="form" action="" method="post">
        <h2 class="form-signin-heading">爱走起</h2>
        <h6 class="form-signin-heading">${error}</h6>
        <!--
        <input type="email" class="form-control" placeholder="Email address" required autofocus>
        -->
        <input type="username" name="username" class="form-control" placeholder="账号" required>
        <input type="password" name="password" class="form-control" placeholder="密码" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="/static/libs/login/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
