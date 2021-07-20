package com.example.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.model.Review;

@Repository
public interface ReviewDAO {
   public Review selectReview(@Param("id") int id);
   
   public int insertReview(Review review); //Review 객체의 내용을 row로 추가
   
   public int insertReviewAsField(
		   @Param("storeName") String storeName,
		   @Param("menu")String menu,
		   @Param("userName")String userName,
		   @Param("point")double point, 
		   @Param("review")String review);
   
   public int updateReview(@Param("id")int id, @Param("review")String review);
   
   public int deleteReviewById(int id);
}
