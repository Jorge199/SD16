<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="template">
        <g:set var="entityName"
        value="${message(code: 'article.label', default: 'Article')}" />
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
                        <strong>Lista de Stock</strong>
                    </h4>
                </div>
                <div class="panel-body">
                    <div class="col-sm-4">
                        <a class="btn btn-success" href="/Sistema/article/create"
                        role="button"><i class="fa fa-plus"></i> Agregar Articulo</a>
                    </div>
                    <div class="col-sm-8" align="right">
                        <g:form action="list" class="form-search">
                            <div class="input-group col-md-10">
                                <input type="text" name="text" class="form-control" maxlength="50" value="${text}"
                                placeholder="Ingrese un texto para buscar" /> <span
                                class="input-group-btn">
                                <button class="btn btn-primary" name="list" value="Buscar">
                                    <span class=" glyphicon glyphicon-search"></span>
                                </button>
                                </span>
                            </div>
                        </g:form>
                    </div>
                    <br> <br><br> <br> 
                    <div>
                        <div class="row">
                            <div class="col-sm-12">
                                <table id="list-report"
                                class="table table-striped table-bordered" cellspacing="0"
                                width="100%">
                                <thead>
                                    <tr>
                                        <g:sortableColumn property="_name" params= "${params}" title="Nombre" ></g:sortableColumn>
                                        <g:sortableColumn property="_description" params= "${params}" title="Descripción" ></g:sortableColumn>
                                        <g:sortableColumn property="_units" params= "${params}" title="Unidades" ></g:sortableColumn>
                                        <g:sortableColumn property="_quantity" params= "${params}" title="Cantidad" ></g:sortableColumn>                                        
                                        <td></td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <g:each in="${articleInstanceList}" status="i"
                                        var="articleInstance">
                                        <tr>
                                            <td>
                                                ${fieldValue(bean: articleInstance, field: "name")}
                                            </td>
                                            <td>
                                                ${fieldValue(bean: articleInstance, field: "description")}
                                            </td>
                                            <td>
                                                ${fieldValue(bean: articleInstance, field: "units")}
                                            </td>
                                            <td class="numbers">
                                                ${fieldValue(bean: articleInstance, field: "quantity")}
                                            </td>
                                            <td width="80" class="center"><g:link action="edit"
                                                class="btn btn-success" id="${articleInstance.getId()}">
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
	<script src=" ${request.contextPath}/template/js/jquery.validate.js"></script>
	<script src=" ${request.contextPath}/template/js/validationFormArticle.js"></script>

        <!-- Bootstrap Core JavaScript -->
    <script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
</body>
</html>