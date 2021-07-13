package com.example.lesson1;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson1/ex01")
@Controller //controller spring bean
public class EX01Controller {
  @RequestMapping("/1") //url 주소 선택
  @ResponseBody  // 리턴되는 값을 HTML Response body로 보낸다
  public String printString() {
	  String text = "예제1번<br>문자열을 response body로 보내는 예제";
	  return text;
  }
  
  //요청 url : http://localhost/lesson1/ex01/2
  @RequestMapping("/2")
  public @ResponseBody Map<String, Object> printMap() {
	  Map<String, Object> map = new HashMap<>();
	  map.put("apple", 1);
	  map.put("banana", 2);
	  map.put("lemon", 3);
	  map.put("orange", 4);
	  
	  //map을 리턴하면 json으로 나타난다
	  //web starter에 jackson 이라는 라이브러리가 포함되어있기 때문
	  return map;   //{"apple=4" ......}
  }
  
}
