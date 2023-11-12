package christmas.output;

import static christmas.constant.message.Notice.FREE_GIFT_HEADER;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.PrintTest;
import christmas.constant.FreeGift;
import christmas.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrintFreeGiftTest extends PrintTest {
    final OutputView outputView = new OutputView();

    @Test
    @DisplayName("증정 메뉴 출력: 증정품이 있는 경우")
    void printFreeGiftChampagne() {
        final FreeGift freeGift = FreeGift.CHAMPAGNE;

        initializeOutput();
        outputView.printFreeGift(freeGift.getName());

        assertThat(printedOutput()).contains(
                FREE_GIFT_HEADER,
                "샴페인 1개");
    }

    @Test
    @DisplayName("증정 메뉴 출력: 증정품이 없는 경우")
    void printFreeGiftNone() {

        initializeOutput();
        outputView.printNoFreeGift();

        assertThat(printedOutput()).contains(
                FREE_GIFT_HEADER,
                "없음");
    }
}
