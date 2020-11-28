package np.com.roshanadhikary.studentmgmt.services;

import java.util.Arrays;
import java.util.List;

import np.com.roshanadhikary.studentmgmt.dao.StudentDao;
import np.com.roshanadhikary.studentmgmt.dto.Student;
import np.com.roshanadhikary.studentmgmt.util.Stringifier;

public class StudentServiceImpl implements StudentService {
	
	private StudentDao studentDao;
	
	public StudentServiceImpl(StudentDao studentDao) {
		super();
		this.studentDao = studentDao;
	}

	@Override
	public Student getStudentById(int id) {
		Student student = studentDao.getStudent(id);
		
		student.setHobbies(
				Arrays.asList(
						student.getStringifiedHobbies()
						.split(",")
				)
		);
		
		student.setLanguages(
				Arrays.asList(
						student.getStringifiedLanguages()
						.split(",")
				)
		);
		
		return student;
	}

	@Override
	public List<Student> listStudents() {
		return studentDao.getStudents();
	}

	@Override
	public void createStudent(Student student) {
		List<String> hobbies = student.getHobbies();
		List<String> languages = student.getLanguages();
		
		String stringifiedHobbies = Stringifier.stringify(hobbies);
		String stringifiedLanguages = Stringifier.stringify(languages);
		
		student.setStringifiedHobbies(stringifiedHobbies);
		student.setStringifiedLanguages(stringifiedLanguages);
		
		studentDao.createStudent(student);
	}

	@Override
	public void updateStudent(Student student) {
		List<String> hobbies = student.getHobbies();
		List<String> languages = student.getLanguages();
		
		String stringifiedHobbies = Stringifier.stringify(hobbies);
		String stringifiedLanguages = Stringifier.stringify(languages);
		
		student.setStringifiedHobbies(stringifiedHobbies);
		student.setStringifiedLanguages(stringifiedLanguages);
		
		studentDao.updateStudent(student);
	}

	@Override
	public int deleteStudent(int id) {
		return studentDao.deleteStudent(id);
	}
	

}
