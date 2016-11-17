package sistema

class LoginController {

    def index() { }
	def denied(){
		redirect action: 'index', controller: 'inicio'
	}
}
