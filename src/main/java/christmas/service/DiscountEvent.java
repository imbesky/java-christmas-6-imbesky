package christmas.service;

import christmas.constant.Discount;

public interface DiscountEvent {
    boolean applicable();

    Discount discountType();

    int price();
}
