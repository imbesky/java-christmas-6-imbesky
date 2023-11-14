package christmas.dayUtil;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.util.DayUtil;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DayBetweenTest {
    private final static LocalDate start = LocalDate.of(2023, 12, 1);
    private final static LocalDate end = LocalDate.of(2023, 12, 10);
    private final static LocalDate inRange = LocalDate.of(2023, 12, 6);
    private final static LocalDate outRange = LocalDate.of(2023, 12, 17);

    @Test
    @DisplayName("날짜 범위 확인: 범위 내인 경우")
    void dateInRange() {
        final boolean result = DayUtil.isBetween(start, end, inRange);

        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("날짜 범위 확인: 시작일과 일치하는 경우")
    void dateEqualsRangeStart() {
        final boolean result = DayUtil.isBetween(start, end, start);

        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("날짜 범위 확인: 종료일과 일치하는 경우")
    void dateEqualsRangeEnd() {
        final boolean result = DayUtil.isBetween(start, end, end);

        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("날짜 범위 확인: 범위에 표함되지 않는 경우")
    void dateOutRange() {
        final boolean result = DayUtil.isBetween(start, end, outRange);

        assertThat(result).isEqualTo(false);
    }
}
