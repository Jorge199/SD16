
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
					Este boton estara en listar de Request, para cada estado
					"Procesado"

					<g:link action="create" class="btn btn-primary" id="${1}">
						${}<i class="fa fa-plus"></i> Generar Informe</g:link>
					<br>(Para cada estado "Terminado" aparecera el boton Editar
					como el de abajo)
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
								<div class="col-md-5">
									<div
										class="fieldcontain ${hasErrors(bean: reportInstance, field: 'diagnostic', 'error')} required">
										<label class="col-sm-3" for="diagnostic"> <g:message code="Diagnostico" />
										</label>
										<div class="col-md-9">
										<g:select name="diagnostic"  class="form-control input-sm" from="${DiagnosticEnum.values()}"
											value="${}" name="diagnosticSearch" optionKey="key"
											noSelection="${['null':'Seleccione un diagnostico..']}"
											required=""></g:select>
											</div>
									</div>
								</div>
								<div class="col-md-5">
									<div class="fieldcontain ${hasErrors(bean: reportInstance, field: 'start', 'error')} required">
										<div class="col-md-2">
											<label for="start"> <g:message code="Inicio" />
											</label>
										</div>
										<div class="col-md-4">
											<g:textField class="form-control input-sm" name="startSearch"
												required="" />
										</div>
										<div class="col-md-1">
											<label for="end"> <g:message code="Fin" />
											</label>
										</div>
										<div class="col-md-4">
											<g:textField class="form-control input-sm" name="endSearch"
												required="" />
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
											<g:sortableColumn property="id" title="ID" />
											<g:sortableColumn property="request" title="Request" />
											<g:sortableColumn property="date" title="Date" />
											<g:sortableColumn property="diagnostic" title="Diagnostico" />
											<g:sortableColumn property="observation"
												title="Observaciones" />
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
													${fieldValue(bean: reportInstance, field: "request.id")}
												</td>
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
												<td class="center"><g:link action="edit"
														class="btn btn-success" id="${reportInstance.getId()}">
														${}<i class="fa fa-pencil"></i> Editar</g:link></td>
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