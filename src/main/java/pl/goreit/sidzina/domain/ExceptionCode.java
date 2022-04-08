package pl.goreit.sidzina.domain;

public enum ExceptionCode {

    AUCTION_NOT_EXIST("GoreIT.01", "Auction does not exist"),
    NON_AVAILABLE_AUCION("GoreIT.03", "Non available  product"),
    ORDER_NOT_FOUND("GoreIT.04", "Order not found {} "),
    IMPORT_IN_PROGRESS("GoreIT.05", "Some Import already in progress"),
    ORDER_NOT_HAVE_ORDERLINES("GoreIT.06", "Order must contains orderlines"),
    CAR_NOT_EXIST("GoreIT.07", "Car No {}  not exist  in cars"),
    OFFER_NOT_EXIST("GoreIT.08", "Offer does not exist {}"),
    USER_NOT_EXIST("GoreIT.09", "User does not exist"),
    ONLY_KEYCLOAK("GoreIT.10", "\"Only keycloak authorization is allowed\"");


    private final String message;
    private String code;

    private ExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
