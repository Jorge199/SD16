<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="template">
        <g:set var="entityName"
        value="${message(code: 'articleMovement.label', default: 'ArticleMovement')}" />
        <title><g:message code="default.create.label"
                args="[entityName]" /></title>
    <asset:stylesheet src="application.css" />
    <asset:javascript src="application.js" />
</head>
<body>
    <%@ page import="com.sd.uni.labpatologia.util.MovementTypeEnum"%>
    <div class="container-fluid">
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4>
                        <strong>Lista de movimientos de Stock</strong>
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
                            <a class="btn btn-success" href="/Sistema/ArticleMovement/create" role="button"><i class="fa fa-plus"></i> Agregar Movimiento</a>
                        </div>
                        <br> <br>
                        <div class="panel-body">
                            <g:form action="list">
                                <div class="col-md-4">
                                    <div class="fieldcontain ${hasErrors(bean: requestInstance, field: 'movementType', 'error')} required">
                                        <label class="col-md-4" for="movementType"> <g:message
                                                code="Tipo de movimiento" />
                                        </label>
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <g:select name="type" class="form-control"
                                                from="${MovementTypeEnum.values()}" name="movementType" value="${movementType}"
                                                    optionKey="key"
                                                noSelection="${['null':'Entrada y Salida']}"
                                                    required="">
                                                </g:select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="fieldcontain ${hasErrors(bean: requestInstance, field: 'start', 'error')} required">
                                        <div class="col-md-3">
                                            <label for="start"> <g:message code="Desde Fecha" />
                                            </label>
                                        </div>
                                        <div class="col-md-9">
                                            <div class="form-group">
                                                <div class='input-group date' id='datetimepicker1'>
                                                    <input type='text' class="form-control " value="${startSearch}"
                                                    name="startSearch" /> <span class="input-group-addon">
                                                        <span class="glyphicon glyphicon-calendar"> </span>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="fieldcontain ${hasErrors(bean: requestInstance, field: 'end', 'error')} required">
                                        <div class="col-md-3">
                                            <label for="start"> <g:message code="Hasta Fecha" />
                                            </label>
                                        </div>
                                        <div class="col-md-9">
                                            <div class="form-group">
                                                <div class='input-group date' id='datetimepicker2'>
                                                    <input type='text' class="form-control" value="${endSearch}"
                                                    name="endSearch" /> <span class="input-group-addon">
                                                        <span class="glyphicon glyphicon-calendar"> </span>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-1"></div>
                                <fieldset class="buttons">
                                    <button type="submit" class="btn btn-primary" name="list">
                                        <i class="fa fa-search"></i> Buscar
                                    </button>
                                    <g:actionSubmit action="download" class="btn btn-primary" value="Descargar"/>
                                    <br>
                                </fieldset>
                            </g:form>
                        </div>
                    </div>

<!--<div class="col-sm-4">
    <a class="btn btn-success" href="/Sistema/articleMovement/create"
    role="button"><i class="fa fa-plus"></i> Agregar Movimiento</a>
</div>
<div class="col-sm-8" align="right">
    <g:form action="list" class="form-search">
        <div class="input-group col-md-10">
            <input type="text" name="text" class="form-control" maxlength="50"
            placeholder="Ingrese un texto para buscar" /> <span
            class="input-group-btn">
            <button class="btn btn-primary" name="list" value="Buscar">
                <span class=" glyphicon glyphicon-search"></span>
            </button>
            </span>
        </div>
    </g:form>
</div>-->

            <!--<div class="col-md-6">
                                                                <div class="fieldcontain ${hasErrors(bean: reportInstance, field: 'start', 'error')} required">
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
                                        </div>-->
                   
                    <br> <br>
                    <div class="dataTable_wrapper">
                        <div class="row">
                            <div class="col-sm-12">
                                <table id="list-report"
                                class="table table-striped table-bordered" cellspacing="0"
                                width="100%">
                                <thead>
                                    <tr>
                                        <th>Articulo</th>
                                        <th>Tipo de movimiento</th>
                                        <th>Cantidad</th>
                                        <th>Fecha</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <g:each in="${articleMovementInstanceList}" status="i"
                                        var="articleMovementInstance">
                                        <tr align="center">
                                            <td>
                                                ${articleMovementInstance?.article?.name}
                                            </td>
                                            <td>
                                            <g:if test="${articleMovementInstance?.movementType.toString()=="Entrada"}">
													<h4><span class="label label-success label-col-lg" >Entrada</span></h4>
												</g:if>
												<g:else test="${articleMovementInstance?.movementType.toString()=="Salida"}">
													<h4><span class="label label-danger label-col-lg" >Salida</span></h4>
												</g:else>
												
                                            </td>
                                            <td>
                                                ${fieldValue(bean: articleMovementInstance, field: "quantity")}
                                            </td>
                                            <td>
                                                ${formatDate(format: 'dd/MM/yyyy', date:articleMovementInstance?.date)}
                                            </td>
                                            <%--  <td>${fieldValue(bean: laboratoryInstance, field: "laboratory.id")}</td>		--%>

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
	<script src=" ${request.contextPath}/template/js/jquery.validate.js"></script>
	<script src=" ${request.contextPath}/template/js/validationFormArticleMovement.js"></script>
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