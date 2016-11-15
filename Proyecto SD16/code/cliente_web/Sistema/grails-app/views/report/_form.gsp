<%@ page import="com.sd.uni.labpatologia.util.DiagnosticEnum"%>
<div class="row">
	<div class="panel panel-default">
		<div class="panel-heading">Datos de la Solicitud</div>
		<div class="panel-body">
			<div class="col-md-4">
				<label> Código:</label>

				${reportInstance?.request?.code}
				<g:hiddenField class="form-control" name="requestId" required=""
					value="${reportInstance?.request?.id}" />
			</div>
			<div class="col-md-4">
				<label>Fecha de Solicitud:</label>
				<g:formatDate date="${reportInstance?.request?.date}"
					format='dd/MM/yyyy' />
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="panel panel-default">
		<div class="panel-heading">Datos del Doctor</div>
		<div class="panel-body">
			<div class="col-md-4">
				<label> Nombre y Apellido:</label>
				${reportInstance?.request?.doctor?.name +" "+ reportInstance?.request?.doctor?.lastName}
			</div>
			<g:if
				test="${!reportInstance?.request?.doctor?.speciality.isEmpty()}">
				<div class="col-md-4">
					<label> Especialidad:</label>
					${reportInstance?.request?.doctor?.speciality}
				</div>
			</g:if>
			<g:if test="${!reportInstance?.request?.doctor?.phone.isEmpty()}">
				<div class="col-md-4">
					<label> Teléfono:</label>
					${reportInstance?.request?.doctor?.phone}
				</div>
			</g:if>
		</div>
	</div>
</div>

<div class="row">
	<div class="panel panel-default">
		<div class="panel-heading">Datos del Paciente</div>
		<div class="panel-body">

			<div class="col-md-4">
				<label> Nombre y Apellido:</label>
				${reportInstance?.request?.patient?.name +" "+ reportInstance?.request?.patient?.lastName}
			</div>
			<g:if test="${reportInstance?.request?.patient?.sex}">
				<div class="col-md-2">
					<label> Sexo:</label>
					${reportInstance?.request?.patient?.sex}
				</div>
			</g:if>


			<g:if test="${reportInstance?.request?.patient?.birthDate}">
				<div class="col-md-2">
					<label> Edad:</label>
					<g:if
						test="${reportInstance?.request?.patient?.birthDate.getMonth() <= new Date().getMonth()}">
						${(new Date().getYear() - reportInstance?.request?.patient?.birthDate.getYear())}
					</g:if>
					<g:else>
						${(new Date().getYear() - reportInstance?.request?.patient?.birthDate.getYear())-1  }
					</g:else>
				</div>
			</g:if>
			<g:if test="${reportInstance?.request?.patient?.phone}">
				<div class="col-md-4">
					<label> Teléfono:</label>
					${reportInstance?.request?.patient?.phone}
				</div>
			</g:if>
		</div>
	</div>
</div>
<div class="row">
	<div class="panel panel-default">
		<div class="panel-heading">Datos del Informe</div>
		<div class="panel-body">
			<div class="col-md-4">
				<label> Fecha del Informe:</label>
				<g:formatDate date="${new Date()}" class="form-control" name="date"
					type="date" value="${reportInstance?.date}" />
			</div>
			<div class="col-md-4">

				<div
					class="fieldcontain ${hasErrors(bean: reportInstance, field: 'diagnostic', 'error')} required">
					<label for="diagnostic"> <g:message code="Diagnostico" />
						<span class="required-indicator">*</span>
					</label>
					<g:select name="diagnostic" class="form-control"
						from="${DiagnosticEnum.values()}"
						value="${reportInstance?.diagnostic}" optionKey="key" required=""
						noSelection="${['':'Seleccione un diagnostico..']}"
						></g:select>
				</div>
			</div>
			<div class="col-md-10">
		<label> Observaciones <span class="required-indicator">*</span>
		</label>
		<g:textArea rows="5" cols="40" class="form-control"
			name="observations" required="" maxlength="250"
			value="${reportInstance?.observations}" />
	</div>

		</div>
	</div>
</div>
<div class="row"></div>
<!-- jQuery -->
<script src=" ${request.contextPath}/template/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
