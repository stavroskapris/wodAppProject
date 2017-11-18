<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE>
<html>
<head>
<title>Workout Of The Day</title>
</head>


<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>


<body background="${pageContext.request.contextPath}/resources/images/bg4.jpg" style= "background-repeat:no-repeat;">
	<div class="form-style-8">

		<c:if test="${not empty message3}">
			<div class="empty">
				<c:out value="${message3}" />
			</div>
		</c:if>

		<c:if test="${not empty message2}">
			<div class="alreadyFavourite">
				<c:out value="${message2}" />
			</div>
		</c:if>

		<c:if test="${not empty message1}">
			<div class="success">
				<c:out value="${message1}" />
			</div>
		</c:if>

		<p align="right" style="color: white">Welcome Back
			${athlete.userName}</p>

		<br> <br> <br>
		<div align="center" style="color: white">
			<h1> Work Out of the Day :</h1>
			<img
			alt="workoutid" width="350px" height="250px"
			 src="${pageContext.request.contextPath}/resources/images/${randomWorkout.id}.jpg">
			 
				<%-- src="${pageContext.request.contextPath}/resources/images/giphy-downsized.gif"  --%>
				<!-- src="//i.imgur.com/ifCQQWy.gif"  -->
				
				
				
		<%-- 		<video width="250">
          <source src="${pageContext.request.contextPath}/resources/images/.giphy.mp4" type="video/mp4">
            </video> --%>
				<h1> ${randomWorkout.title} </h1>
		</div>

		<br> <br>


		<c:url var="addLink" value="/athlete/addToFavoutites">
			<c:param name="workoutId" value="${randomWorkout.id}" />
			<c:param name="userName" value="${athlete.userName}" />
		</c:url>

		<c:url var="favLink" value="athlete/favouriteWorkouts">
			<c:param name="userName" value="${athlete.userName}" />
		</c:url>

		<c:url var="getLink"
			value="http://localhost:8080/wodApp/athlete/welcome">
			<c:param name="userName" value="${athlete.userName}" />
		</c:url>

		<c:url var="updateLink" value="/athlete/showFormForUpdate">
			<c:param name="athleteId" value="${athlete.id}" />
		</c:url>
		<br> <br> <br> <br> <br> 

		<div align="center" style="color: white">
			<a href="${addLink}" style="color: white">Add to Favourites  </a><strong>|</strong> <a
				href="${favLink}" style="color: white">My Favourites  </a><strong>|</strong> <a
				href="${getLink}" style="color: white">Get Another  </a><strong>|</strong> <a
				href="${updateLink}" style="color: white">Edit me</a>
		</div>

	</div>
</body>
</html>