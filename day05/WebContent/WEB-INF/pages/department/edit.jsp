<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@include file="/WEB-INF/pages/common/header.jspf" %> 
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>编辑部门</title>
</head>
<body>

<!--路径导航-->
<ol class="breadcrumb breadcrumb_nav">
    <li>首页</li>
    <li>部门管理</li>
    <li class="active">编辑用户</li>
</ol>
<!--路径导航-->

<div class="page-content">
    <div class="panel panel-default">
        <div class="panel-heading">编辑部门</div>
        <div class="panel-body">
            <form action ="${basepath}/department/save" method="post">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-9">
                           <div class="form-group">
                                <label >ID</label>
                                <input type="text" class="form-control" name="id" />
                            </div>
                            <div class="form-group">
                                <label >部门名称</label>
                                <input type="text" class="form-control" name="name" />
                            </div >
                            	
                            	
							<div class="form-group">
							    <label>上级部门</label>
							    <select name="parent_id">
							    	<option value="parent_id">请选择部门</option>
							    	
							    		<c:forEach items="${list }" var="item">
							    			<option value="${item.id}">${item.name}</option>
							    	</c:forEach>
							    </select>
							</div>
                             <div class="form-group">
                                <label >排序号</label>
                                <input type="text" class="form-control" name="order_num" value="${department.order_num}"/>
                            </div>
                        </div> 
                    </div>
					<input type="hidden"  name="id" value="${department.id }"/>
                    <input type="submit" class="btn btn-primary" value="保存"/>
					<a  href ="javascript:history.go(-1)" class="btn btn-primary" >返回</a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>