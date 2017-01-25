<!DOCTYPE html>
<html>
<head>

<g:set var="entityName"
	value="${message(code: 'login.label', default: 'Login')}" />
<title><g:message code="Inicio de Sesion" /></title>
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
	<br />
	<br />
	<div class="container">
		<div class="row" id="pwd-container">
			<div class="col-md-4">
				<section class="login-form">
					<form class="form-signin form-horizontal" role="login"
						action='${postUrl}' method='POST' id='loginForm'
						autocomplete='off'>
						<h2 align="center">Iniciar Sesión</h2>
						<g:if test='${flash.message}'>
							<div class="alert alert-danger">
								${flash.message = "Usuario y/o Contraseña incorrecta."}
							</div>
							
						</g:if>
						<input type="text" class="form-control input-lg" required=""
							name='j_username' id="username" placeholder="Nombre de Usuario">
						<input type="password" class="form-control input-lg" required=""
							name='j_password' id="password" placeholder="Contraseña">
						<button type="submit" id="submit"
							class="btn btn-lg btn-primary btn-block">Ingresar</button>
						<div></div>

					</form>
				</section>
			</div>
		</div>

	</div>
	<br />
	<br />
	<div class="pag-footer" align="center"
		style="background-color: #f2f2f2; opacity: 0.8; position: fixed; width: 100%;">
		<strong>Desarrolladores:</strong> Jorge Esquivel<a
			href="mailto:jorgeesquivelfernandez@gmail.com?Subject=Laboratorio%20SD2016">(jorgeesquivelfernandez@gmail.com)</a>
		- Alex Jiñes<a
			href="mailto:abel.oalex@gmail.com?Subject=Laboratorio%20SD2016">(abel.oalex@gmail.com)</a>
		- Tania Monges<a
			href="mailto:taniamonges@gmail.com?Subject=Laboratorio%20SD2016">(taniamonges@gmail.com)</a>
		- Jerson Paniagua<a
			href="mailto:diazpany@gmail.com?Subject=Laboratorio%20SD2016">(diazpany@gmail.com)</a>
		- Fátima Talavera<a
			href="mailto:fa.talavera95@gmail.com?Subject=Laboratorio%20SD2016">(fa.talavera95@gmail.com)</a>
		<br> Líder del Proyecto: Ing. Aldo Medina <a
			href="mailto:medinaldo@gmail.com?Subject=Laboratorio%20SD2016">(medinaldo@gmail.com)</a>
		<br> <strong>Copyright © 2016 - Sistemas Distribuídos -
			F.I.U.N.I</strong>
	</div>
	<!-- jQuery -->

	<script src=" ${request.contextPath}/template/js/jquery.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
	<script type='text/javascript'>
	<!--
		(function() {
			document.forms['loginForm'].elements['j_username'].focus();
		})();
	// -->
	</script>
</body>

</html>

