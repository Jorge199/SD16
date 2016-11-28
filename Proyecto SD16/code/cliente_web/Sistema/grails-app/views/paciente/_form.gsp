<%@ page import="com.sd.uni.labpatologia.util.SexEnum"%>


<div class="row">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4>
				<strong>Registrar Paciente</strong>
			</h4>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-md-6">
					<label> Nombre <span class="required-indicator">*</span>
					</label>

					<g:textField class="form-control" name="address" />

				</div>
				<div class="col-md-6">
					<label> Apellido <span class="required-indicator">*</span>
					</label>

					<g:textField class="form-control" name="last_name" required=""
						value="${patientInstance?.last_name}" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<label> Direccion <span class="required-indicator">*</span>
					</label>

					<g:textField class="form-control" name="name" required=""
						value="${patientInstance?.name}" />

				</div>
				<div class="col-md-6">
					<label> Telefono <span class="required-indicator">*</span>
					</label>
					<g:textField class="form-control" name="service" required=""
						value="${patientInstance?.service}" />
				</div>

			</div>
			<div class="row">
				<div class="col-md-6">
					<label> Servicio <span class="required-indicator">*</span>
					</label>

					<g:textField class="form-control" name="telephone" required=""
						value="${patientInstance?.telephone}" />

				</div>
			</div>
			<br>
			<button class="btn btn-primary">
				<i class="fa fa-floppy-o"></i> Crear
			</button>
		</div>

	</div>

</div>



<!-- jQuery -->
<script src=" ${request.contextPath}/template/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
