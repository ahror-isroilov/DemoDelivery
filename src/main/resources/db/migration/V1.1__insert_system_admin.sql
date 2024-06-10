CREATE EXTENSION IF NOT EXISTS pgcrypto;

INSERT INTO public.roles(id, name)
values ('d7642126-64de-4fde-9d89-b2e9532bd2d4', 'ADMIN');


INSERT INTO public.users(id, username, firstname, lastname, email, image_id, password, password_hash, status, role_id)
values ('c7be49b3-ed42-4928-8029-51323579398b',
        'admin', 'alex', 'johnson', 'admin@demodelivery.com', null,
        '$2y$10$.zlRXSJE4s2jH/iAVRluYeKmpLSEmtuMFlBWvOIOc7jGW3VtkkYim',
        'bcrypt',
        'ENABLED',
        'd7642126-64de-4fde-9d89-b2e9532bd2d4');

DO
$do$
    DECLARE
        _admin_id    uuid;
        _elem        varchar;
        _permissions varchar[];
    BEGIN
        _admin_id = 'd7642126-64de-4fde-9d89-b2e9532bd2d4';
        _permissions = ARRAY [
            'USER_CREATE',
            'USER_READ',
            'USER_UPDATE',
            'USER_DELETE',
            'GET_USERS',
            'SET_CARRIER_REGIONS',
            'ROLE_CREATE',
            'ROLE_READ',
            'ROLE_UPDATE',
            'ROLE_DELETE',
            'GET_ROLES',
            'PRODUCT_CREATE',
            'PRODUCT_READ',
            'PRODUCT_UPDATE',
            'PRODUCT_DELETE',
            'GET_USER_PRODUCTS',
            'OFFER_CREATE',
            'OFFER_READ',
            'OFFER_UPDATE',
            'OFFER_DELETE',
            'GET_USER_OFFERS',
            'REQUEST_CREATE',
            'REQUEST_READ',
            'REQUEST_UPDATE',
            'REQUEST_DELETE',
            'GET_USER_REQUESTS',
            'TRANSACTION_CREATE',
            'TRANSACTION_READ',
            'TRANSACTION_UPDATE',
            'TRANSACTION_DELETE',
            'EVALUATE_TRANSACTION',
            'GET_USER_TRANSACTIONS',
            'REGION_CREATE',
            'REGION_READ',
            'REGION_UPDATE',
            'REGION_DELETE',
            'GET_REGIONS_AND_PLACES',
            'PLACE_CREATE',
            'PLACE_READ',
            'PLACE_UPDATE',
            'PLACE_DELETE',
            'GET_OWN_PRODUCTS',
            'GET_OWN_OFFERS',
            'GET_OWN_REQUESTS',
            'GET_OWN_TRANSACTIONS',
            'STATISTICS'
            ];
        FOREACH _elem IN ARRAY _permissions
            LOOP
                insert into role_permissions(role_id, permission)
                VALUES (_admin_id, _elem);
            END LOOP;
    END;
$do$;