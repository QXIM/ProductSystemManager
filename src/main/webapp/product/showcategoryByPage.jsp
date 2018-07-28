<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <style>
        article{

            color: #0a3665;
            font-size: 16px ;
            text-align: center;
            width: 700px;


        }
        .choose{
            color: red;

        }
        .btn{
            margin: 10px;
        }
    </style>
</head>
<body>

<h3>查看分类</h3>
<article>
<table border="0px" cellpadding="5px" cellspacing="0px" >

<tr>
<th >类别id</th>
<th>类别名称</th>
<th>类别父id</th>
<th>类别状态</th>
<th>类别顺序</th>
<th>创建时间</th>
<th>修改时间</th>
<th>用户操作</th>

</tr>

<c:forEach items="${PageModel.date}"  var="category">

<tr>
<td>${category.categoryid }</td>
<td>${category.name }</td>
<td>${category.parent_id }</td>
<td>${category.status }</td>
<td>${category.sort_order }</td>
<td>${category.create_time }</td>
<td>${category.update_time }</td>


<td><a href="category?_id=${category.categoryid }&operation=4" class="choose">修改</a>
<a href="category?_id=${category.categoryid }&operation=3" class="choose">删除</a></td>


</tr>

</c:forEach>
</table>

<div style="position: absolute;top: 300px;left: 100px">
<c:forEach begin="1" end="${PageModel.totalPage}" step="1"  var="pageNo">

<a href="category?pageNo=${pageNo}&operation=2 "><button class="btn">
        ${pageNo}
</button>

</a>

</c:forEach>
<br/>
</div>
<!-- <a href="loginsucc.jsp">返回上一层</a> -->

</article>

	
	
</body>
</html>