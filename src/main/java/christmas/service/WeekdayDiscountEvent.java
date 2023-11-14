package christmas.service;

import static christmas.constant.Discount.WEEKDAY;
import static christmas.constant.MenuType.DESSERT;
import static christmas.constant.Number.INITIAL_VALUE;

import christmas.constant.Discount;
import christmas.constant.MenuType;
import christmas.util.DayUtil;
import java.time.LocalDate;
import java.util.Map;

public class WeekdayDiscountEvent extends DayDiscountEvent {
    private final MenuType targetType = DESSERT;

    public WeekdayDiscountEvent(final LocalDate visitDate, final Map<MenuType, Integer> numberByMenuType) {
        super(visitDate, numberByMenuType);
    }

    @Override
    public boolean applicable() {
        return (DayUtil.isWeekDay(visitDate)
                && numberByMenuType.get(targetType) != INITIAL_VALUE);
    }

    @Override
    public Discount discountType() {
        return WEEKDAY;
    }

    @Override
    public int price() {
        return DISCOUNT_UNIT * numberByMenuType.get(targetType);
    }
}
