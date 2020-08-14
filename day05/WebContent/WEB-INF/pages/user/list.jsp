<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/pages/common/header.jspf" %> 

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户列表</title>
</head>
<body>

<!--路径导航-->
<ol class="breadcrumb breadcrumb_nav">
    <li>首页</li>
    <li>用户管理</li>
    <li class="active">用户列表</li>
</ol>
<!--路径导航-->

<div class="page-content">
    <form class="form-inline">
        <div class="panel panel-default">
            <div class="panel-heading">用户列表</div>
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th width="5%">ID</th>
                        <th width="15%">账号</th>
                        <th width="15%">姓名</th>
                        <th width="15%">年龄</th>
                        <th width="25%">注册时间</th>
                        <th width="25%">操作</th>    
                    </tr>
                    </thead>
                    <tbody>
					<c:forEach items="${pageInfo.list }" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.account}</td>
                        <td>${user.name}</td>
                        <td>${user.age}</td>
                        <td><fmt:formatDate value="${user.registerTime}" pattern="yyyy年MM月dd日HH:mm:ss"/></td>
                        <td>
                            <a href="${basepath}/user/edit?id=${user.id }"class="btn btn-info btn-xs"><span class="glyphicon glyphicon-edit"></span> 编辑</a>
                            <a href="${basepath}/user/delete?id=${user.id }" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> 删除</a>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div>
     
                	<c:if test="${pageInfo.currentPage>1 }">
                	    <a href ="${basepath }/user/list?currentPage=${pageInfo.currentPage-1}">上一页</a>
                	</c:if>
                	
        			<c:forEach begin="${pageInfo.beginPage }" end ="${pageInfo.endPage }" varStatus="status">
        			
        			<!-- 判断-->
        			<c:if test="${pageInfo.currentPage eq status.index}">
        				<span>${status.index}</span>
        			</c:if>
        			<c:if test="${pageInfo.currentPage ne status.index}">
        				<a href ="${basepath }/user/list?currentPage=${status.index}">${status.index}</a>
        			</c:if>
        			</c:forEach>
        			<c:if test="${pageInfo.currentPage<pageInfo.totalPage}">
        				<a href ="${basepath }/user/list?currentPage=${pageInfo.currentPage+1}">下一页</a>
        			</c:if>
                    <a href ="${basepath }/user/list?currentPage=${pageInfo.totalPage}">尾页</a>
                	<span>当前页：${pageInfo.currentPage}</span>
                	<span>总页数：${pageInfo.totalPage}</span>
                	<span>总记录数：${pageInfo.totalRecord}</span>
                </div>

            </div>
        </div>
    </form>
</div>
</body>
</html>