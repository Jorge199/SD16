<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="template">
		<g:set var="entityName" value="${message(code: 'patient.label', default: 'Patient')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
		<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>
	</head>
	<body>
        <div class="container-fluid">
        	<div class="row">
        	
<div class="panel panel-default">
	<div class="panel-heading">
		<h4>
			<strong>Articulos en Stock</strong>
		</h4>
	</div>
	<div class="panel-body">
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<div class="dataTable_wrapper">
			<div class="row">
				<div class="col-sm-12">
					<table id="list-report"
						class="table table-striped table-bordered" cellspacing="0"
						width="100%">
						<thead>
							<tr>
								<g:sortableColumn property="name" title="Nombre" />
								<g:sortableColumn property="units" title="Cantidad" />
								<g:sortableColumn property="description" title="Descripcion" />
								<g:sortableColumn property="count_stock" title="En Stock" />
								<td>Acciones</td>
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
										${fieldValue(bean: articleInstance, field: "units")}
									</td>
									<td>
										${fieldValue(bean: articleInstance, field: "description")}
									</td>
									<td>
										${fieldValue(bean: articleInstance, field: "count_stock")}
									</td>
									
									<td class="center">
										<g:link action="show" class="btn btn-primary" id="${articleInstance.getId()}"><i class="fa fa-eye"></i> Ver Detalle</g:link>
										<g:link action="edit" class="btn btn-success" id="${articleInstance.getId()}"><i class="fa fa-pencil"></i> Editar</g:link>

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
		<!-- jQuery -->
    <script src=" ${request.contextPath}/template/js/jquery.js"></script>
   
    <!-- Bootstrap Core JavaScript -->
    <script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
								
	</body>
</html>