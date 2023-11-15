package christmas.validator;

import static christmas.constant.StandardDate.EVENT_END_DAY_OF_MONTH;
import static christmas.constant.StandardDate.EVENT_START_DAY_OF_MONTH;
import static christmas.constant.message.Error.INVALIDATE_DATE;
import static christmas.constant.message.Tip.DATE_NOT_IN_RANGE;
import static christmas.constant.message.Tip.DATE_NOT_NUMERIC;

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
        if (date < EVENT_START_DAY_OF_MONTH || date > EVENT_END_DAY_OF_MONTH) {
            throw new IllegalArgumentException(INVALIDATE_DATE.getMessage()
                    .concat(DATE_NOT_IN_RANGE.getMessage()));
        }
    }
}
