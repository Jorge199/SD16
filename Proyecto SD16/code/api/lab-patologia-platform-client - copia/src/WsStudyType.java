import study_type.StudyTypeManager;


public class WsStudyType {
	public static void main(String[] args) {
		StudyTypeManager s = new StudyTypeManager();
		s.addStudy("asd", "fgh");
		s.getAllStudies();
	}
}
