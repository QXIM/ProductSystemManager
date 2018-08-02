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

<h1 >查看购物车</h1>
<table border="1px" cellpadding="5px" cellspacing="0px">

<tr>
<th>购物车id</th>
<th>购物车编号</th>
<th>商品id</th>
<th>商品名称</th>
<th>商品价格</th>
<th>商品描述</th>
<th>商品库存</th>
<th>商品图片</th>
<th>购物车数量</th>

<%--<th>用户操作</th>--%>
</tr>

<c:forEach items="${carts}"  var="cart">

<tr>
<td>${cart.id }</td>
<td>${cart.cart_no }</td>

<td>${cart.product.productid }</td>
<td>${cart.product.pname }</td>
<td>${cart.product.price }</td>
<td>${cart.product.detail }</td>
<td>${cart.product.stock }</td>
<td>${cart.product.image }</td>


<td>${cart.quantity }</td>
<%--<td>
<a href="cart?cid=${cart.id }&operation=3" >删除</a>
<a href="cart?cid=${cart.id}&operation=4" >修改数量</a>

</td>--%>



</tr>




</c:forEach>
</table>


<a   href="order?cid=${cart.id}&operation=1"  ><h4 style="color: red" >结算</h4></a>







	
	
</body>
</html>