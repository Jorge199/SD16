
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
					<g:if test="${flash.message}">
						<div class="message" role="status">
							${flash.message}
						</div>
					</g:if>
					<div class="dataTable_wrapper">
						<div class="row">
							<div class="col-sm-12">
								<table id="list-report"
									class="table table-striped table-bordered" cellspacing="0"
									width="100%">
									<thead>
										<tr>
											<g:sortableColumn property="name" title="Nombre" />
											<g:sortableColumn property="password" title="Contraseña" />
											<g:sortableColumn property="rol" title="Rol" />
											
											<td>Acciones</td>
										</tr>
									</thead>
									<tbody>
										<g:each in="${userInstanceList}" status="i"
										
											var="userInstance">

											<tr>
												<td>
													${fieldValue(bean: userInstance, field: "name")}
												</td>
												<td>
													${fieldValue(bean: userInstance, field: "password")}
												</td>
												<td>
													${fieldValue(bean: userInstance, field: "rol.name")}
												</td>
												
												
												<%--  <td>${fieldValue(bean: userInstance, field: "user.id")}</td>		--%>
												<td class="center">
													<g:link action="show" class="btn btn-primary" id="${userInstance.getId()}">${}<i class="fa fa-eye"></i> Ver Detalle</g:link>
													<g:link action="edit" class="btn btn-success" id="${userInstance.getId()}">${}<i class="fa fa-pencil"></i> Editar</g:link>

												</td>
											</tr>

										</g:each>

									</tbody>
								</table>
								<div class="pagination"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery -->
	<script src=" ${request.contextPath}/template/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
</body>
</html>