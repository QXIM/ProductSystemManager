<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>查看商品</h1>
<table border="1px" cellpadding="5px" cellspacing="0px">

<tr>
<th>商品id</th>
<th>商品名称</th>
<th>商品价格</th>
<th>商品描述</th>
<th>商品库存</th>
<th>商品图片</th>
</tr>

<c:forEach items="${products}"  var="product">

<tr>
<td>${product.id }</td>
<td>${product.name }</td>
<td>${product.price }</td>
<td>${product.detail }</td>
<td>${product.stock }</td>
<td>${product.image }</td>

<td><a href="product?_id=${product.id }&operation=3" >修改</a></td>
<td><a href="product?_id=${product.id }&operation=4" >删除</a></td>
<td><a href="cart?pid=${product.id }&operation=1" >加入购物车</a></td>




</tr>




</c:forEach>
</table>




<br/>
<!-- <a href="http://localhost:8080/ProductSystem_web/product/loginsucc.jsp">返回上一层</a> -->




	
	
</body>
</html>