<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<title>enter app</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body background="${pageContext.request.contextPath}/resources/images/bgbg2.jpg" >

	<br>
	<br>


<!-- 	<div id="wrapper"> 
 -->	<div class="form-style-8" id="container">

		<c:if test="${not empty message}">
			<div class="error">
				<c:out value="${message}" />
			</div>
		</c:if>

		<h2>Please enter your username</h2>
		<br>

		<form:form action="welcome" modelAttribute="athlete">

			<form:input path="userName" placeholder="username*" />



			<c:if test="${not empty message1}">
				<div class="nullInput">
					<c:out value="${message1}" />
				</div>
			</c:if>

			<br>
			<br>

			<input type="submit" value="Enter" />

		</form:form>
	</div>
	
</body>

</html>

