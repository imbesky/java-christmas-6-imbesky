package christmas.controller;

import christmas.model.Benefit;
import christmas.model.Order;
import christmas.model.VisitDate;
import christmas.service.BadgeEvent;
import christmas.service.ChristmasDdayDiscountEvent;
import christmas.service.DecemberBadgeEvent;
import christmas.service.DecemberFreeGiftEvent;
import christmas.service.DiscountEvent;
import christmas.service.FreeGiftEvent;
import christmas.service.SpecialDiscountEvent;
import christmas.service.WeekdayDiscountEvent;
import christmas.service.WeekendDiscountEvent;

public class EventController {

    private final VisitDate visitDate;
    private final Order orders;
    private final Benefit benefit = new Benefit();

    public EventController(VisitDate visitDate, Order orders) {
        this.visitDate = visitDate;
        this.orders = orders;
    }

    public Benefit checkEvent() {
        checkFreeGiftEvent(new DecemberFreeGiftEvent(orders.inquireTotalListPrice()));
        checkDiscount();
        checkBadgeEvent(new DecemberBadgeEvent(benefit.inquireTotalBenefitPrice()));
        return benefit;
    }

    private void checkFreeGiftEvent(FreeGiftEvent freeGiftEvent) {
        benefit.applyFreeGift(freeGiftEvent.targetFreeGift());
    }

    private void checkDiscount() {
        checkChristmasDdayDiscount(
                new ChristmasDdayDiscountEvent(visitDate.inquireVisitDate()));
        checkWeekdayDiscount(
                new WeekdayDiscountEvent(visitDate.inquireVisitDate(), orders.inquireOrders()));
        checkWeekendDiscount(
                new WeekendDiscountEvent(visitDate.inquireVisitDate(), orders.inquireOrders()));
        checkSpecialDiscount(
                new SpecialDiscountEvent(visitDate.inquireVisitDate()));
    }

    private void checkChristmasDdayDiscount(DiscountEvent discountEvent) {
        if (discountEvent.applicable()) {
            benefit.applyDiscount(discountEvent.discountType(), discountEvent.price());
        }
    }

    private void checkWeekdayDiscount(DiscountEvent discountEvent) {
        if (discountEvent.applicable()) {
            benefit.applyDiscount(discountEvent.discountType(), discountEvent.price());
        }
    }

    private void checkWeekendDiscount(DiscountEvent discountEvent) {
        if (discountEvent.applicable()) {
            benefit.applyDiscount(discountEvent.discountType(), discountEvent.price());
        }
    }

    private void checkSpecialDiscount(DiscountEvent discountEvent) {
        if (discountEvent.applicable()) {
            benefit.applyDiscount(discountEvent.discountType(), discountEvent.price());
        }
    }

    private void checkBadgeEvent(BadgeEvent badgeEvent) {
        benefit.applyBadge(badgeEvent.targetBadge());
    }
}
