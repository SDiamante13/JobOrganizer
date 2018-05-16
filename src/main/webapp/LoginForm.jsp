<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*, com.diamante.JobOrganizer.SQLConnection" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Abril+Fatface" rel="stylesheet" type="text/css">
        <title>Job Search Catalog</title>
        <style>
        h4{
        color: blue;
        font-family: Abril Fatface;
        }
        .login-body{
        background-color: #0040ff;
        text-align: center;
        }
        #container {
    	display: table;
    	height: 200px;
    	margin: 0 auto;
   		width: 400px;
   		position: absolute;
   		top: 25%;
  		left: 35%;
		}
        .login-form{
  		background: #b3c6ff;
    	padding: 20px;
    	text-align: center;
    	display: table-cell;
    	vertical-align: middle;
        }
        
        </style>
    </head>
     <body class = "login-body">
        <div id=container>
        <div class="login-form">
        <h4>Job Search Catalog</h4>
        <form class = "login-form" method = "post" action = "getLogin">
        Username: <input type = "text" name = "username">
        <br><br>
        Password: <input type = "password" name = "password">
        <br><br>
        <input type = "submit"/>
        <span style="color:red;"><b>${errMsg}</b></span>
        </form>
        </div>
        </div>
    </body>
</html>
