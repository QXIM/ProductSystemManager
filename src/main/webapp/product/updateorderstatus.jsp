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

<h1>修改订单状态</h1>
<form action="order" method="get">
	<input type="hidden" name="operation" value="6"/>
	<input type="hidden" name="order_no" value= "${updateorder.order_no }" />
	<table>
		<tr style="margin-bottom: 20px">
			<td><span>选择状态：</span></td>
			<td>
				<select name="status">
                    <option >${updateorder.status}</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="0">0</option>
				</select>
			</td>
		</tr>
	<%--<tr>
	<td><span>选择状态：</span></td>
	<td><input type="text" name="status" value= "${order.status}"/></td>
	</tr>--%>
	<tr>
	<td><input type="submit" value="修改" /></td>
	</tr>
	</table>
	</form>








	
	
</body>
</html>