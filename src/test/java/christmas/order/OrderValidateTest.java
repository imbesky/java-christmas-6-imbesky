package christmas.order;

import static christmas.constant.message.Error.INVALIDATE_ORDER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import christmas.constant.Menu;
import christmas.validator.OrderValidator;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderValidateTest {
    final OrderValidator validator = new OrderValidator();

    @Test
    @DisplayName("주문 검증: 음료만 주문")
    void orderOnlyBeverage() {
        final Map<Menu, Integer> orders = new HashMap<>();
        orders.put(Menu.findByName("레드와인"), 1);
        orders.put(Menu.findByName("샴페인"), 1);
        orders.put(Menu.findByName("제로콜라"), 1);

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.isProperOrder(orders));

        assertThat(exception.getMessage().equals(INVALIDATE_ORDER));
    }

    @Test
    @DisplayName("주문 검증: 최대 주문 가능 개수(20개) 초과")
    void overMaxOrderNumber() {
        final Map<Menu, Integer> orders = new HashMap<>();
        orders.put(Menu.findByName("티본스테이크"), 12);
        orders.put(Menu.findByName("초코케이크"), 1);
        orders.put(Menu.findByName("타파스"), 8);

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.inOrderRange(orders));

        assertThat(exception.getMessage().equals(INVALIDATE_ORDER));
    }
}
