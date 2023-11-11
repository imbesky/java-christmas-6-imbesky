package christmas.eventTest;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.Order;
import christmas.model.VisitDate;
import christmas.service.DiscountEvent;
import christmas.service.WeekendDiscountEvent;
import christmas.util.Converter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WeekendDiscountTest {
    @Test
    @DisplayName("주말 할인: 이벤트 대상일, 대상 항목 포함")
    void weekendDiscountInRangeIncludeTarget() {
        final String order = "티본스테이크-10";
        final Order orders = new Order(Converter.toOrderFormat(order));
        final VisitDate visitDate = new VisitDate("9"); // 토요일
        final DiscountEvent discountEvent = new WeekendDiscountEvent(visitDate.inquireVisitDate(),
                orders.inquireOrders());

        final int price = discountEvent.price();

        assertThat(price).isEqualTo(20_230);
    }

    @Test
    @DisplayName("평일 할인: 이벤트 대상일, 대상 항목 미포함")
    void weekendDiscountInRangeExcludeTarget() {
        final String order = "아이스크림-10";
        final Order orders = new Order(Converter.toOrderFormat(order));
        final VisitDate visitDate = new VisitDate("16"); // 토요일
        final DiscountEvent discountEvent = new WeekendDiscountEvent(visitDate.inquireVisitDate(),
                orders.inquireOrders());

        final int price = discountEvent.price();

        assertThat(price).isEqualTo(0);
    }

    @Test
    @DisplayName("평일 할인: 이벤트 미 대상일, 대상 항목 포함")
    void weekendDiscountOutRangeIncludeTarget() {
        final String order = "바비큐립-10";
        final Order orders = new Order(Converter.toOrderFormat(order));
        final VisitDate visitDate = new VisitDate("25"); // 월요일
        final DiscountEvent discountEvent = new WeekendDiscountEvent(visitDate.inquireVisitDate(),
                orders.inquireOrders());

        final boolean apply = discountEvent.applicable();

        assertThat(apply).isEqualTo(false);
    }
}
