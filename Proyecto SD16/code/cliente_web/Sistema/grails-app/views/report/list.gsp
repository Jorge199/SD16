
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="template">
<g:set var="entityName"
	value="${message(code: 'report.label', default: 'Report')}" />
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
						<strong>Lista de Informes</strong>
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
											<g:sortableColumn property="id" title="ID" />
											<g:sortableColumn property="date" title="Date" />
											<g:sortableColumn property="diagnostic" title="Diagnostico" />
											<g:sortableColumn property="observation" title="Observaciones" />
											<td>Acciones</td>
										</tr>
									</thead>
									<tbody>
										<g:each in="${reportInstanceList}" status="i"
										
											var="reportInstance">

											<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
												<td><g:link action="show" id="${reportInstance.id}">
														${fieldValue(bean: reportInstance, field: "id")}
													</g:link></td>
												<td>
													${fieldValue(bean: reportInstance, field: "date")}
												</td>
												<td>
													${fieldValue(bean: reportInstance, field: "diagnostic")}
												</td>
												<td>
													${fieldValue(bean: reportInstance, field: "observations")}
												</td>
												
												<%--  <td>${fieldValue(bean: reportInstance, field: "request.id")}</td>		--%>
												<td class="center">
													<g:link action="show" class="btn btn-primary" id="${reportInstance.getId()}">${}<i class="fa fa-eye"></i> Ver Detalle</g:link>
													<g:link action="edit" class="btn btn-success" id="${reportInstance.getId()}">${}<i class="fa fa-pencil"></i> Editar</g:link>
													<g:link action="delete" class="btn btn-danger" id="${reportInstance.getId()}">${}<i class="fa fa-trash-o"></i> Eliminar</g:link>
									

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