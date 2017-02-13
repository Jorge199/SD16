
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="template">
		<g:set var="entityName" value="${message(code: 'laboratory.label', default: 'Laboratory')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
       <div class="container-fluid">
        	<div class="row">
            	<div class="panel panel-default">		
                	<div class="panel-heading">
						<h4><strong>Editar Informacion</strong></h4>
					</div>
					<div class="panel-body">
						<g:form action="update" >
							<fieldset class="form">
								<g:render template="form"/>
							</fieldset>
							<fieldset class="buttons">
								<br>
								<button type="submit" class="btn btn-success" name="edit" value="${laboratoryInstance?.id}">
  									<i class="fa fa-floppy-o"></i> Guardar  
								</button>
							</fieldset>
						</g:form>						
					</div>
				</div>
			</div>
		</div>
		<!-- jQuery -->
	<script src=" ${request.contextPath}/template/js/jquery.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
    <!-- Jasny-Bootstrap JavaScript -->
	<script src=" ${request.contextPath}/template/js/jasny-bootstrap.min.js"></script>
	<script type="text/javascript">
		$("#phoneNum").mask("(000) 999-999");
	</script>
</html>