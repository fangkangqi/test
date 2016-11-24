package com.example.notification;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTime {

	public MyTime() {
		// TODO 自动生成的构造函数存根
	}

	public static String getTime(int year,int mon,int day,int hour, int min) {
		
		String mins,mons,days,hours;
		if(hour<10)
			hours = 0+String.valueOf(hour);
		else
			hours = String.valueOf(hour);
		if(min<10)
			mins =0+ String.valueOf(min);
		else
			mins = String.valueOf(min);
		if(mon<10)
			mons =0+ String.valueOf(mon);
		else
			mons = String.valueOf(mon);
		if(day<10)
			days = 0+String.valueOf(mon);
		else
			days = String.valueOf(day);
		return year+":"+mons+":"+days+":"+hours+":"+mins;

	}
}
