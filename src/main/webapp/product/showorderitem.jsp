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

<h1 >查看订单明细</h1>
<table border="1px" cellpadding="5px" cellspacing="0px">






<tr>

<th>用户id</th>
<th>订单编号</th>
<th>商品id</th>
<th>商品名称</th>
<th>商品图片</th>
<th>创建时间</th>
<th>实际付款金额</th>
<th>商品数量</th>
<th>总金额</th>



</tr>


<c:forEach items="${orderitems}"  var="orderitems">

<tr>

<td>${orderitems.user_id }</td>
<td>${orderitems.orderItem_no }</td>
<td>${orderitems.product_id }</td>
<td>${orderitems.product_name }</td>
<td>${orderitems.product_image }</td>
<td>${orderitems.create_time }</td>
<td>${orderitems.current_unit_price }</td>
<td>${orderitems.quantity }</td>
<td>${orderitems.total_price }</td>
<td>
<a href="cart?cid=${cart.id}&operation=4" >删除</a></td>





</tr>




</c:forEach>
</table>


<a  href="order?cid=${cart.id}&operation=3" ><h4 style="color: red" >支付</h4></a>





	
	
</body>
</html>