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

    private static final Discount DISCOUNT_TYPE = WEEKEND;
    private static final MenuType TARGET_TYPE = MAIN;

    public WeekendDiscountEvent(final LocalDate visitDate, final Map<MenuType, Integer> numberByMenuType) {
        super(visitDate, numberByMenuType);
    }

    @Override
    public boolean applicable() {
        return (DayUtil.isWeekEnd(visitDate)
                && numberByMenuType.get(TARGET_TYPE) != INITIAL_VALUE);
    }

    @Override
    public Discount discountType() {
        return DISCOUNT_TYPE;
    }

    @Override
    public int price() {
        return DISCOUNT_TYPE.unitPrice() * numberByMenuType.get(TARGET_TYPE);
    }
}
