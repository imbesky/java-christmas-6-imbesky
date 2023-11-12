package christmas.validator;

import static christmas.constant.Number.MIN_ORDER;
import static christmas.constant.message.Error.INVALIDATE_ORDER;
import static christmas.constant.message.Tip.NUMBER_NOT_NUMERIC;
import static christmas.constant.message.Tip.NUMBER_UNDER_MIN;

public class NumberValidator {
    public void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALIDATE_ORDER.getMessage()
                    .concat(NUMBER_NOT_NUMERIC.getMessage()));
        }
    }

    public void isInRange(String input) {
        if (Integer.parseInt(input) < MIN_ORDER) {
            throw new IllegalArgumentException(INVALIDATE_ORDER.getMessage()
                    .concat(NUMBER_UNDER_MIN.getMessage()));
        }
    }
}
