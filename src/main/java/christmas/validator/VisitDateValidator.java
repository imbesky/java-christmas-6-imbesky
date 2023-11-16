package christmas.validator;

import static christmas.constant.StandardDate.EVENT_MONTH;
import static christmas.constant.StandardDate.EVENT_YEAR;
import static christmas.constant.message.Error.INVALIDATE_DATE;
import static christmas.constant.message.Tip.DATE_NOT_IN_RANGE;
import static christmas.constant.message.Tip.DATE_NOT_NUMERIC;

import java.time.DateTimeException;
import java.time.LocalDate;

public class VisitDateValidator {
    public void isNumeric(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALIDATE_DATE.getMessage()
                    .concat(DATE_NOT_NUMERIC.getMessage()));
        }
    }

    public void isProperDateRange(final String input) {
        int date = Integer.parseInt(input);
        try {
            LocalDate.of(EVENT_YEAR, EVENT_MONTH, date);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(INVALIDATE_DATE.getMessage()
                    .concat(DATE_NOT_IN_RANGE.getMessage()));
        }
    }
}
