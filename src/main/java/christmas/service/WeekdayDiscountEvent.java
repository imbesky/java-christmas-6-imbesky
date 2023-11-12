package christmas.service;

import static christmas.constant.Discount.WEEKDAY;
import static christmas.constant.MenuType.DESSERT;
import static christmas.constant.Number.INITIAL_VALUE;

import christmas.constant.Discount;
import christmas.constant.Menu;
import christmas.util.DayUtil;
import java.time.LocalDate;
import java.util.Map;

public class WeekdayDiscountEvent extends DayDiscountEvent {
    public WeekdayDiscountEvent(LocalDate visitDate, Map<Menu, Integer> orders) {
        super(visitDate, orders);
    }

    @Override
    public boolean applicable() {
        return (DayUtil.isWeekDay(visitDate) && numberOfTargetMenu(DESSERT) != INITIAL_VALUE);
    }

    @Override
    public Discount type() {
        return WEEKDAY;
    }

    @Override
    public int price() {
        return DISCOUNT_UNIT * numberOfTargetMenu(DESSERT);
    }
}
