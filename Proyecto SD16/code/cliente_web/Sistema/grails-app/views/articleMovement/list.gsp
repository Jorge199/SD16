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
    <div class="container-fluid">
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4>
                        <strong>Lista de movimientos de Stock</strong>
                    </h4>
                </div>
                <div class="panel-body">
                    <div class="col-sm-4">
                        <a class="btn btn-success" href="/Sistema/articleMovement/create"
                        role="button"><i class="fa fa-plus"></i> Agregar Movimiento</a>
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
                    <br> <br> <br>
                    <div class="dataTable_wrapper">
                        <div class="row">
                            <div class="col-sm-12">
                                <table id="list-report"
                                class="table table-striped table-bordered" cellspacing="0"
                                width="100%">
                                <thead>
                                    <tr>
                                        <g:sortableColumn property="article.name" title="Articulo" />
                                        <g:sortableColumn property="movementType" title="Tipo de movimiento" />
                                        <g:sortableColumn property="quantity" title="Cantidad" />
                                        <g:sortableColumn property="date" title="Fecha" />
                                    </tr>
                                </thead>
                                <tbody>
                                    <g:each in="${articleMovementInstanceList}" status="i"
                                        var="articleMovementInstance">
                                        <tr>
                                            <td>
                                                ${articleMovementInstance?.article?.name}
                                            </td>
                                            <td>
                                                ${fieldValue(bean: articleMovementInstance, field: "movementType")}
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

        <!-- Bootstrap Core JavaScript -->
    <script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
</body>
</html>