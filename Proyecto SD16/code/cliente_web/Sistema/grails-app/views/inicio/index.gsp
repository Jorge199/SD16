<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="template" />
<title>Bienvenido al Laboratorio</title>

<!-- Morris Charts CSS -->
<link href="${request.contextPath}/template/css/plugins/morris.css?v=1"
	rel="stylesheet">


</head>
<body>

	<div class="container-fluid">

		<!-- Page Heading -->
		<div class="row">
			<div class="col-lg-12">
				<fieldset class="form">
					<g:render contextPath="/laboratory" template="list" />
				</fieldset>
			</div>
		</div>
		<!-- /.row -->

		<!-- /.row -->

		<div class="row">
			<sec:ifAnyGranted roles='ROLE_ADMINISTRADOR,ROLE_DOCTOR'>
			<div class="col-lg-3 col-md-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-3">
								<i class="fa fa-info-circle fa-5x"></i>
							</div>
							<div class="col-xs-9 text-right">

								<div>Informaciòn del Laboratorio</div>
							</div>
						</div>
					</div>
					<a href="/Sistema/laboratory/edit/1">
						<div class="panel-footer">
							<span class="pull-left">Editar</span> <span class="pull-right"><i
								class="fa fa-arrow-circle-right"></i></span>
							<div class="clearfix"></div>
						</div>
					</a>
				</div>
			</div>
			</sec:ifAnyGranted>
			<sec:ifAnyGranted roles='ROLE_ADMINISTRADOR,ROLE_DOCTOR,ROLE_SECRETARIA'>
				<div class="col-lg-3 col-md-6">
					<div class="panel panel-green">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa fa-fw fa-bars fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<g:if test="${requestInstanceList?.size()}">
										<div class="huge">
											${requestInstanceList.size()}
										</div>
									</g:if>
									<g:else>
										<div class="huge">0</div>
									</g:else>
									<div>Fichas recibidas</div>
								</div>
							</div>
						</div>
						<a href="/Sistema/request/list">
							<div class="panel-footer">
								<span class="pull-left">Ver Detalle</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<div class="panel panel-yellow">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-child fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<g:if test="${patientInstanceList?.size()}">
										<div class="huge">
											${patientInstanceList.size()}
										</div>
									</g:if>
									<g:else>
										<div class="huge">0</div>
									</g:else>
									<div>Pacientes</div>
								</div>
							</div>
						</div>
						<a href="/Sistema/patient/list">
							<div class="panel-footer">
								<span class="pull-left">Ver Detalle</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
			</sec:ifAnyGranted>

			<sec:ifAnyGranted roles='ROLE_ADMINISTRADOR,ROLE_DOCTOR,ROLE_TECNICO'>
				<div class="col-lg-3 col-md-6">
					<div class="panel panel-red">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-medkit fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<g:if test="${articleInstanceList?.size()}">
										<div class="huge">
											${articleInstanceList.size()}
										</div>
									</g:if>
									<g:else>
										<div class="huge">0</div>
									</g:else>
									<div>Insumos</div>
								</div>
							</div>
						</div>
						<a href="#">
							<div class="panel-footer">
								<span class="pull-left">Ver Detalle</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
			</sec:ifAnyGranted>

		</div>
		<!-- /.row -->



		<!-- jQuery -->
		<script src=" ${request.contextPath}/template/js/jquery.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>

		<!-- Morris Charts JavaScript -->
		<script
			src=" ${request.contextPath}/template/js/plugins/morris/raphael.min.js"></script>
		<script
			src=" ${request.contextPath}/template/js/plugins/morris/morris.min.js"></script>
		<script
			src=" ${request.contextPath}/template/js/plugins/morris/morris-data.js"></script>
</body>

</html>