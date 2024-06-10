package demo.delivery_project.common.exception;

public interface ErrorMessages {
    String USER_NOT_FOUND = "user not found";
    String ACCESS_TOKEN_NOT_FOUND = "access token not found";
    String USER_DISABLED = "user disabled";
    String BAD_CREDENTIALS = "bad credentials";
    String EMAIL_ALREADY_EXISTS = "email already exists";
    String USERNAME_ALREADY_EXISTS = "username already exists";

    String USER_ROLE_NOT_FOUND = "user role not found";
    String REGION_NOT_FOUND = "region not found";
    String REGION_NAME_ALREADY_EXISTS = "region name already exists";

    String IMAGE_NOT_FOUND = "image not found!";

    String PRODUCT_NOT_FOUND = "product not found";

    String PROCESS_DENIED = "the process was not allowed to complete!";
    String MAX_FILE_SIZE = "File must be less than 10mb";
    String PRODUCT_ALREADY_EXISTS = "product already exists";
    String OFFER_NOT_FOUND = "offer not found";
    String OFFER_CODE_ALREADY_EXISTS = "offer code already exists";
    String PLACE_NOT_FOUND = "place not found";

    String TRANSACTION_NOT_FOUND = "transaction not found";
    String TRANSACTION_CODE_ALREADY_EXISTS = "transaction code already exists";

    String UNABLE_TO_CREATE_TRANSACTION_TO_THIS_REQUEST = "unable to create transaction to this request";
    String CARRIER_CANNOT_SERVE_THIS_PLACES = "carrier cannot serve this places";
    String USER_IS_NOT_CARRIER = "user is not_carrier";
    String PLACE_ALREADY_EXISTS = "place %s already exists";
}
