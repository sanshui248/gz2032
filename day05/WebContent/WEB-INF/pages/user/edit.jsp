<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@include file="/WEB-INF/pages/common/header.jspf" %> 
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>添加用户</title>
</head>
<body>

<!--路径导航-->
<ol class="breadcrumb breadcrumb_nav">
    <li>首页</li>
    <li>用户管理</li>
    <li class="active">编辑用户</li>
</ol>
<!--路径导航-->

<div class="page-content">
    <div class="panel panel-default">
        <div class="panel-heading">编辑用户</div>
        <div class="panel-body">
            <form action ="${basepath}/user/save" method="post">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-9">
                            <div class="form-group">
                                <label >用户姓名</label>
                                <input type="text" class="form-control" name="name" value="${user.name }"/>
                            </div>
                            <div class="form-group">
                                <label >用户年龄</label>
                                <input type="text" class="form-control" name="age" value="${user.age }"/>
                            </div>
                            <div class="form-group">
                                <label >账号</label>
                                <input type="text" class="form-control" name="account" value="${user.account }"/>
                            </div> 
                            <!-- <div class="form-group">
                                <label >密码</label>
                                <input type="password" class="form-control" name="account" value="${user.password }"/>
                            </div>-->
                        </div> 
                    </div>
					<input type="hidden"  name="id" value="${user.id }"/>
                    <input type="submit" class="btn btn-primary" value="保存"/>
					<a  href ="javascript:history.go(-1)" class="btn btn-primary" >返回</a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>