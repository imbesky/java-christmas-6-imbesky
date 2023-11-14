package christmas.controller;

import christmas.constant.MenuType;
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
import java.time.LocalDate;
import java.util.Map;

public class EventController {

    private final VisitDate visitDate;
    private final Order orders;
    private final Benefit benefit = new Benefit();

    public EventController(VisitDate visitDate, Order orders) {
        this.visitDate = visitDate;
        this.orders = orders;
    }

    public Benefit checkEvent() {
        checkFreeGiftEvent(new DecemberFreeGiftEvent(orders.calculateTotalListPrice()));
        checkDiscount();
        checkBadgeEvent(new DecemberBadgeEvent(benefit.calculateTotalBenefitPrice()));
        return benefit;
    }

    private void checkFreeGiftEvent(FreeGiftEvent freeGiftEvent) {
        benefit.applyFreeGift(freeGiftEvent.targetFreeGift());
    }

    private void checkDiscount() {
        final LocalDate date = visitDate.inquireVisitDate();
        final Map<MenuType, Integer> numberByMenuType = orders.numberByMenuType();
        checkChristmasDdayDiscount(new ChristmasDdayDiscountEvent(date));
        checkWeekdayDiscount(new WeekdayDiscountEvent(date, numberByMenuType));
        checkWeekendDiscount(new WeekendDiscountEvent(date, numberByMenuType));
        checkSpecialDiscount(new SpecialDiscountEvent(date));
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
