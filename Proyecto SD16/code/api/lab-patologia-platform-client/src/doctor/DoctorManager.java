package doctor;
import com.sd.uni.labpatologia.dto.doctor.DoctorDto;
import com.sd.uni.labpatologia.util.SexEnum;

import base.AbstractBaseManager;

public class DoctorManager extends AbstractBaseManager {

	public DoctorManager() {
		super();
	}

	public void addDoctor(String address, String ci, SexEnum sex, String email, String lastName, String name, String phone, String speciality) {
		DoctorDto doctorDto = new DoctorDto();
		doctorDto.setAddress(address);
		doctorDto.setCi(ci);
		doctorDto.setEmail(email);
		doctorDto.setLastName(lastName);
		doctorDto.setName(name);
		doctorDto.setPhone(phone);
		doctorDto.setSpeciality(speciality);
		doctorDto.setSex(sex);
		setAdminAut();
		getJerseyClient().resource(getBaseUrl() + "/doctor").entity(doctorDto).post(DoctorDto.class);

	}

}
