package christmas.service.dicount;

import christmas.constant.Discount;
import christmas.constant.MenuType;
import java.time.LocalDate;
import java.util.Map;

public class DayDiscountEvent implements DiscountEvent {
    protected final LocalDate visitDate;
    protected final Map<MenuType, Integer> numberByMenuType;

    public DayDiscountEvent(final LocalDate visitDate, final Map<MenuType, Integer> numberByMenuType) {
        this.visitDate = visitDate;
        this.numberByMenuType = numberByMenuType;
    }

    @Override
    public boolean applicable() {
        return false;
    }

    @Override
    public Discount discountType() {
        return null;
    }

    @Override
    public int price() {
        return 0;
    }
}
