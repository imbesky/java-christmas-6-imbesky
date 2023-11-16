package christmas.constant;

public enum Badge {
    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    STAR("별", 5_000),
    NONE("없음", 0);
    private final String name;
    private final int standardPrice;

    Badge(String name, int standardPrice) {
        this.name = name;
        this.standardPrice = standardPrice;
    }

    public String getName() {
        return this.name;
    }

    public int getStandardPrice() {
        return this.standardPrice;
    }
}
