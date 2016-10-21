<!DOCTYPE html>
<html>
	<head>
		<asset:stylesheet src="application.css"/>
		
		<g:set var="entityName" value="${message(code: 'login.label', default: 'Login')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		 <!-- Bootstrap Core CSS -->
	    <link href="${request.contextPath}/template/css/bootstrap.min.css?v=1" rel="stylesheet">
	
	    <!-- Custom CSS -->
	    <link href="${request.contextPath}/template/css/sb-admin.css?v=1" rel="stylesheet">
	
	    <!-- Custom Fonts -->
	    <link href="${request.contextPath}/template/font-awesome/css/font-awesome.min.css?v=1" rel="stylesheet" type="text/css">
		

	</head>
	<body>
		<center>
		<img src="<g:resource dir='images' file='fondo.png'/>" data-toggle="modal" data-target="#login-modal">
		</center>
		<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    	  <div class="modal-dialog">
				<div class="loginmodal-container">
					<h1>Ingresa a tu cuenta</h1><br>
				  <form>
					<input type="text" name="user" placeholder="Correo o nombre de usuario">
					<input type="password" name="pass" placeholder="Contrasena">
					<input type="submit" name="login" class="login loginmodal-submit" value="Ingresar">
				  </form>
					
				</div>
			</div>
		  </div>
	<!-- jQuery -->
   
    <script src=" ${request.contextPath}/template/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${request.contextPath}/template/js/bootstrap.min.js"></script> 
	</body>
	
</html>

