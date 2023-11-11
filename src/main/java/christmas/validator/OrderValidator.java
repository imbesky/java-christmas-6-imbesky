package christmas.validator;

import static christmas.constant.MenuType.BEVERAGE;
import static christmas.constant.Number.INITIAL_VALUE;
import static christmas.constant.Number.MAX_ORDER;
import static christmas.constant.message.Error.INVALIDATE_ORDER;
import static christmas.constant.message.Tip.ONLY_BEVERAGE;
import static christmas.constant.message.Tip.ORDER_OVER_MAX;

import christmas.constant.Menu;
import java.util.Map;

public class OrderValidator {
    public void isProperOrder(Map<Menu, Integer> orders) {
        for (Menu menu : orders.keySet()) {
            if (!menu.getType().equals(BEVERAGE)) {
                return;
            }
        }
        System.out.println(ONLY_BEVERAGE.getMessage());
        throw new IllegalArgumentException(INVALIDATE_ORDER.getMessage());
    }

    public void inOrderRange(Map<Menu, Integer> orders) {
        int orderedNumber = INITIAL_VALUE;
        for (Menu menu : orders.keySet()) {
            orderedNumber += orders.get(menu);
        }
        if (orderedNumber > MAX_ORDER) {
            System.out.println(ORDER_OVER_MAX.getMessage());
            throw new IllegalArgumentException(INVALIDATE_ORDER.getMessage());
        }
    }
}
