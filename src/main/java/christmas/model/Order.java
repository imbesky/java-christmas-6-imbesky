package christmas.model;

import static christmas.constant.Number.FIRST_INDEX;
import static christmas.constant.Number.INITIAL_VALUE;
import static christmas.constant.Number.PROPER_ORDER_LENGTH;
import static christmas.constant.Number.SECOND_INDEX;
import static christmas.constant.message.Error.INVALIDATE_ORDER;
import static christmas.constant.message.Tip.INVALIDATE_FORMAT;

import christmas.constant.Menu;
import christmas.constant.MenuType;
import christmas.validator.MenuValidator;
import christmas.validator.NumberValidator;
import christmas.validator.OrderValidator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Order {
    private final Map<Menu, Integer> orders = new HashMap<>(); //메뉴, 개수

    public Order(List<String[]> inputOrders) {
        for (String[] order : inputOrders) {
            validateInputFormat(order);
            validateMenu(order[FIRST_INDEX]);
            validateNumber(order[SECOND_INDEX]);
            saveOrder(Menu.findByName(order[FIRST_INDEX]), Integer.parseInt(order[SECOND_INDEX]));
        }
        validateOrder();
    }

    public Map<String, Integer> inquireOrders() {
        Map<String, Integer> orderMenuNameAndPrice = new HashMap<>();
        for (Entry<Menu, Integer> order : orders.entrySet()) {
            orderMenuNameAndPrice.put(order.getKey().getName(), order.getValue());
        }
        return orderMenuNameAndPrice;
    }

    public Map<MenuType, Integer> numberByMenuType() {
        Map<MenuType, Integer> numbers = new HashMap<>();
        for (MenuType menuType : MenuType.values()) {
            numbers.put(menuType, checkMatchedNumber(menuType));
        }
        return numbers;
    }

    private int checkMatchedNumber(MenuType menuType) {
        int count = INITIAL_VALUE;
        for (Entry<Menu, Integer> order : orders.entrySet()) {
            if (order.getKey().getType().equals(menuType)) {
                count += order.getValue();
            }
        }
        return count;
    }

    public int calculateTotalListPrice() {
        int totalListPrice = INITIAL_VALUE;
        for (Entry<Menu, Integer> order : orders.entrySet()) {
            totalListPrice += order.getKey().getPrice() * order.getValue();
        }
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
        validator.isNotDuplicateMenu(orders, menu);
    }

    private void validateNumber(String number) {
        NumberValidator validator = new NumberValidator();
        validator.isNumeric(number);
        validator.isInRange(number);
    }

    private void validateOrder() {
        OrderValidator validator = new OrderValidator();
        validator.isProperOrder(orders);
        validator.inOrderRange(orders);
    }

    private void saveOrder(Menu menu, int number) {
        orders.put(menu, number);
    }
}
