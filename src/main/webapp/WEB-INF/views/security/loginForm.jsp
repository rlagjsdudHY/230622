<%@	page language="java" contentType="text/html;	charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE	html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="/style/style.css">
</head>
<body>
	<div id="wrap">
		<h1>LoginForm</h1>
		<hr>
		<c:url var="loginUrl" value="security_url_check" />
		<form action="${loginUrl}" method="post">
			<c:if test="${param.error	!=	null}">
				<h3>Login Error!</h3>
				<p>${err_Msg}</p>
			</c:if>
			<span>ID</span> 
				<input type="text" name="sec_username"	value="${username}"> <br>
			 
			<span>PW</span> 
				<input type="text" name="sec_password"> <br>
			<button>LOGIN</button>
		</form>


	</div>
	<!--	div#wrap	-->
	<script src="/script/jquery-3.6.4.min.js"></script>
	<script src="/script/script.js"></script>
</body>
</html>