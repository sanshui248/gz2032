<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/pages/common/header.jspf" %> 

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>部门管理</title>
</head>
<body>

<!--路径导航-->
<ol class="breadcrumb breadcrumb_nav">
    <li>首页</li>
    <li>用户管理</li>
    <li class="active">部门管理</li>
</ol>
<!--路径导航-->

<div class="page-content">
    <form class="form-inline">
        <div class="panel panel-default">
            <div class="panel-heading">部门管理</div>
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th width="5%">ID</th>
                        <th width="15%">部门名称</th>
                        <th width="15%">上级部门</th>
                        <th width="15%">排序号</th>  
                        <th width="15%">操作</th> 
                    </tr>
                    </thead>
                    <tbody>
					<c:forEach items="${pageInfo2.list }" var="item">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.name}</td>
                        <td>${item.parentName}</td>
                        <td>${item.order_num}</td>
                        <td>
                            <a href="${basepath}/department/edit?id=${item.id }"class="btn btn-info btn-xs"><span class="glyphicon glyphicon-edit"></span> 编辑</a>
                            <a href="${basepath}/department/delete?id=${item.id }" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> 删除</a>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div>
     
                	<c:if test="${pageInfo2.currentPage>1 }">
                	    <a href ="${basepath }/department/list?currentPage=${pageInfo2.currentPage-1}">上一页</a>
                	</c:if>
                	
        			<c:forEach begin="${pageInfo2.beginPage }" end ="${pageInfo2.endPage }" varStatus="status">
        			
        			<!-- 判断-->
        			<c:if test="${pageInfo2.currentPage eq status.index}">
        				<span>${status.index}</span>
        			</c:if>
        			<c:if test="${pageInfo2.currentPage ne status.index}">
        				<a href ="${basepath }/department/list?currentPage=${status.index}">${status.index}</a>
        			</c:if>
        			</c:forEach>
        			<c:if test="${pageInfo2.currentPage<pageInfo.totalPage}">
        				<a href ="${basepath }/department/list?currentPage=${pageInfo2.currentPage+1}">下一页</a>
        			</c:if>
                    <a href ="${basepath }/department/list?currentPage=${pageInfo2.totalPage}">尾页</a>
                	<span>当前页：${pageInfo2.currentPage}</span>
                	<span>总页数：${pageInfo2.totalPage}</span>
                	<span>总记录数：${pageInfo2.totalRecord}</span>
                </div>

            </div>
        </div>
    </form>
</div>
</body>
</html>