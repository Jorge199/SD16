package com.sd.uni.labpatologia.rest.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;

import com.sd.uni.labpatologia.dto.base.BaseDTO;
import com.sd.uni.labpatologia.service.auth.IAuthService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sd.uni.labpatologia.utils.Config;
import javax.swing.JOptionPane;

public abstract class BaseResourceImpl<DTO extends BaseDTO> implements IBaseResource<DTO> {
	private final String _resourcePath;
	private final Class<DTO> _dtoClass;
	private final WebResource _webResource;

	
	protected static final String CACHE_REGION = "labpatologia-client-web-cache";
	private static final String BASE_URL = Config.getUrl();
        
        // Usar esto cuando se necesite mientras no haya un configuration como la gente
        /*static{
            System.out.println("Ingrese URL del api: ");
            String url = JOptionPane.showInputDialog(null, "ingrese la url");
            BASE_URL = url;
        }*/
	
	@Autowired
	@Qualifier("grailsCacheManager")
	private CacheManager _cacheManager;
	
	@Autowired
	private IAuthService authService;
	public BaseResourceImpl(Class<DTO> dtoClass, String resourcePath) {
		_dtoClass = dtoClass;
		_resourcePath = BASE_URL + resourcePath;

		final Client jerseyClient = Client.create();

		_webResource = jerseyClient.resource(_resourcePath);
	}

	protected WebResource getWebResource() {
		return _webResource;
	}

	protected Class<DTO> getDtoClass() {
		return _dtoClass;
	}
	protected CacheManager getCacheManager() {
		return _cacheManager;
	}

	public void setWebResourceBasicAuthFilter(){
		String u = authService.getUsername();
		String p = authService.getPassword();
				
		_webResource.addFilter(new HTTPBasicAuthFilter(u,p));		
	}
	
	@Override
	public DTO save(DTO dto) {
		setWebResourceBasicAuthFilter();
		return getWebResource().entity(dto).post(getDtoClass());
	}

	@Override
	public DTO getById(Integer id) {
		setWebResourceBasicAuthFilter();
		return getWebResource().path("/" + id).get(getDtoClass());
	}
	public WebResource findWR(String textToFind, int maxItems, int page) {
		if (null == textToFind){
			setWebResourceBasicAuthFilter();
			return getWebResource().path("/search/" + maxItems + "/" + page);
		}else{
			setWebResourceBasicAuthFilter();
			return getWebResource().path("/search/" + maxItems + "/" + page + "/" + textToFind);
		}
	}

}
