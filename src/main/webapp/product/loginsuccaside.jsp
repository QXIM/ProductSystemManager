<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="aside.css">
</head>
<body>
		<div class="order">
			<div class="side_list">
				<ul style="list-style: none;">

					<li class="li2" id="productAll">商品 </li>
					<div id="product" >
						<li class="li2"><a href="addproduct.jsp" target="caidan" class="a3">添加商品 </a></li>
						<hr>
						<li class="li2"><a href="product?operation=7&pageNo=1" target="caidan" class="a3">查看商品</a></li>
						<hr>
					</div>
					<hr>
					<li class="li2" id="categoryAll">类别 </li>

<div id="category">
	<li class="li2"><a href="addcategory.jsp" target="caidan" class="a3">添加类别</a></li>
	<hr>
	<li class="li2"><a href="category?operation=2&pageNo=1" target="caidan" class="a3">查看类别</a></li>
	<hr>
</div>
					<hr>
<li class="li2"><a href="order?operation=2" target="caidan" class="a3">查看订单</a></li>
						<hr>




				</ul>
			</div>
			</div>
</body>

</html>

<script src="../js/jquery-3.3.1.min.js"></script>
<script>
	$(function () {
		$("#productAll").click(function () {

		   $("#product").toggle("1000");
			 })

		$("#categoryAll").click(function () {

		    $("#category").toggle("1000");
        })






    })







</script>