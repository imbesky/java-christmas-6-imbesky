package christmas.service;

import christmas.constant.Discount;
import christmas.constant.Menu;
import java.time.LocalDate;
import java.util.Map;

public class DayDiscountEvent implements DiscountEvent {
    protected final LocalDate visitDate;
    protected final Map<Menu, Integer> orders;
    protected static final int DISCOUNT_UNIT = 2_023;

    public DayDiscountEvent(LocalDate visitDate, Map<Menu, Integer> orders) {
        this.visitDate = visitDate;
        this.orders = orders;
    }

    @Override
    public boolean appliable() {
        return false;
    }

    @Override
    public Discount type() {
        return null;
    }

    @Override
    public int price() {
        return 0;
    }

    protected int numberOfTargetMenu(String type) {
        int number = 0;
        for (Menu menu : orders.keySet()) {
            if (menu.getType().equals(type)) {
                number++;
            }
        }
        return number;
    }
}
