package christmas.constant;

public enum FreeGift {
    CHAMPAGNE(Menu.CHAMPAGNE.getName(), 120_000, Menu.CHAMPAGNE.getPrice()),
    NONE("없음", 0, 0);
    private final String name;
    private final int standardPrice;
    private final int price;
    public final static String FREE_GIFT_EVENT = "증정 이벤트";

    FreeGift(String name, int standardPrice, int price) {
        this.name = name;
        this.standardPrice = standardPrice;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getStandardPrice() {
        return this.standardPrice;
    }

    public int getPrice() {
        return price;
    }
}
