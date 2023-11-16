package christmas.benefit;

import static christmas.constant.FreeGift.FREE_GIFT_EVENT;
import static christmas.constant.Number.NEGATIVE;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.Discount;
import christmas.constant.FreeGift;
import christmas.model.Benefit;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SaveBenefitTest {


    @Test
    @DisplayName("혜택 내역 조회 테스트: 증정품이 없는 경우")
    void inquireBenefitDetailTestWithoutFreeGift() {
        final Benefit benefit = new Benefit();
        benefit.applyDiscount(Discount.CHRISTMAS_DDAY, 10_000);
        benefit.applyDiscount(Discount.WEEKDAY, 5_000);
        benefit.applyFreeGift(FreeGift.NONE);

        final Map<String, Integer> details = new HashMap<>();
        details.put(Discount.CHRISTMAS_DDAY.getName(), NEGATIVE * 10_000);
        details.put(Discount.WEEKDAY.getName(), NEGATIVE * 5_000);
        assertThat(benefit.inquireBenefitDetail()).isEqualTo(details);
    }

    @Test
    @DisplayName("혜택 내역 조회 테스트: 증정품이 있는 경우")
    void inquireBenefitDetailTestWithFreeGift() {
        final Benefit benefit = new Benefit();
        benefit.applyDiscount(Discount.SPECIAL, 12_345);
        benefit.applyDiscount(Discount.WEEKEND, 5_432);
        benefit.applyFreeGift(FreeGift.CHAMPAGNE);

        final Map<String, Integer> details = new HashMap<>();
        details.put(Discount.SPECIAL.getName(), NEGATIVE * 12_345);
        details.put(Discount.WEEKEND.getName(), NEGATIVE * 5_432);
        details.put(FREE_GIFT_EVENT, NEGATIVE * FreeGift.CHAMPAGNE.getPrice());
        assertThat(benefit.inquireBenefitDetail()).isEqualTo(details);
    }

    @Test
    @DisplayName("총혜택 금액 계산 테스트")
    void calculateTotalBenefitPriceTest() {
        final Benefit benefit = new Benefit();
        benefit.applyDiscount(Discount.WEEKDAY, 40_000);
        benefit.applyDiscount(Discount.WEEKEND, 30);
        benefit.applyFreeGift(FreeGift.CHAMPAGNE);

        assertThat(benefit.calculateTotalBenefitPrice()).isEqualTo(-65_030);
    }
}
