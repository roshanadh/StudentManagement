package np.com.roshanadhikary.studentmgmt.services;

import java.util.List;

import np.com.roshanadhikary.studentmgmt.dto.Student;

public interface StudentService {
	
	
	public Student getStudentById(int id);
	
	public List<Student> listStudents();
	
	public void createStudent(Student student);
	
	public void updateStudent(Student student);
	
	public int deleteStudent(int id);
}
