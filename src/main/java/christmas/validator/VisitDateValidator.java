package christmas.validator;

import static christmas.constant.StandardDate.FIRST;
import static christmas.constant.StandardDate.THIRTY_FIRST;
import static christmas.constant.message.Error.INVALIDATE_DATE;
import static christmas.constant.message.Tip.DATE_NOT_IN_RANGE;
import static christmas.constant.message.Tip.DATE_NOT_NUMERIC;

public class VisitDateValidator {
    public void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALIDATE_DATE.getMessage()
                    .concat(DATE_NOT_NUMERIC.getMessage()));
        }
    }

    public void isProperDateRange(String input) {
        int date = Integer.parseInt(input);
        if (date < FIRST || date > THIRTY_FIRST) {
            throw new IllegalArgumentException(INVALIDATE_DATE.getMessage()
                    .concat(DATE_NOT_IN_RANGE.getMessage()));
        }
    }
}
