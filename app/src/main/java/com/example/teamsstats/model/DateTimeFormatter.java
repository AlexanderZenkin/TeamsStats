package com.example.teamsstats.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeFormatter {

    public String dateTimeFormatter(Date date, int plusDays) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, plusDays);

        return formatter.format(cal.getTime().getTime());
    }
}
