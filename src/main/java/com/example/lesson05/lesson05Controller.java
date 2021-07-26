package com.example.lesson05;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class lesson05Controller {
   
	@RequestMapping("/lesson05/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}
	
	@RequestMapping("/lesson05/ex02")
	public String ex02(Model model) {
		//list
		List<String> fruits = new ArrayList<>();
		fruits.add("appler");
		fruits.add("akdrh");
		fruits.add("banana");
		fruits.add("pineapple");
		fruits.add("grape");
		
		model.addAttribute("fruits", fruits);                                                                                                                                                                                                                                         
		
		
		//List
		List<Map<String, Object>> users = new ArrayList<>();
		Map<String, Object> map = new HashMap();
		map.put("name", "카리나");
		map.put("age", 22 );
		map.put("hobby", "노래하기");
		users.add(map);
		
		map = new HashMap<>();
		map.put("name", "윈터");
		map.put("age", 21);
		map.put("hobby", "노래하기");
		model.addAttribute("users", users);
		
		users.add(map);
	
		return "lesson05/ex02"; 
		
		
	}
	@RequestMapping("/lesson05/ex03")
	public String ex03(Model model) {
		Date today = new Date();
		model.addAttribute("today", today);
		return "lesson05/ex03";
	}
}
