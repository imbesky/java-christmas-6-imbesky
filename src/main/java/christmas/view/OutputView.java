package christmas.view;

import static christmas.constant.Format.BENEFIT_DETAIL_FORMAT;
import static christmas.constant.Format.FREE_GIFT_FORMAT;
import static christmas.constant.Format.ORDER_FORMAT;
import static christmas.constant.Format.PRICE_FORMAT;
import static christmas.constant.Number.FREE_GIFT_NUMBER;
import static christmas.constant.Number.INITIAL_VALUE;
import static christmas.constant.message.Notice.ASK_ORDER;
import static christmas.constant.message.Notice.ASK_VISIT_DATE;
import static christmas.constant.message.Notice.BADGE_HEADER;
import static christmas.constant.message.Notice.BENEFIT_DETAIL_HEADER;
import static christmas.constant.message.Notice.EVENT_EXCLUSION;
import static christmas.constant.message.Notice.EVENT_NOTICE_TITLE;
import static christmas.constant.message.Notice.EXPECTED_BILL_HEADER;
import static christmas.constant.message.Notice.FREE_GIFT_HEADER;
import static christmas.constant.message.Notice.GREETING;
import static christmas.constant.message.Notice.LINE_DIVIDER;
import static christmas.constant.message.Notice.NONE;
import static christmas.constant.message.Notice.ORDERED_MENU_HEADER;
import static christmas.constant.message.Notice.TOTAL_BENEFIT_PRICE_HEADER;
import static christmas.constant.message.Notice.TOTAL_PRICE_HEADER;
import static christmas.constant.message.Notice.UNIT;
import static christmas.constant.message.Notice.WON;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {
    public void printError(final String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printGreeting() {
        System.out.println(GREETING);
    }

    public void askVisitDate() {
        System.out.println(ASK_VISIT_DATE);
    }

    public void askOrder() {
        System.out.println(ASK_ORDER);
    }

    public void printEventExceptionNotice() {
        System.out.println(EVENT_EXCLUSION);
    }

    public void printEventNoticeTitle(final int visitDate) {
        System.out.println(String.format(EVENT_NOTICE_TITLE, visitDate));
    }

    public void printOrders(final Map<String, Integer> orders) {
        System.out.println(LINE_DIVIDER);
        System.out.println(ORDERED_MENU_HEADER);
        for (Entry<String, Integer> order : orders.entrySet()) {
            System.out.println(String
                    .format(ORDER_FORMAT, order.getKey(), order.getValue())
                    .concat(UNIT));
        }
    }

    public void printTotalListPrice(final int totalListPrice) {
        System.out.println(LINE_DIVIDER);
        System.out.println(TOTAL_PRICE_HEADER);
        DecimalFormat price = new DecimalFormat(PRICE_FORMAT);
        System.out.println(price.format(totalListPrice).concat(WON));
    }

    public void printFreeGift(final String freeGift) {
        System.out.println(LINE_DIVIDER);
        System.out.println(FREE_GIFT_HEADER);
        System.out.println(String
                .format(FREE_GIFT_FORMAT, freeGift, FREE_GIFT_NUMBER)
                .concat(UNIT));
    }

    public void printNoFreeGift() {
        System.out.println(LINE_DIVIDER);
        System.out.println(FREE_GIFT_HEADER);
        System.out.println(NONE);
    }

    public void printBenefitDetail(final Map<String, Integer> details) {
        System.out.println(LINE_DIVIDER);
        System.out.println(BENEFIT_DETAIL_HEADER);
        DecimalFormat price = new DecimalFormat(PRICE_FORMAT);
        for (Entry<String, Integer> detail : details.entrySet()) {
            System.out.println(String
                    .format(BENEFIT_DETAIL_FORMAT, detail.getKey())
                    .concat(price.format(detail.getValue()))
                    .concat(WON));
        }
    }

    public void printTotalBenefitPrice(final int totalBenefitPrice) {
        System.out.println(LINE_DIVIDER);
        System.out.println(TOTAL_BENEFIT_PRICE_HEADER);
        DecimalFormat price = new DecimalFormat(PRICE_FORMAT);
        System.out.println(price.format(totalBenefitPrice).concat(WON));
    }

    public void printNoBenefit() {
        System.out.println(LINE_DIVIDER);
        System.out.println(BENEFIT_DETAIL_HEADER);
        System.out.println(NONE);

        System.out.println(LINE_DIVIDER);
        System.out.println(TOTAL_BENEFIT_PRICE_HEADER);
        DecimalFormat price = new DecimalFormat(PRICE_FORMAT);
        System.out.println(price.format(INITIAL_VALUE).concat(WON));
    }


    public void printExpectedBill(final int bill) {
        System.out.println(LINE_DIVIDER);
        System.out.println(EXPECTED_BILL_HEADER);
        DecimalFormat price = new DecimalFormat(PRICE_FORMAT);
        System.out.println(price.format(bill).concat(WON));
    }

    public void printBadge(final String badge) {
        System.out.println(LINE_DIVIDER);
        System.out.println(BADGE_HEADER);
        System.out.println(badge);
    }
}
