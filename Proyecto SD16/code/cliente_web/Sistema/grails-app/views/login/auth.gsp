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
body{
background-color: transparent;
}
html{
	background: url(http://biologiainteresante.com/wp-content/uploads/2014/09/ADN.jpeg);
}
</style>
</head>
<body>
	<div class="container">
		<br> <br><br> <br><br> <br><br> <br>
		<div class="row" id="pwd-container">
			<div class="col-md-4">
				<section class="login-form">
					<form class="form-signin form-horizontal" role="login"
						action='${postUrl}' method='POST' id='loginForm'
						autocomplete='off'>
						<h2 align="center">Iniciar Sesión</h2>
						
						<input type="text" class="form-control input-lg" required=""
							name='j_username' id="username"
							placeholder="Ingrese su Nombre de Usuario"> <input
							type="password" class="form-control input-lg" name='j_password' id="pass"
							 placeholder=" Ingrese su Contraseña">
											<button type="submit" id="submit"
							class="btn btn-lg btn-primary btn-block">Ingresar</button>
						<div></div>
						<div class="panel-footer" align="center">
							Desarrolladores: <a
				href="mailto:jorgeesquivelfernandez@gmail.com?Subject=Laboratorio%20SD2016">Jorge
				Esquivel</a> - <a
				href="mailto:jabel.oalex@gmail.com?Subject=Laboratorio%20SD2016">Alex
				Jiñes</a> - <a
				href="mailto:taniamonges@gmail.com?Subject=Laboratorio%20SD2016">Tania
				Monges</a> <a
				href="mailto:diazpany@gmail.com?Subject=Laboratorio%20SD2016">Jerson
				Paniagua</a> - <a
				href="mailto:fa.talavera95@gmail.com?Subject=Laboratorio%20SD2016">Fátima
				Talavera</a> <br> Líder del Proyecto: <a
				href="mailto:medinaldo@gmail.com?Subject=Laboratorio%20SD2016">Ing.
				Aldo Medina</a> <br> <strong>Copyright © 2016 - Sistemas
				Distribuídos - F.I.U.N.I</strong>
						</div>
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

