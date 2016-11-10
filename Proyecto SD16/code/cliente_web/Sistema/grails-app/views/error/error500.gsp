<!DOCTYPE html>
<html>
<head>
<g:set var="entityName"
	value="${message(code: 'laboratory.label', default: 'Laboratory')}" />
<title><g:message code="default.create.label"
		args="[entityName]" /></title>
<asset:stylesheet src="application.css" />
<asset:javascript src="application.js" />
<!-- Bootstrap Core CSS -->
<link href="${request.contextPath}/template/css/bootstrap.min.css?v=1"
	rel="stylesheet">


<!-- Custom Fonts -->
<link
	href="${request.contextPath}/template/font-awesome/css/font-awesome.min.css?v=1"
	rel="stylesheet" type="text/css">
<style type="text/css">
#bg {
	position: fixed;
	top: -15%;
	left: 20%;
	width: 60%;
	height: 100%;
}

#bg img {
	position: absolute;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	margin: auto;
	min-width: 50%;
	min-height: 50%;
}

#bt {
	position: fixed;
	top: 60%;
	left: 46%;
	width: 60%;
	height: 100%;
}
}
</style>
</head>
<body>
	<div id="bg">
		<img src="${resource(dir: 'images', file: '500error.png')} "
			height="100" width="100" alt="Grails" />
	</div>
	<div id="bt">
	<a href="/Sistema/" class="btn btn-info" role="button">Menú Principal</a>

	</div>

</body>

</html>