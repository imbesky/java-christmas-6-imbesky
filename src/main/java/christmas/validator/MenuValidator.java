package christmas.validator;

import static christmas.constant.message.Error.INVALIDATE_ORDER;
import static christmas.constant.message.Tip.DUPLICATE_MENU;
import static christmas.constant.message.Tip.NOT_IN_MENU;

import christmas.constant.Menu;
import java.util.Map;

public class MenuValidator {
    public void isValidateMenu(String input) {
        if (Menu.findByName(input) == null) {
            throw new IllegalArgumentException(INVALIDATE_ORDER.getMessage()
                    .concat(NOT_IN_MENU.getMessage()));
        }
    }

    public void isNotDuplicateMenu(Map<Menu, Integer> orders, String menu) {
        if (orders.containsKey(Menu.findByName(menu))) {
            throw new IllegalArgumentException(INVALIDATE_ORDER.getMessage()
                    .concat(DUPLICATE_MENU.getMessage()));
        }
    }
}
