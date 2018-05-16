<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src=http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js> </script>
<title>Edit Job</title>
<style>
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
	background: #0040ff;
	color:  #ffffff;
	text-align: center;
}
</style>

</head>
<h2> Edit existing job </h2>
<body>

<form method = "post" action = "selectJob">
Job Number <input name = jobNumber type = "number" min = "1" max = "${jobLength}" required>
<input type = "submit" value = "Search">
</form>
<br><br><br>

<div id="job-number" job-contact-number="${editedJob.jobNo}">
</div>

<script type= "text/javascript">
$(function(){
	var jobNo = document.getElementById("job-number").getAttribute("job-contact-number");
	if(jobNo > 0){
	$(".edit-form").show();
	}
});


</script>

<div class = "edit-form" style = "display:none">
<form method = "post" action = "editJob">
Date <input name = "date" type = "date" value = "${editedJob.date}" required>
<br><br>
Employer <input name = "employer" type = "text" value = "${editedJob.employer}" required>
<br><br>
Location <input name = "location" type = "text" value = "${editedJob.location}" required>
<br><br>
Position <input name = "position" type = "text" value = "${editedJob.position}" required>
<br><br>
Salary <input name = "salary" type = "text" value = "${editedJob.salary}" required>
<br><br>
Result <input name = "result" type = "text"€ value = "${editedJob.result}" required>
<br><br>
<input type = "submit" value = "Edit Job"€/>
</form>
</div>



</body>
</html>