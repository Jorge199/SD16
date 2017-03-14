package com.sd.uni.labpatologia.beans.statistic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.uni.labpatologia.beans.base.BaseBean;
import com.sd.uni.labpatologia.beans.diagnostic.DiagnosticB;
import com.sd.uni.labpatologia.beans.doctor.DoctorB;
import com.sd.uni.labpatologia.beans.patient.PatientB;
import com.sd.uni.labpatologia.beans.study_type.StudyTypeB;
import com.sd.uni.labpatologia.util.DiagnosticEnum;
import com.sd.uni.labpatologia.util.SexEnum;
import com.sd.uni.labpatologia.util.StatusEnum;

public class StatisticB extends BaseBean {

	private static final long serialVersionUID = 1L;
	private Integer _patientAge;
	private SexEnum _sex;
	private DiagnosticB _diagnostic;
	private Date _date;

	public StatisticB(Map<String, String> params) {
		super(params);
	}

	public Integer getPatientAge() {
		return _patientAge;
	}

	public void setPatientAge(Integer patientAge) {
		_patientAge = patientAge;
	}

	public SexEnum getSex() {
		return _sex;
	}

	public void setSex(SexEnum sex) {
		_sex = sex;
	}

	public DiagnosticB getDiagnostic() {
		return _diagnostic;
	}

	public void setDiagnostic(DiagnosticB diagnostic) {
		_diagnostic = diagnostic;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try {
			// setDate(formato.parse(params.get("date")));
			// para que no lance error
			if (null != params.get("date")) {
				setDate(formato.parse(params.get("date")));
			}
		} catch (ParseException e) {
			e.printStackTrace();

		}
	}
}
