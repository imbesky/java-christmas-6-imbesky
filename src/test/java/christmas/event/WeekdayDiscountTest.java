package christmas.event;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.Order;
import christmas.model.VisitDate;
import christmas.service.DiscountEvent;
import christmas.service.WeekdayDiscountEvent;
import christmas.util.Converter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WeekdayDiscountTest {
    @Test
    @DisplayName("평일 할인: 이벤트 대상일, 대상 항목 포함")
    void weekdayDiscountInRangeIncludeTarget() {
        final String order = "초코케이크-10";
        final Order orders = new Order(Converter.toOrderFormat(order));
        final VisitDate visitDate = new VisitDate("12"); // 화요일
        final DiscountEvent discountEvent = new WeekdayDiscountEvent(visitDate.inquireVisitDate(),
                orders.inquireOrders());

        final boolean apply = discountEvent.applicable();
        final int price = discountEvent.price();

        assertThat(apply).isEqualTo(true);
        assertThat(price).isEqualTo(20_230);
    }

    @Test
    @DisplayName("평일 할인: 이벤트 대상일, 대상 항목 미포함")
    void weekdayDiscountInRangeExcludeTarget() {
        final String order = "해산물파스타-10";
        final Order orders = new Order(Converter.toOrderFormat(order));
        final VisitDate visitDate = new VisitDate("14"); // 목요일
        final DiscountEvent discountEvent = new WeekdayDiscountEvent(visitDate.inquireVisitDate(),
                orders.inquireOrders());

        final boolean apply = discountEvent.applicable();

        assertThat(apply).isEqualTo(false);
    }

    @Test
    @DisplayName("평일 할인: 이벤트 미 대상일, 대상 항목 포함")
    void weekdayDiscountOutRangeIncludeTarget() {
        final String order = "초코케이크-10";
        final Order orders = new Order(Converter.toOrderFormat(order));
        final VisitDate visitDate = new VisitDate("16"); // 토요일
        final DiscountEvent discountEvent = new WeekdayDiscountEvent(visitDate.inquireVisitDate(),
                orders.inquireOrders());

        final boolean apply = discountEvent.applicable();

        assertThat(apply).isEqualTo(false);
    }
}
