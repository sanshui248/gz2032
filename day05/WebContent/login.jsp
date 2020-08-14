<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/pages/common/header.jspf" %> 
 <head>
 	<meta charset="utf-8">
 	<meta http-equiv="X-UA-Compatible" content="IE=edge">
 	<meta name="viewport" content="width=device-width,initial-scale=1">
    <title>登录页面</title>
 </head>

 <body>
 <div class = "page-content">
	<form action="${basepath }/user/login"  class="form-horizontal" style=" width:450px; margin-left: 35%;" method="post">
		  <div class="form-group">
		    <label  class="col-sm-2 control-label">账号</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="account" placeholder="请输入账号">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">密码</label>
		    <div class="col-sm-10">
		      <input type="password" class="form-control" name="password" placeholder="请输入密码">
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <div class="checkbox">
		        <label>
		          <input type="checkbox" value="1" name="rememberme"> 下次自动登录
		        </label>
		      </div>
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <input type="submit" class="btn btn-default" value="登录">
		    </div>
		  </div>
	</form>
</div>
</body>