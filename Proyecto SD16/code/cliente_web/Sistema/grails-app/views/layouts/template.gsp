<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@ page import="com.sd.uni.labpatologia.service.auth.IAuthService" %>
<%@ page import="com.sd.uni.labpatologia.service.user.IUserService" %>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<asset:stylesheet src="application.css" />
<asset:javascript src="application.js" />
<title>Sistema</title>

<!-- Select -->
 <link rel="stylesheet" href="${request.contextPath}/dist/css/bootstrap-select.css">
   <script src="${request.contextPath}/dist/js/bootstrap-select.js"></script>
  <script src="${request.contextPath}/dist/js/i18n/defaults-es_ES.js"></script>
  
<!-- Bootstrap Core CSS -->
<link href="${request.contextPath}/template/css/bootstrap.min.css?v=1"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="${request.contextPath}/template/css/sb-admin.css?v=1"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${request.contextPath}/template/font-awesome/css/font-awesome.min.css?v=1"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a href="#" class="navbar-brand"><strong> <g:each
							in="${laboratoryInstanceList}" status="i"
							var="laboratoryInstance">
							<g:if test="${laboratoryInstance?.name}">
								<h4>
									<strong>
										${fieldValue(bean: laboratoryInstance, field: "name")}
									</strong>
								</h4>
							</g:if>
						</g:each>
				</strong></a>
			</div>
			<!-- Top Menu Items -->
			<ul class="nav navbar-right top-nav">




				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-user"></i> Hola, ${user}<b
						class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="Sistema/j_spring_security_logout"><i
								class="fa fa-fw fa-power-off"></i> Salir</a></li>
					</ul></li>
			</ul>
			<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li><a href="/Sistema/inicio/index"><i
							class="fa fa-fw fa-bars"></i>Panel Principal</a></li>
					
					<sec:ifNotGranted roles='ROLE_TECNICO'>
						<li><a href="/Sistema/request/list/"><i
								class="fa fa-fw fa-file-text"></i>Fichas de Entradas</a></li>
					
						<li><a href="/Sistema/patient/list/"><i
								class="fa fa-fw fa-user"></i>Pacientes</a></li>
	
						<li><a href="/Sistema/doctor/list/"><i
								class="fa fa-fw fa-user-md"></i>Doctores</a></li>
					</sec:ifNotGranted>
					
					<sec:ifNotGranted roles='ROLE_TECNICO'>
						<li><a href="/Sistema/report/list/"><i
								class="fa fa-fw fa-file-text-o"></i>Informes</a></li>
					</sec:ifNotGranted>
					
					<sec:ifNotGranted roles='ROLE_SECRETARIA'>
						<li><a href="/Sistema/article/list/"><i class="fa fa-fw fa-medkit"></i>Insumos</a></li>
					</sec:ifNotGranted>
                                        
                                        <sec:ifNotGranted roles='ROLE_SECRETARIA'>
						<li><a href="/Sistema/articleMovement/list/"><i class="fa fa-fw fa-bars"></i>Movimientos de Stock</a></li>
					</sec:ifNotGranted>
					
					<sec:ifNotGranted roles='ROLE_TECNICO, ROLE_SECRETARIA'>
						<li><a href="/Sistema/user/list/"><i
							class="fa fa-fw fa-user"></i>Usuarios</a></li>
					</sec:ifNotGranted>
					


				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>
		
		<div id="page-wrapper">
			
			<g:layoutBody />
			
		</div>
		<div class="pag-footer" align="center">
			<strong>Desarrolladores:</strong> 
			Jorge Esquivel<a href="mailto:jorgeesquivelfernandez@gmail.com?Subject=Laboratorio%20SD2016">(jorgeesquivelfernandez@gmail.com)</a> 
			- Alex Jiñes<a href="mailto:abel.oalex@gmail.com?Subject=Laboratorio%20SD2016">(abel.oalex@gmail.com)</a> 
			- Tania Monges<a href="mailto:taniamonges@gmail.com?Subject=Laboratorio%20SD2016">(taniamonges@gmail.com)</a> 
			- Jerson Paniagua<a href="mailto:diazpany@gmail.com?Subject=Laboratorio%20SD2016">(diazpany@gmail.com)</a> 
			- Fátima Talavera<a href="mailto:fa.talavera95@gmail.com?Subject=Laboratorio%20SD2016">(fa.talavera95@gmail.com)</a> 
			<br> Líder del Proyecto: 
			Ing. Aldo Medina
			<a href="mailto:medinaldo@gmail.com?Subject=Laboratorio%20SD2016">(medinaldo@gmail.com)</a> 
			<br> <strong>Copyright © 2016 - Sistemas Distribuídos - F.I.U.N.I</strong>
		</div>
		
	</div>
</body>

</html>
