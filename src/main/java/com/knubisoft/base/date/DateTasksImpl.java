package com.knubisoft.base.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTasksImpl implements DateTasks {

    @Override
    public String add1Day(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        try {
        date1 = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        calendar.add(Calendar.DATE, 1);
        date1 = calendar.getTime();
        return formatter.format(date1);
    }

    @Override
    public int getMonthFromDate(String date) {
        return -1;
    }

    @Override
    public String findBiggestDate(String date1, String date2, String date3) {
        return null;
    }

    @Override
    public String getLastDayOfTheMonth(String date) {
        return null;
    }

    @Override
    public String sumTimes(String time1, String time2) {
        return null;
    }

    @Override
    public String getDateAfter2Weeks(String date) {
        return null;
    }

    @Override
    public long getNumberOfDaysBetweenTwoDates(String date1, String date2) {
        return -1;
    }

    @Override
    public String[] getTheNextAndPreviousFriday(String date) {
        return null;
    }

    @Override
    public int getNumberOfMonthsRemainingInTheYear(String date) {
        return -1;
    }
}
