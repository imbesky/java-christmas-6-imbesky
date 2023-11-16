package christmas.event;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.service.event.DecemberEvent;
import christmas.service.event.Event;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EventExclusionTest {
    @Test
    @DisplayName("이벤트 제외 대상인 경우: 총주문 금액 10,000원 미만")
    void eventExclusion() {
        final LocalDate visitDate = LocalDate.of(2023, 12, 8);
        final int totalListPrice = 9_999;

        final Event event = new DecemberEvent(visitDate, totalListPrice);

        assertThat(event.applicable()).isEqualTo(false);
    }
}
