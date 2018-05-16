<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Job</title>
        <style>
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
	background: #0040ff;
	color:  #ffffff; 
}

h2{
	position: absolute;
	font-size: 40px;
	font-weight: 900;
    top: 30px;
    left: 545px;

}

.add-job-form{
	position: absolute;
    top: 150px;
    right: 550px;
}
</style>
    </head>

<h2> Add new job </h2>
<body>
<div class = "add-job-form">
<form method = "post" action = "addJob" id = "formRegister">
Date <input name = "date" type = "date" required>
<br><br>
Employer <input name = "employer" type = "text" placeholder = "Employer" required>
<br><br>
Location <input name = "location" type = "text" placeholder = "Location" required>
<br><br>
Position <input name = "position" type = "text" placeholder = "Position" required>
<br><br>
Salary <input name = "salary" type = "text" placeholder = "70000" required>
<br><br>
Result <input name = "result" type = "text" placeholder = "Result" required>
<br><br>
<input type = "submit" value = "Add Job"/>
</form>
</div>
</body>
</html>
