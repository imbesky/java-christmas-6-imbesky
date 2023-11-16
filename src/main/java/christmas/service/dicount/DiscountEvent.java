package christmas.service.dicount;

import christmas.constant.Discount;

public interface DiscountEvent {
    boolean applicable();

    Discount discountType();

    int price();
}
