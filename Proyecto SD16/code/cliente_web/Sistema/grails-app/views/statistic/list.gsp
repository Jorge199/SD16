
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="template">
<g:set var="entityName"
	value="${message(code: 'statistic.label', default: 'Statistic')}" />
<title><g:message code="default.create.label"
		args="[entityName]" /></title>
<asset:stylesheet src="application.css" />
<asset:javascript src="application.js" />
<title>Estadísticas</title>


</head>
<body>
	<%@ page import="com.sd.uni.labpatologia.util.DiagnosticEnum"%>
	<%@ page import="com.sd.uni.labpatologia.util.SexEnum"%>

	<div class="container-fluid">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>
						<strong>Estadísticas</strong>
					</h4>

				</div>
				<div class="row">
					<div class="panel-body">
						<g:form action="download" action="list">
							<div class="col-md-5">
								<div
									class="fieldcontain ${hasErrors(bean: reportInstance, field: 'diagnostic', 'error')} required">
									<label class="col-md-3" for="diagnostic"> <g:message
											code="Diagnostico" />
									</label>
									<div class="col-md-9">
										<input type="text" name="diagnosticSearch" class="form-control" maxlength="50" value="${diagnosticSearch}"
									placeholder="Ingrese un texto para buscar" id="dataDiagnosticSearch" />
									</div>
								</div>
							</div>
							<div class="col-md-7">
								<div class="col-md-3">
									<label for="age"> <g:message code="Edad (Paciente)" />
									</label>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<input type="number" min="0" name="startAge" value="${startAge}"
										id="dataStartAge"
											class="form-control" placeholder="Edad Inicial" />
									</div>
								</div>
								<div class="col-md-1">
									<label for="age"> <g:message code="Y" />
									</label>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<input type="number" min="0" name="endAge" value="${endAge}"
										id="dataEndAge"
											class="form-control" placeholder="Edad Final" />
									</div>
								</div>
							</div>
							<div class="col-md-5">
								<label class="col-md-3" for="sex"> <g:message
										code="Sexo" />
								</label>
								<div class="col-md-9">
									<div class="form-group">
										<label class="radio-inline"> <g:radio name="sex"
												value="${SexEnum.MASCULINO}"
												checked="${sex == "Masculino" }" id="dataSexMas"/>
											${SexEnum.MASCULINO}
										</label> <label class="radio-inline"> <g:radio name="sex"
												value="${SexEnum.FEMENINO}" id="dataSexFem"
												checked="${sex ==  "Femenino"}" /> ${SexEnum.FEMENINO}
										</label>
									</div>
								</div>
							</div>
							<div class="col-md-7">
								<div
									class="fieldcontain ${hasErrors(bean: reportInstance, field: 'start', 'error')} required">
									<div class="col-md-3">
										<label for="start"> <g:message
												code="Desde (Fecha Informe)" />
										</label>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<div class='input-group date' id='datetimepicker1'>
												<input type='text' class="form-control" id="dataStartSearch"
												name="startSearch" value="${startSearch}" />
												<span class="input-group-addon"> <span
													class="glyphicon glyphicon-calendar"> </span>
												</span>
											</div>
										</div>
									</div>
									<div class="col-md-1">
										<label for="start"> <g:message code="Hasta" />
										</label>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<div class='input-group date' id='datetimepicker2'>
												<input type='text' class="form-control" 
												id="dataEndSearch" name="endSearch" value="${endSearch}" />
												<span class="input-group-addon"> <span
													class="glyphicon glyphicon-calendar"> </span>
												</span>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-xs-12" align="center">
								<fieldset class="buttons">
									<!--<button type="submit" action="list" class="btn btn-primary" name="list">
										<i class="fa fa-pie-chart"></i> Generar
									</button>
                                                                        <g:actionSubmit action="list" controller="Statistic" value="list"/>-->
                                                                        <button type="submit" action="download" class="btn btn-primary" name="download">
										<i class="fa fa-pie-chart"></i> listar
                                                                        </button>
                                                                        <g:actionSubmit action="download" class="btn btn-primary" value="Descargar"/>
                                                                        <button class="btn btn-default" name="delete" onclick="deleteData()">
										<i class="fa fa-eraser"></i> Borrar
									</button>
                                                                        <!--<g:link action="download" type="submit">
                                                                            generar
                                                                        </g:link>
                                                                        <g:link action="list" controller="Statistic" type="submit">
                                                                            listar
                                                                        </g:link>-->
								</fieldset>
							</div>
						</g:form>


					</div>

				</div>




			</div>
		</div>

	</div>


	<div class="col-md-3">
		<g:if test="${!dataMap.getByDiagnostic.equals("false")}">
		Diagnóstico = ${dataMap.getByDiagnostic}
		</g:if>
		<g:else>
		Diagnóstico = Todos los Diagnósticos
		</g:else>
	</div>

	<div class="col-md-3">
		<g:if test="${!dataMap.getByPatientAge.equals("false")}">
		Edades = ${dataMap.startAge} -  ${dataMap.endAge}
		</g:if>
		<g:else>
			Edades = Todas las Edades
		</g:else>
	</div>

	<div class="col-md-3">
		<g:if test="${!dataMap.getBySex.equals("false")}">
			Por Sexo = ${dataMap.getBySex}
		</g:if>
		<g:else>
			Sexo = Todos los Sexos
		</g:else>
	</div>
	<div class="col-md-3">
		<g:if test="${!dataMap.getByDate.equals("false")}">
		Fecha = ${dataMap.startDate}   al   ${dataMap.endDate}
		</g:if>
		<g:else>
		Fecha = Todas las Fechas
		</g:else>
	</div>
	<br>
	<br>

	<div class="col-md-2"></div>
	<div class="column">
		<div class="col-md-4">
			<div class="panel panel-default">
				<div class="panel-heading text-center">Estadísticas de
					Diagnósticos</div>
				<div class="panel-body">
				<g:if test="${(dataMap.getByDiagnostic=="false") && (dataMap.totalDiagnostic >0) }">
				<table id="list-diagnostics"
									class="table table-striped table-bordered" cellspacing="0"
									width="100%">
									<thead>
										<tr>
											<td><strong>Diagnóstico</strong></td>
											<td><strong>Cantidad</strong></td>
											<td><strong>Porcentaje</strong></td>
										</tr>
									</thead>
									<tbody>
										<g:each in="${dataMap.keySet()}" var="diagnostic">
											<g:if test="${diagnostic!="getByDate"  && diagnostic!="getByDiagnostic" && diagnostic!="getByPatientAge" && diagnostic!="getBySex"  && diagnostic!="totalDiagnostic" && diagnostic!="masculino" && diagnostic!="femenino" &&diagnostic!="totalSex"}">
											<tr>
												<td>
													${diagnostic}
												</td>
												<td>
													${dataMap.get(diagnostic)}
												</td>
												<td>
													${(dataMap.get(diagnostic)/dataMap.totalDiagnostic)*100}%
												</td>
											</tr>
											</g:if>
										</g:each>
										<tr>
											<td><strong>Total:</strong></td>
											<td>${dataMap.totalDiagnostic}<td>
										<tr>
									</tbody>
									
								</table>
				
				</g:if>
				<g:else>
				<div id="bar-diagnostic"></div>
				</g:else>
					
					
					
				</div>
			</div>
		</div>
	</div>
	<g:if test="${dataMap.getBySex.equals("false")}">
		<div class="column">
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading text-center">Estadísticas de
						Hombres y Mujeres</div>
					<div class="panel-body">
						<div id="bar-sex"></div>
					</div>
				</div>
			</div>
		</div>
	</g:if>


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
	<link rel="stylesheet"
		href="${request.contextPath}/template/css/plugins/morris.css" />
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


	<!-- Morris Charts JavaScript -->
	<script
		src=" ${request.contextPath}/template/js/plugins/morris/raphael.min.js"></script>
	<script
		src=" ${request.contextPath}/template/js/plugins/morris/morris.min.js"></script>
	<script
		src=" ${request.contextPath}/template/js/plugins/morris/morris-data.js"></script>


	<!-- Flot Charts JavaScript -->
	<!--[if lte IE 8]><script src="js/excanvas.min.js"></script><![endif]-->
	<script
		src=" ${request.contextPath}/template/js/plugins/flot/jquery.flot.js"></script>
	<script
		src=" ${request.contextPath}/template/js/plugins/flot/jquery.flot.tooltip.min.js"></script>
	<script
		src=" ${request.contextPath}/template/js/plugins/flot/jquery.flot.resize.js"></script>
	<script
		src=" ${request.contextPath}/template/js/plugins/flot/jquery.flot.pie.js"></script>
	<script
		src=" ${request.contextPath}/template/js/plugins/flot/flot-data.js"></script>



	<script>
	if (${dataMap.getBySex}==false){
		//show sex statistic
		var totalSex = ${dataMap.totalSex}
		Morris.Bar({
			  element: 'bar-sex',
			  data: [
			         { y: 'Sexos', masc: "${dataMap.masculino}", fem: "${dataMap.femenino}" }
			       ],
			xkey: 'y',
	       	ykeys: ['masc', 'fem'],
	       labels: ['Masculino', 'Femenino'],
	       yLabelFormat: function(y){return y != Math.round(y)?'':y;},
			       
			});
	}
	</script>
	<script>
	//show diagnostic statistic
	var totalDiagnostic = ${dataMap.totalDiagnostic}
	if(totalDiagnostic>0){
		Morris.Bar({
			  element: 'bar-diagnostic',
			  yLabelFormat: function (value, data) { return   (value/totalDiagnostic *100).toFixed(2) + '%'; },
			  data: [
				{label: "Diagnósticos", ${dataMap.getByDiagnostic}: "${dataMap.get(dataMap.getByDiagnostic)}", otros: "${dataMap.totalDiagnostic}" - "${dataMap.get(dataMap.getByDiagnostic)}"},
			  ],
			  xkey: 'label',
			  ykeys: ['${dataMap.getByDiagnostic}','otros'],
			  labels: ['${dataMap.getByDiagnostic} ('+"${dataMap.get(dataMap.getByDiagnostic)}"+')', 'Otros ('+("${dataMap.totalDiagnostic}"-"${dataMap.get(dataMap.getByDiagnostic)}")+")"],
			});
		
	}else{
		Morris.Bar({
			  element: 'bar-diagnostic',
			  data: [
				{label: "Diagnósticos", noData: "0" }
			  ],
			  
			  xkey: 'label',
			  ykeys: [''],
			  labels: ['No hay Datos'],
			});
		}
	</script>

	<script>
		function deleteData(){
			$("#dataDiagnostic").val("null");
			$("#dataStartAge").val("");
			$("#dataEndAge").val("");
			$("#dataStartSearch").val("");
			$("#dataEndSearch").val("");
			$("#dataSexMas").val("");
			$("#dataSexFem").val("");
		}
	</script>
</body>
</html>