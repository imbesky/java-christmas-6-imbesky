package christmas.order;

import static christmas.constant.message.Error.INVALIDATE_ORDER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import christmas.constant.Menu;
import christmas.validator.MenuValidator;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuValidateTest {
    final MenuValidator validator = new MenuValidator();

    @Test
    @DisplayName("메뉴 검증: 유효하지 않은 메뉴")
    void isValidateMenu() {
        final String input = "우테코특별메뉴";

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.isValidateMenu(input));

        assertThat(exception.getMessage().equals(INVALIDATE_ORDER));
    }

    @Test
    @DisplayName("메뉴 검증: 유효한 메뉴")
    void validateMenu() {
        final String input = "제로콜라";

        assertDoesNotThrow(() -> validator.isValidateMenu(input));
    }

    @Test
    @DisplayName("메뉴 검증: 중복된 메뉴")
    void isDuplicateMenu() {
        final String input = "샴페인";
        final Map<Menu, Integer> orders = new HashMap<>();
        orders.put(Menu.findByName("크리스마스파스타"), 1);
        orders.put(Menu.findByName("샴페인"), 1);
        orders.put(Menu.findByName("양송이수프"), 1);

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.isNotDuplicateMenu(orders, input));

        assertThat(exception.getMessage().equals(INVALIDATE_ORDER));
    }

    @Test
    @DisplayName("메뉴 검증: 중복되지 않은 메뉴")
    void notDuplicateMenu() {
        final String input = "바비큐립";
        final Map<Menu, Integer> orders = new HashMap<>();
        orders.put(Menu.findByName("크리스마스파스타"), 1);
        orders.put(Menu.findByName("샴페인"), 1);
        orders.put(Menu.findByName("양송이수프"), 1);

        assertDoesNotThrow(() -> validator.isNotDuplicateMenu(orders, input));
    }

}
