<%@ page import="java.lang.System"%>
<%@ page import="com.sd.uni.labpatologia.util.StatusEnum" %>
<div class="row">
	<div class=col-md-12>
		<div class="col-md-4">
			<label>Fecha de Ingreso <span class="required-indicator">*</span></label>
			<div class='input-group date' id='datetimepicker1'>
				<input type='text' class="form-control" name="date"
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
					<div class="col-sm-5">
						<g:field type="text" name="code1" readonly="readonly" class="form-control" value="${requestInstance?.code}"/>
					</div>
					<div class="col-sm-7">
						<g:textField  class="form-control"  max="20" name="code" 
						placeholder="Numero de cortes" />
					</div>
					<g:hiddenField name="status" value="${StatusEnum.PROCESO.name()}" />
				</g:if>
				<g:elseif test="${requestInstance?.status==StatusEnum.PROCESO }">
					<div class="col-sm-5">
						<g:field type="text" name="code1" readonly="readonly" class="form-control" value="${requestInstance?.code}"/>
					</div>
					<div class="col-sm-7">
						<g:textField  class="form-control"  max="20" name="code" 
						placeholder="Numero de laminas"/>
					</div>
					<g:hiddenField name="status" value="${StatusEnum.PROCESADO.name()}" />
				</g:elseif>
				<g:else>
					<g:textField  class="form-control" required=""  max="20" name="code" 
					placeholder="Ingrese un codigo" value="${requestInstance?.code}"/>
				</g:else>
				<g:hiddenField name="statusOld" value="${requestInstance?.status.name()}" />
			</div>
		</div>
	</div>
	
	<br><br>
	
	<div class=col-md-12>
		<div class="col-md-4">
				<label>Paciente <span class="required-indicator">*</span></label>
				<g:select  class="form-control many-to-one" name="patientId" from="${patients}" value="${requestInstance?.patient?.id}"
				optionKey="id" optionValue="name" required=""
				noSelection="${['null':'Seleccione un paciente..']}"
			  	required=""/>
		</div>
		
		<div class="col-md-4">
				<label>Doctor <span class="required-indicator">*</span></label>
				<g:select class="form-control many-to-one" name="doctorId" from="${doctors}"  value="${requestInstance?.doctor?.id}"
				optionKey="id" optionValue="name" 
				noSelection="${['null':'Seleccione un doctor..']}"
				required=""/>
		</div>
		
		<div class="col-md-4">
			<label>Tipo de Estudio <span class="required-indicator">*</span></label>
			<g:select  class="form-control" name="studyTypeId" from="${studies}" value="${requestInstance?.studyType?.id}"
			optionKey="id" optionValue="name" required=""
			noSelection="${['null':'Seleccione un estudio..']}"
			required=""/>
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

