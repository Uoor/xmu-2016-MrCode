package com.mrcode.utils;

public class Recommend {
	
	//        cusType:1 出差      2游玩
	//        shopLevel:1高消费      2：低消费
	//
    //         cusType   shopLevel     
	//  num       1          1    business_high    
	//	num       1          2    business_low
	//  num       2          1    visitor_high
	//  num       2          2    visitor_low
	
	public static int recomendInt (int a ,int b) {
		if (a == 1 && b == 1)
			return 1;  //business_high
		else if (a == 1 && b == 2)
			return 2;  //business_low
		else if (a == 2 && b == 1)
			return 3;  //visitor_high
		else if (a == 2 && b == 2)
			return 4;  //visitor_low
		
		// 默认返回4
		return 4;
	}

}
