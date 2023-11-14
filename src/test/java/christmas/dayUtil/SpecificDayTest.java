package christmas.dayUtil;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.util.DayUtil;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpecificDayTest {
    private final static LocalDate ordinaryDay = LocalDate.of(2023, 12, 5); //화
    private final static LocalDate sunday = LocalDate.of(2023, 12, 10); //일
    private final static LocalDate christmas = LocalDate.of(2023, 12, 25);

    @Test
    @DisplayName("일요일 여부 확인: 일요일인 경우")
    void checkSundayTrue() {
        final boolean result = DayUtil.isSunday(sunday);

        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("일요일 여부 확인: 일요일이 아닌 경우")
    void checkSundayFalse() {
        final boolean result = DayUtil.isSunday(ordinaryDay);

        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("크리스마스 여부 확인: 크리스마스인 경우")
    void checkChristmasTrue() {
        final boolean result = DayUtil.isChristmas(christmas);

        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("크리스마스 여부 확인: 크리스마스가 아닌 경우")
    void checkChristmasFalse() {
        final boolean result = DayUtil.isChristmas(ordinaryDay);

        assertThat(result).isEqualTo(false);
    }
}
