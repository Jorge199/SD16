package com.sd.uni.labpatologia.beans.request;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.uni.labpatologia.beans.base.BaseBean;
import com.sd.uni.labpatologia.beans.doctor.DoctorB;
import com.sd.uni.labpatologia.beans.patient.PatientB;
import com.sd.uni.labpatologia.beans.study_type.StudyTypeB;
import com.sd.uni.labpatologia.util.StatusEnum;

public class RequestB extends BaseBean {

	private static final long serialVersionUID = 1L;
	private String _note;
	private Date _date;
	private DoctorB _doctor;
	private PatientB _patient;
	//private UserB _user;
	private StudyTypeB _studyType;
	private String _code;
	private StatusEnum _status;


	public RequestB(Map<String, String> params) {
		super(params);
	}


	public String getNote() {
		return _note;
	}


	public void setNote(String note) {
		_note = note;
	}


	public Date getDate() {
		return _date;
	}


	public void setDate(Date date) {
		_date = date;
	}


	public DoctorB getDoctor() {
		return _doctor;
	}


	public void setDoctor(DoctorB doctor) {
		_doctor = doctor;
	}



	public PatientB getPatient() {
		return _patient;
	}


	public void setPatient(PatientB patient) {
		_patient = patient;
	}


	/*public UserB getUser() {
		return _user;
	}


	public void setUser(UserB user) {
		_user = user;
	}*/

	public String getCode() {
		return _code;
	}


	public void setCode(String code) {
		_code = code;
	}


	public StatusEnum getStatus() {
		return _status;
	}


	public void setStatus(StatusEnum status) {
		_status = status;
	}


	public StudyTypeB getStudyType() {
		return _studyType;
	}


	public void setStudyType(StudyTypeB studyType) {
		_studyType = studyType;
	}


	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setNote(params.get("note"));
		setCode(params.get("code"));
		//para que no lance error 
		if (!StringUtils.isBlank(params.get("status"))) {
			setStatus(StatusEnum.valueOf(params.get("status")));


			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			try {
				//setDate(formato.parse(params.get("date")));
				//para que no lance error
				if(null != params.get("date")){
					setDate(formato.parse(params.get("date")));
				}

			} catch (ParseException e) {
				e.printStackTrace();

			}
		}
	}
}
