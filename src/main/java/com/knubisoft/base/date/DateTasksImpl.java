package com.knubisoft.base.date;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

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
        SimpleDateFormat dateFormat = new SimpleDateFormat("E, dd MMM yyyy", Locale.ENGLISH);
        int month;
        Date parseDate = null;
        try {
            parseDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDate);
        month = calendar.get(Calendar.MONTH);
        return month+1;
    }

    @Override
    public String findBiggestDate(String date1, String date2, String date3) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parseDate1 = null;
        Date parseDate2 = null;
        Date parseDate3 = null;
        try {
            parseDate1 = dateFormat.parse(date1);
            parseDate2 = dateFormat.parse(date2);
            parseDate3 = dateFormat.parse(date3);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date biggest = Collections.max(Arrays.asList(parseDate1, parseDate2, parseDate3));
        String strDate = dateFormat.format(biggest);
        return strDate;
    }

    @Override
    public String getLastDayOfTheMonth(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(Locale.ENGLISH );
        LocalDate date1 = LocalDate.parse(date, formatter);
        LocalDate start = date1.with(firstDayOfMonth());
        LocalDate end = date1.with(lastDayOfMonth());
        return end.toString();
    }

    @Override
    public String sumTimes(String time1, String time2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String sum = LocalTime.parse(time1).plusSeconds(LocalTime.parse(time2)
                .toSecondOfDay()).format(formatter);
        return sum;
    }

    @Override
    public String getDateAfter2Weeks(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(Locale.ENGLISH );
        LocalDate date1 = LocalDate.parse(date, formatter);
        return date1.plusWeeks(2).toString();
    }

    @Override
    public long getNumberOfDaysBetweenTwoDates(String date1, String date2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(Locale.ENGLISH );
        LocalDate dateStart = LocalDate.parse(date1, formatter);
        LocalDate dateFinish = LocalDate.parse(date2, formatter);
        long daysBetween = DAYS.between(dateStart, dateFinish);
        return daysBetween;
    }

    @Override
    public String[] getTheNextAndPreviousFriday(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(Locale.ENGLISH );
        LocalDate dateStart = LocalDate.parse(date, formatter);
        LocalDate fridayNext = dateStart.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        LocalDate fridayPrevious = dateStart.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        String [] arr = {fridayPrevious.toString(), fridayNext.toString()};
        return arr;
    }

    @Override
    public int getNumberOfMonthsRemainingInTheYear(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(Locale.ENGLISH );
        LocalDate dateStart = LocalDate.parse(date, formatter);
        LocalDate lastDayOfYear = dateStart.with(TemporalAdjusters.lastDayOfYear());
        Period period = dateStart.until(lastDayOfYear);
        return period.getMonths();
    }
}
