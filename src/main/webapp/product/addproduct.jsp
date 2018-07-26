<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="addproduct.css">
</head>
<body>




	<article>
		<h3>增加商品</h3>
		<br />

		<form action="product" method="get">
			<input type="hidden" name="operation" value="1" />
			<table>
				<tr class="tr1">
					<td><span>输入商品名称：</span></td>
					<td><input type="text" name="pname" /></td>

				</tr>

				<tr class="tr1">
					<td><span>输入商品价格：</span></td>
					<td><input type="text" name="price" /></td>

				</tr>

				<tr class="tr1">
					<td><span>输入商品库存：</span></td>
					<td><input type="text" name="stock" /></td>

				</tr>

				<tr class="tr1">
					<td><span>输入商品介绍：</span></td>
					<td><input type="text" name="detail" /></td>

				</tr>

				<tr class="tr1">
					<td><span>输入商品图片：</span></td>
					<td><input type="text" name="image" /></td>

				</tr>


				<tr class="tr1">

					<td><a href="#" target="caidan" class="a1">
						<input type="submit" class="detail_buttom22" value="添加商品"  />
					</a></td>
				</tr>
			</table>

		</form>




	</article>


</body>
</html>