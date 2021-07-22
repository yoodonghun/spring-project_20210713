package com.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.bo.UsedGoodsBO;
import com.example.lesson02.model.UsedGoods;

@RestController //@controller+ @ResponseBody
public class UsedGoodsRestController {
   
	@Autowired
	private UsedGoodsBO usedGoodsBO; //(Spring Bean)
	
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01() {
		
		
		List<UsedGoods> list = usedGoodsBO.getUsedGoodsList();
		return list; //jackson -> json
	}
}
