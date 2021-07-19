package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.model.Review;

@RestController //데이터만 response로 내릴 때 사용
public class ReviewRestController {
	@Autowired
	private com.example.lesson03.bo.ReviewBO reviewBO;

	//요청 url : http://localhost/lesson03/ex01
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			//1) @RequestParam(value="id") int id //필수 파라미터 => int해도 됨
			//2)@RequestParam(value="id", required=true) int id
			//3)@RequestParam(value="id", required=false) Integer id 
			//비필수 파라미터(값이 없을 수 있기 때문에 null을 저장하기 위해 Integer)
			@RequestParam(value="id", defaultValue="1") int id //필수 파라미터, 디폴트 값 1
			) {
		System.out.println("### id:" + id);
		//if(id == null) {
			//return null;
		//}
		return reviewBO.getReview(id);
	}
	
	@RequestMapping("/lesson03/ex01/1")
	public String ex02() {
		Review review = new Review();
		review.setStoreName("대왕부대찌개");
		review.setMenu("1인분 부대찌개");
		review.setUserName("김민정");
		review.setPoint(4.5);
		review.setReview("혼자 먹기 양이 많아서 좋네요");
		
		int row = reviewBO.insertReview(review); //insert 된 row 수를 리턴 받는다.
		
		return "success row count:" + row; // @ResponseBody로 인해 String 값 자체가 rewponseBody에 담긴다
	}
	
	@RequestMapping("/lesson03/ex01/2")
	public String ex02_2() {
		int row = reviewBO.insertReviewAsField("도미노 피자", "콤비네이션", "김윈터", 4.5, "정말 알차고 양이 많습니다");
		
		return "success row count:" + row;
	}
}
