package doctor;
import com.sd.uni.labpatologia.dto.doctor.DoctorDto;

import base.AbstractBaseManager;

public class DoctorManager extends AbstractBaseManager {

	public DoctorManager() {
		super();
	}

	public void addDoctor(String address, int ci, String email, String lastName, String name, String phone, String speciality) {
		DoctorDto doctorDto = new DoctorDto();
		doctorDto.setAddress(address);
		doctorDto.setCi(ci);
		doctorDto.setEmail(email);
		doctorDto.setLastName(lastName);
		doctorDto.setName(name);
		doctorDto.setPhone(phone);
		doctorDto.setSpeciality(speciality);
		setAdminAut();
		getJerseyClient().resource(getBaseUrl() + "/doctor").entity(doctorDto).post(DoctorDto.class);

	}

}
