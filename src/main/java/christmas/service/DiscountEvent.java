package christmas.service;

import christmas.constant.Discount;

public interface DiscountEvent {
    boolean appliable();

    Discount type();

    int price();
}
