<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="template">
        <g:set var="entityName"
        value="${message(code: 'studyType.label', default: 'StudyType')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    <asset:stylesheet src="application.css" />
    <asset:javascript src="application.js" />
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4>
                        <strong>Tipos de Estudio</strong>
                    </h4>
                </div>
                <div class="panel-body">
                    <g:if test="${flash.message}">
                        <div class="message" role="status">
                            ${flash.message}
                        </div>
                    </g:if>

                    <g:form action="list">
                        <g:textField name="text" />
                        <g:submitButton name="list" value="Buscar" class="btn btn-primary" />
                    </g:form>
                    <div class="dataTable_wrapper">
                        <div class="row">
                            <div class="col-sm-12">
                                <table id="list-studyType"
                                class="table table-striped table-bordered" cellspacing="0"
                                width="100%">
                                <thead>
                                    <tr>
                                        <g:sortableColumn property="name" title="Nombre" />
                                        <g:sortableColumn property="description" title="Descripcion" />
                                        <td>Acciones</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <g:each in="${studyTypeInstanceList}" status="i"

                                        var="studyTypeInstance">

                                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                            <td>
                                                ${fieldValue(bean: studyTypeInstance, field: "name")}
                                            </td>
                                            <td>
                                                ${fieldValue(bean: studyTypeInstance, field: "description")}
                                            </td>

<%--  <td>${fieldValue(bean: reportInstance, field: "request.id")}</td>		--%>
                                            <td class="center">
                                                <g:link action="show" class="btn btn-primary" id="${studyTypeInstance.getId()}">${}<i class="fa fa-eye"></i> Ver Detalle</g:link>
                                                <g:link action="edit" class="btn btn-success" id="${studyTypeInstance.getId()}">${}<i class="fa fa-pencil"></i> Editar</g:link>
                                                <g:link action="delete" class="btn btn-danger" id="${studyTypeInstance.getId()}">${}<i class="fa fa-trash-o"></i> Eliminar</g:link>


                                            </td>
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



        <div class="nav" role="navigation">
            <ul>
                    <li><g:link class="create" action="create">
                            <g:message code="Nuevo" />
                        </g:link></li>
                </ul>
            </div>

        </body>
    </html>
