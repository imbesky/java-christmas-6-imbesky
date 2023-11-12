package christmas.output;

import static christmas.constant.message.Notice.TOTAL_PRICE_HEADER;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.view.OutputView;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrintTotalListPriceTest {
    final OutputStream out = new ByteArrayOutputStream();
    final OutputView outputView = new OutputView();

    private void initializeOutput() {
        System.setOut(new PrintStream(out));
    }

    private String printedOutput() {
        return out.toString().trim();
    }

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
