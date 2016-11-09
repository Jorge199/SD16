
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="template">
<g:set var="entityName"
	value="${message(code: 'doctor.label', default: 'Doctor')}" />
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
						<strong>Lista de Doctores</strong>
					</h4>
				</div>
				<div class="panel-body">
					<g:if test="${flash.message}">
						<div class="message" role="status">
							${flash.message}
						</div>
					</g:if>
                                        
                                        <g:form action="list">
   					<g:textField name="text" />
   					<g:submitButton name="list" value="Buscar" class="btn btn-primary" />
						</g:form>
                                        
					<div class="dataTable_wrapper">
						<div class="row">
							<div class="col-sm-12">
								<table id="list-report"
									class="table table-striped table-bordered" cellspacing="0"
									width="100%">
									<thead>
										<tr>
											<g:sortableColumn property="name" title="Nombre" />
                                                                                        <g:sortableColumn property="last_name" title="Apellido" />
                                                                                        <g:sortableColumn property="ci" title="C.I" />
											<g:sortableColumn property="address" title="Direcccion" />
											<g:sortableColumn property="email" title="Correo" />
											<g:sortableColumn property="phone" title="Telefono" />
											<td>Acciones</td>
										</tr>
									</thead>
									<tbody>
										<g:each in="${doctorInstanceList}" status="i"
										
											var="doctorInstance">

											<tr>
												<td>
													${fieldValue(bean: doctorInstance, field: "name")}
												</td>
                                                                                                <td>
													${fieldValue(bean: doctorInstance, field: "lastName")}
												</td>
                                                                                                <td>
													${fieldValue(bean: doctorInstance, field: "ci")}
												</td>
												<td>
													${fieldValue(bean: doctorInstance, field: "address")}
												</td>
												<td>
													${fieldValue(bean: doctorInstance, field: "email")}
												</td>
												<td>
													${fieldValue(bean: doctorInstance, field: "phone")}
												</td>
												
												<%--  <td>${fieldValue(bean: laboratoryInstance, field: "laboratory.id")}</td>		--%>
												<td class="center">
													<g:link action="show" class="btn btn-primary" id="${doctorInstance.getId()}">${}<i class="fa fa-eye"></i> Ver Detalle</g:link>
													<g:link action="edit" class="btn btn-success" id="${doctorInstance.getId()}">${}<i class="fa fa-pencil"></i> Editar</g:link>

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