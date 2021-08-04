package com.example.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.NewUserBO;

@RequestMapping("/lesson06/ex02")
@Controller
public class lessono06Ex02Controller {
	
	@Autowired
	private NewUserBO newUserBO;
	
   @RequestMapping("/add_name")
   public String addName() {
	   return "lesson06/addName";
   }
   
   @GetMapping("/is_duplication")
   @ResponseBody  //AJAX의 요청이므로 ResponseBody로 추가
   public Map<String, Boolean> isDuplication(
		   @RequestParam("name") String name){
	   
	  
	   
	   Map<String , Boolean> result = new HashMap<>();
	   result.put("is_duplication", newUserBO.existNewUserByName(name) );
	   return result;
   }
   
  
}
