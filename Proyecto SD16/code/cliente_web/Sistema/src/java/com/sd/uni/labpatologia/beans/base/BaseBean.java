package com.sd.uni.labpatologia.beans.base;

import java.io.Serializable;
import java.util.Map;

public abstract class BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer _id;

	public BaseBean(Map<String, String> params) {
		create(params);
	}

	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	protected abstract void create(Map<String, String> params);

}
