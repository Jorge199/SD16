<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="template">
<g:set var="entityName"
	value="${message(code: 'request.label', default: 'Request')}" />
<title><g:message code="default.create.label"
		args="[entityName]" /></title>
<asset:stylesheet src="application.css" />
<asset:javascript src="application.js" />
</head>
<body>
	<%@ page import="com.sd.uni.labpatologia.util.StatusEnum"%>


	<div class="container-fluid">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>
						<strong>Lista de Fichas </strong>
					</h4>
				</div>
				<div class="panel-body">
					<g:if test="${flash.message}">
						<div class="message" role="status">
							${flash.message}
						</div>
					</g:if>
					<div class="row">
						<div class="col-md-4">
							<a class="btn btn-success" href="/Sistema/request/create"
								role="button"><i class="fa fa-plus"></i> Agregar Ficha</a>
						</div>
						<br> <br>
						<div class="panel-body">
							<g:form action="list">
								<div class="col-md-4">

									<div
										class="fieldcontain ${hasErrors(bean: requestInstance, field: 'status', 'error')} required">
										<label class="col-md-3" for="status"> <g:message
												code="Estado" />
										</label>
										<div class="col-md-9">
											<div class="form-group">
												<g:select name="status" class="form-control"
													from="${StatusEnum.values()}" name="statusSearch"
													optionKey="key"
													noSelection="${['null':'Seleccione un estado..']}"
													required=""></g:select>
											</div>
										</div>
									</div>

									<div class="col-md-3">
										<label for="patient"> <g:message code="Paciente" />
										</label>
									</div>
									<div class="col-md-9">
										<div class="form-group">
											<input type="text" name="patient"
												class="form-control" placeholder=" Ingrese dato del paciente" />
										</div>
									</div>
									<div class="col-md-3">
										<label for="specimen"> <g:message code="Espécimen" />
										</label>
									</div>
									<div class="col-md-9">
										<div class="form-group">
											<input type="text" name="specimen"
												class="form-control" placeholder=" Ingrese el espécimen" />
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div
										class="fieldcontain ${hasErrors(bean: requestInstance, field: 'start', 'error')} required">
										<div class="col-md-4">
											<label for="start"> <g:message code="Desde Fecha" />
											</label>
										</div>
										<div class="col-md-5">
											<div class="form-group">
												<div class='input-group date' id='datetimepicker1'>
													<input type='text' class="form-control " name="startSearch" placeholder="Seleccione una fecha"/>
													<span class="input-group-addon"> <span
														class="glyphicon glyphicon-calendar"> </span>
													</span>
												</div>
											</div>
										</div>
										<div class="col-md-4">
											<label for="start"> <g:message code="Hasta Fecha" />
											</label>
										</div>
										<div class="col-md-5">
											<div class="form-group">
												<div class='input-group date' id='datetimepicker2'>
													<input type='text' class="form-control" name="endSearch" placeholder="Seleccione una fecha"/>
													<span class="input-group-addon"> <span
														class="glyphicon glyphicon-calendar"> </span>
													</span>
												</div>
											</div>
										</div>
										<div class="col-md-4">
										<label for="code"> <g:message code="Código" />
										</label>
									</div>
									<div class="col-md-5">
										<div class="form-group">
											<input type="text" name="code"
												class="form-control" placeholder=" Ingrese el código" />
										</div>
									</div>
									</div>
								</div>

								<fieldset class="buttons">
									<button type="submit" class="btn btn-primary" name="list">
										<i class="fa fa-search"></i> Buscar
									</button>
									<br>
								</fieldset>

							</g:form>
						</div>
					</div>
								
					<br>
					<br>
					<div class="dataTable_wrapper">
						<div class="row">
							<div class="col-sm-12">
								<table id="list-request" class="table table-bordered" cellspacing="0" width="100%">
									<thead>
										<tr>
											<g:sortableColumn property="id" title="Codigo" />
											<g:sortableColumn property="date" title="Fecha" />
											<g:sortableColumn property="status" title="Estado" />
											<g:sortableColumn property="doctor" title="Doctor" />
											<g:sortableColumn property="patient" title="Paciente" />
											<g:sortableColumn property="studyType" 
												title="Tipo de estudio" />
											<g:sortableColumn property="specimen" title="Espécimen" />
											<td colspan="2" align="center">Acciones</td>
										</tr>
									</thead>
									<tbody>
										<g:each in="${requestInstanceList}" status="i"
											var="requestInstance">

											<tr align="center">
												<td width="9%">
													${requestInstance?.code }
												</td>
												<td width="5%">
													${formatDate(format: 'dd/MM/yyyy', date:requestInstance.getDate())}
												</td>
												<td width="9%">
												<g:if test="${requestInstance?.status==StatusEnum.RECIBIDO}">
													<h4><span class="label label-danger label-col-lg" >Recibido</span></h4>
												</g:if>
												<g:elseif test="${requestInstance?.status==StatusEnum.PROCESO}">
													<h4><span class="label label-warning">Proceso</span></h4>
												</g:elseif>
												<g:elseif test="${requestInstance?.status==StatusEnum.PROCESADO}">
													<h4><span class="label label-info">Procesado</span></h4>
												</g:elseif>
												<g:elseif test="${requestInstance?.status==StatusEnum.TERMINADO}">
													<h4><span class="label label-success">Terminado</span></h4>
												</g:elseif>
												<g:else>
													<h4><span class="label label-default col-lg">Retirado</span></h4>
												</g:else>
												</td>
												<td width="15%">
													${requestInstance?.doctor?.name} ${requestInstance?.doctor?.lastName}
													<br> ${requestInstance?.doctor?.phone}
												</td>
												<td width="15%"> 
													${requestInstance?.patient?.name} ${requestInstance?.patient?.lastName}
													<br> ${requestInstance?.patient?.phone}
												</td>
												<td width="12%">
													${requestInstance?.studyType?.name}
												</td>
												<td width="20%">
													${requestInstance?.specimen}
												</td>


												<sec:ifAnyGranted roles='ROLE_ADMINISTRADOR,ROLE_DOCTOR'>
													<g:if
														test="${requestInstance?.status==StatusEnum.TERMINADO || requestInstance?.status==StatusEnum.RETIRADO}">
														<td align="center" width="12%"><g:jasperReport
																action="generateReport" controller="report"
																format="PDF,DOCX" jasper="report"
																id="${requestInstance.getId()}">
																<input type="hidden" name="id"
																	value="${requestInstance.getId()}" />Descargar
																</g:jasperReport></td>
													</g:if>
													<g:else><td width="12%"></td></g:else>
												</sec:ifAnyGranted>
												<td align="center" width="12%"><g:link action="edit"
														class="btn btn-success" id="${requestInstance.getId()}">
														<i class="fa fa-pencil"></i> Editar</g:link> 
													<sec:ifAnyGranted
														roles='ROLE_ADMINISTRADOR,ROLE_DOCTOR'>
														<g:if test="${requestInstance?.status==StatusEnum.PROCESADO}">
															<g:link action="create" class="btn btn-default"
																controller="report" id="${requestInstance.getId()}">
																<i class="fa fa-list-alt"></i> Informar</g:link>
														</g:if>
														<g:if test="${requestInstance?.status==StatusEnum.TERMINADO || requestInstance?.status==StatusEnum.RETIRADO}">
															<g:link action="edit" class="btn btn-default"
																params="[reportEdit: 'request']" controller="report"
																id="${requestInstance.getId()}">
																<i class="fa fa-list-alt"></i> Informe</g:link>
														</g:if>
													</sec:ifAnyGranted> 
													<sec:ifAnyGranted
														roles='ROLE_SECRETARIA'>
														<g:if test="${requestInstance?.status==StatusEnum.TERMINADO || requestInstance?.status==StatusEnum.RETIRADO}">
														<g:link action="show" class="btn btn-default"
														params="[reportShow: 'request']"
																controller="report" id="${requestInstance.getId()}">
																<i class="fa fa-list-alt"></i> Informe</g:link>
																</g:if>
														</sec:ifAnyGranted>
														
													</td>
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
	<br />
	<br />
	<br />
	<br />
	<!-- jQuery -->
	<script src=" ${request.contextPath}/template/js/jquery.js"></script>
	<script src=" ${request.contextPath}/template/js/jquery.validate.js"></script>
	<script src=" ${request.contextPath}/template/js/validationModalPatient.js"></script>
	<script src=" ${request.contextPath}/template/js/validationModalDoctor.js"></script>
	<script src=" ${request.contextPath}/template/js/validationFormRequest.js"></script>
	<script src=" ${request.contextPath}/template/js/jquery.number.js"></script>

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
				locale : 'es',
			});
		});
	</script>
	<script type="text/javascript">
		$(function() {
			$('#datetimepicker2').datetimepicker({
				format : 'DD-MM-YYYY',
				locale : 'es'
			});
		});
	</script>
</body>
</html>