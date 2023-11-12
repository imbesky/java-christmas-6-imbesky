package christmas.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static christmas.constant.message.Notice.EVENT_EXCLUSION;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EventExclusionTest extends NsTest {
    @Test
    @DisplayName("이벤트 제외 대상인 경우")
    void eventExclusion() {
        assertSimpleTest(() -> {
            run("2", "타파스-1");
            assertThat(output()).contains(EVENT_EXCLUSION);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
