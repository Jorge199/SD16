
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
						<strong>Generar Informe</strong>
					</h4>
				</div>
				<div class="panel-body">
					<form action="/Sistema/report/save" method="post" id="report" onsubmit="return saveDataReport();">
					
						<fieldset class="form">
							
							<g:render template="form" />

						</fieldset>
						<fieldset class="buttons">
							<br>
							<div class="col-xs-12" align="center">
									<button type="submit" class="btn btn-primary" name="create"
										value="${reportInstance?.request?.id}">
										<i class="fa fa-floppy-o"></i> Guardar
									</button>
									<a class="btn btn-default" href="/Sistema/request/list"
											role="button"><i class="fa fa-times"></i> Cancelar</a>
								</div>
						

						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
	<br><br><br><br>
	<!-- jQuery -->
	<script src=" ${request.contextPath}/template/js/jquery.js"></script>
	<script src=" ${request.contextPath}/template/js/jquery.validate.js"></script>
	<script src=" ${request.contextPath}/template/js/validationFormReport.js"></script>
</body>
</html>
