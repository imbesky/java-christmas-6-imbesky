package christmas.visitDate;

import static christmas.constant.message.Error.INVALIDATE_DATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import christmas.validator.VisitDateValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VisitDateValidateTest {
    final VisitDateValidator validator = new VisitDateValidator();

    @Test
    @DisplayName("방문 날짜 검증: 유요한 날짜(숫자)")
    void numericDate() {
        final String input = "12";

        assertDoesNotThrow(() -> validator.isNumeric(input));
    }

    @Test
    @DisplayName("방문 날짜 검증: 유효한 날짜(범위 내)")
    void inRangeDate() {
        final String input = "12";

        assertDoesNotThrow(() -> validator.isProperDateRange(input));
    }


    @Test
    @DisplayName("방문 날짜 검증: 날짜가 아님(empty)")
    void emptyDate() {
        final String input = "";

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.isNumeric(input));

        assertThat(exception.getMessage().equals(INVALIDATE_DATE));
    }

    @Test
    @DisplayName("방문 날짜 검증: 날짜가 아님(blank)")
    void blankDate() {
        final String input = " ";

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.isNumeric(input));

        assertThat(exception.getMessage().equals(INVALIDATE_DATE));
    }

    @Test
    @DisplayName("방문 날짜 검증: 날짜가 아님(문자)")
    void charDate() {
        final String input = "s";

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.isNumeric(input));

        assertThat(exception.getMessage().equals(INVALIDATE_DATE));
    }

    @Test
    @DisplayName("방문 날짜 검증: 범위 미만")
    void underMinDate() {
        final String input = "0";

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.isProperDateRange(input));

        assertThat(exception.getMessage().equals(INVALIDATE_DATE));
    }

    @Test
    @DisplayName("방문 날짜 검증: 범위 초과")
    void overMaxDate() {
        final String input = "32";

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.isProperDateRange(input));

        assertThat(exception.getMessage().equals(INVALIDATE_DATE));
    }
}
