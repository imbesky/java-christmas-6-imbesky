package christmas.order;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.Menu;
import christmas.model.Order;
import christmas.util.Converter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SaveOrderTest {
    @Test
    @DisplayName("총주문 금액 테스트")
    void totalListPriceTest() {
        final String input = "아이스크림-1,타파스-1,레드와인-1,바비큐립-2";
        final List<String[]> formattedInput = Converter.toOrderFormat(input);

        final Order order = new Order(formattedInput);

        assertThat(order.calculateTotalListPrice()).isEqualTo(178_500);
    }

    @Test
    @DisplayName("주문 저장 테스트")
    void orderSaveTest() {
        final String input = "시저샐러드-1,샴페인-1,초코케이크-1";
        final List<String[]> formattedInput = Converter.toOrderFormat(input);

        final Order order = new Order(formattedInput);

        final Map<Menu, Integer> orders = new HashMap<>();
        orders.put(Menu.findByName("시저샐러드"), 1);
        orders.put(Menu.findByName("샴페인"), 1);
        orders.put(Menu.findByName("초코케이크"), 1);
        assertThat(order.inquireOrders().equals(orders));
    }
}
