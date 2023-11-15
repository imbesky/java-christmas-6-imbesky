package christmas.service.dicount;

import static christmas.constant.Discount.CHRISTMAS_DDAY;
import static christmas.constant.StandardDate.DDAY_DISCOUNT_END_DATE;
import static christmas.constant.StandardDate.DDAY_DISCOUNT_START_DATE;

import christmas.constant.Discount;
import christmas.util.DayUtil;
import java.time.LocalDate;

public class ChristmasDdayDiscountEvent implements DiscountEvent {
    private final LocalDate visitDate;
    private static final int DISCOUNT_UNIT = 100;
    private static final int INITIAL_DISCOUNT_PRICE = 1_000;

    public ChristmasDdayDiscountEvent(final LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    @Override
    public boolean applicable() {
        return DayUtil.isBetween(DDAY_DISCOUNT_START_DATE, DDAY_DISCOUNT_END_DATE, visitDate);
    }

    @Override
    public Discount discountType() {
        return CHRISTMAS_DDAY;
    }

    @Override
    public int price() {
        return (INITIAL_DISCOUNT_PRICE + DISCOUNT_UNIT * visitDate.compareTo(DDAY_DISCOUNT_START_DATE));
    }

}
