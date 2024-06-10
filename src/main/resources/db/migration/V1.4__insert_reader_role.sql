INSERT INTO public.roles(id, name)
values ('26f18580-8ade-4d94-a5da-b121d3b7ca3f', 'READER');

INSERT INTO public.users(id, username, firstname, lastname, email, image_id, password, password_hash, status, role_id)
values ('0fa7f840-83de-4cc5-b277-8c91336d25c4',
        'reader', 'tim', 'cook', 'reader@demodelivery.com', null,
        '$2a$10$aXi7VJ51vLh9XK0qlWAWcO8ttbZEfUUNb.KQZA4khmDu0HtK5pOGK',
        'scrypt',
        'ENABLED',
        '26f18580-8ade-4d94-a5da-b121d3b7ca3f');

DO
$do$
    DECLARE
        _admin_id    uuid;
        _elem        varchar;
        _permissions varchar[];
    BEGIN
        _admin_id = '26f18580-8ade-4d94-a5da-b121d3b7ca3f';
        _permissions = ARRAY [
            'USER_READ',
            'GET_USERS',
            'GET_ROLES',
            'GET_USER_PRODUCTS',
            'GET_USER_OFFERS',
            'GET_USER_REQUESTS',
            'TRANSACTION_READ',
            'GET_USER_TRANSACTIONS',
            'REGION_READ',
            'GET_REGIONS_AND_PLACES',
            'PLACE_READ'
            ];
        FOREACH _elem IN ARRAY _permissions
            LOOP
                insert into role_permissions(role_id, permission)
                VALUES (_admin_id, _elem);
            END LOOP;
    END;
$do$;