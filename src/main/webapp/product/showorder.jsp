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

<h1 >查看订单</h1>
<table border="1px" cellpadding="5px" cellspacing="0px">

<tr>
<th>订单id</th>
<th>用户id</th>
<th>地址id</th>
<th>付款方式</th>
<th>创建时间</th>
<th>运费</th>
<th>订单状态</th>
<th>订单编号</th>
<th>付款金额</th>
</tr>


<c:forEach items="${order}"  var="order">

<tr>
<td>${order.ordersid}</td>
<td>${user.accountid}</td>
<td>${order.shipping_id }</td>
<td>${order.payment_type }</td>
<td>${order.create_time }</td>
<td>${order.postage }</td>
<td>${order.status }</td>
<td>${order.order_no }</td>
<td>${order.payment }</td>


<%--<td>
<a href="cart?cid=${cart.id}&operation=3" >删除</a></td>
    <td>--%>
    <td>
        <a href="order?order_no=${order.order_no}&operation=5" >修改</a></td>
<td>
        <a href="order?order_no=${order.order_no}&operation=4" >订单明细</a></td>


</tr>


</c:forEach>
</table>





<a  href="order?cid=${cart.id}&operation=3" ><h4 style="color: red" >支付</h4></a>





	
	
</body>
</html>