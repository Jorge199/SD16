
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="template">
<g:set var="entityName"
	value="${message(code: 'laboratory.label', default: 'Laboratory')}" />
<title><g:message code="default.create.label"
		args="[entityName]" /></title>
<asset:stylesheet src="application.css" />
<asset:javascript src="application.js" />
</head>
<body>
	<g:each in="${laboratoryInstanceList}" status="i" var="laboratoryInstance">
		<g:if test="${i == 0}">
			<g:if test="${laboratoryInstance?.name}">
				<h1>
					<strong>
						${fieldValue(bean: laboratoryInstance, field: "name")}
					</strong>
				</h1>
			</g:if>
			<g:if test="${laboratoryInstance?.address}">
				<h4>
					<strong>Dirección: </strong>
					${fieldValue(bean: laboratoryInstance, field: "address")}
				</h4>
			</g:if>
			<g:if test="${laboratoryInstance?.phone}">
				<h4>
					<strong>Teléfono: </strong>
					${fieldValue(bean: laboratoryInstance, field: "phone")}
				</h4>
			</g:if>
			<g:if test="${laboratoryInstance?.email}">
				<h4>
					<strong>Correo: </strong>
					${fieldValue(bean: laboratoryInstance, field: "email")}
				</h4>
			</g:if>
		</g:if>
	</g:each>


	<!-- jQuery -->
	<script src=" ${request.contextPath}/template/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
</body>
</html>