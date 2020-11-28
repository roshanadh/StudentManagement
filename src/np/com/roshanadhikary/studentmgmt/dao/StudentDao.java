package np.com.roshanadhikary.studentmgmt.dao;

import java.util.List;

import np.com.roshanadhikary.studentmgmt.dto.Student;

public interface StudentDao {
	
	public Student getStudent(int id);
	
	public List<Student> getStudents();
	
	public void createStudent(Student student);
	
	public void updateStudent(Student student);
	
	public int deleteStudent(int id);

}
