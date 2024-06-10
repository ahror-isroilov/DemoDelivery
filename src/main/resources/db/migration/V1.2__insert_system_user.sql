CREATE EXTENSION IF NOT EXISTS pgcrypto;

INSERT INTO public.roles(id, name)
values ('172933a6-2e1f-4494-9e8a-66c03b0decb0', 'USER');


INSERT INTO public.users(id, username, firstname, lastname, email, image_id, password, password_hash, status, role_id)
values ('10ff7013-0efd-4b90-abec-73a612f7d7de',
        'user', 'Toms', 'Shelby', 'user@demodelivery.com', null,
        '$2y$10$0oR5Lz3JidLcygtKlXzy3.eDoIfJX.XRdm5xx2PnqNCQtcmDqaQgu',
        'bcrypt',
        'ENABLED',
        '172933a6-2e1f-4494-9e8a-66c03b0decb0');

DO
$do$
    DECLARE
        _admin_id    uuid;
        _elem        varchar;
        _permissions varchar[];
    BEGIN
        _admin_id = '172933a6-2e1f-4494-9e8a-66c03b0decb0';
        _permissions = ARRAY [
            'PRODUCT_CREATE',
            'PRODUCT_READ',
            'PRODUCT_UPDATE',
            'PRODUCT_DELETE',
            'GET_USER_PRODUCTS',
            'GET_OWN_PRODUCTS',
            'REQUEST_CREATE',
            'REQUEST_READ',
            'REQUEST_UPDATE',
            'REQUEST_DELETE',
            'GET_USER_REQUESTS',
            'GET_OWN_REQUESTS',
            'OFFER_CREATE',
            'OFFER_READ',
            'OFFER_UPDATE',
            'OFFER_DELETE',
            'GET_USER_OFFERS',
            'GET_OWN_OFFERS',
            'REGION_READ',
            'GET_REGIONS_AND_PLACES',
            'EVALUATE_TRANSACTION',
            'GET_OWN_TRANSACTIONS'
            ];
        FOREACH _elem IN ARRAY _permissions
            LOOP
                insert into role_permissions(role_id, permission)
                VALUES (_admin_id, _elem);
            END LOOP;
    END;
$do$;