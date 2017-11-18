
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>

<head>
<title>Favoutite Workouts</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body
	background="${pageContext.request.contextPath}/resources/images/bg4.jpg"
	style="background-repeat: no-repeat;">


	<div class="form-style-8">

		<div align="center">
			<img
				src="${pageContext.request.contextPath}/resources/images/titleIcon.png"
				alt="workoutid" width="40px" height="40px">
			<h1 style="color: white; display: inline-block">Your favourite
				workouts</h1>
			<img
				src="${pageContext.request.contextPath}/resources/images/titleIcon.png"
				alt="workoutid" width="40px" height="40px">
		</div>

		<br> <br> <br> <br> <br> <br>
		<table align="center">

			<tr>
				<th style="color: white">-- Workouts --</th>
			</tr>


			<c:forEach var="tempWorkout" items="${favouritelist}">


				<c:url var="deleteLink" value="/athlete/delete">
					<c:param name="workoutId" value="${tempWorkout.id}" />
					<c:param name="userName" value="${athlete.userName}" />
				</c:url>

				<tr>

					<td>${tempWorkout} | <a href="${deleteLink}"
						onclick="if(!(confirm('Are you sure you want to delete this workout from your favouritelist?')))return false"
						style="color: white">Delete <img
						src="${pageContext.request.contextPath}/resources/images/deleteIcon.png"
						alt="workoutid" width="13px" height="13px"></a>

					</td>

				</tr>

			</c:forEach>
		</table>

		<br> <br>

		<c:url var="addLink" value="/athlete/welcome">
			<c:param name="userName" value="${athlete.userName}" />
		</c:url>
		<p align="center"><a href="${addLink}" style= "color:white;">Back</a></p>

	</div>
</body>
</html>













