<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

 <style>
  article{

   color: #0a3665;
   font-size: 16px ;
   text-align: center;
  width: 700px;


  }
  .choose{
    color: red;

  }
  .btn{
margin: 10px;
   }



 </style>

</head>
<body>

<h3>查看商品</h3>
<article >
<table border="0px" cellpadding="5px" cellspacing="0px" >

<tr>
<th>商品id</th>
<th>商品名称</th>
<th>商品价格</th>
<th>商品描述</th>
<th>商品库存</th>
<th>商品图片</th>
 <th>用户操作</th>


</tr>

<c:forEach items="${PageModel.date}"  var="product">

<tr>
<td>${product.productid }</td>
<td>${product.pname}</td>
<td>${product.price }</td>
<td>${product.detail }</td>
<td>${product.stock }</td>
<td>${product.image }</td>

<td><a href="product?_id=${product.productid }&operation=3" class="choose" >修改</a></td>
<td><a href="product?_id=${product.productid }&operation=4" class="choose">删除</a></td>
<td><a href="cart?pid=${product.productid }&operation=1" class="choose">加入购物车</a></td>

</tr>

</c:forEach>
</table>
 <div style="position: absolute;top: 300px;left: 100px">
<c:forEach var="pageNo"  begin="1" end="${PageModel.totalPage}" step="1">

 <c:choose>

<c:when test="${ pageNo==PageModel.currentPage}"> 
<a  href="product?pageNo=${pageNo}&operation=7"><button class="btn" style="color: red">
${pageNo}
</button>
</a>
 </c:when>
<c:when test="${ pageNo!=PageModel.currentPage}" >
<a href="product?pageNo=${pageNo}&operation=7 " ><button class="btn">
  ${pageNo}
</button>

</a>
</c:when>

</c:choose>

</c:forEach>
 </div>

<!-- <a href="loginsucc.jsp">返回上一层</a>
 -->






</article>
	
</body>
</html>