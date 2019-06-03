<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<hr>
<h2>${message}</h2>
이곳은 doC입니다.
<br>
<div>[제품의 정보]</div>
제품 이름 : ${map.product.name} <br>
제품 가격 : ${map.product.price}원 <br>


</body>
</html>