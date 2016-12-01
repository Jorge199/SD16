
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
					<br> <br> 
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
												<td class="numbers">
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
												<td width="80" class="center"><g:link action="edit"
														class="btn btn-success" id="${doctorInstance.getId()}">
														<i class="fa fa-pencil"></i> Editar</g:link></td>
											</tr>

										</g:each>
									</tbody>
								</table>
								<g:render template="/layouts/paginate"/>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br/><br/><br/><br/>
	<!-- jQuery -->
	<script src=" ${request.contextPath}/template/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
</body>
</html>