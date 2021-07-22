package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.NewStudentBO;
import com.example.lesson04.model.NewStudent;

@Controller
@RequestMapping("/lesson04/ex02")
public class NewStudentController {
	@Autowired
	private NewStudentBO newStudentBO;
	
   //http://localhost/lesson04/ex02/1
	@GetMapping("/1")
	public String addStudentView() {
		return "lesson04/addStudent";
	}
	
	@PostMapping("/add_student")
	public String addStudent(
			@ModelAttribute NewStudent newStudent,
			Model model) {
		//   ㄴ name 태그 값과 일치하는 필드에 값이 들어간다
		//insert DB
		newStudentBO.addNewStudent(newStudent);
		
		newStudent = newStudentBO.getNewStudentById(newStudent.getId());
		model.addAttribute("result", newStudent);
		model.addAttribute("subject", "학생 정보");
		//select DB
		return "lesson04/afterAddStudent";
	}
}
