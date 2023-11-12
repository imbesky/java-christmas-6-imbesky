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
            System.out.println(DATE_NOT_NUMERIC.getMessage());
            throw new IllegalArgumentException(INVALIDATE_DATE.getMessage());
        }
    }

    public void isProperDateRange(String input) {
        int date = Integer.parseInt(input);
        if (date < FIRST || date > THIRTY_FIRST) {
            System.out.println(DATE_NOT_IN_RANGE.getMessage());
            throw new IllegalArgumentException(INVALIDATE_DATE.getMessage());
        }
    }
}
