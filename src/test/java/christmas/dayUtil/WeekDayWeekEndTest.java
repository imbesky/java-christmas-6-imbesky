package christmas.dayUtil;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.util.DayUtil;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WeekDayWeekEndTest {
    private final static LocalDate weekend = LocalDate.of(2023, 11, 11); //토
    private final static LocalDate weekday = LocalDate.of(2023, 11, 12); //일

    @Test
    @DisplayName("주말 여부 확인: 주말인 경우")
    void checkWeekEndTrue() {
        final boolean result = DayUtil.isWeekEnd(weekend);

        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("주말 여부 확인: 주말이 아닌 경우")
    void checkWeekEndFalse() {
        final boolean result = DayUtil.isWeekEnd(weekday);

        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("주중 여부 확인: 주중인 경우")
    void checkWeekDayTrue() {
        final boolean result = DayUtil.isWeekDay(weekday);

        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("주중 여부 확인: 주중이 아닌 경우")
    void checkWeekDayFalse() {
        final boolean result = DayUtil.isWeekDay(weekend);

        assertThat(result).isEqualTo(false);
    }
}

