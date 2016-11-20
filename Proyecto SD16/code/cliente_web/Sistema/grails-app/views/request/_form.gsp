<%@ page import="java.lang.System"%>
<%@ page import="com.sd.uni.labpatologia.util.StatusEnum" %>

<div class="row">
	<div class=col-md-12>
		<div class="col-md-4">
			<label>Fecha de Ingreso <span class="required-indicator">*</span></label>
			<div class='input-group date' id='datetimepicker1'>
				<input type='text' class="form-control" name="date" required=""
					value="${formatDate(format: 'dd-MM-yyyy', date:requestInstance.getDate())}" /> <span
					class="input-group-addon"> <span
					class="glyphicon glyphicon-calendar"> </span>
				</span>
			</div>
		</div>
		
		<div class="col-md-4">
			<label>Codigo <span class="required-indicator">*</span></label>
			<div>
				<g:if test="${requestInstance?.status == StatusEnum.RECIBIDO }">
					<div class="col-sm-4">
						<g:field type="text" name="code" readonly="readonly" class="form-control" value="${requestInstance?.code}"/>
					</div>
					
					<sec:ifAnyGranted roles='ROLE_ADMINISTRADOR,ROLE_DOCTOR'>
						<div class="col-sm-4">
							<g:textField type="number" class="form-control"  max="20" name="code_cortes" 
							placeholder="Nro de cortes" />
						</div>
						<div class="col-sm-4">
							<g:textField type="number" class="form-control"  max="20" name="code_laminas" 
							placeholder="Nro de laminas"/>
						</div>
					</sec:ifAnyGranted>
					
				</g:if>
				<g:elseif test="${requestInstance?.status==StatusEnum.PROCESO }">
					<div class="col-sm-4">
						<g:field type="text" name="code" readonly="readonly" class="form-control" value="${requestInstance?.code}"/>
					</div>
					<sec:ifAnyGranted roles='ROLE_ADMINISTRADOR,ROLE_DOCTOR'>
						<div class="col-sm-4">
							<g:textField type="number" class="form-control"  max="20" name="code_laminas" 
							placeholder="Nro de laminas"/>
						</div>
					</sec:ifAnyGranted>
				</g:elseif>
				<g:else>
					<g:textField  class="form-control" required=""  max="20" name="code" 
					placeholder="Ingrese un codigo" value="${requestInstance?.code}"/>
				</g:else>
			</div>
		</div>
	</div>
	
	<br><br>
	
	<div class=col-md-12>
		<div class="col-md-4">
				<label>Paciente <span class="required-indicator">*</span></label>
				<g:select  class="form-control selectpicker many-to-one" data-live-search="true" name="patientId" from="${patients}" value="${requestInstance?.patient?.id}"
				optionKey="id" optionValue="fullName" required=""
				noSelection="${['':'Seleccione un paciente..']}"/>
				
				</div>
		
		<div class="col-md-4">
			<label>Doctor <span class="required-indicator">*</span></label>
				<g:select class="form-control selectpicker many-to-one" data-live-search="true" name="doctorId" from="${doctors}"  value="${requestInstance?.doctor?.id}"
				optionKey="id" optionValue="fullName" required=""
				noSelection="${['':'Seleccione un doctor..']}"
				/>
		</div>
		
		<div class="col-md-4">
			<label>Tipo de Estudio <span class="required-indicator">*</span></label>
			<g:select  class="form-control selectpicker many-to-one" name="studyTypeId" from="${studies}" value="${requestInstance?.studyType?.id}"
			optionKey="id" optionValue="name" required=""
			noSelection="${['':'Seleccione un estudio..']}" />
		</div>
	</div>
	<br><br>
	<div class="col-md-12">
		<div class="col-md-6">
			<label>Observaciones <span class="required-indicator">*</span></label>
			<g:textArea class="form-control" rows="5" cols="40" class="form-control"
				name="note" required="" maxlength="250"
				placeholder="Ingrese sus observaciones"
				value="${requestInstance?.note}" />
		</div>
	</div>
</div>


