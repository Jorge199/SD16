
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="template">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
		<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>
	</head>
	<body>
        <div class="container-fluid">
        	<div class="row">
            	<div class="panel panel-default">		
                	<div class="panel-heading">
						<h4><strong>Registrarse</strong></h4>
					</div>
					<div class="panel-body">
						<g:form action="save" >
							<fieldset class="form">
								<g:render template="form"/>
							</fieldset>
							<fieldset class="buttons">
								<div class="col-xs-10">
									<div class="text-right">
										<button type="submit" class="btn btn-primary" name="edit" value="${userInstance?.id}">
		  									<i class="fa fa-save"></i> Guardar  
										</button>
										<a class="btn btn-default" href="/Sistema/user/list"
										role="button"><i class="fa fa-times"></i> Cancelar</a>
									</div>
								</div>
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
    document.getElementById('updater').onchange = function () {
    	  var selectedValue = this.options[this.selectedIndex].text; 
    	  if (selectedValue == "Doctor") { 
    	    document.getElementById('update').style.display = '';
    	  }else{
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
	</body>
	
</html>
