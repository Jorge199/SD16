
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
					<div class="col-sm-4">
						<a class="btn btn-success" href="/Sistema/patient/create"
							role="button"><i class="fa fa-plus"></i> Agregar Paciente</a>
					</div>
					<div class="col-sm-8" align="right">
						<g:form action="list" class="form-search">

							<div class="input-group col-md-10">
								<input type="text" name="text" class="form-control" maxlength="50"  value="${text}"
									placeholder="Ingrese un texto para buscar" /> <span
									class="input-group-btn">
									<button class="btn btn-primary" name="list" value="Buscar">
										<span class=" glyphicon glyphicon-search"></span>
									</button>
								</span>
							</div>
						</g:form>
					</div>
					<br> <br> <br> <br> 
					<div class="dataTable_wrapper">
						<div class="row">
							<div class="col-sm-12">
								<table id="list-report"
									class="table table-striped table-bordered" cellspacing="0"
									width="100%">
									<thead>
										<tr>
											
											<g:sortableColumn property="_name" params= "${params}" title="Nombre" ></g:sortableColumn>
											<g:sortableColumn property="_lastName" params= "${params}" title="Apellido" ></g:sortableColumn>
											<g:sortableColumn property="_sex" params= "${params}" title="Sexo" ></g:sortableColumn>
											<g:sortableColumn property="_document" params= "${params}" title="C.I" ></g:sortableColumn>
											<g:sortableColumn property="_birthDate" params= "${params}" title="Fecha de Nac." ></g:sortableColumn>
											<g:sortableColumn property="_address" params= "${params}" title="Direcccion" ></g:sortableColumn>
											<g:sortableColumn property="_phone" params= "${params}" title="Teléfono" ></g:sortableColumn>
											<td></td>
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
													${fieldValue(bean: patientInstance, field: "sex")}
												</td>
												<td class="numbers">
													${fieldValue(bean: patientInstance, field: "document")}
												</td>
												<td>
													${formatDate(format: 'dd-MM-yyyy', date:patientInstance.getBirthDate())}
												</td>
												<td>
													${fieldValue(bean: patientInstance, field: "address")}
												</td>
												<td>
													${fieldValue(bean: patientInstance, field: "phone")}
												</td>

												<%--  <td>${fieldValue(bean: patientInstance, field: "patient.id")}</td>		--%>
												<td width="80" class="center"><g:link action="edit"
														class="btn btn-success" id="${patientInstance.getId()}">
														<i class="fa fa-pencil"></i></g:link></td>
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