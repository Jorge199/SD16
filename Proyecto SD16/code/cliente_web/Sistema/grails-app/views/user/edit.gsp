
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="template">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
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
								<button type="submit" class="btn btn-success" name="edit" value="${userInstance?.id}">
  									<i class="fa fa-pencil"></i> Actualizar  
								</button>
							</fieldset>
						</g:form>						
					</div>
				</div>
			</div>
		</div>
		
   
    <!-- Bootstrap Core JavaScript -->
    <script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		document.getElementById('update').style.display = 'none';
		document.getElementById('updater').onchange = function() {
			var selectedValue = this.options[this.selectedIndex].text;
			if (selectedValue == "Doctor") {
				document.getElementById('update').style.display = '';
			} else {
				document.getElementById('update').style.display = 'none';
			}
		};
	</script>
	<script language='javascript' type='text/javascript'>
    function check(input) {
        if (input.value != document.getElementById('pass1').value) {
            input.setCustomValidity('Password Must be Matching.');
        } else {
            input.setCustomValidity('');
        }
    }
</script>
</html>
