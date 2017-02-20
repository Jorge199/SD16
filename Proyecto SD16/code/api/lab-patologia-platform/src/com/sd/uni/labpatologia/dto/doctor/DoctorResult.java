package com.sd.uni.labpatologia.dto.doctor;

import javax.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.annotation.XmlElement;

import com.sd.uni.labpatologia.dto.base.BaseResult;
import com.sd.uni.labpatologia.dto.doctor.DoctorDto;

import java.util.List;

@XmlRootElement(name = "doctorResult")
public class DoctorResult extends BaseResult<DoctorDto>{
	private static final long serialVersionUID = 1L;
	private int _count;

	@XmlElement
	public List<DoctorDto> getDoctors() {
		return getList();
	}

	public void setDoctors(List<DoctorDto> dtos) {
		super.setList(dtos);
	}
	
	public int getCount(){
		return _count;
	}
	public void setCount(int count){
		_count = count;
	}
}
