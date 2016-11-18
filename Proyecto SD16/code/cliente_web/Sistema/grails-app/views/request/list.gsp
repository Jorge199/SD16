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
												<g:select name="status" class="form-control input-sm"
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
											<input type="text" name="patient" class="form-control input-sm"
									placeholder="Ingrese dato del paciente" />
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
													<input type='text' class="form-control input-sm"
														name="startSearch" /> <span class="input-group-addon">
														<span class="glyphicon glyphicon-calendar"> </span>
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
													<input type='text' class="form-control input-sm"
														name="endSearch" /> <span class="input-group-addon">
														<span class="glyphicon glyphicon-calendar"> </span>
													</span>
												</div>
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


					<div class="dataTable_wrapper">
						<div class="row">
							<div class="col-sm-12">
								<table id="list-request"
									class="table table-striped table-bordered" cellspacing="0"
									width="100%">
									<thead>
										<tr>
											<g:sortableColumn property="id" title="Codigo" />
											<g:sortableColumn property="date" title="Fecha" />
											<g:sortableColumn property="status" title="Estado" />
											<g:sortableColumn property="doctor" title="Doctor" />
											<g:sortableColumn property="patient" title="Paciente" />
											<g:sortableColumn property="studyType"
												title="Tipo de estudio" />
											<td></td>
										</tr>
									</thead>
									<tbody>
										<g:each in="${requestInstanceList}" status="i"
											var="requestInstance">

											<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
												<td>
													${requestInstance?.code }
												</td>
												<td>
													${formatDate(format: 'dd/MM/yyyy', date:requestInstance.getDate())}
												</td>
												<td>
													${requestInstance?.status}
												</td>
												<td>
													${requestInstance?.doctor?.name} ${requestInstance?.doctor?.lastName}
													<br> ${requestInstance?.doctor?.phone}
												</td>
												<td>
													${requestInstance?.patient?.name} ${requestInstance?.patient?.lastName}
													<br> ${requestInstance?.patient?.phone}
												</td>
												<td>
													${requestInstance?.studyType?.name}
												</td>

												<td class="center"><g:link action="edit"
														class="btn btn-success" id="${requestInstance.getId()}">
														${}<i class="fa fa-pencil"></i> Editar</g:link> 
														<sec:ifAnyGranted roles='ROLE_ADMINISTRADOR,ROLE_DOCTOR'>
															<g:if test="${requestInstance?.status==StatusEnum.PROCESADO}">
																<g:link action="create" class="btn btn-default"
																controller="report" id="${requestInstance.getId()}">
																${}<i class="fa fa-list-alt"></i> Informar</g:link>
															</g:if> 
															<g:if test="${requestInstance?.status==StatusEnum.TERMINADO || requestInstance?.status==StatusEnum.RETIRADO}">
																<g:link action="edit" class="btn btn-default"
																controller="report" id="${requestInstance.getId()}">
																${}<i class="fa fa-list-alt"></i> Informe</g:link>
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
	<!-- jQuery -->
	<script src=" ${request.contextPath}/template/js/jquery.js"></script>

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