<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="template">
	<script src="jquery.validate.js"></script>
	<script src="validationModalPatient.js"></script>
	<script src="validationModalDoctor.js"></script>
	<script src="validationFormRequest.js"></script>
	<script src="jquery.number.js"></script>
</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>
						<strong>Registrar Ficha de Entrada</strong>
					</h4>
				</div>
				<div class="panel-body">
						<fieldset class="form">
							<g:render template="form" />
						</fieldset>
				</div>
			</div>
		</div>
	</div>
	<br><br><br><br>
	
			

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
			$('#datetimepicker2').datetimepicker({
				format : 'DD-MM-YYYY',
				locale : 'es',
			});
		});
	</script>
</body>
</html>
