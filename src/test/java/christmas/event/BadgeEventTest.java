package christmas.event;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.Badge;
import christmas.service.BadgeEvent;
import christmas.service.DecemberBadgeEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BadgeEventTest {
    @Test
    @DisplayName("12월 이벤트 배지 부여: 산타")
    void badgeEventTargetSanta() {
        final int totalBenefitPrice = 20_000;
        final BadgeEvent badgeEvent = new DecemberBadgeEvent(totalBenefitPrice);

        final Badge badge = badgeEvent.targetBadge();

        assertThat(badge).isEqualTo(Badge.SANTA);
    }

    @Test
    @DisplayName("12월 이벤트 배지 부여: 트리")
    void badgeEventTargetTree() {
        final int totalBenefitPrice = 10_000;
        final BadgeEvent badgeEvent = new DecemberBadgeEvent(totalBenefitPrice);

        final Badge badge = badgeEvent.targetBadge();

        assertThat(badge).isEqualTo(Badge.TREE);
    }

    @Test
    @DisplayName("12월 이벤트 배지 부여: 별")
    void badgeEventTargetStar() {
        final int totalBenefitPrice = 5_000;
        final BadgeEvent badgeEvent = new DecemberBadgeEvent(totalBenefitPrice);

        final Badge badge = badgeEvent.targetBadge();

        assertThat(badge).isEqualTo(Badge.STAR);
    }

    @Test
    @DisplayName("12월 이벤트 배지 부여: 미해당")
    void badgeEventTargetNone() {
        final int totalBenefitPrice = 0;
        final BadgeEvent badgeEvent = new DecemberBadgeEvent(totalBenefitPrice);

        final Badge badge = badgeEvent.targetBadge();

        assertThat(badge).isEqualTo(Badge.NONE);
    }
}
