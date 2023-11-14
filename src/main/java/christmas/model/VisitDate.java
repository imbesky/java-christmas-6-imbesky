package christmas.model;

import static christmas.constant.StandardDate.MONTH;
import static christmas.constant.StandardDate.YEAR;

import christmas.validator.VisitDateValidator;
import java.time.LocalDate;

public class VisitDate {
    private final LocalDate visitDate;

    public VisitDate(final String date) {
        validate(date);
        visitDate = LocalDate.of(YEAR, MONTH, Integer.parseInt(date));
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
