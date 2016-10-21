<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="template">
		<asset:stylesheet src="application.css"/>
    	<asset:javascript src="application.js"/>
		<g:set var="entityName" value="${message(code: 'patient.label', default: 'Patient')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
<div class="container-fluid">
              <div class="row">
                        <div class="panel panel-default">		
                            <div class="panel-heading">
								<h4><strong>Lista de Pacientes</strong></h4>
							</div>
							<div class="panel-body">
									<g:if test="${flash.message}">
										<div class="message" role="status">${flash.message}</div>
									</g:if>
							<div class="dataTable_wrapper">
    						<div class="row">
     						<div class="col-sm-12">
        					<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
							<thead>
											<tr>
											
												<th>Nombre</th>
												<th>Apellido</th>
												<th>Direccion</th>
												<th>Telefono</th>
												<th>Servicio</th>
												<th>Acciones</th>
											</tr>
										</thead>
										<tbody>
										
											<tr>
											
											
												<td>Ana</td>
											
												<td>Maidana</td>
											
												<td>Kennedy</td>
											
												<td>202020</td>
												
												<td>Biopsia</td>
												
												<td class="center">
												<button class="btn btn-primary"><i class="fa fa-eye"></i> Ver Detalle</button>
								                <button class="btn btn-success"><i class="fa fa-pencil"></i> Editar</button> 
								                <button class="btn btn-danger"><i class="fa fa-trash-o"></i> Eliminar</button> 

								                </td>
											</tr>
										
										</tbody>
									</table>
									<div class="pagination">
										
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>