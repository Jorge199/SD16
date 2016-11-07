package com.sd.uni.labpatologia.beans.rol;
import java.util.Map;

import org.apache.commons.lang.*;

import com.sd.uni.labpatologia.beans.base.BaseBean;

public class RolB extends BaseBean {

	private static final long serialVersionUID = 1L;
	private String _name;

	public RolB(Map<String, String> params) {
		super(params);
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setName(params.get("name"));
	}

}