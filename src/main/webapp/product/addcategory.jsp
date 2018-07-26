<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>增加商品</h1>
	<form action="category" method="get">
	<input type="hidden" name="operation" value="1" />
	<table>
	<tr>
	<td><span>输入类别名称：</span></td>
	<td><input type="text" name="name" /></td>
	</tr>
	<tr>
	<td><span>输入类别parent_id：</span></td>
	<td>
	<select name="parent_id">
<option value="111">111</option>
<option value="222">222</option>
<option value="666">666</option>
<option value="888">888</option>
<option value="0">0</option>
</select>
	</td>
	</tr>
	<tr>
	<td><span>输入类别状态：</span></td>
	<td><input type="text" name="status" /></td>
	</tr>
	<tr>
	<td><span>输入类别顺序：</span></td>
	<td><input type="text" name="sort_order" /></td>
	</tr>
	
	<tr>
	<td><input type="submit" value="添加" /></td>
	</tr>
	</table>

	</form>
</body>
</html>