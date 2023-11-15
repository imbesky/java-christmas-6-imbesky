package christmas.constant;

import java.time.LocalDate;

public class StandardDate {
    private static final int FIRST = 1;
    private static final int TWENTY_FIFTH = 25;
    public static final int EVENT_YEAR = 2023;
    public static final int EVENT_MONTH = 12;
    public static final int EVENT_START_DAY_OF_MONTH = 1;
    public static final int EVENT_END_DAY_OF_MONTH = 31;
    public static final LocalDate DDAY_DISCOUNT_START_DATE = LocalDate.of(EVENT_YEAR, EVENT_MONTH, FIRST);
    public static final LocalDate DDAY_DISCOUNT_END_DATE = LocalDate.of(EVENT_YEAR, EVENT_MONTH, TWENTY_FIFTH);
    public static final LocalDate CHRISTMAS = LocalDate.of(EVENT_YEAR, EVENT_MONTH, TWENTY_FIFTH);
}