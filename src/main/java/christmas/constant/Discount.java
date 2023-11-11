package christmas.constant;

public enum Discount {
    CHRISTMAS_DDAY("크리스마스 디데이 할인"),
    WEEKDAY("평일 할인"),
    WEEKEND("주말 할인"),
    SPECIAL("특별 할인");

    private final String name;


    Discount(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Discount findByName(String name) {
        return CHRISTMAS_DDAY;
    }
}