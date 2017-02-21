
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
						<h4><strong>Editar Información</strong></h4>
					</div>
					<div class="panel-body">
						<form action="/Sistema/user/update" method="post" id="user"  onsubmit="return saveDataUser();" >
							<fieldset class="form">
								<g:render template="form"/>
							</fieldset>
							<fieldset class="buttons">
								<br><br>
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
		
   <script src=" ${request.contextPath}/template/js/jquery.js"></script>
	<script src=" ${request.contextPath}/template/js/jquery.validate.js"></script>
	<script src=" ${request.contextPath}/template/js/validationUserEdit.js"></script>
	<script src=" ${request.contextPath}/template/js/jquery.number.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
 
<script type="text/javascript">
	window.onload=function() {
		var element = document.getElementById('updater')
		 var selectedValue =  element.options[element.selectedIndex].text; 
		 if (selectedValue == "Doctor") { 
	    	    document.getElementById('update').style.display = '';
	    }
	};
    
    document.getElementById('updater').onchange = function () {
    	  var selectedValue = this.options[this.selectedIndex].text; 
    	  if (selectedValue == "Doctor") { 
    	    document.getElementById('update').style.display = '';
    	  }else{
    		  document.getElementById('update').style.display = 'none'; 
        	  }
    	};
    </script>
	<script type='text/javascript'>
    function check(input) {
        if (input.value != document.getElementById('pass1').value) {
            input.setCustomValidity('Password Must be Matching.');
        } else {
            input.setCustomValidity('');
        }
    }
</script>
</html>
