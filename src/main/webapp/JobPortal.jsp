<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://fonts.googleapis.com/css?family=Abril+Fatface" rel="stylesheet" type="text/css">
<script type="text/javascript" src=http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js> </script>
<title>Job Organizer Portal</title>
</head>
<style>
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
	background: #0040ff;
}

.topnav {
	overflow: hidden;
	background-color: #333;
}

.topnav a {
	float: left;
	color: #ffffff;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

h1 {
	font-weight: bolder;
	font-family: Abril Fatface;
	font-size: 35px;
	color: #ffffff
}

.topnav a.active {
	background-color: #4CAF50;
	color: white;
}

<!--
Table style-->table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
	color: #ffffff
}

td, th {
	border: 1px solid #dddddd;
	text-align: center;
	padding: 8px;
}

th{
	background-color: #000000;
    color: white;
}

tr{
	background-color: #666666;
	color: white
}

.greeting {
	text-align: center;
	color:  #ffffff;
}
</style>


<body>

	<center>
		<h1>Job Portal</h1>
	</center>


	<div class="topnav">
		<a href="AddJob.jsp">Add Job</a>
		<a href="EditJob.jsp">Edit Job</a>
		<a href="deleteJob" onclick= "return confirm('Are you sure you want to delete the last added job?');">Delete Job</a>
	</div>
	

	<div class="greeting">
		<h3>Welcome to the Job Contact Organizer!</h3>
	</div>
	<span style="color: red;"><b>${errMsgEmpty}</b></span>
	
<script type= "text/javascript">
$(function(){
	$(".greeting").hide().slideToggle(2000);
	console.log("Hiding greeting");
});

</script>

	<table>
		<tr>
			<th>Job Number</th>
			<th>Date</th>
			<th>Employer</th>
			<th>Location</th>
			<th>Position</th>
			<th>Salary</th>
			<th>Result</th>
		</tr>

		<c:if test="${jobs != null}">
			<c:forEach var="job" items="${jobs}">

				<tr>
					<td><c:out value="${job.jobNo}">
						</c:out></td>
					<td><c:out value="${job.date}">
						</c:out></td>
					<td><c:out value="${job.employer}">
						</c:out></td>
					<td><c:out value="${job.location}">
						</c:out></td>
					<td><c:out value="${job.position}">
						</c:out></td>
					<td><c:out value="${job.salary}">
						</c:out></td>
					<td><c:out value="${job.result}">
						</c:out></td>
				</tr>

			</c:forEach>
		</c:if>
	</table>
</body>
</html>