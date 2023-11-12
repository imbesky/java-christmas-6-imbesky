package christmas.order;

import static christmas.constant.message.Error.INVALIDATE_ORDER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import christmas.model.Order;
import christmas.util.Converter;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderInputFormatValidateTest {
    private Order order;

    @Test
    @DisplayName("주문 포맷 검증: 유효한 포맷")
    void validateFormat() {
        final String input = "아이스크림-2,타파스-1,레드와인-1,바비큐립-2";
        final List<String[]> formattedInput = Converter.toOrderFormat(input);

        assertDoesNotThrow(() -> order = new Order(formattedInput));
    }

    @Test
    @DisplayName("주문 포맷 검증: 유효하지 않은 포맷")
    void invalidateFormat() {
        final String input = "아이스크림1,타파스-1,레드와인-1바비큐립-2";
        final List<String[]> formattedInput = Converter.toOrderFormat(input);

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> order = new Order(formattedInput));

        assertThat(exception.getMessage().equals(INVALIDATE_ORDER));
    }
}
