package christmas.service.dicount;

import static christmas.constant.Discount.WEEKEND;
import static christmas.constant.MenuType.MAIN;
import static christmas.constant.Number.INITIAL_VALUE;

import christmas.constant.Discount;
import christmas.constant.MenuType;
import christmas.util.DayUtil;
import java.time.LocalDate;
import java.util.Map;

public class WeekendDiscountEvent extends DayDiscountEvent {
    private final MenuType targetType = MAIN;

    public WeekendDiscountEvent(final LocalDate visitDate, final Map<MenuType, Integer> numberByMenuType) {
        super(visitDate, numberByMenuType);
    }

    @Override
    public boolean applicable() {
        return (DayUtil.isWeekEnd(visitDate)
                && numberByMenuType.get(targetType) != INITIAL_VALUE);
    }

    @Override
    public Discount discountType() {
        return WEEKEND;
    }

    @Override
    public int price() {
        return DISCOUNT_UNIT * numberByMenuType.get(targetType);
    }
}
