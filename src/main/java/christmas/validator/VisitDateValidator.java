package christmas.validator;

import static christmas.constant.StandardDate.EVENT_END_DATE;
import static christmas.constant.StandardDate.EVENT_START_DATE;
import static christmas.constant.StandardDate.MONTH;
import static christmas.constant.StandardDate.YEAR;
import static christmas.constant.message.Error.INVALIDATE_DATE;
import static christmas.constant.message.Tip.DATE_NOT_IN_RANGE;
import static christmas.constant.message.Tip.DATE_NOT_NUMERIC;

import christmas.util.DayUtil;
import java.time.LocalDate;

public class VisitDateValidator {
    public void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(DATE_NOT_NUMERIC.getMessage());
            throw new IllegalArgumentException(INVALIDATE_DATE.getMessage());
        }
    }

    public void isProperDateRange(String input) {
        LocalDate date = LocalDate.of(YEAR, MONTH, Integer.parseInt(input));
        if (DayUtil.isBetween(EVENT_START_DATE, EVENT_END_DATE, date)) {
            System.out.println(DATE_NOT_IN_RANGE.getMessage());
            throw new IllegalArgumentException(INVALIDATE_DATE.getMessage());
        }
    }
}
