package christmas.controller;

import static christmas.util.Converter.toOrderFormat;

import christmas.model.Order;
import christmas.model.VisitDate;
import christmas.view.InputView;
import christmas.view.OutputView;

public class InputController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public VisitDate saveVisitDate() {
        VisitDate visitDate;
        do {
            visitDate = inputVisitDate();
        } while (visitDate == null);
        return visitDate;
    }

    private VisitDate inputVisitDate() {
        outputView.askVisitDate();
        try {
            return new VisitDate(inputView.input());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return null;
        }
    }

    public Order saveOrder() {
        Order order;
        do {
            order = inputOrder();
        } while (order == null);
        return order;
    }

    private Order inputOrder() {
        outputView.askOrder();
        try {
            return new Order(toOrderFormat(inputView.input()));
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return null;
        }
    }
}
