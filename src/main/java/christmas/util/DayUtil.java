package christmas.util;

import static christmas.constant.StandardDate.CHRISTMAS;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayUtil {
    public static boolean isWeekDay(LocalDate date) {
        return (date.getDayOfWeek() != DayOfWeek.FRIDAY && date.getDayOfWeek() != DayOfWeek.SATURDAY);
    }

    public static boolean isWeekEnd(LocalDate date) {
        return (date.getDayOfWeek() == DayOfWeek.FRIDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY);
    }

    public static boolean isSunday(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    public static boolean isChristmas(LocalDate date) {
        return date.equals(CHRISTMAS);
    }

    public static boolean isBetween(LocalDate startDate, LocalDate endDate, LocalDate date) {
        return (!date.isBefore(endDate) && !date.isAfter(startDate));
    }
}
