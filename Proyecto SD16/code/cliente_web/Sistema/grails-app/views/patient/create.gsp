
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="template">
	<g:set var="entityName"
		value="${message(code: 'patient.label', default: 'Patient')}" />
	<title><g:message code="default.create.label"
			args="[entityName]" /></title>
	<asset:stylesheet src="application.css" />
	<asset:javascript src="application.js" />
	<!-- jQuery -->	
	<script src=" ${request.contextPath}/template/js/jquery.js"></script>
	<script src="jquery.validate.js"></script>
	<script src="validationFormPatient.js"></script>
	<script src="jquery.number.js"></script>
</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4><strong>Registrar Paciente</strong></h4>
				</div>
				<div class="panel-body">
					<g:form action="save" onsubmit="return saveData();">
							<g:render template="form" />
						<fieldset class="buttons">
							<br> <br>
							<div class="col-xs-12" align="center">
									<button type="submit" class="btn btn-primary" id="save" name="create" >
										<i class="fa fa-floppy-o"></i> Guardar
									</button>
									<a class="btn btn-default" href="/Sistema/patient/list"
										role="button"><i class="fa fa-times"></i> Cancelar</a>	
							</div>
						</fieldset>
					</g:form>
				</div>
			</div>
		</div>
	</div>
	
	<!-- estilo a la validacion -->
  	<style>
		input.error{
		    border: 2px dotted #FF0000; 
		}
		form label.error{
		    font-size: 1em;
		    color: #FF0000;
		    font-weight: bold;
		    display: inline-table;
		}
  	</style>
  	
  	<!-- formato a telefono y documento -->
  	<script type="text/javascript">	
		$(function(){
			$('#phone').number(true, 0 ,',','-');
		});
		
	</script>
	<script type="text/javascript">
		$('#document').on('input', function() {
			if(!isNaN($("#document").val())){
			    var doc = $(this).val().replace(/[^\d]/g, '')
			    if (doc.length == 7) {
			      doc = doc.replace(/(\d{1})(\d{3})(\d{3})/, "$1.$2.$3");
			    } else if (doc.length == 6) {
			      doc = doc.replace(/(\d{3})(\d{3})/, "$1.$2");
			    }
			    $(this).val(doc)
			}
		 });
	</script>
	<!-- Jasny-Bootstrap JavaScript -->
	<script
		src=" ${request.contextPath}/template/js/jasny-bootstrap.min.js"></script>

	
	<!-- Moment -->
	<script src=" ${request.contextPath}/template/js/moment.js"></script>
	<script src=" ${request.contextPath}/template/js/es.js"></script>

	<!-- Transition -->
	<script src=" ${request.contextPath}/template/js/transition.js"></script>

	<!-- Collapse -->
	<script src=" ${request.contextPath}/template/js/collapse.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>

	<!-- Bootstrap datetimepicker -->
	<script
		src=" ${request.contextPath}/template/js/bootstrap-datetimepicker.min.js"></script>
	<script
		src=" ${request.contextPath}/template/js/bootstrap-datetimepicker.es.js"></script>

	<link rel="stylesheet"
		href="${request.contextPath}/template/css/bootstrap-datetimepicker.min.css" />
	<script type="text/javascript">
		$(function() {
			$('#datetimepicker1').datetimepicker({
				format : 'DD-MM-YYYY',
				locale : 'es'
			});
			
		});
	</script>
</body>
</html>
