package christmas.service;

import static christmas.constant.Discount.WEEKEND;
import static christmas.constant.MenuType.MAIN;
import static christmas.constant.Number.INITIAL_VALUE;

import christmas.constant.Discount;
import christmas.constant.Menu;
import christmas.util.DayUtil;
import java.time.LocalDate;
import java.util.Map;

public class WeekendDiscountEvent extends DayDiscountEvent {
    public WeekendDiscountEvent(LocalDate visitDate, Map<Menu, Integer> orders) {
        super(visitDate, orders);
    }

    @Override
    public boolean applicable() {
        return (DayUtil.isWeekEnd(visitDate) && numberOfTargetMenu(MAIN) != INITIAL_VALUE);
    }

    @Override
    public Discount discountType() {
        return WEEKEND;
    }

    @Override
    public int price() {
        return DISCOUNT_UNIT * numberOfTargetMenu(MAIN);
    }
}
