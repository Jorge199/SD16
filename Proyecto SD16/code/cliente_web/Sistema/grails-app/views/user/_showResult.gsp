
				<g:each in="${userInstanceList}" status="i" var="userInstance" >

											<tr >
												<td>
													${fieldValue(bean: userInstance, field: "name")}
												</td>
												<td>
													*****
												</td>
												<td>
													${fieldValue(bean: userInstance, field: "rol.name")}
												</td>
												<td>
													${fieldValue(bean: userInstance, field: "doctor")}
												</td>
												<td>
													${fieldValue(bean: userInstance, field: "matricula")}
												</td>
												
												
												<%--  <td>${fieldValue(bean: userInstance, field: "user.id")}</td>		--%>
												<td class="center">
													<g:link action="show" class="btn btn-primary" id="${userInstance.getId()}"><i class="fa fa-eye"></i> Ver Detalle</g:link>
													<g:link action="edit" class="btn btn-success" id="${userInstance.getId()}"><i class="fa fa-pencil"></i> Editar</g:link>

												</td>
											</tr>
		
										</g:each>
										