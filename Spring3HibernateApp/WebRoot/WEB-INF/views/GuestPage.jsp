    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    <!DOCTYPE html>  
    <html>  
     <head>  
     <title>Image File Upload</title>  
     <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script> 
     <script type="text/javascript">
  function chk(txt){
	
	if((document.getElementById('textdata').value)&&(document.getElementById('fileToUpload').value)){
	alert("You can select/enter only one text or image!");
	return false;
	}
 
  } 
     
     
     </script>
     
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
       
    <h3 style="color:red">${filesuccess}</h3>  
    <form:form method="post" action="savefile.html" enctype="multipart/form-data">
      <p><label for="text" class="bg-secondary text-white">Text/File Upload</label></p> 
    <p><label for="image">Choose Image</label></p>  
    <p><input name="file" id="fileToUpload" type="file" /></p>  
    <input type="hidden" name="user" id="user" value="${msg}">
    <p><label for="text" class="bg-info">Text Here</label></p>  
    <p><textarea name="textdata" id="textdata" rows="4" cols="50"></textarea></p> 
    <!--  <p><input type="submit" value="submit" onclick= "return chk();"></p>--> 
     <div class="form-group" style="width:400px;">
            <button type="submit" onclick= "return chk();" class="btn btn-primary">Submit</button>
        </div>
        </form:form>  
</div>
<div class="container footer">
	<table border="1"  class="table">
	<thead >
		
	<tr  class="bg-primary">
			<th colspan="3" class="text-center  text-white">Previous Records.</th>
			
		</tr>
		<tr>
			<th>User</th>
			<th>Text</th>
			<th>image</th>
			
		</tr>
		</thead>
		<tbody>
		<c:forEach var="detail" items="${userDetail}">
			<tr>
				<td>${detail.loginBean}</td>
				<td>${detail.textmessage}</td>
				<td><img width="100" height="100" src="getStudentPhoto.html?id=${detail.id}" ></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>

     

</div>
    </body>  
    </html>  