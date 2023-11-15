package christmas.service.dicount;

import static christmas.constant.Discount.CHRISTMAS_DDAY;
import static christmas.constant.StandardDate.CHRISTMAS;
import static christmas.constant.StandardDate.EVENT_MONTH;
import static christmas.constant.StandardDate.EVENT_YEAR;

import christmas.constant.Discount;
import christmas.util.DayUtil;
import java.time.LocalDate;

public class ChristmasDdayDiscountEvent implements DiscountEvent {
    private static final LocalDate START_DATE = LocalDate.of(EVENT_YEAR, EVENT_MONTH, 1);
    private static final Discount DISCOUNT_TYPE = CHRISTMAS_DDAY;
    private final LocalDate visitDate;

    public ChristmasDdayDiscountEvent(final LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    @Override
    public boolean applicable() {
        return DayUtil.isBetween(START_DATE, CHRISTMAS, visitDate);
    }

    @Override
    public Discount discountType() {
        return DISCOUNT_TYPE;
    }

    @Override
    public int price() {
        return (DISCOUNT_TYPE.initialPrice()
                + DISCOUNT_TYPE.unitPrice() * visitDate.compareTo(START_DATE));
    }

}
