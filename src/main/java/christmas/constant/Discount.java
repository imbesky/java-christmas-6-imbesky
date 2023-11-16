package christmas.constant;

public enum Discount {
    CHRISTMAS_DDAY("크리스마스 디데이 할인", 1_000, 100),
    WEEKDAY("평일 할인", 0, 2_023),
    WEEKEND("주말 할인", 0, 2_023),
    SPECIAL("특별 할인", 1_000, 0);

    private final String name;
    private final int initialPrice;
    private final int unitPrice;

    Discount(String name, int initialPrice, int unitPrice) {
        this.name = name;
        this.initialPrice = initialPrice;
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public int initialPrice() {
        return initialPrice;
    }

    public int unitPrice() {
        return unitPrice;
    }
}
