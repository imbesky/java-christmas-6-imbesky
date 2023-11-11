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
    private InputController inputController;
    private EventController eventController;
    private VisitDate visitDate;
    private Order orders;
    private Benefit benefit;

    public void run() {
        saveInput();
        checkEventExclusion();
        printInputResults();
        saveEventResult();
        printEventResults();
    }

    private void saveInput() {
        inputController = new InputController();
        outputView.printGreeting();
        visitDate = inputController.inputVisitDate();
        orders = inputController.inputOrder();
    }

    private void checkEventExclusion() {
        if (orders.inquireTotalListPrice() < EVENT_APPLY_MIN_PRICE) {
            outputView.printEventNoticeTitle(visitDate.inquireVisitDate().getDayOfMonth());
            outputView.printEventExceptionNotice();
            eventExcludedResult();
            Console.close();
        }
    }

    private void eventExcludedResult() {
        outputView.printOrders(orders.inquireOrders());
        outputView.printTotalListPrice(orders.inquireTotalListPrice());
        outputView.printNoFreeGift();
        outputView.printNoBenefit();
        outputView.printExpectedBill(orders.inquireTotalListPrice());
        outputView.printBadge(NONE);
    }

    private void printInputResults() {
        outputView.printEventNoticeTitle(visitDate.inquireVisitDate().getDayOfMonth());
        outputView.printOrders(orders.inquireOrders());
        outputView.printTotalListPrice(orders.inquireTotalListPrice());
    }

    private void saveEventResult() {
        eventController = new EventController(visitDate, orders);
        benefit = eventController.checkEvent();
    }

    private void printFreeGiftDetail() {
        if (benefit.inquireFreeGiftDetail().equals(NONE)) {
            outputView.printNoFreeGift();
            return;
        }
        outputView.printFreeGift(benefit.inquireFreeGiftDetail());
    }

    private void printEventResults() {
        printFreeGiftDetail();
        outputView.printBenefitDetail(benefit.inquireBenefitDetail());
        outputView.printTotalBenefitPrice(benefit.inquireTotalBenefitPrice());
        outputView.printExpectedBill(orders.inquireTotalListPrice() + benefit.inquireTotalBenefitPrice());
        outputView.printBadge(benefit.inquireBadge());
    }
}
