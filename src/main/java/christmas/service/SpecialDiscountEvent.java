package christmas.service;

import static christmas.constant.Discount.SPECIAL;

import christmas.constant.Discount;
import christmas.util.DayUtil;
import java.time.LocalDate;

public class SpecialDiscountEvent implements DiscountEvent {
    private final LocalDate visitDate;

    public SpecialDiscountEvent(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    @Override
    public boolean applicable() {
        return (DayUtil.isSunday(visitDate) || DayUtil.isChristmas(visitDate));
    }

    @Override
    public Discount type() {
        return SPECIAL;
    }

    @Override
    public int price() {
        return 0;
    }
}
