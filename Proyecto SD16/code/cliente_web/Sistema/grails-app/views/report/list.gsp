
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
	<%@ page import="com.sd.uni.labpatologia.util.DiagnosticEnum"%>
	
	


	<div class="container-fluid">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>
						<strong>Lista de Informes </strong>
					</h4>

				</div>
				<div class="panel-body">
					<g:if test="${flash.message}">
						<div class="message" role="status">
							${flash.message}
						</div>
					</g:if>
					<div class="row">
						<div class="panel-body">
							<g:form action="list">
								<div class="col-md-4">
									<div
										class="fieldcontain ${hasErrors(bean: reportInstance, field: 'diagnostic', 'error')} required">
										<label class="col-sm-3" for="diagnostic"> <g:message
												code="Diagnostico" />
										</label>
										<div class="col-md-9">
											<g:select name="diagnostic" class="form-control selectpicker"
												from="${DiagnosticEnum.values()}" value="${}"
												name="diagnosticSearch" optionKey="key"
												noSelection="${['null':'Seleccione un diagnostico..']}"
												required=""></g:select>
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div
										class="fieldcontain ${hasErrors(bean: reportInstance, field: 'start', 'error')} required">
										<div class="col-md-4">
											<label for="start"> <g:message
													code="Desde (Fecha de Informe)" />
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
											<label for="start"> <g:message
													code="Hasta (Fecha de Informe)" />
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
								</fieldset>
							</g:form>
						</div>
					</div>


					<div class="dataTable_wrapper">
						<div class="row">
							<div class="col-sm-12">
								<table id="list-report"
									class="table table-striped table-bordered" cellspacing="0"
									width="100%">
									<thead>
										<tr>
											<g:sortableColumn property="request"
												title="Código de Solicitud" />
											<g:sortableColumn property="date_request"
												title="Fecha de Solicitud" />
											<g:sortableColumn property="date_report"
												title="Fecha de Informe" />
											<g:sortableColumn property="patient" title="Paciente" />
											<g:sortableColumn property="doctor" title="Doctor" />
											<g:sortableColumn property="diagnostic" title="Diagnostico" />
											<td></td>
										</tr>
									</thead>
									<tbody>
										<g:each in="${reportInstanceList}" status="i"
											var="reportInstance">

											<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
												<td><g:link action="edit" controller="request"
														id="${reportInstance.request.id}">
														${fieldValue(bean: reportInstance, field: "request.code")}
													</g:link></td>

												<td>
													${formatDate(format: 'dd/MM/yyyy', date:reportInstance.getRequest().getDate())}
												</td>
												<td>
													${formatDate(format: 'dd/MM/yyyy', date:reportInstance.getDate())}
												</td>
												<td>
													${fieldValue(bean: reportInstance, field: "request.patient.name")}
													${fieldValue(bean: reportInstance, field: "request.patient.lastName")}
												</td>
												<td>
													${fieldValue(bean: reportInstance, field: "request.doctor.name")}
													${fieldValue(bean: reportInstance, field: "request.doctor.lastName")}
												</td>
												<td>
													${fieldValue(bean: reportInstance, field: "diagnostic")}
												</td>

												<%--  <td>${fieldValue(bean: reportInstance, field: "request.id")}</td>		--%>
												<sec:ifAnyGranted roles='ROLE_ADMINISTRADOR,ROLE_DOCTOR'>
													<td class="center"><g:link action="edit"
															class="btn btn-success" id="${reportInstance.getId()}">
															${}<i class="fa fa-pencil"></i> Editar</g:link>
												</sec:ifAnyGranted>
												<sec:ifAnyGranted roles='ROLE_SECRETARIA'>
														<td class="center"><g:link action="show"
															class="btn btn-default" id="${reportInstance.getId()}">
															${}<i class="fa fa-list-alt"></i> Informe</g:link>
														</sec:ifAnyGranted>
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
	<br/><br/><br/>
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