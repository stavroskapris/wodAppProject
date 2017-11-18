<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>


<html>

<head>
<title>Successful sign up</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>


<body
	background="${pageContext.request.contextPath}/resources/images/bg4.jpg"
	style="background-repeat: no-repeat;">

	<div class="form-style-8">


		<h1 align="center" style="color: white">Your sign up was
			successful!</h1>

		<p align="right" style="color: white"> Welcome ${athlete.firstName} ${athlete.lastName}</p>
		
		<br> <br> <br>
		<div align="center" style="color: white">
			<h1> Work Out of the Day :</h1>
			<img
				src="${pageContext.request.contextPath}/resources/images/${randomWorkout.id}.jpg"
				alt="workoutid" width="350px" height="250px">
				<h1> ${randomWorkout.title} </h1>
				<a href="http://localhost:8080/wodApp" style="color: white; text-decoration: underline;"> Main menu</a>
		</div>


	</div>

</body>





</html>