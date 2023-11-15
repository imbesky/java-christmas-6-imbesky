package christmas.event;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.VisitDate;
import christmas.service.dicount.DiscountEvent;
import christmas.service.dicount.SpecialDiscountEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpecialDiscountTest {
    @Test
    @DisplayName("특별 할인: 이벤트 대상일(일요일)")
    void specialDiscountInRangeSunday() {
        final VisitDate visitDate = new VisitDate("17"); // 일요일
        final DiscountEvent discountEvent = new SpecialDiscountEvent(visitDate.inquireVisitDate());

        final int price = discountEvent.price();

        assertThat(price).isEqualTo(1_000);
    }

    @Test
    @DisplayName("특별 할인: 이벤트 대상일(크리스마스)")
    void specialDiscountInRangeChristmas() {
        final VisitDate visitDate = new VisitDate("25");
        final DiscountEvent discountEvent = new SpecialDiscountEvent(visitDate.inquireVisitDate());

        final int price = discountEvent.price();

        assertThat(price).isEqualTo(1_000);
    }

    @Test
    @DisplayName("특별 할인: 이벤트 미 대상일")
    void specialDiscountOutRange() {
        final VisitDate visitDate = new VisitDate("2");
        final DiscountEvent discountEvent = new SpecialDiscountEvent(visitDate.inquireVisitDate());

        final boolean apply = discountEvent.applicable();

        assertThat(apply).isEqualTo(false);
    }
}
