
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="template">
	<g:set var="entityName"
		value="${message(code: 'doctor.label', default: 'Doctor')}" />
	<title><g:message code="default.create.label"
			args="[entityName]" /></title>
	<asset:stylesheet src="application.css" />
	<asset:javascript src="application.js" />
	<script src=" ${request.contextPath}/template/js/jquery.js"></script>
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
						<strong>Registrar Doctor</strong>
					</h4>
				</div>
				<div class="panel-body">
					<form action="/Sistema/doctor/save" method="post" id="doctor" onsubmit="return saveData();">
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
</body>
</html>
