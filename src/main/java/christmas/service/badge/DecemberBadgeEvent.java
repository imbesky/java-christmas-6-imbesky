package christmas.service.badge;

import static christmas.constant.Number.NEGATIVE;

import christmas.constant.Badge;

public class DecemberBadgeEvent implements BadgeEvent {
    private final int totalBenefitPrice;

    public DecemberBadgeEvent(final int totalBenefitPrice) {
        this.totalBenefitPrice = totalBenefitPrice;
    }

    @Override
    public Badge targetBadge() {
        for (Badge badge : Badge.values()) {
            if (totalBenefitPrice * NEGATIVE >= badge.getStandardPrice()) {
                return badge;
            }
        }
        return null;
    }
}
