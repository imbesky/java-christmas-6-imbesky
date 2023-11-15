package christmas.service;

import static christmas.constant.Number.EVENT_APPLY_MIN_PRICE;

public class DecemberEvent implements Event {
    private final int totalListPrice;

    public DecemberEvent(final int totalListPrice1) {
        this.totalListPrice = totalListPrice1;
    }

    @Override
    public boolean applicable() {
        return (totalListPrice < EVENT_APPLY_MIN_PRICE);
    }
}
