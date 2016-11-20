<!DOCTYPE html>
<html>
<head>

<g:set var="entityName"
	value="${message(code: 'login.label', default: 'Login')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
<!-- Bootstrap Core CSS -->
<link href="${request.contextPath}/template/css/bootstrap.min.css?v=1"
	rel="stylesheet">
<asset:stylesheet src="user-login.css" />
<style>
body {
	background-color: transparent;
}

html {
	background-image: url(${request.contextPath}/images/mic.jpg);
	 background-repeat: no-repeat;
	 background-size: cover;
	  background-position: center center;
	  
	  
	 
}
</style>
</head>
<body>
	<div class="container">
		<br> <br>
		<br> <br>
		<br> <br>
		<br> <br>
		<div class="row" id="pwd-container">
			<div class="col-md-4">
				<section class="login-form">
					<form class="form-signin form-horizontal" role="login"
						action='${postUrl}' method='POST' id='loginForm'
						autocomplete='off'>
						<h2 align="center">Iniciar Sesión</h2>
					
						<input type="text" class="form-control input-lg" required=""
							name='j_username' id="username"
							placeholder="Nombre de Usuario"> <input
							type="password" class="form-control input-lg" name='j_password' required=""
							id="pass" placeholder="Contraseña">
						<button type="submit" id="submit"
							class="btn btn-lg btn-primary btn-block">Ingresar</button>
						<div></div>

					</form>
				</section>
			</div>
		</div>

	</div>
	<!-- jQuery -->

	<script src=" ${request.contextPath}/template/js/jquery.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>

</body>

</html>

