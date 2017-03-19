<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="template">
<g:set var="entityName"
	value="${message(code: 'articleMovement.label', default: 'ArticleMovement')}" />

</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>
						<strong>Registrar Movimiento de Stock</strong>
					</h4>
				</div>
				
				<div class="panel-body">
					<form action="/Sistema/articleMovement/save" method="post"
						id="articleMovement" onsubmit="return saveDataArticleMovement();">
						<fieldset class="form">
							<g:render template="form" />
						</fieldset>
						<fieldset class="buttons">
							<br> <br>
							<div class="col-xs-12" align="center">
								<button type="submit" class="btn btn-primary " name="create"
									value="${message(code: 'default.button.create.label', default: 'Create')}">
									<i class="fa fa-floppy-o"></i> Guardar
								</button>
								<a class="btn btn-default" href="/Sistema/articleMovement/list"
									role="button"><i class="fa fa-times"></i> Cancelar</a>
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
	<script src=" ${request.contextPath}/template/js/validationFormArticleMovement.js"></script>
	<script src=" ${request.contextPath}/template/js/jquery.number.js"></script>
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
	<script type='text/javascript'>
        (function() {   
            <g:if test='${flash.error}'>
            $('document').ready(function(){
            	alert("Stock insuficiente, solo dispones de " +  +" " + "${params.articleName}");
            	$(".select-article").select2("data", { id: 1, text: "Alcohol A1" });
            	$('#inputID').select2('data', {id: 100, a_key: 'Lorem Ipsum'}).change();
            
                alert("Stock insuficiente, solo dispones de " + ${params.articleQuantity} +" " + "${params.articleName}");
            });
            </g:if>
        })();
    </script>   
</body>
</html>