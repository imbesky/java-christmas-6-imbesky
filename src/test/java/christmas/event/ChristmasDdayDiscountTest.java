package christmas.event;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.VisitDate;
import christmas.service.dicount.ChristmasDdayDiscountEvent;
import christmas.service.dicount.DiscountEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChristmasDdayDiscountTest {

    @Test
    @DisplayName("크리스마스 디데이 할인: 이벤트 기간 내")
    void christmasDdayDiscountInRange() {
        final VisitDate visitDate = new VisitDate("5");
        final DiscountEvent discountEvent = new ChristmasDdayDiscountEvent(visitDate.inquireVisitDate());

        final boolean apply = discountEvent.applicable();
        final int discountPrice = discountEvent.price();

        assertThat(apply).isEqualTo(true);
        assertThat(discountPrice).isEqualTo(1_400);
    }

    @Test
    @DisplayName("크리스마스 디데이 할인: 이벤트 기간 외")
    void christmasDdayDiscountOutRange() {
        final VisitDate visitDate = new VisitDate("28");
        final DiscountEvent discountEvent = new ChristmasDdayDiscountEvent(visitDate.inquireVisitDate());

        final boolean apply = discountEvent.applicable();

        assertThat(apply).isEqualTo(false);
    }
}
