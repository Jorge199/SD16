import user.UserManager;


public class WsUser {
	
		public static void main(String[] args) {
			UserManager s = new UserManager();
			s.addUser("Liliana", "contraseña1", 1, "", "usuario1");
			s.addUser("Elizabeth","contraseña2", 1, "", "usuario2");
			s.getAllUsers();
		}
	

}
