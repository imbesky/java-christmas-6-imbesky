package christmas.model;

import static christmas.constant.StandardDate.EVENT_MONTH;
import static christmas.constant.StandardDate.EVENT_YEAR;

import christmas.validator.VisitDateValidator;
import java.time.LocalDate;

public class VisitDate {
    private final LocalDate visitDate;

    public VisitDate(final String date) {
        validate(date);
        visitDate = LocalDate.of(EVENT_YEAR, EVENT_MONTH, Integer.parseInt(date));
    }

    public LocalDate inquireVisitDate() {
        return visitDate;
    }

    private void validate(final String input) {
        final VisitDateValidator validator = new VisitDateValidator();
        validator.isNumeric(input);
        validator.isProperDateRange(input);
    }
}
