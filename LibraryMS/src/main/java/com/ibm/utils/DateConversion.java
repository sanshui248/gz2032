package com.ibm.utils;

import java.util.Calendar;
import java.util.Date;

public class DateConversion {
	//获取当前时间30天后的日期
	public static Date stepDay(Date sourceDate, int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(sourceDate);
        c.add(Calendar.DATE, day);
        return c.getTime();
    }
}
