package christmas.service;

import static christmas.constant.Discount.WEEKDAY;
import static christmas.constant.MenuType.DESSERT;

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
    public boolean appliable() {
        return DayUtil.isWeekDay(visitDate);
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