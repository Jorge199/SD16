
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="template">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
		<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>
		<script src=" ${request.contextPath}/template/js/jquery.js"></script>
		<script src="jquery.validate.js"></script>
		<script src="validationFormUser.js"></script>
	</head>
	<body>
        <div class="container-fluid">
        	<div class="row">
            	<div class="panel panel-default">		
                	<div class="panel-heading">
						<h4><strong>Registrarse</strong></h4>
					</div>
					<div class="panel-body">
						<form action="/Sistema/user/save" method="post" id="user"  onsubmit="return saveData();" >
							<fieldset class="form">
								<g:render template="form"/>
							</fieldset>
							<fieldset class="buttons">
								<div class="col-xs-12" align="center">
										<button type="submit" class="btn btn-primary" name="edit" value="${userInstance?.id}">
		  									<i class="fa fa-save"></i> Guardar  
										</button>
										<a class="btn btn-default" href="/Sistema/user/list"
										role="button"><i class="fa fa-times"></i> Cancelar</a>
									
								</div>
							</fieldset>
						</form>						
					</div>
				</div>
			</div>
		</div>
		<br><br><br><br>
		<!-- Bootstrap Core JavaScript -->
    <script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
    <script type="text/javascript">
	window.onload=function() {
		document.getElementById('updatePass').style.display = '';
		document.getElementById('confirmPass').style.display = '';
	};
	  </script>
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
