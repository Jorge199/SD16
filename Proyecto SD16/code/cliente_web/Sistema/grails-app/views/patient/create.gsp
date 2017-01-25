
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="template">
	<g:set var="entityName"
		value="${message(code: 'patient.label', default: 'Patient')}" />
	<title><g:message code="default.create.label"
			args="[entityName]" /></title>
	<asset:stylesheet src="application.css" />
	<asset:javascript src="application.js" />
	<!-- jQuery -->	
	<script src=" ${request.contextPath}/template/js/jquery.js"></script>
	<script src="jquery.validate.js"></script>
	<script src="validationFormPatient.js"></script>
	<script src="jquery.number.js"></script>
</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4><strong>Registrar Paciente</strong></h4>
				</div>
				<div class="panel-body">
					<form action="/Sistema/patient/save" method="post" id="patient" onsubmit="return saveData();">
							<g:render template="form" />
						<fieldset class="buttons">
							<br> <br>
							<div class="col-xs-12" align="center">
									<button type="submit" class="btn btn-primary" id="save" name="create" >
										<i class="fa fa-floppy-o"></i> Guardar
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
				locale : 'es'
			});
			
		});
	</script>
</body>
</html>
