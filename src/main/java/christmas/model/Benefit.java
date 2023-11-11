package christmas.model;

import static christmas.constant.FreeGift.FREE_GIFT_EVENT;
import static christmas.constant.Number.INITIAL_VALUE;
import static christmas.constant.message.Notice.NONE;

import christmas.constant.Badge;
import christmas.constant.Discount;
import christmas.constant.FreeGift;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Benefit {
    private final Map<Discount, Integer> discounts = new HashMap<>();//할인이벤트, 금액
    private Badge badge;
    private FreeGift freeGift;
    private int totalBenefitPrice = INITIAL_VALUE;

    public Benefit() {
        for (Discount discount : Discount.values()) {
            discounts.put(discount, INITIAL_VALUE);
        }
    }

    public String inquireFreeGiftDetail() {
        return freeGift.getName();
    }

    public Map<String, Integer> inquireBenefitDetail() {
        Map<String, Integer> details = new HashMap<>();
        for (Entry<Discount, Integer> discount : discounts.entrySet()) {
            details.put(discount.getKey().getName(), discount.getValue());
        }
        if (!freeGift.getName().equals(NONE)) {
            details.put(FREE_GIFT_EVENT, freeGift.getPrice());
        }
        return details;
    }

    public int inquireTotalBenefitPrice() {
        return totalBenefitPrice;
    }

    public String inquireBadge() {
        return badge.getName();
    }

    public void applyDiscount(String discount, int price) {
        discounts.replace(Discount.findByName(discount), price);
        totalBenefitPrice -= price;
    }

    public void applyFreeGift(FreeGift freeGift) {
        this.freeGift = freeGift;
        totalBenefitPrice -= freeGift.getPrice();
    }

    public void applyBadge(Badge badge) {
        this.badge = badge;
    }
}
