package com.sd.isp.rest.client;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sd.isp.dto.client.ClientDTO;
import com.sd.isp.dto.client.ClientResult;
import com.sd.isp.rest.base.BaseResourceImpl;

@Repository("clientResource")
public class ClientResourceImpl extends BaseResourceImpl<ClientDTO> implements
		IClientResource {

	public ClientResourceImpl() {
		super(ClientDTO.class, "/client");
	}

	@CacheEvict(value = CACHE_REGION, key = "'client_' + #client.id", condition = "#client.id!=null")
	@Override
	public ClientDTO save(ClientDTO client) {
		return super.save(client);
	}

	@Cacheable(value = CACHE_REGION, key = "'client_' + #id")
	@Override
	public ClientDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	public ClientResult getAll() {
		ClientResult clients = getWebResource().get(ClientResult.class);
		for(ClientDTO client: clients.getClients()) {
			getCacheManager().getCache(CACHE_REGION).put(
					"client_" + client.getId(), client);
		}
		return clients;
	}

}
