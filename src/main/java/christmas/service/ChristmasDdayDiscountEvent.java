package christmas.service;

import static christmas.constant.Discount.CHRISTMAS_DDAY;
import static christmas.constant.StandardDate.DDAY_DISCOUNT_END_DATE;
import static christmas.constant.StandardDate.DDAY_DISCOUNT_START_DATE;

import christmas.constant.Discount;
import christmas.util.DayUtil;
import java.time.LocalDate;

public class ChristmasDdayDiscountEvent implements DiscountEvent {
    private final LocalDate visitDate;
    private final int DISCOUNT_UNIT = 100;
    private final int INITIAL_DISCOUNT_PRICE = 1_000;

    public ChristmasDdayDiscountEvent(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    @Override
    public boolean appliable() {
        return DayUtil.isBetween(DDAY_DISCOUNT_START_DATE, DDAY_DISCOUNT_END_DATE, visitDate);
    }

    @Override
    public Discount type() {
        return CHRISTMAS_DDAY;
    }

    @Override
    public int price() {
        return (INITIAL_DISCOUNT_PRICE + DISCOUNT_UNIT * visitDate.compareTo(DDAY_DISCOUNT_START_DATE));
    }

}
