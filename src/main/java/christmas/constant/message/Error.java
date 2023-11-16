package christmas.constant.message;

public enum Error {
    INVALIDATE_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALIDATE_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String error;
    private static final String ERROR = "[ERROR] ";

    Error(String error) {
        this.error = error;
    }

    public String getMessage() {
        return ERROR.concat(error);
    }
}
