package np.com.roshanadhikary.studentmgmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import np.com.roshanadhikary.studentmgmt.dto.Student;
import np.com.roshanadhikary.studentmgmt.util.DbUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public Student getStudent(int id) {
		try {			
			Connection con = DbUtil.getConnection();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM students WHERE id = ?;");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			Student student = new Student();
			
			while (rs.next()) {
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setAddress(rs.getString("address"));
				student.setCountry(rs.getString("country"));
				student.setGender(rs.getString("gender"));
				student.setStringifiedHobbies(rs.getString("hobbies"));
				student.setStringifiedLanguages(rs.getString("languages"));
			}
			
			return student;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<Student>();
		try {			
			Connection con = DbUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM students;");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setAddress(rs.getString("address"));
				student.setCountry(rs.getString("country"));
				student.setGender(rs.getString("gender"));
				student.setStringifiedHobbies(rs.getString("hobbies"));
				student.setStringifiedLanguages(rs.getString("languages"));
				
				students.add(student);
			}
			
			return students;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void createStudent(Student student) {
		try {
			
			Connection con = DbUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO students(name, address, gender, country, hobbies, languages) VALUES(?, ?, ?, ?, ?, ?);");
			
			ps.setString(1, student.getName());
			ps.setString(2, student.getAddress());
			ps.setString(3, student.getGender());
			ps.setString(4, student.getCountry());
			ps.setString(5, student.getStringifiedHobbies());
			ps.setString(6, student.getStringifiedLanguages());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent(Student student) {
		try {
			
			Connection con = DbUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE students SET name = ?, address = ?, gender = ?, country = ?, hobbies = ?, languages = ? WHERE id = ?");
			
			ps.setString(1, student.getName());
			ps.setString(2, student.getAddress());
			ps.setString(3, student.getGender());
			ps.setString(4, student.getCountry());
			ps.setString(5, student.getStringifiedHobbies());
			ps.setString(6, student.getStringifiedLanguages());
			ps.setInt(7, student.getId());
					
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int deleteStudent(int id) {
		try {
			
			Connection con = DbUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE id = ?");
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			return id;
			
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

}
