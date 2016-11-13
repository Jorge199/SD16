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
<title>Template</title>

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
				<a href="#" class="navbar-brand"><strong>
					<g:each in="${laboratoryInstanceList}" status="i" var="laboratoryInstance">
						<g:if test="${laboratoryInstance?.name}">
						<h4><strong>${fieldValue(bean: laboratoryInstance, field: "name")}</strong></h4>
						</g:if>
					</g:each>
				</strong></a>
			</div>
			<!-- Top Menu Items -->
			<ul class="nav navbar-right top-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-envelope"></i> <b
						class="caret"></b></a>
					<ul class="dropdown-menu message-dropdown">
						<li class="message-preview"><a href="#">
								<div class="media">
									<span class="pull-left"> <img class="media-object"
										src="http://placehold.it/50x50" alt="">
									</span>
									<div class="media-body">
										<h5 class="media-heading">
											<strong>John Smith</strong>
										</h5>
										<p class="small text-muted">
											<i class="fa fa-clock-o"></i> Yesterday at 4:32 PM
										</p>
										<p>Lorem ipsum dolor sit amet, consectetur...</p>
									</div>
								</div>
						</a></li>
						<li class="message-preview"><a href="#">
								<div class="media">
									<span class="pull-left"> <img class="media-object"
										src="http://placehold.it/50x50" alt="">
									</span>
									<div class="media-body">
										<h5 class="media-heading">
											<strong>John Smith</strong>
										</h5>
										<p class="small text-muted">
											<i class="fa fa-clock-o"></i> Yesterday at 4:32 PM
										</p>
										<p>Lorem ipsum dolor sit amet, consectetur...</p>
									</div>
								</div>
						</a></li>
						<li class="message-preview"><a href="#">
								<div class="media">
									<span class="pull-left"> <img class="media-object"
										src="http://placehold.it/50x50" alt="">
									</span>
									<div class="media-body">
										<h5 class="media-heading">
											<strong>John Smith</strong>
										</h5>
										<p class="small text-muted">
											<i class="fa fa-clock-o"></i> Yesterday at 4:32 PM
										</p>
										<p>Lorem ipsum dolor sit amet, consectetur...</p>
									</div>
								</div>
						</a></li>
						<li class="message-footer"><a href="#">Read All New
								Messages</a></li>
					</ul></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-list"></i> <b
						class="caret"></b></a></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-bell"></i> <b
						class="caret"></b></a>
					<ul class="dropdown-menu alert-dropdown">
						<li><a href="#">Alert Name <span
								class="label label-default">Alert Badge</span></a></li>
						<li><a href="#">Alert Name <span
								class="label label-primary">Alert Badge</span></a></li>
						<li><a href="#">Alert Name <span
								class="label label-success">Alert Badge</span></a></li>
						<li><a href="#">Alert Name <span class="label label-info">Alert
									Badge</span></a></li>
						<li><a href="#">Alert Name <span
								class="label label-warning">Alert Badge</span></a></li>
						<li><a href="#">Alert Name <span
								class="label label-danger">Alert Badge</span></a></li>
						<li class="divider"></li>
						<li><a href="#">View All</a></li>
					</ul></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-user"></i> Usuario <b
						class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#"><i class="fa fa-fw fa-user"></i> Cuenta</a></li>
						<li><a href="#"><i class="fa fa-fw fa-envelope"></i> Chat</a>
						</li>
						<li><a href="#"><i class="fa fa-fw fa-gear"></i>
								Configuracion</a></li>
						<li class="divider"></li>
						<li><a href="#"><i class="fa fa-fw fa-power-off"></i>
								Salir</a></li>
					</ul></li>
			</ul>
			<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li><a href="/Sistema/inicio/index"><i
							class="fa fa-fw fa-bars"></i>Menu</a></li>
					<li><a href="/Sistema/request/list/"><i
							class="fa fa-fw fa-file-text"></i>Fichas de Entradas</a></li>

					<li><a href="/Sistema/patient/list/"><i
							class="fa fa-fw fa-user"></i>Pacientes</a></li>

					<li><a href="/Sistema/doctor/list/"><i
							class="fa fa-fw fa-user-md"></i>Doctores</a></li>

					<li><a href="/Sistema/report/list/"><i
							class="fa fa-fw fa-file-text-o"></i>Informes</a></li>

					<li><a href="#"><i
							class="fa fa-fw fa-medkit"></i>Insumos</a></li>


				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>

		<div id="page-wrapper">
			<g:layoutBody />
		</div>
		<div class="panel-footer" align="center">
			Desarrolladores: 
				<a href="mailto:jorgeesquivelfernandez@gmail.com?Subject=Laboratorio%20SD2016">Jorge Esquivel</a> - 
				<a href="mailto:jabel.oalex@gmail.com?Subject=Laboratorio%20SD2016">Alex Jiñes</a> -
				<a href="mailto:taniamonges@gmail.com?Subject=Laboratorio%20SD2016">Tania Monges</a> 
				<br> <a href="mailto:diazpany@gmail.com?Subject=Laboratorio%20SD2016">Jerson Paniagua</a> - 
				<a href="mailto:fa.talavera95@gmail.com?Subject=Laboratorio%20SD2016">Fátima Talavera</a> 
				<br> Líder del Proyecto: <a href="mailto:medinaldo@gmail.com?Subject=Laboratorio%20SD2016">Ing. Aldo Medina</a>
				
				<br> <strong>Copyright © 2016 - Sistemas Distribuídos - F.I.U.N.I</strong>
		</div>
	</div>
</body>

</html>
