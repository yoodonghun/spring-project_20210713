package com.example.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.NewUserBO;

@RequestMapping("/lesson06/ex01")
@Controller
public class lesson06Controller {
    @Autowired
    private NewUserBO newUserBO;
    
    @RequestMapping("/add_new_user_view")
    public String ex01() {
    	return "lesson06/addNewUser";
    }
    
    @PostMapping("/add_new_user")
    @ResponseBody //출력만 할 경우 반드시 써야됨
    public String addNewUser(
    		@RequestParam("name") String name,
    		@RequestParam("yyyymmdd") String yyyymmdd,
    		@RequestParam(value="email", required=false) String email,
    		@RequestParam(value = "introduce", required=false) String introduce) {
    	
    	newUserBO.addNewUser(name, yyyymmdd, email, introduce);
    	
    	return "success";
    }
} 
