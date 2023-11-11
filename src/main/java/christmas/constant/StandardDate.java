package christmas.constant;

import java.time.LocalDate;

public class StandardDate {
    public static final int YEAR = 2023;
    public static final int MONTH = 12;
    private static final int FIRST = 1;
    private static final int TWENTY_FIFTH = 25;
    private static final int THIRTY_FIRST = 31;

    public static final LocalDate EVENT_START_DATE = LocalDate.of(YEAR, MONTH, FIRST);
    public static final LocalDate EVENT_END_DATE = LocalDate.of(YEAR, MONTH, THIRTY_FIRST);
    public static final LocalDate DDAY_DISCOUNT_START_DATE = EVENT_START_DATE;
    public static final LocalDate DDAY_DISCOUNT_END_DATE = LocalDate.of(YEAR, MONTH, TWENTY_FIFTH);
    public static final LocalDate CHRISTMAS = DDAY_DISCOUNT_END_DATE;
}