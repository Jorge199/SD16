
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="template">
<g:set var="entityName"
	value="${message(code: 'user.label', default: 'User')}" />
<title><g:message code="default.create.label"
		args="[entityName]" /></title>
<asset:stylesheet src="application.css" />
<asset:javascript src="application.js" />
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>
						<strong>Lista de Usuarios</strong>
					</h4>
				</div>
				<div class="panel-body">
					<div class="col-sm-4">
						<a class="btn btn-success" href="/Sistema/user/create"
							role="button"><i class="fa fa-plus"></i> Agregar Usuario</a>


					</div>
					<div class="col-sm-8" align="right">
						<g:form action="list" class="form-search">

							<div class="input-group col-md-6">
								<input type="text" name="text" class="form-control"
									placeholder="Ingrese un texto para buscar" /> <span
									class="input-group-btn">
									<button class="btn btn-primary" name="list" value="Buscar">
										<span class=" glyphicon glyphicon-search"></span>
									</button>
								</span>
							</div>
						</g:form>
					</div>
					<br><br>


					<div class="dataTable_wrapper">
						<div class="row">
							<div class="col-sm-12">

								<table id="list-report"
									class="table table-striped table-bordered" cellspacing="0"
									width="100%">
									<thead>
										<tr>
											<g:sortableColumn property="name" title="Nombre y Apellido" />
											<g:sortableColumn property="password"
												title="Nombre de Usuario" />
											<g:sortableColumn property="rol" title="Rol" />
											<g:sortableColumn property="registrationNumber"
												title="Matricula" />

											<td></td>
										</tr>
									</thead>
									<tbody>


										<g:each in="${userInstanceList}" status="i" var="userInstance">

											<tr>
												<td>
													${fieldValue(bean: userInstance, field: "name")}
												</td>
												<td>
													${fieldValue(bean: userInstance, field: "userName")}
												</td>
												<td>
													${fieldValue(bean: userInstance, field: "rol.name")}
												</td>
												<td>
													${fieldValue(bean: userInstance, field: "registrationNumber")}
												</td>



												<%--  <td>${fieldValue(bean: userInstance, field: "user.id")}</td>		--%>
												<td class="center"><g:link action="edit"
														class="btn btn-success" id="${userInstance.getId()}">
														<i class="fa fa-pencil"></i> Editar</g:link></td>
											</tr>

										</g:each>


									</tbody>
								</table>

								<g:render template="/layouts/paginate" />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br/><br/><br/><br/>
	<script>
		$(document).ready(function() {
			$('#searching').on('propertychange input', function(e) {
				var bla = $('#searching').val();
				if (val.lenght < 3) {
					$('#searching').delay();
				}
			});

		});

		function ajaxSearch(str) {

			if (str.length > 5) {
				alert("entro")
			}

		}
	</script>


	<script>
		function letterDelimiter(str) {

			$(".container-fluid").css("color", "#000000");

		}
	</script>

	<!-- jQuery -->
	<script src=" ${request.contextPath}/template/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
</body>
</html>