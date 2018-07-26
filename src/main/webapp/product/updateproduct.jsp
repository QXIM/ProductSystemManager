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
<form action="product" method="get">
	<input type="hidden" name="operation" value="5"/>
	<table>
	<tr>
	<td><input type="text" name="id" value=${ product.id } readonly="readonly" /></td>
	</tr>
	<tr>
	<td><span>输入商品名称：</span></td>
	<td><input type="text" name="pname" value=${ product.name } /></td>
	</tr>
	<tr>
	<td><span>输入商品价格：</span></td>
	<td><input type="text" name="price" value=${ product.price } /></td>
	</tr>
	<tr>
	<td><span>输入商品库存：</span></td>
	<td><input type="text" name="stock" value=${ product.stock } /></td>
	</tr>
	<tr>
	<td><span>输入商品介绍：</span></td>
	<td><input type="text" name="detail" value=${ product.detail } /></td>
	</tr>
	<tr>
	<td><span>输入商品图片：</span></td>
	<td><input type="text" name="image" value=${ product.image } /></td>
	</tr>
	<tr>
	<td><input type="submit" value="修改" /></td>
	</tr>
	</table>
	
	</form>








	
	
</body>
</html>