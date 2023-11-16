package christmas.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static christmas.constant.message.Notice.ASK_ORDER;
import static christmas.constant.message.Notice.EVENT_NOTICE_TITLE;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputSaveTest extends NsTest {
    final InputController controller = new InputController();

    @Test
    @DisplayName("잘못된 방문 날짜 입력시 재입력 받는지 확인")
    void invalidateDateInputRetry() {
        assertSimpleTest(() -> {
            runException("a", " ", "", "1");
            assertThat(output()).contains(ASK_ORDER);
        });
    }

    @Test
    @DisplayName("잘못된 주문 입력시 재입력 받는지 확인")
    void invalidateOrderInputRetry() {
        assertSimpleTest(() -> {
            runException("2", "크림빵-2", "불고기피자-", "타파스", "레드와인-2", "초코케이크-3");
            assertThat(output()).contains(String.format(EVENT_NOTICE_TITLE, "2"));
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
