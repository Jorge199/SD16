
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
					<h4>
						<strong>Registrar Doctor</strong>
					</h4>
				</div>
				<div class="panel-body">
					<form action="/Sistema/doctor/save" method="post" id="doctor" onsubmit="return saveDataDoc();">
						<fieldset class="form">
							<g:render template="form" />
						</fieldset>
						<fieldset class="buttons">
							<br>
							<div class="col-xs-12" align="center">
									<button type="submit" class="btn btn-primary " name="create"
										value="${message(code: 'default.button.create.label', default: 'Create')}">
										<i class="fa fa-floppy-o"></i> Guardar
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
	 <!-- jQuery -->
	<script src=" ${request.contextPath}/template/js/jquery.js"></script>
	<script src=" ${request.contextPath}/template/js/jquery.validate.js"></script>
	<script src=" ${request.contextPath}/template/js/validationFormDoctor.js"></script>
</body>
</html>
