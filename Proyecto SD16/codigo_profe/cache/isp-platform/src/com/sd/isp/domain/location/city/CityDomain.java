package com.sd.isp.domain.location.city;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sd.isp.domain.base.BaseDomain;
import com.sd.isp.domain.location.state.StateDomain;

@Entity
@Table(name = "city")
public class CityDomain extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "name")
	private String _name;

	@ManyToOne
	private StateDomain _state;

	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	public StateDomain getState() {
		return _state;
	}

	public void setState(StateDomain state) {
		_state = state;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

}
