package com.zb.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Str2Date {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public static Date str2date(String time){
        Date date = null;

        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
    public  static Object date2str(Date date){
        String time = sdf.format(date);
        return time;
    }
}
