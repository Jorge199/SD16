<%@ page import="java.lang.System"%>
<%@ page import="com.sd.uni.labpatologia.util.StatusEnum" %>
<div class="row">
	<div class=col-md-12>
		<div class="col-md-4">
			<label>Codigo<span class="required-indicator">*</span></label>
			<g:textField  class="form-control" required=""  max="20" name="code" 
			placeholder="Ingrese un codigo" value="${requestInstance?.code}"/>
		</div>
	</div>
	<br><br>
	<div class=col-md-12>
		<div class="col-md-4">
				<label>Paciente<span class="required-indicator">*</span></label>
				<g:select  class="form-control many-to-one" name="patient" from="${patients}" value="${requestInstance?.patient}"
				optionKey="id" optionValue="name" required=""
				noSelection="${['null':'Seleccione un paciente..']}"
			  	required=""/>
		</div>
		
		<div class="col-md-4">
				<label>Doctor<span class="required-indicator">*</span></label>
				<g:select class="form-control many-to-one" name="doctor" from="${doctors}"  value="${requestInstance?.doctor}"
				optionKey="id" optionValue="name" 
				noSelection="${['null':'Seleccione un doctor..']}"
				required=""/>
		</div>
		
		<div class="col-md-4">
			<label>Tipo de Estudio<span class="required-indicator">*</span></label>
			<g:select  class="form-control" name="studyType" from="${studies}" value="${requestInstance?.studyType}"
			optionKey="id" optionValue="name" required=""
			noSelection="${['null':'Seleccione un estudio..']}"
			required=""/>
		</div>
	</div>
	<br><br>
	<div class="col-md-12">
		<div class="col-md-6">
			<label>Observaciones<span class="required-indicator">*</span></label>
			<g:textArea class="form-control" rows="5" cols="40" class="form-control"
				name="note" required="" maxlength="250"
				placeholder="Ingrese sus observaciones"
				value="${requestInstance?.note}" />
		</div>
	</div>
	
</div>

