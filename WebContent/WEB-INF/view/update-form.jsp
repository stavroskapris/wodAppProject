<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<head>
<title>Athletes Registration Form</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body background="${pageContext.request.contextPath}/resources/images/bgbg2.jpg" >
	<br>
	<br>
	<div id="container">
		<div class="form-style-8">

			<h2>Update profile</h2>

			<c:if test="${not empty message}">
				<div class="error">
					<c:out value="${message}" />
				</div>
			</c:if>

			<form:form action="processUpdateForm" method ="POST" modelAttribute="athlete">




				<form:input path="firstName" placeholder="First name(*)"
					pattern="^[a-zA-Z]*$" title="only letters" />
				<form:errors path="firstName" cssClass="nullInput" />

				<form:input path="lastName" placeholder="Last name(*)"
					pattern="^[a-zA-Z]*$" title="only letters" />
				<form:errors path="lastName" cssClass="nullInput" />

				<form:input path="userName" placeholder="User name(*)" />
				<form:errors path="userName" cssClass="nullInput" />


				<form:select path="gender">
					<form:option value="M" label="male" />
					<form:option value="F" label="female" />

				</form:select>
				<br>
				<input type="hidden" value="${athlete.id}" name="update" />

				<input type="submit" value="Update account" />

			</form:form>

		</div>
	</div>
</body>