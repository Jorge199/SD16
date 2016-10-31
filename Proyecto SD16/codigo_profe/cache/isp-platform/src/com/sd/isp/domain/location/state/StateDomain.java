package com.sd.isp.domain.location.state;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sd.isp.domain.base.BaseDomain;
import com.sd.isp.domain.location.city.CityDomain;
import com.sd.isp.domain.location.country.CountryDomain;

@Entity
@Table(name = "state")
public class StateDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "name")
	private String _name;

	@ManyToOne
	private CountryDomain _country;
	
	@OneToMany(mappedBy="_state")
	private Set<CityDomain>_cities= new HashSet<CityDomain>();

	
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
	
	public CountryDomain getCountry() {
		return _country;
	}

	public void setCountry(CountryDomain country) {
		_country = country;
	}

	public Set<CityDomain> getCities() {
		return _cities;
	}

	public void setCities(Set<CityDomain> cities) {
		_cities = cities;
	}

}
