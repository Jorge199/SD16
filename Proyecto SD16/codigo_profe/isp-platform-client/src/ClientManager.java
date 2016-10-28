import com.sd.isp.dto.client.ClientDTO;
import com.sd.isp.dto.client.ClientResult;

public class ClientManager extends AbstractBaseManager {

	public ClientManager() {
		super();
	}

	public void addClient() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setDocument("4585dad32");
		clientDTO.setFirstName("juan3333");
		clientDTO.setLastName("pere3333z");

		getJerseyClient().resource(getBaseUrl() + "/client").entity(clientDTO).post(ClientDTO.class);
	}

	public void getAllClients() {
		ClientResult clientResult = getJerseyClient().resource(getBaseUrl() + "/client").get(ClientResult.class);
		for (ClientDTO c : clientResult.getClients()) {
			System.out.println(c.getFirstName());
		}
	}

	public void getById() {
		ClientDTO Client = getJerseyClient().resource(getBaseUrl() + "/client/1").get(ClientDTO.class);
		
			System.out.println(Client.getFirstName());
		
	}
}
