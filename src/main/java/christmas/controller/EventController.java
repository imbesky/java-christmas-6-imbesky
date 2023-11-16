package christmas.controller;

import christmas.constant.MenuType;
import christmas.model.Benefit;
import christmas.model.Order;
import christmas.model.VisitDate;
import christmas.service.badge.BadgeEvent;
import christmas.service.dicount.ChristmasDdayDiscountEvent;
import christmas.service.badge.DecemberBadgeEvent;
import christmas.service.freegift.DecemberFreeGiftEvent;
import christmas.service.dicount.DiscountEvent;
import christmas.service.freegift.FreeGiftEvent;
import christmas.service.dicount.SpecialDiscountEvent;
import christmas.service.dicount.WeekdayDiscountEvent;
import christmas.service.dicount.WeekendDiscountEvent;
import java.time.LocalDate;
import java.util.Map;

public class EventController {

    private final VisitDate visitDate;
    private final Order orders;
    private final Benefit benefit = new Benefit();

    public EventController(final VisitDate visitDate, final Order orders) {
        this.visitDate = visitDate;
        this.orders = orders;
    }

    public Benefit checkEvent() {
        checkFreeGiftEvent(new DecemberFreeGiftEvent(orders.calculateTotalListPrice()));
        checkDiscount();
        checkBadgeEvent(new DecemberBadgeEvent(benefit.calculateTotalBenefitPrice()));
        return benefit;
    }

    private void checkFreeGiftEvent(final FreeGiftEvent freeGiftEvent) {
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

    private void checkChristmasDdayDiscount(final DiscountEvent discountEvent) {
        if (discountEvent.applicable()) {
            benefit.applyDiscount(discountEvent.discountType(), discountEvent.price());
        }
    }

    private void checkWeekdayDiscount(final DiscountEvent discountEvent) {
        if (discountEvent.applicable()) {
            benefit.applyDiscount(discountEvent.discountType(), discountEvent.price());
        }
    }

    private void checkWeekendDiscount(final DiscountEvent discountEvent) {
        if (discountEvent.applicable()) {
            benefit.applyDiscount(discountEvent.discountType(), discountEvent.price());
        }
    }

    private void checkSpecialDiscount(final DiscountEvent discountEvent) {
        if (discountEvent.applicable()) {
            benefit.applyDiscount(discountEvent.discountType(), discountEvent.price());
        }
    }

    private void checkBadgeEvent(final BadgeEvent badgeEvent) {
        benefit.applyBadge(badgeEvent.targetBadge());
    }
}
