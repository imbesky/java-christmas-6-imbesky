package christmas.model;

import static christmas.constant.Number.FIRST_INDEX;
import static christmas.constant.Number.INITIAL_VALUE;
import static christmas.constant.Number.PROPER_ORDER_LENGTH;
import static christmas.constant.Number.SECOND_INDEX;
import static christmas.constant.message.Error.INVALIDATE_ORDER;
import static christmas.constant.message.Tip.INVALIDATE_FORMAT;

import christmas.constant.Menu;
import christmas.validator.MenuValidator;
import christmas.validator.NumberValidator;
import christmas.validator.OrderValidator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private final Map<Menu, Integer> orders = new HashMap<>();
    private int totalListPrice = INITIAL_VALUE;

    public Order(List<String[]> inputOrders) {
        for (String[] order : inputOrders) {
            validateInputFormat(order);
            validateMenu(order[FIRST_INDEX]);
            validateNumber(order[SECOND_INDEX]);
            saveOrder(Menu.findByName(order[FIRST_INDEX]), Integer.parseInt(order[SECOND_INDEX]));
        }
        validateOrder(inputOrders);
    }

    public Map<Menu, Integer> inquireOrders() {
        return orders;
    }

    public int inquireTotalListPrice() {
        return totalListPrice;
    }

    private void validateInputFormat(String[] order) {
        if (order.length != PROPER_ORDER_LENGTH) {
            throw new IllegalArgumentException(INVALIDATE_ORDER.getMessage()
                    .concat(INVALIDATE_FORMAT.getMessage()));
        }
    }

    private void validateMenu(String menu) {
        MenuValidator validator = new MenuValidator();
        validator.isValidateMenu(menu);
        validator.isNotDuplicateMenu(this.orders, menu);
    }

    private void validateNumber(String number) {
        NumberValidator validator = new NumberValidator();
        validator.isNumeric(number);
        validator.isInRange(number);
    }

    private void validateOrder(List<String[]> orders) {
        OrderValidator validator = new OrderValidator();
        validator.isProperOrder(this.orders);
        validator.inOrderRange(this.orders);
    }

    private void saveOrder(Menu menu, int number) {
        orders.put(menu, number);
        totalListPrice += menu.getPrice() * number;
    }
}
