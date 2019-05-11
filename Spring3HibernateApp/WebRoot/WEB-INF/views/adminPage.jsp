<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script> 
</head>
<body>
<div class="container">


<div class="container head bg-primary"> 
      
      <table   class="table">
	<thead >
		
	<tr  class="bg-primary">
			
			<th  class="text-left text-white">Welcome ${msg}</th>
			<th  class="text-right text-white"><a href="logout.html" class="text-white"  >Logout </a></th>
			</tr></thead></table>
      
      
    </div>




<div class="container main">
  
	<div class="bg-secondary text-white">All Guest user Detail </div>


	<table border="1"  class="table">
	<thead >
		<tr>
			<th>User</th>
			<th>Text</th>
			<th>Image</th>
			<th>Status</th>
			<th>Approve</th>
			<th>Delete</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="details" items="${userdetail}">
			<tr>
				<td>${details.loginBean}</td>
				<td>${details.textmessage}</td>
				<td><img width="100" height="100" src="getStudentPhoto.html?id=${details.id}" ></td>
				<td>${details.status}</td>
				<td><a href="approve.html?id=${details.id}" > Approve </a> </td>
				<td><a href="delete.html?id=${details.id}" >Delete</a> </td>
				</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
</div>
</body>
</html>