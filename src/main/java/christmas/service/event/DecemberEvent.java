package christmas.service.event;

import static christmas.constant.Number.EVENT_APPLY_MIN_PRICE;
import static christmas.constant.StandardDate.EVENT_MONTH;
import static christmas.constant.StandardDate.EVENT_YEAR;

import christmas.util.DayUtil;
import java.time.LocalDate;

public class DecemberEvent implements Event {
    private static final LocalDate START_DATE = LocalDate.of(EVENT_YEAR, EVENT_MONTH, 1);
    private static final LocalDate END_DATE = LocalDate.of(EVENT_YEAR, EVENT_MONTH, START_DATE.lengthOfMonth());
    private final LocalDate visitDate;
    private final int totalListPrice;

    public DecemberEvent(final LocalDate visitDate, final int totalListPrice) {
        this.visitDate = visitDate;
        this.totalListPrice = totalListPrice;
    }

    @Override
    public boolean applicable() {
        return totalListPrice < EVENT_APPLY_MIN_PRICE
                && DayUtil.isBetween(START_DATE, END_DATE, visitDate);
    }
}
