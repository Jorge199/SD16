
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
						<strong>Actualizar Informe</strong>
					</h4>
				</div>
				<div class="panel-body">
					<form action="/Sistema/report/update" method="post" id="report" onsubmit="return saveDataReport();">
						<fieldset class="form">
							<g:render template="form" />
						</fieldset>
						<fieldset class="buttons">
							<br>
							<div class="col-xs-12" align="center">
									<g:hiddenField name="reportEdit" value="${reportEdit}" />
									<button type="submit" class="btn btn-primary" name="edit"
										value="${reportInstance?.id}">
										<i class="fa fa-save"></i> Guardar
									</button>
									<g:if test="${reportEdit.equals("request")}">
										<a class="btn btn-default" href="/Sistema/request/list"
											role="button"><i class="fa fa-times"></i> Cancelar</a>
									</g:if>
									<g:else>
										<a class="btn btn-default" href="/Sistema/report/list"
											role="button"><i class="fa fa-times"></i> Cancelar</a>
									</g:else>

								
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
	<!-- Bootstrap Core JavaScript -->
	<script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>

</body>
</html>
