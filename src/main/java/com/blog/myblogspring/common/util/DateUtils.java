package com.blog.myblogspring.common.util;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

public class DateUtils {

    public static final String YEAR_MONTH_DAY_HOUR_MINUTE_SECOND = "yyyy-MM-dd HH:mm:ss";
    public static final String YEAR_MONTH_DAY = "yyyy-MM-dd";

    public DateTime getCurrentDate(){
        return Instant.now().toDateTime();
    }

    public DateTime dateToDateTime(Date date) {
        return new DateTime(date);
    }

    public DateTime stringToDateTime(String format, String date) {
        if (format == null) {
            format = YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;
        }
        DateTime datetime = DateTimeFormat.forPattern(format).parseDateTime(date);
        return datetime;
    }

    public Long stringToMills(String format, String date) {
        if (format == null) {
            format = YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;
        }
        if (date == null) {
            return null;
        }
        Long mills = DateTimeFormat.forPattern(format).parseDateTime(date).getMillis() / 1000;
        return mills;
    }

    public Date addMinute(DateTime dateTime, Integer minute){
        return dateTime.plusMinutes(minute).toDateTime().toDate();
    }

    public Float getPeriodByStringDate(String startDate, String endDate) {

        Days days = Days.daysBetween(stringToDateTime(YEAR_MONTH_DAY, startDate), stringToDateTime(YEAR_MONTH_DAY, endDate));

        return (float)days.getDays() +1;
    }

    public Integer getYearByDateTime(DateTime startDate, DateTime endDate) {
        Years years = Years.yearsBetween(startDate, endDate);
        return years.getYears();
    }
    public DateTime addYear(DateTime dateTime, Integer year){
        return dateTime.plusYears(year).toDateTime();
    }


    public Integer getPeriodByStringMonth(DateTime startDate, DateTime endDate) {
        Months months = Months.monthsBetween(startDate, endDate);
        return months.getMonths();
    }

    public Integer getMonthByDateTime(DateTime startDate, DateTime endDate) {
        Months month = Months.monthsBetween(startDate, endDate);
        return month.getMonths();
    }

    public Integer compareDateTime(DateTime startDate, DateTime endDate) {
        return startDate.compareTo(endDate);
    }

    public String dateTimeToString(DateTime dateTime) {
        DateTimeFormatter fmt = DateTimeFormat.forPattern(YEAR_MONTH_DAY);
        String result = fmt.print(dateTime);
        return result;
    }

    public Float excludeWeekend(String startDate, String endDate) {

        DateTime start = stringToDateTime(YEAR_MONTH_DAY, startDate);
        DateTime end = stringToDateTime(YEAR_MONTH_DAY, endDate);
        int weekendCount = 0;
        while (start.compareTo(end) <= 0) {
            if (start.getDayOfWeek() == 6 || start.getDayOfWeek() == 7) {
                weekendCount++;
            }
            start = start.plusDays(1);
        }
        Days days = Days.daysBetween(stringToDateTime(YEAR_MONTH_DAY, startDate), stringToDateTime(YEAR_MONTH_DAY, endDate));

        return (float)days.getDays() + 1 - weekendCount;
    }

}
