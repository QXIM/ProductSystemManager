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

<h1>修改购物车数量</h1>
<form action="cart" method="get">
	<input type="hidden" name="operation" value="5"/>
	<input type="hidden" name="cid" value= "${cart.id }" />
	<table>
	<tr>
	<td><span>输入修改的数量：</span></td>
	<td><input type="text" name="quantity" value= "${cart.quantity }"/></td>
	</tr>
	<tr>
	<td><input type="submit" value="修改" /></td>
	</tr>
	</table>
	</form>








	
	
</body>
</html>