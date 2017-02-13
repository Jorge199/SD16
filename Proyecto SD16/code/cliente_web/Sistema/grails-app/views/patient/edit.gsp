
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="template">
	<script src="jquery.validate.js"></script>
	<script src="validationFormPatient.js"></script>
	<script src="jquery.number.js"></script>
</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4><strong>Editar Información del Paciente</strong></h4>
				</div>
				<div class="panel-body">
					<form action="/Sistema/patient/update" method="post" id="patient" onsubmit="return saveDataPa();">
						<fieldset class="form">
							<g:render template="form" />
						</fieldset>
						<fieldset class="buttons">
							<br>
							<div class="col-xs-12" align="center">
									<button type="submit" class="btn btn-primary " name="edit"
										value="${patientInstance?.id}">
										<i class="fa fa-primary"></i> Guardar
									</button>
									<a class="btn btn-default" href="/Sistema/patient/list"
										role="button"><i class="fa fa-times"></i> Cancelar</a>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>

<!-- jQuery -->
	<script src=" ${request.contextPath}/template/js/jquery.js"></script>
	<script src=" ${request.contextPath}/template/js/jquery.validate.js"></script>
	<script src=" ${request.contextPath}/template/js/validationFormPatient.js"></script>
	
	<script src=" ${request.contextPath}/template/js/jquery.number.js"></script>
	<!-- Jasny-Bootstrap JavaScript -->
	<script
		src=" ${request.contextPath}/template/js/jasny-bootstrap.min.js"></script>

	<!-- Moment -->
	<script src=" ${request.contextPath}/template/js/moment.js"></script>
	<script src=" ${request.contextPath}/template/js/es.js"></script>

	<!-- Transition -->
	<script src=" ${request.contextPath}/template/js/transition.js"></script>

	<!-- Collapse -->
	<script src=" ${request.contextPath}/template/js/collapse.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script type="text/javascript">
		$("#phoneNum").mask("(999) 999-9999");
	</script>

	<!-- Bootstrap datetimepicker -->
	<script
		src=" ${request.contextPath}/template/js/bootstrap-datetimepicker.min.js"></script>
	<script
		src=" ${request.contextPath}/template/js/bootstrap-datetimepicker.es.js"></script>

	<link rel="stylesheet"
		href="${request.contextPath}/template/css/bootstrap-datetimepicker.min.css" />
	<script type="text/javascript">
		$(function() {
			$('#datetimepicker1').datetimepicker({
				format : 'DD-MM-YYYY',
				locale : 'es',
			});
		});
	</script>
	<script type="text/javascript">
		$("#phoneNum").mask("(999) 999-9999");
	</script>

</body>
</html>
