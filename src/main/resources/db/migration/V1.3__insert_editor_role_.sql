INSERT INTO public.roles(id, name)
values ('7a4167d9-9606-4988-83ce-35399b6bcfb0', 'EDITOR');


INSERT INTO public.users(id, username, firstname, lastname, email, image_id, password, password_hash, status, role_id)
values ('6e0f0d06-dea7-45d0-aa3a-26735950d6b0',
        'editor', 'steve', 'jobs', 'editor@demodelivery.com', null,
        '$2a$10$aXi7VJ51vLh9XK0qlWAWcO8ttbZEfUUNb.KQZA4khmDu0HtK5pOGK',
        'scrypt',
        'ENABLED',
        '7a4167d9-9606-4988-83ce-35399b6bcfb0');

DO
$do$
    DECLARE
        _admin_id    uuid;
        _elem        varchar;
        _permissions varchar[];
    BEGIN
        _admin_id = '7a4167d9-9606-4988-83ce-35399b6bcfb0';
        _permissions = ARRAY [
            'GET_USERS',
            'PRODUCT_CREATE',
            'PRODUCT_READ',
            'PRODUCT_UPDATE',
            'PRODUCT_DELETE',
            'GET_USER_PRODUCTS',
            'GET_USER_OFFERS',
            'GET_USER_REQUESTS',
            'GET_USER_TRANSACTIONS',
            'REGION_CREATE',
            'REGION_READ',
            'REGION_UPDATE',
            'REGION_DELETE',
            'GET_REGIONS_AND_PLACES',
            'PLACE_CREATE',
            'PLACE_READ',
            'PLACE_UPDATE',
            'PLACE_DELETE'
            ];
        FOREACH _elem IN ARRAY _permissions
            LOOP
                insert into role_permissions(role_id, permission)
                VALUES (_admin_id, _elem);
            END LOOP;
    END;
$do$;