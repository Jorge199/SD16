package com.sd.uni.labpatologia.domain.estudio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sd.uni.labpatologia.domain.base.BaseDomain;

@Entity
@Table(name = "estudio")
public class EstudioDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "name", nullable = false, unique = true)
	private String _name;
	
	@Column(name = "description", nullable = false, unique = false)
	private String _description;

	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}
	
	public String getDescription() {
		return _name;
	}

	public void setDescription(String description) {
		_description = description;
	}

}
