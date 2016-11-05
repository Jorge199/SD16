package user;

import base.AbstractBaseManager;
import com.sd.uni.labpatologia.dto.user.UserDTO;
import com.sd.uni.labpatologia.dto.user.UserResult;
import com.sd.uni.labpatologia.dto.rol.RolDTO;
import com.sd.uni.labpatologia.dto.rol.RolResult;

public class UserManager extends AbstractBaseManager {
	public UserManager() {
		
		super();
		addRols();
		
	}
	
	public void addRols(){
		
		RolDTO rolDTO1 = new RolDTO();
		rolDTO1.setName("Administrador");
		
		RolDTO rolDTO2 = new RolDTO();
		rolDTO2.setName("Secretaria");
		
		RolDTO rolDTO3 = new RolDTO();
		rolDTO3.setName("Doctor");
		
		getJerseyClient().resource(getBaseUrl() + "/rol").entity(rolDTO1).post(RolDTO.class);
		getJerseyClient().resource(getBaseUrl() + "/rol").entity(rolDTO2).post(RolDTO.class);
		getJerseyClient().resource(getBaseUrl() + "/rol").entity(rolDTO3).post(RolDTO.class);
		
	}
	
	public void addUser(String name, String password, Integer rolId) {
		
		UserDTO userDTO = new UserDTO();
		userDTO.setName(name);
		userDTO.setPassword(password);
		userDTO.setRolId(rolId);
		
		getJerseyClient().resource(getBaseUrl() + "/user").entity(userDTO).post(UserDTO.class);
	}
	
	
	public void getAllUsers() {
		UserResult userResult = getJerseyClient().resource(getBaseUrl() + "/user").get(UserResult.class);
		for (UserDTO p : userResult.getUsers()) {
			System.out.println("Name: "+p.getName());
			System.out.println("Password: "+p.getPassword());
			System.out.println("Rol: "+p.getRolId());
			
		}
	}
	
	public void getByIdUser(int id){
		UserDTO userResult = getJerseyClient().resource(getBaseUrl() + "/user/"+id).get(UserDTO.class);
		System.out.println("Name: "+ userResult.getName());
		System.out.println("Password: "+ userResult.getPassword());
		System.out.println("Rol: "+ userResult.getRolId());
		
	}
	
	public void getByPropertyUser(String textToFind){
		UserResult patResult = getJerseyClient().resource(getBaseUrl() + "/user/search/"+textToFind).get(UserResult.class);
		for (UserDTO c : patResult.getUsers()) {
			System.out.println("Name: "+c.getName());
			System.out.println("Password: "+c.getPassword());
			System.out.println("Rol: "+c.getRolId());
			
		}
		
	}
	
}
