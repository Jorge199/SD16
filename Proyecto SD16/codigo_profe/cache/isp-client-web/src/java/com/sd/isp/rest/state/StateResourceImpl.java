package com.sd.isp.rest.state;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sd.isp.dto.location.state.StateDTO;
import com.sd.isp.dto.location.state.StateResult;
import com.sd.isp.rest.base.BaseResourceImpl;

@Repository("stateResource")
public class StateResourceImpl extends BaseResourceImpl<StateDTO> implements
		IStateResource {

	public StateResourceImpl() {
		super(StateDTO.class, "/state");
	}

	@CacheEvict(value = CACHE_REGION, key = "'state_' + #state.id", condition = "#state.id!=null")
	@Override
	public StateDTO save(StateDTO state) {
		return super.save(state);
	}

	@Cacheable(value = CACHE_REGION, key = "'state_' + #id")
	@Override
	public StateDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	public StateResult getAll() {
		StateResult states = getWebResource().get(StateResult.class);
		for (StateDTO state : states.getStates()) {
			getCacheManager().getCache(CACHE_REGION).put(
					"state_" + state.getId(), state);
		}
		return states;
	}

}
