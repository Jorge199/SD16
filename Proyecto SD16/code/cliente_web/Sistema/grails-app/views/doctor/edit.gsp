
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="template">
	<script src="jquery.validate.js"></script>
	<script src="validationFormDoctor.js"></script>
	<script src="jquery.number.js"></script>
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
					<form action="/Sistema/doctor/update" method="post" id="doctor" onsubmit="return saveData();">
						<fieldset class="form">
							<g:render template="form" />
						</fieldset>
						<fieldset class="buttons">
							<br>
							<div class="col-xs-12" align="center">
									<button type="submit" class="btn btn-primary " name="edit"
										value="${doctorInstance?.id}">
										<i class="fa fa-primary"></i> Guardar
									</button>
									<a class="btn btn-default" href="/Sistema/doctor/list"
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
	<script type="text/javascript">
		$("#phoneNum").mask("(999) 999-9999");
	</script>

</body>
</html>
