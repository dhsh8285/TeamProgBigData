package com.teamprog.service;

import java.util.Calendar;

import com.teamprog.vo.CheckVO;
import com.teamprog.vo.UserVO;

public class TestTime {
	
	public static void main(String[] args) {
		System.out.println(new TestTime().checkTime( 
				new UserVO("010-1234-1234",
				"4321", "테스트", 901010, 1)));
	}
	
	
	public CheckVO checkTime(UserVO user){
		CheckVO check = new CheckVO();
		final int time[] = {9, 12, 17};
		final int difference = 30;
		String result = null;
		Calendar calendar = Calendar.getInstance(); 
		int day = calendar.get(calendar.DAY_OF_WEEK); // 일요일0, 월요일1, 화요일2 .....
		int hour = calendar.get(calendar.HOUR_OF_DAY);
		int minute = calendar.get(calendar.MINUTE);
		System.out.println("현재 시간 " + day + "요일 " + hour +":"+minute);
		int set = -1;
		for(int i=0; i<3; i++){
			if(day >=1 && day <= 5){
				// 월요일 부터 금요일 인 경우에만 계산
				if(hour - time[i] <=2 ){
					result = "지각";
					set = i;
				}
				if(time[i] >= hour && (time[i] - hour) <= 1 && minute >= difference){
					// 해당 시간 30분 이전
					result = "출석";
					set = i;
				}else if(hour == time[i] && minute < difference){
					// 해당 시간 30분 이내까지 (30분 후까지는 출석 쳐주마)
					result = "출석";
					set = i;
				}
			}
		}
		if(set == 0) check.setPart("오전");
		if(set == 1) check.setPart("오후");
		if(set == 2) check.setPart("끝");
		check.setPhone(user.getPhone());
		check.setName(user.getName());
		check.setTime(hour+":"+minute);
		check.setFlag(result);
		return check;
	}
}
