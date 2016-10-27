Get, con esta ruta obtienes todos los reportes
	http://localhost:8080/lab-patologia-platform/rest/report/

Get, con esta ruta obtienes el reporte con el id "1"
	http://localhost:8080/lab-patologia-platform/rest/report/1
	
Get, con esta ruta obtienes todos los reportes con diagnostico "cancer
	http://localhost:8080/lab-patologia-platform/rest/report/search/diagnostic=cancer

Get, con esta ruta obtienes los reportes de la fecha "11-06-2016"
	http://localhost:8080/lab-patologia-platform/rest/report/search/date=11-06-2016

Get, con esta ruta obtienes los reportes desde una fecha hasta otra (del 2016 en este caso)	
	http://localhost:8080/lab-patologia-platform/rest/report/search/start=01-01-2016&end=31-12-2016