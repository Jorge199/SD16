import user.UserManager;


public class WsUser {
	
		public static void main(String[] args) {
			UserManager s = new UserManager();
			s.addUser("Liliana", "cualquier cosa", 1, false, null);
			s.addUser("Elizabeth", "lalala", 1, true, "ksjhdf");
			s.getAllUsers();
		}
	

}
