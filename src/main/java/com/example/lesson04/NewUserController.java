package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.NewUserBO;
import com.example.lesson04.model.NewUser;

@RequestMapping("/lesson04")
@Controller
public class NewUserController {
	
	@Autowired
	private NewUserBO newUserBO;
	
	//url: http://localhost/lesson04/ex01/1
  @RequestMapping(path = "/1", method = RequestMethod.GET)
  public String addUserView() {
	  return "lesson04/addUser"; // View 경로
  }
  
  @PostMapping("/ex01/add_user") //Post만 받아오는 Mapping
  public String addUser(
		  @RequestParam("name") String name,
		  @RequestParam("yyyymmdd") String yyyymmdd,
		  @RequestParam("email") String email, //필수값이 아님
		  @RequestParam(value = "introduce", required = false) String introduce) {
	  
	  // TODO db insert
	  // 결과 jsp
	  
	  newUserBO.addNewUser(name, yyyymmdd, email, introduce);
	  
	  return "lesson04/afterAddUser";
	  
  }
  
  // http://localhost/lesson04/ex01/add_user
  @GetMapping ("/ex01/2")
  public String getUserView(Model model) {// view 화면에 데이터를 넘겨주는 객체(ModelAndView 객체는 요즘 사용하지 않음)
	  NewUser newUser = newUserBO.getLastUser();
	  model.addAttribute("result", newUser);
	  model.addAttribute("subject", "회원 정보");
	  
	  return "lesson04/getLastUser";
  }
  
}
