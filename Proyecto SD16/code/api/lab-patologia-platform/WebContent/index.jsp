

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>API LABORATORIO</title>
<style>
table {
	width: 100%;
	padding: 50px;
	margin-left: 50px;
}

table, th, td {
	border-bottom: 1px solid #ddd;
	border-collapse: collapse;
}

th, td {
	padding: 5px;
	text-align: center;
}

table#t01 tr:nth-child(even) {
	background-color: #eee;
}

table#t01 tr:nth-child(odd) {
	background-color: #fff;
}

table#t01 th {
	background-color: #428bca;
	color: white;
}
</style>
</head>
<body>
	<h1>
		<span style="margin-left: 250px">lab-patology-platform API</span>
	</h1>
	<table style="width: 90%" id="t01">
		<tr>
			<th>Controller</th>
			<th>Listar</th>
			<th>Obtener</th>
			<th>Editar</th>
			<th>Buscar</th>

		</tr>
		<tr>
			<td>Article</td>
			<td>path=<a
				href="http://localhost:8080/lab-patologia-platform/rest/article">lab-patologia-platform/rest/article</a></td>
				<td>path/{id}]</td>
				<td>path/edit/{id}</td>
				<td>path/search/{max}/{page}/{textToFind}</td>
				
				
		</tr>
		<tr>
			<td>Doctor</td>
			<td>path=<a
				href="http://localhost:8080/lab-patologia-platform/rest/doctor">lab-patologia-platform/rest/doctor</a></td>
				<td>path/{id}]</td>
				<td>path/edit/{id}</td>
				<td>path/search/{max}/{page}/{textToFind}</td>
		</tr>
		<tr>
			<td>Laboratory</td>
			<td>path=<a
				href="http://localhost:8080/lab-patologia-platform/rest/laboratory">lab-patologia-platform/rest/laboratory</a></td>
				<td>path/{id}]</td>
				<td>path/edit/{id}</td>
				<td>path/search/{max}/{page}/{textToFind}</td>
		</tr>
		<tr>
			<td>Patient</td>
			<td>path=<a
				href="http://localhost:8080/lab-patologia-platform/rest/patient">lab-patologia-platform/rest/patient</a></td>
				<td>path/{id}]</td>
				<td>path/edit/{id}</td>
				<td>path/search/{max}/{page}/{textToFind}</td>
		</tr>
		<tr>
			<td>Report</td>
			<td>path=<a
				href="http://localhost:8080/lab-patologia-platform/rest/report">lab-patologia-platform/rest/report</a></td>
				<td>path/{id}]</td>
				<td>path/edit/{id}</td>
				<td>path/search/{max}/{page}/diagnostic={diagnostic}&start={dd-mm-aa}&end={dd-mm-aa}</td>
		</tr>
		<tr>
			<td>Request</td>
			<td>path=<a
				href="http://localhost:8080/lab-patologia-platform/rest/request">lab-patologia-platform/rest/request</a></td>
				<td>path/{id}]</td>
				<td>path/edit/{id}</td>
				<td>path/search/{max}/{page}/note={note}&code={code}&status{status}&start={dd-mm-aa}&end={dd-mm-aa}</td>
		</tr>
		<tr>
			<td>Rol</td>
			<td>path=<a
				href="http://localhost:8080/lab-patologia-platform/rest/rol">lab-patologia-platform/rest/rol</a></td>
				<td>path/{id}]</td>
				<td>path/edit/{id}</td>
				<td>path/search/{max}/{page}/{textToFind}</td>
		</tr>
		<tr>
			<td>Study Type</td>
			<td>path=<a
				href="http://localhost:8080/lab-patologia-platform/rest/study_type">lab-patologia-platform/rest/study_type</a></td>
				<td>path/{id}]</td>
				<td>path/edit/{id}</td>
				<td>path/search/{max}/{page}/{textToFind}</td>
		</tr>
		<tr>
			<td>User</td>
			<td>path=<a
				href="http://localhost:8080/lab-patologia-platform/rest/user">lab-patologia-platform/rest/user</a></td>
				<td>path/{id}]</td>
				<td>path/edit/{id}</td>
				<td>path/search/{max}/{page}/{textToFind}</td>
		</tr>
	</table>
</body>
</html>