package demo.delivery_project.common.constant;

public interface ValidationMessages {
    String USERNAME_MUST_NOT_BE_NULL = "username must not be null!";
    String USERNAME_MUST_CONTAIN_ONLY_LETTERS_AND_NUMBERS = "username must contain only latin letters, numbers and underscore(_)";
    String USERNAME_MUST_CONTAIN_AT_LEAST_3_CHARACTERS = "username must contain at least 3 characters!";

    String FIRSTNAME_MUST_NOT_BE_NULL = "firstname must not be null!";
    String FIRSTNAME_MUST_HAVE_AT_LEAST_3_AND_ONLY_LETTERS = "firstname must contain at least 3 characters and must have only latin letters";

    String REGION_NAME_MUST_NOT_BE_NULL = "region name must not be null!";
    String REGION_ID_MUST_NOT_BE_NULL = "region ID must not be null!";
    String PLACE_NAME_MUST_NOT_BE_NULL = "place name must not be null!";

    String LASTNAME_MUST_NOT_BE_NULL = "lastname must not be null!";
    String LASTNAME_MUST_HAVE_AT_LEAST_3_AND_ONLY_LETTERS = "lastname must contain at least 3 characters and must have only latin letters";

    String EMAIL_MUST_NOT_BE_NULL = "email must not be null!";
    String INVALID_EMAIL_ADDRESS = "invalid email address!";
    String PASSWORD_MUST_NOT_BE_NULL = "password must not be null!";
    String ENTER_VALID_PASSWORD = "enter valid password";

    String ROLE_NAME_MUST_CONTAIN_AT_LEAST_3_CHARACTERS = "role name must contain at least 3 characters";
    String ROLE_MUST_NOT_BE_NULL = "role must not be null";

    String PRODUCT_NAME_MUST_NOT_BE_NULL = "product name must not be null";
    String PRODUCT_CODE_MUST_NOT_BE_NULL = "product code must not be null";
    String PRODUCT_PRICE_MUST_NOT_BE_NULL = "product price must not be null";
    String INVALID_PRODUCT_PRICE = "invalid product price";
    String PRODUCT_IMAGE_MUST_NOT_BE_NULL = "product image must not be null";
    String PRODUCT_NAME_MUST_CONTAIN_AT_LEAST_3_CHARACTERS = "product name must contain at least 3 characters";
    String REGIONS_FIELD_MUST_NOT_BE_NULL = "regions field must not be null";
    String SET_AT_LEAST_ONE_REGION = "set at least one region";
}
