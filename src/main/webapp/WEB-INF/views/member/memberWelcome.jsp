<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
...
<div id="wrap">
	<h2>Welcome : Member</h2>
	<hr>
	<sec:authorize access="isAuthenticated()">
		<p>Log-In</p>
	</sec:authorize>
	<sec:authorize access="!isAuthenticated()">
		<p>Log-Out</p>
	</sec:authorize>
	<p>
		User ID :
		<sec:authentication property="name" />
	</p>
	<c:url var="logoutUrl" value="/logout" />
	<a href="${logoutUrl}">[Logout]</a>
</div>
<!--	div#wrap	-->

<script src="/script/jquery-3.6.4.min.js"></script>
<script src="/script/script.js"></script>
</body>
</html>

