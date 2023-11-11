package christmas.order;

import static christmas.constant.message.Error.INVALIDATE_ORDER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import christmas.validator.NumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberValidateTest {
    final NumberValidator validator = new NumberValidator();

    @Test
    @DisplayName("개수 검증: 숫자가 아님")
    void notNumericInput() {
        final String input = "하하하";

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.isNumeric(input));

        assertThat(exception.getMessage().equals(INVALIDATE_ORDER));
    }

    @Test
    @DisplayName("개수 검증: 숫자임")
    void numericInput() {
        final String input = "3";

        assertDoesNotThrow(() -> validator.isNumeric(input));
    }

    @Test
    @DisplayName("개수 검증: 최소 주문 개수(1개) 미만")
    void underMin() {
        final String input = "0";

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.isInRange(input));

        assertThat(exception.getMessage().equals(INVALIDATE_ORDER));
    }

    @Test
    @DisplayName("개수 검증: 최소 주문 개수(1개) 이상")
    void overMin() {
        final String input = "1";

        assertDoesNotThrow(() -> validator.isInRange(input));
    }
}
