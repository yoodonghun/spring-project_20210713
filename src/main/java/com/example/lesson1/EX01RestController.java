package com.example.lesson1;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson1/ex01")
@RestController  //@Controller + @ResponseBody : 데이터를 내릴 때 주로 사용한다.
public class EX01RestController {

	//요청 url : http://localhost/lesson1/ex01/3
	@RequestMapping("/3")
	public String printString() {
		return "@RestController를 사용해서 String을 리턴해본다";
	}
	
	@RequestMapping("/4")
	public Map<String, String> printMap(){
		Map<String, String> map = new HashMap<>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		
		return map; //json
	}
	
	@RequestMapping("/5")
	public Data printData() {
		Data data = new Data(); // 일반 자바 bean
		data.setId(1);
		data.setName("문월");
		System.out.println(data);
		return data;  //일반 bean 객체도 JSON으로 내려간다(jackson 라이브러리 때문에
	}
	
	@RequestMapping("/6")
	public ResponseEntity<Data> entity() {
		Data data = new Data();
		data.setId(2);
		data.setName("김민정");
		
		//크롬 > Network 웹 응답값 확인
		//return new ResponseEntity<>(data, HttpStatus.OK); //200 ok/data를 주고 정상적인 데이터를 받았다
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
