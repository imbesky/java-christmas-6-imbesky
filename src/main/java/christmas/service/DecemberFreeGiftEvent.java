package christmas.service;

import christmas.constant.FreeGift;

public class DecemberFreeGiftEvent implements FreeGiftEvent {
    private final int totalListPrice;

    public DecemberFreeGiftEvent(int totalListPrice) {
        this.totalListPrice = totalListPrice;
    }

    @Override
    public FreeGift targetFreeGift() {
        for (FreeGift freeGift : FreeGift.values()) {
            if (totalListPrice >= freeGift.getStandardPrice()) {
                return freeGift;
            }
        }
        return null;
    }

}
