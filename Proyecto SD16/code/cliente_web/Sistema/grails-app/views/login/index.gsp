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

		
		 <div class="loginmodal-container">
			<h1>Ingresa a tu cuenta</h1><br>
			<form>
				<input type="text" name="user" placeholder="Correo o nombre de usuario">
				<input type="password" name="pass" placeholder="Contrasena">
				<input type="submit" name="login" class="login loginmodal-submit" value="Ingresar">
			</form>
			 <div class="panel-footer" align="center">
    			<strong>Copyright © 2016 - F.I.U.N.I</strong>
 			 </div>
		  </div>
		
		
	<!-- jQuery -->
   
    <script src=" ${request.contextPath}/template/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${request.contextPath}/template/js/bootstrap.min.js"></script> 
	</body>
	
</html>

