
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
						<strong>Contacto</strong>
					</h4>
				</div>
				<div class="panel-body">
					<form action="/Sistema/contact/save" method="post" id="contact" onsubmit="return saveDataContact();">
						<fieldset class="form">
							<g:render template="form" />
						</fieldset>
						<fieldset class="buttons">
							<br> <br>
							<div class="col-xs-12" align="center">
									<button type="submit" class="btn btn-primary " name="create"
										value="${message(code: 'default.button.create.label', default: 'Create')}">
										<i class="fa fa-floppy-o"></i> Enviar
									</button>
				
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
	<script src=" ${request.contextPath}/template/js/validationFormContact.js"></script>
		<!-- Bootstrap Core JavaScript -->
	<script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
</body>
</html>