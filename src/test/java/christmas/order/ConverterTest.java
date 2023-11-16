package christmas.order;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.util.Converter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConverterTest {
    @Test
    @DisplayName("컨버터 테스트:")
    void converter() {
        final String orders = "양송이수프-1,타파스-1,시저샐러드-1";

        List<String[]> formattedOrder = Converter.toOrderFormat(orders);

        String[] order1 = new String[]{"양송이수프", "1"};
        String[] order2 = new String[]{"타파스", "1"};
        String[] order3 = new String[]{"시저샐러드", "1"};

        assertThat(formattedOrder.equals(new ArrayList<>(Arrays.asList(order1, order2, order3))));
    }
}
