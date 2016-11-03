
<!DOCTYPE html>
<html>
<head>
		<meta name="layout" content="template">
		<g:set var="entityName" value="${message(code: 'report.label', default: 'Report')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
		<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>
</head>
<body>


<g:formatDate date="${new Date()}" class="form-control"
						 name="date" type="date" value="${reporttInstance?.date}"/>


	
	<div id="create-report" class="content scaffold-create" role="main">
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<g:hasErrors bean="${reportInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${reportInstance}" var="error">
					<li
						<g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
							error="${error}" /></li>
				</g:eachError>
			</ul>
		</g:hasErrors>
		<g:form action="save">
			<fieldset class="form">
				<g:render template="form" />
			</fieldset>
			
		</g:form>
	</div>
</body>
</html>
