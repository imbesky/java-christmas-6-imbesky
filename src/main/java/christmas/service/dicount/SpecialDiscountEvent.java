package christmas.service.dicount;

import static christmas.constant.Discount.SPECIAL;

import christmas.constant.Discount;
import christmas.util.DayUtil;
import java.time.LocalDate;

public class SpecialDiscountEvent implements DiscountEvent {
    private static final Discount DISCOUNT_TYPE = SPECIAL;
    private final LocalDate visitDate;

    public SpecialDiscountEvent(final LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    @Override
    public boolean applicable() {
        return (DayUtil.isSunday(visitDate) || DayUtil.isChristmas(visitDate));
    }

    @Override
    public Discount discountType() {
        return DISCOUNT_TYPE;
    }

    @Override
    public int price() {
        return DISCOUNT_TYPE.initialPrice();
    }
}
