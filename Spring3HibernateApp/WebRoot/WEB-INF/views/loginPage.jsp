<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap Simple Login Form</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script> 
</head>
<body>

<div class="login-form">
    <form:form method="POST" action="validateUser.html" commandName="loginBean"  >
        <h2 class="text-center">Log in</h2>       
        <div class="form-group">
            
            <form:input path="userName" class="form-control" placeholder="userName" required="required"/>
            
        </div>
        <div class="form-group">
            
            <form:password path="password" class="form-control" placeholder="password" required="required"/>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Log in</button>
        </div>
              
    </form:form>
    <p class="text-center"><a href="#">Create an Account</a></p>
</div>

</body>
</html>  