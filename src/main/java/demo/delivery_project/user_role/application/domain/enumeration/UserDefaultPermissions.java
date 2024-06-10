package demo.delivery_project.user_role.application.domain.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

import static demo.delivery_project.common.constant.PermissionConstants.*;

@Getter
@RequiredArgsConstructor
public enum UserDefaultPermissions {
    USER(Set.of(
            PRODUCT_CREATE,
            PRODUCT_READ,
            PRODUCT_UPDATE,
            PRODUCT_DELETE,
            GET_USER_PRODUCTS,
            GET_OWN_PRODUCTS,

            REQUEST_CREATE,
            REQUEST_READ,
            REQUEST_UPDATE,
            REQUEST_DELETE,
            GET_USER_REQUESTS,
            GET_OWN_REQUESTS,

            OFFER_CREATE,
            OFFER_READ,
            OFFER_UPDATE,
            OFFER_DELETE,
            GET_USER_OFFERS,
            GET_OWN_OFFERS,

            REGION_READ,
            GET_REGIONS_AND_PLACES,

            EVALUATE_TRANSACTION,
            GET_OWN_TRANSACTIONS
    )),
    CARRIER(Set.of(
            TRANSACTION_CREATE,
            TRANSACTION_READ,
            TRANSACTION_UPDATE,
            TRANSACTION_DELETE,
            GET_USER_OFFERS,
            GET_USER_REQUESTS,
            GET_OWN_TRANSACTIONS
    ));
    private final Set<String> defaultPermissions;
}
