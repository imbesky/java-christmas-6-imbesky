package christmas.service;

import christmas.constant.Badge;

public class DecemberBadgeEvent implements BadgeEvent {
    private final int totalBenefitPrice;

    public DecemberBadgeEvent(int totalBenefitPrice) {
        this.totalBenefitPrice = totalBenefitPrice;
    }

    @Override
    public Badge targetBadge() {
        for (Badge badge : Badge.values()) {
            if (totalBenefitPrice >= badge.getStandardPrice()) {
                return badge;
            }
        }
        return null;
    }
}
