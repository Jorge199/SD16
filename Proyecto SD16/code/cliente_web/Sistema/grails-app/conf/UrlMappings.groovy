class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/inicio/index"){
			controller = "Inicio"
			action = "index"
		}
		"401"(view:'/error/error401')
		"403"(view:'/error/error403')
		"404"(view:'/error/error404')
        "500"(view:'/error/error500')
		"503"(view:'/error/error503')
		"508"(view:'/error/error508')
	}
}
