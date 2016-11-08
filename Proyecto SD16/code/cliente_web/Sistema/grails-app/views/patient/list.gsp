
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
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>
						<strong>Lista de Pacientes</strong>
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
											<g:sortableColumn property="lastName" title="Apellido" />
											<g:sortableColumn property="document" title="C.I" />
											<g:sortableColumn property="sex" title="Sexo" />
											<g:sortableColumn property="birthDate" title="Fecha de Nac." />
											<g:sortableColumn property="address" title="Direcccion" />
											<g:sortableColumn property="phone" title="Telefono" />
											<td>Acciones</td>
										</tr>
									</thead>
									<tbody>
										<g:each in="${patientInstanceList}" status="i"
										
											var="patientInstance">

											<tr>
												<td>
													${fieldValue(bean: patientInstance, field: "name")}
												</td>
												<td>
													${fieldValue(bean: patientInstance, field: "lastName")}
												</td>
												<td>
													${fieldValue(bean: patientInstance, field: "document")}
												</td>
												<td>
													${fieldValue(bean: patientInstance, field: "sex")}
												</td>
												<td>
													${fieldValue(bean: patientInstance, field: "birthDate")}
												</td>
												<td>
													${fieldValue(bean: patientInstance, field: "address")}
												</td>
												<td>
													${fieldValue(bean: patientInstance, field: "phone")}
												</td>
												
												<%--  <td>${fieldValue(bean: patientInstance, field: "patient.id")}</td>		--%>
												<td class="center">
													<g:link action="show" class="btn btn-primary" id="${patientInstance.getId()}">${}<i class="fa fa-eye"></i> Ver Detalle</g:link>
													<g:link action="edit" class="btn btn-success" id="${patientInstance.getId()}">${}<i class="fa fa-pencil"></i> Editar</g:link>

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