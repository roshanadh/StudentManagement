package np.com.roshanadhikary.studentmgmt.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import np.com.roshanadhikary.studentmgmt.dao.StudentDao;
import np.com.roshanadhikary.studentmgmt.dao.StudentDaoImpl;
import np.com.roshanadhikary.studentmgmt.dto.Student;
import np.com.roshanadhikary.studentmgmt.services.StudentService;
import np.com.roshanadhikary.studentmgmt.services.StudentServiceImpl;

@Controller
@RequestMapping("students")
public class StudentController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String getStudents(Model model) {
		StudentService studentService = new StudentServiceImpl(new StudentDaoImpl());
		
		List<Student> students = studentService.listStudents();
		
		model.addAttribute("students", students);
		
		return "students/students";
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String postStudent(HttpServletRequest request) {
		
		StudentService studentService = new StudentServiceImpl(new StudentDaoImpl());
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String country = request.getParameter("country");
		
		String[] hobbies = request.getParameterValues("hobbies");
		String[] languages = request.getParameterValues("languages");
		
		List<String> listOfHobbies = Arrays.asList(hobbies);
		List<String> listOfLanuguages = Arrays.asList(languages);
		
		Student student = new Student();
		student.setName(name);
		student.setAddress(address);
		student.setCountry(country);
		student.setGender(gender);
		student.setHobbies(listOfHobbies);
		student.setLanguages(listOfLanuguages);
		
		studentService.createStudent(student);
		
		return new HelloController().index();
	}
	
	@RequestMapping(value="update/{id}", method=RequestMethod.GET)
	public String editStudent(@PathVariable("id") int id, Model model) {
		StudentService studentService = new StudentServiceImpl(new StudentDaoImpl());
		
		Student student = studentService.getStudentById(id);
		
		model.addAttribute("student", student);
				
		return "students/editStudent";
		
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String updateStudent(HttpServletRequest request, Model model) {
		StudentService studentService = new StudentServiceImpl(new StudentDaoImpl());
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String country = request.getParameter("country");
		
		String[] hobbies = request.getParameterValues("hobbies");
		String[] languages = request.getParameterValues("languages");
		
		List<String> listOfHobbies = Arrays.asList(hobbies);
		List<String> listOfLanuguages = Arrays.asList(languages);
		
		Student student = new Student();
		
		student.setId(id);
		student.setName(name);
		student.setAddress(address);
		student.setCountry(country);
		student.setGender(gender);
		student.setHobbies(listOfHobbies);
		student.setLanguages(listOfLanuguages);
		
		studentService.updateStudent(student);
		
		model.addAttribute("student", student);
		
		return "students/editStudent";
	}
	
	@RequestMapping(value="remove/{id}", method=RequestMethod.GET)
	public String removeStudent(@PathVariable("id") int id, Model model) {
		
		StudentService studentService = new StudentServiceImpl(new StudentDaoImpl());
		
		studentService.deleteStudent(id);
		
		return getStudents(model);
	}

}
