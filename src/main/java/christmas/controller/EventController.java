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
        checkFreeGiftEvent();
        checkDiscount();
        checkBadgeEvent();
        return benefit;
    }


    private void checkFreeGiftEvent() {
        FreeGiftEvent freeGiftEvent = new DecemberFreeGiftEvent(orders.inquireTotalListPrice());
        benefit.applyFreeGift(freeGiftEvent.targetFreeGift());
    }

    private void checkDiscount() {
        checkChristmasDdayDiscount();
        checkWeekdayDiscount();
        checkWeekendDiscount();
        checkSpecialDiscount();
    }

    private void checkChristmasDdayDiscount() {
        DiscountEvent discountEvent = new ChristmasDdayDiscountEvent(visitDate.inquireVisitDate());
        if (discountEvent.applicable()) {
            benefit.applyDiscount(discountEvent.type().getName(), discountEvent.price());
        }
    }

    private void checkWeekdayDiscount() {
        DiscountEvent discountEvent = new WeekdayDiscountEvent(visitDate.inquireVisitDate(), orders.inquireOrders());
        if (discountEvent.applicable()) {
            benefit.applyDiscount(discountEvent.type().getName(), discountEvent.price());
        }
    }

    private void checkWeekendDiscount() {
        DiscountEvent discountEvent = new WeekendDiscountEvent(visitDate.inquireVisitDate(), orders.inquireOrders());
        if (discountEvent.applicable()) {
            benefit.applyDiscount(discountEvent.type().getName(), discountEvent.price());
        }
    }

    private void checkSpecialDiscount() {
        DiscountEvent discountEvent = new SpecialDiscountEvent(visitDate.inquireVisitDate());
        if (discountEvent.applicable()) {
            benefit.applyDiscount(discountEvent.type().getName(), discountEvent.price());
        }
    }

    private void checkBadgeEvent() {
        BadgeEvent badgeEvent = new DecemberBadgeEvent(benefit.inquireTotalBenefitPrice());
        benefit.applyBadge(badgeEvent.targetBadge());
    }
}
