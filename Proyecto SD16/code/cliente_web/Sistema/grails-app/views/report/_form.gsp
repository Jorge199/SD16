<%@ page import="com.sd.uni.labpatologia.util.DiagnosticEnum"%>
<div class="row">
	<div class="col-md-4">
		<label> Código:</label>
		${reportInstance?.request?.id}
		-
		${reportInstance?.request?.code}
		<g:hiddenField class="form-control" name="requestId" required=""
			value="${reportInstance?.request?.id}" />
	</div>
</div>
<div class="row">
	<div class="col-md-4">
		<label> Fecha:</label>
		<g:formatDate date="${new Date()}" class="form-control" name="date"
			type="date" value="${reportInstance?.date}" />
	</div>
</div>
<div class="row">
	<div class="col-md-6">

		<div
			class="fieldcontain ${hasErrors(bean: reportInstance, field: 'diagnostic', 'error')} required">
			<label for="diagnostic"> <g:message code="Diagnostic" /> <span
				class="required-indicator">*</span>
			</label>
			<g:select name="diagnostic" class="form-control"
				from="${DiagnosticEnum.values()}"
				value="${reportInstance?.diagnostic}" optionKey="key"
				noSelection="${['null':'Seleccione un diagnostico..']}" required=""></g:select>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-10">
		<label> Observaciones <span class="required-indicator">*</span>
		</label>
		<g:textArea rows="5" cols="40" class="form-control"
			name="observations" required="" maxlength="250"
			value="${reportInstance?.observations}" />
	</div>
</div>
<!-- jQuery -->
<script src=" ${request.contextPath}/template/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
