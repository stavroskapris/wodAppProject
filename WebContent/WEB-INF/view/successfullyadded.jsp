<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<div class="success">
	<c:out value="Your workout was added successfully!!!" />

</div>


<body>
<body>



	<br>
	<br>

	<br>

	<br>




	<c:url var="favLink" value="athlete/favouriteWorkouts">

		<c:param name="athleteId" value="${athlete.userName}" />

	</c:url>
	<a href="${favLink}">My Favourites</a>

	<c:url var="addLink" value="/athlete/welcome">
		<c:param name="userName" value="${athlete.userName}" />

	</c:url>
	<a href="${addLink}">Back</a>


</body>
</html>

