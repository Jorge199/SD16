
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
						<g:form action="list">
							<div class="col-md-5">
								<div
									class="fieldcontain ${hasErrors(bean: reportInstance, field: 'diagnostic', 'error')} required">
									<label class="col-md-3" for="diagnostic"> <g:message
											code="Diagnostico" />
									</label>
									<div class="col-md-9">
										<g:select name="diagnostic" class="form-control"
											from="${DiagnosticEnum.values()}" value=""
											name="diagnosticSearch" optionKey="key"
											noSelection="${['null':'Seleccione un diagnostico..']}"
											required=""></g:select>
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
										<input type="number" min ="0" name="startAge" class="form-control"
											placeholder="Edad Inicial" />
									</div>
								</div>
								<div class="col-md-1">
									<label for="age"> <g:message code="Y" />
									</label>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<input type="number" min="0" name="endAge" class="form-control"
											placeholder="Edad Final" />
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
												checked="${patientInstance?.sex == SexEnum.MASCULINO }" />
											${SexEnum.MASCULINO}
										</label> <label class="radio-inline"> <g:radio name="sex"
												value="${SexEnum.FEMENINO}"
												checked="${patientInstance?.sex == SexEnum.FEMENINO }" /> ${SexEnum.FEMENINO}
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
												<input type='text' class="form-control"
													name="startSearch" /> <span class="input-group-addon">
													<span class="glyphicon glyphicon-calendar"> </span>
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
													name="endSearch" /> <span class="input-group-addon">
													<span class="glyphicon glyphicon-calendar"> </span>
												</span>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-xs-12" align="center">
								<fieldset class="buttons">
									<button type="submit" class="btn btn-primary" name="list">
										<i class="fa fa-pie-chart"></i> Generar
									</button>
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

					<div id="donut-diagnostic"></div>
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
						<div id="donut-sex"></div>
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
		Morris.Donut({
			  element: 'donut-sex',
			  formatter: function (value, data) { return "Cantidad  " + value +"\n" + (value/totalSex *100).toFixed(2) + '%'; },
			  data: [
				{label: "Masculino", value: "${dataMap.masculino}"},
			    {label: "Femenino", value: "${dataMap.femenino}"}
			  ]
			});
	}
	</script>
	<script>
	//show diagnostic statistic
	var totalDiagnostic = ${dataMap.totalDiagnostic}
	if(${dataMap.getByDiagnostic=="false"}){
		Morris.Donut({
			  element: 'donut-diagnostic',
			  formatter: function (value, data) { return  "Cantidad  " + value +"\n" + (value/totalDiagnostic *100).toFixed(2) + '%'; },
			  data: [
				{label: "Carcinoma", value: "${dataMap.CARCINOMA}"},
				{label: "Leucemia", value: "${dataMap.LEUCEMIA}"},
				{label: "Linfoma", value: "${dataMap.LINFOMA}"},
				{label: "Sarcoma", value: "${dataMap.SARCOMA}"},
				{label: "Sin Indicios", value: "${dataMap.SIN_INDICIOS}"}
			  ]
			});
		}
	else{
	if(${dataMap.getByDiagnostic=="CARCINOMA"}){
	Morris.Donut({
		  element: 'donut-diagnostic',
		  formatter: function (value, data) { return  "Cantidad  " + value +"\n" + (value/totalDiagnostic *100).toFixed(2) + '%'; },
		  data: [
			{label: "Carcinoma", value: "${dataMap.CARCINOMA}"},
			{label: "Otros" , value: totalDiagnostic - "${dataMap.CARCINOMA}"}
		  ]
		});
	}else{
		if(${dataMap.getByDiagnostic=="LEUCEMIA"}){
			Morris.Donut({
				  element: 'donut-diagnostic',
				  formatter: function (value, data) { return  "Cantidad  " + value +"\n" + (value/totalDiagnostic *100).toFixed(2) + '%'; },
				  data: [
					{label: "Leucemia", value: "${dataMap.LEUCEMIA}"},
					{label: "Otros" , value: totalDiagnostic - "${dataMap.LEUCEMIA}"}
				  ]
				});
			}else{
				if(${dataMap.getByDiagnostic=="LINFOMA"}){
					Morris.Donut({
						  element: 'donut-diagnostic',
						  formatter: function (value, data) { return  "Cantidad  " + value +"\n" + (value/totalDiagnostic *100).toFixed(2) + '%'; },
						  data: [
							{label: "Linfoma", value: "${dataMap.LINFOMA}"},
							{label: "Otros" , value: totalDiagnostic - "${dataMap.LINFOMA}"}
						  ]
						});
					}else{
						if(${dataMap.getByDiagnostic=="SARCOMA"}){
							Morris.Donut({
								  element: 'donut-diagnostic',
								  formatter: function (value, data) { return  "Cantidad  " + value +"\n" + (value/totalDiagnostic *100).toFixed(2) + '%'; },
								  data: [
									{label: "Sarcoma", value: "${dataMap.SARCOMA}"},
									{label: "Otros" , value: totalDiagnostic - "${dataMap.SARCOMA}"}
								  ]
								});
							}else{
								Morris.Donut({
									  element: 'donut-diagnostic',
									  formatter: function (value, data) { return  "Cantidad  " + value +"\n" + (value/totalDiagnostic *100).toFixed(2) + '%'; },
									  data: [
										{label: "Sin Indicios", value: "${dataMap.SIN_INDICIOS}"},
										{label: "Otros" , value: totalDiagnostic - "${dataMap.SIN_INDICIOS}"}
									  ]
									});

								}
						}
					}
				}
		
		}
	</script>


</body>
</html>