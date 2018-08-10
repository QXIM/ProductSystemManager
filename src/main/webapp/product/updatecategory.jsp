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

<h1>修改商品</h1>
<form action="category" method="get">
	<input type="hidden" name="operation" value="5"/>
	<table>
	<tr>
	<td><input type="text" name="id" value=${ category.categoryid } readonly="readonly" /></td>
	</tr>
	<tr>
	<td><span>输入类别名称：</span></td>
	<td><input type="text" name="name" value=${ category.name } /></td>
	</tr>
	<tr>
	<td><span>输入父ID：</span></td>
	<td><input type="text" name="parent_id" value=${ category.parent_id } /></td>
	</tr>
	<tr>
	<td><span>输入类别状态：</span></td>
	<td><input type="text" name="status" value=${ category.status } /></td>
	</tr>
	<tr>
	<td><span>输入类别顺序：</span></td>
	<td><input type="text" name="sort_order" value=${ category.sort_order } /></td>
	</tr>
	
	<tr>
	<td><input type="submit" value="修改" /></td>
	</tr>
	</table>
	
	</form>








	
	
</body>
</html>