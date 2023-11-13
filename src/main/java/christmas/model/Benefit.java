package christmas.model;

import static christmas.constant.FreeGift.FREE_GIFT_EVENT;
import static christmas.constant.Number.INITIAL_VALUE;
import static christmas.constant.Number.NEGATIVE;
import static christmas.constant.message.Notice.NONE;

import christmas.constant.Badge;
import christmas.constant.Discount;
import christmas.constant.FreeGift;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Benefit {
    private final Map<Discount, Integer> discounts = new HashMap<>();//할인, 금액
    private Badge badge;
    private FreeGift freeGift;

    public String inquireFreeGiftDetail() {
        return freeGift.getName();
    }

    public Map<String, Integer> inquireBenefitDetail() {
        Map<String, Integer> details = new HashMap<>();
        for (Entry<Discount, Integer> discount : discounts.entrySet()) {
            details.put(discount.getKey().getName(), discount.getValue());
        }
        if (!freeGift.getName().equals(NONE)) {
            details.put(FREE_GIFT_EVENT, NEGATIVE * freeGift.getPrice());
        }
        return details;
    }

    public int calculateTotalBenefitPrice() {
        int totalBenefitPrice = INITIAL_VALUE;
        for (Entry<Discount, Integer> discount : discounts.entrySet()) {
            totalBenefitPrice -= discount.getValue();
        }
        totalBenefitPrice -= freeGift.getPrice();
        return totalBenefitPrice;
    }

    public String inquireBadge() {
        return badge.getName();
    }

    public void applyDiscount(Discount discount, int price) {
        discounts.put(discount, price);
    }

    public void applyFreeGift(FreeGift freeGift) {
        this.freeGift = freeGift;
    }

    public void applyBadge(Badge badge) {
        this.badge = badge;
    }
}
