<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="template">
</head>
<body>
	
	<div class="container-fluid">
        	<div class="row">
            	<div class="panel panel-default">		
                	<div class="panel-heading">
						<h4><strong>Actualizar ficha</strong></h4>
					</div>
					<div class="panel-body">
							<fieldset class="form">
								<g:render template="form"/>
							</fieldset>
					</div>
				</div>
			</div>
		</div>
		
<!-- jQuery -->
	<script src=" ${request.contextPath}/template/js/jquery.js"></script>
	<script src=" ${request.contextPath}/template/js/jquery.validate.js"></script>
	<script src=" ${request.contextPath}/template/js/validationModalPatient.js"></script>
	<script src=" ${request.contextPath}/template/js/validationModalDoctor.js"></script>
	<script src=" ${request.contextPath}/template/js/validationFormRequest.js"></script>
	<script src=" ${request.contextPath}/template/js/jquery.number.js"></script>
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
				locale : 'es',
				maxDate : 'now'
			});
		});
	</script>
</body>
</html>