import user.UserManager;


public class WsUser {
	
		public static void main(String[] args) {
			UserManager s = new UserManager();
			s.addUser("Liliana", "cualquier cosa", 1);
			s.addUser("Elizabeth", "lalala", 1);
			s.getAllUsers();
		}
	

}
