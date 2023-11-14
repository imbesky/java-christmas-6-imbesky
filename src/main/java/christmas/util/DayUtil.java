package christmas.util;

import static christmas.constant.StandardDate.CHRISTMAS;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayUtil {
    public static boolean isWeekDay(final LocalDate date) {
        return (date.getDayOfWeek() != DayOfWeek.FRIDAY && date.getDayOfWeek() != DayOfWeek.SATURDAY);
    }

    public static boolean isWeekEnd(final LocalDate date) {
        return (date.getDayOfWeek() == DayOfWeek.FRIDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY);
    }

    public static boolean isSunday(final LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    public static boolean isChristmas(final LocalDate date) {
        return date.equals(CHRISTMAS);
    }

    public static boolean isBetween(final LocalDate startDate, final LocalDate endDate, final LocalDate date) {
        return (!date.isBefore(startDate) && !date.isAfter(endDate));
    }
}
