
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="template">
<title><g:message code="default.edit.label" args="[entityName]" /></title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>
						<strong>Editar Informacion</strong>
					</h4>
				</div>
				<div class="panel-body">
					<g:form action="update">
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
					</g:form>
				</div>
			</div>
		</div>
	</div>
	<!-- Jasny-Bootstrap JavaScript -->
	<script
		src=" ${request.contextPath}/template/js/jasny-bootstrap.min.js"></script>

	<!-- jQuery -->
	<script src=" ${request.contextPath}/template/js/jquery.js"></script>

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
