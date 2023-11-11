package christmas.controller;

import static christmas.util.Converter.toOrderFormat;

import christmas.model.Order;
import christmas.model.VisitDate;
import christmas.view.InputView;
import christmas.view.OutputView;

public class InputController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public VisitDate inputVisitDate() {
        outputView.askVisitDate();
        try {
            return new VisitDate(inputView.input());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            inputVisitDate();
        }
        return null;
    }

    public Order inputOrder() {
        outputView.askOrder();
        try {
            return new Order(toOrderFormat(inputView.input()));
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            inputOrder();
        }
        return null;
    }
}
