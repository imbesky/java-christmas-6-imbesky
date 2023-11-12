package christmas.visitDate;

import static christmas.constant.StandardDate.MONTH;
import static christmas.constant.StandardDate.YEAR;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.VisitDate;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VisitDateSaveTest {
    private VisitDate visitDate;

    @Test
    @DisplayName("방문 날짜 저장 테스트")
    void visitDateSaveTest() {
        final String input = "11";

        visitDate = new VisitDate(input);

        LocalDate expection = LocalDate.of(YEAR, MONTH, Integer.parseInt(input));
        assertThat(visitDate.inquireVisitDate()).isEqualTo(expection);
    }
}
