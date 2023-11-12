package christmas.output;

import static christmas.constant.message.Notice.ORDERED_MENU_HEADER;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.Menu;
import christmas.view.OutputView;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrintOrdersTest {
    final OutputStream out = new ByteArrayOutputStream();
    final OutputView outputView = new OutputView();

    private void initializeOutput() {
        System.setOut(new PrintStream(out));
    }

    private String printedOutput() {
        return out.toString().trim();
    }

    @Test
    @DisplayName("주문 메뉴 출력")
    void printOrders() {
        final Map<Menu, Integer> orders = new HashMap<>();
        orders.put(Menu.findByName("크리스마스파스타"), 1);
        orders.put(Menu.findByName("티본스테이크"), 1);
        orders.put(Menu.findByName("제로콜라"), 1);

        initializeOutput();
        outputView.printOrders(orders);

        assertThat(printedOutput()).contains(
                ORDERED_MENU_HEADER,
                "크리스마스파스타 1개",
                "티본스테이크 1개",
                "제로콜라 1개");
    }
}
