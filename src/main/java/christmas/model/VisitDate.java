package christmas.model;

import static christmas.constant.StandardDate.MONTH;
import static christmas.constant.StandardDate.YEAR;

import christmas.validator.VisitDateValidator;
import java.time.LocalDate;

public class VisitDate {
    private final LocalDate visitDate;

    public VisitDate(String date) {
        validate(date);
        visitDate = LocalDate.of(YEAR, MONTH, Integer.parseInt(date));
    }

    public LocalDate inquireVisitDate() {
        return visitDate;
    }

    private void validate(String input) {
        VisitDateValidator validator = new VisitDateValidator();
        validator.isNumeric(input);
        validator.isProperDateRange(input);
    }
}
