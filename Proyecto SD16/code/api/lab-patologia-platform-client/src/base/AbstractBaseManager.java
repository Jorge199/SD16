package base;
import com.sun.jersey.api.client.Client;

public abstract class AbstractBaseManager {
	private final String BASE_URL = "http://localhost:8080/lab-patologia-platform/rest";

	private final Client _jerseyClient;

	public AbstractBaseManager() {
		_jerseyClient = com.sun.jersey.api.client.Client.create();
	}

	protected String getBaseUrl() {
		return BASE_URL;
	}

	protected Client getJerseyClient() {
		return _jerseyClient;
	}
}
