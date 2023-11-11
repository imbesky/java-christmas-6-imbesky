package christmas.eventTest;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.FreeGift;
import christmas.service.DecemberFreeGiftEvent;
import christmas.service.FreeGiftEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FreeGiftEventTest {
    @Test
    @DisplayName("증정 이벤트: 해당")
    void freeGiftEventTargetChampagne() {
        final int totalListPrice = 120_000;
        final FreeGiftEvent freeGiftEvent = new DecemberFreeGiftEvent(totalListPrice);

        final FreeGift freeGift = freeGiftEvent.targetFreeGift();

        assertThat(freeGift).isEqualTo(FreeGift.CHAMPAGNE);
    }

    @Test
    @DisplayName("증정 이벤트: 미해당")
    void freeGiftEventTargetNone() {
        final int totalListPrice = 119_000;
        final FreeGiftEvent freeGiftEvent = new DecemberFreeGiftEvent(totalListPrice);

        final FreeGift freeGift = freeGiftEvent.targetFreeGift();

        assertThat(freeGift).isEqualTo(FreeGift.NONE);
    }
}
