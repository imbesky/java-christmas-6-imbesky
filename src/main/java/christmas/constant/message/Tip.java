package christmas.constant.message;

public enum Tip {
    DATE_NOT_NUMERIC("숫자만 입력 가능합니다."),
    DATE_NOT_IN_RANGE("1부터 31 사이의 날짜만 가능합니다."),
    NOT_IN_MENU("메뉴판에 없는 메뉴입니다."),
    DUPLICATE_MENU("중복된 메뉴입니다."),
    NUMBER_NOT_NUMERIC("개수로는 숫자만 입력 가능합니다."),
    NUMBER_UNDER_MIN("개수는 1 이상이어야 합니다."),
    INVALIDATE_FORMAT("형식이 예시와 다릅니다."),
    ONLY_BEVERAGE("음료만 주문할 수 없습니다."),
    ORDER_OVER_MAX("메뉴는 20개를 초과해 주문할 수 없습니다.");

    private final String tip;
    private static final String TIP = "\n[TIP] ";

    Tip(String tip) {
        this.tip = tip;
    }

    public String getMessage() {
        return TIP.concat(tip);
    }
}
