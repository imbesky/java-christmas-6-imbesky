package christmas.controller;

import static christmas.constant.Number.EVENT_APPLY_MIN_PRICE;
import static christmas.constant.message.Notice.NONE;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.Benefit;
import christmas.model.Order;
import christmas.model.VisitDate;
import christmas.view.OutputView;

public class MainController {

    private final OutputView outputView = new OutputView();
    private VisitDate visitDate;
    private Order orders;
    private Benefit benefit;

    public void run() {
        saveInput(new InputController());
        final int totalListPrice = orders.calculateTotalListPrice();
        if (checkEventExclusion(totalListPrice)) {
            eventExcludedResult(totalListPrice);
            Console.close();
        }
        printInputResults(totalListPrice);
        saveEventResult(new EventController(visitDate, orders));
        printEventResults(totalListPrice);
    }

    private void saveInput(final InputController inputController) {
        outputView.printGreeting();
        visitDate = inputController.saveVisitDate();
        orders = inputController.saveOrder();
    }

    private boolean checkEventExclusion(final int totalListPrice) {
        return (totalListPrice < EVENT_APPLY_MIN_PRICE);
    }

    private void eventExcludedResult(final int totalListPrice) {
        outputView.printEventNoticeTitle(visitDate.inquireVisitDate().getDayOfMonth());
        outputView.printEventExceptionNotice();
        outputView.printOrders(orders.inquireOrders());
        outputView.printTotalListPrice(totalListPrice);
        outputView.printNoFreeGift();
        outputView.printNoBenefit();
        outputView.printExpectedBill(totalListPrice);
        outputView.printBadge(NONE);
    }

    private void printInputResults(final int totalListPrice) {
        outputView.printEventNoticeTitle(visitDate.inquireVisitDate().getDayOfMonth());
        outputView.printOrders(orders.inquireOrders());
        outputView.printTotalListPrice(totalListPrice);
    }

    private void saveEventResult(final EventController eventController) {
        benefit = eventController.checkEvent();
    }

    private void printFreeGiftDetail() {
        if (benefit.inquireFreeGiftDetail().equals(NONE)) {
            outputView.printNoFreeGift();
            return;
        }
        outputView.printFreeGift(benefit.inquireFreeGiftDetail());
    }

    private void printEventResults(final int totalListPrice) {
        printFreeGiftDetail();
        outputView.printBenefitDetail(benefit.inquireBenefitDetail());
        final int totalBenefitPrice = benefit.calculateTotalBenefitPrice();
        outputView.printTotalBenefitPrice(totalBenefitPrice);
        outputView.printExpectedBill(totalListPrice + totalBenefitPrice);
        outputView.printBadge(benefit.inquireBadge());
    }
}