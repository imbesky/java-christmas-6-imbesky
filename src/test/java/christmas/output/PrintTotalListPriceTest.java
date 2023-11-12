package christmas.output;

import static christmas.constant.message.Notice.TOTAL_PRICE_HEADER;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.PrintTest;
import christmas.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrintTotalListPriceTest extends PrintTest {
    final OutputView outputView = new OutputView();

    @Test
    @DisplayName("할인 전 총주문 금액 출력")
    void printTotalListPrice() {
        final int totalListPrice = 123_456;

        initializeOutput();
        outputView.printTotalListPrice(totalListPrice);

        assertThat(printedOutput()).contains(
                TOTAL_PRICE_HEADER,
                "123,456원");
    }
}
