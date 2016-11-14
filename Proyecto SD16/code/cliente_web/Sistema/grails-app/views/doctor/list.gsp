
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
					<div class="col-sm-4">
						<a class="btn btn-success" href="/Sistema/doctor/create"
							role="button"><i class="fa fa-plus"></i> Agregar Doctor</a>


					</div>
					<div class="col-sm-6">
						<g:form action="list" class="form-search">

							<div class="input-group col-md-10">
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
					<br> <br> <br>
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
											<g:sortableColumn property="speciality" title="Especialidad" />
											<g:sortableColumn property="phone" title="Telefono" />
											<g:sortableColumn property="email" title="Correo" />
											<g:sortableColumn property="address" title="Direcccion" />
											<td></td>
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
													${fieldValue(bean: doctorInstance, field: "speciality")}
												</td>
												<td>
													${fieldValue(bean: doctorInstance, field: "phone")}
												</td>

												<td>
													${fieldValue(bean: doctorInstance, field: "email")}
												</td>

												<td>
													${fieldValue(bean: doctorInstance, field: "address")}
												</td>
												<%--  <td>${fieldValue(bean: laboratoryInstance, field: "laboratory.id")}</td>		--%>
												<td class="center"><g:link action="edit"
														class="btn btn-success" id="${doctorInstance.getId()}">
														${}<i class="fa fa-pencil"></i> Editar</g:link></td>
											</tr>

										</g:each>

									</tbody>
								</table>
								<div class="panel-body">
									<g:form action="list">
										<g:hiddenField name="text" value="${text}" />
										<g:if test="${page > 0}">
											<fieldset class="buttons col-sm-1">
												<button type="submit" class="btn btn-default" name="page" value="${page - 1}">
													<i class="fa fa-arrow-left"></i> Anterior 
												</button>
											</fieldset>
										</g:if>
										<g:if test="${siguiente > 0}">
											<fieldset class="buttons col-sm-1">
												<button type="submit" class="btn btn-default" name="page" value="${page + 1}">
													<i class="fa fa-arrow-right"></i> Siguiente 
												</button>
											</fieldset>
										</g:if>
									</g:form>
								</div>
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