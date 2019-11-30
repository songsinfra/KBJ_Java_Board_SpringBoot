package com.board.kbj.utility;

public class CommonUtility {
	
	// BoardController에서 Board List 페이징 기능을 위해 , String 값을 페이지 번호로 변형해서 리턴
	public static int getPageNumber(String strNum) {
		int number;
		try {
	        number = Integer.parseInt(strNum.trim());
	        if(number <=0)
	        	return 1; // 0보다 작은 숫자라면 기본적으로 1 리턴
	    } catch (Exception ex) {
	        return 1; // 숫자로 변환될 수 없는 값이라면 1 리턴
	    }
	    return number;
	}
	
}
