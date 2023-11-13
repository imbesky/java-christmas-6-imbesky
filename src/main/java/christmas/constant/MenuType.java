package christmas.constant;

public enum MenuType {
    APPETIZER("APPETIZER"),
    MAIN("MAIN"),
    DESSERT("DESSERT"),
    BEVERAGE("BEVERAGE");
    private final String menuType;

    MenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuType() {
        return menuType;
    }
}
