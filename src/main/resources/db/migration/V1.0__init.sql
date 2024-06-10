CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE "users"
(
    "id"            uuid PRIMARY KEY,
    "username"      varchar(32) UNIQUE NOT NULL,
    "firstname"     varchar(32)        NOT NULL,
    "lastname"      varchar(23)        NOT NULL,
    "email"         varchar UNIQUE     NOT NULL,
    "image_id"      uuid,
    "password"      varchar            NOT NULL,
    "password_hash" varchar(32)        NOT NULL DEFAULT 'BCRYPT',
    "status"        varchar(32)        NOT NULL DEFAULT 'ENABLED',
    "role_id"       uuid               NOT NULL,
    "created_at"    timestamp,
    "created_by"    uuid
);

CREATE TABLE "access_tokens"
(
    "token"      varchar PRIMARY KEY NOT NULL,
    "user_id"    uuid                NOT NULL,
    "expiration" timestamp,
    "is_deleted" bool                NOT NULL DEFAULT false
);

CREATE TABLE "roles"
(
    "id"         uuid PRIMARY KEY,
    "name"       varchar NOT NULL,
    "is_deleted" bool DEFAULT false,
    "created_at" timestamp,
    "created_by" uuid
);

CREATE TABLE "role_permissions"
(
    "role_id"    uuid    NOT NULL,
    "permission" varchar NOT NULL
);

CREATE TABLE "regions"
(
    "id"         uuid PRIMARY KEY,
    "name"       varchar(64) UNIQUE NOT NULL,
    "is_deleted" bool               NOT NULL DEFAULT false
);

CREATE TABLE "places"
(
    "id"         uuid PRIMARY KEY,
    "name"       varchar(64) UNIQUE NOT NULL,
    "region_id"  uuid               NOT NULL,
    "is_deleted" bool               NOT NULL DEFAULT false
);

CREATE TABLE "carrier_regions"
(
    "carrier_id" uuid UNIQUE NOT NULL,
    "region_id"  uuid        NOT NULL
);

CREATE TABLE "products"
(
    "id"         uuid PRIMARY KEY,
    "name"       varchar(64) UNIQUE NOT NULL,
    "code"       varchar UNIQUE     NOT NULL,
    "price"      float              NOT NULL,
    "image_id"   uuid               NOT NULL,
    "created_at" timestamp          NOT NULL,
    "created_by" uuid               NOT NULL
);

CREATE TABLE "images"
(
    "id"            uuid PRIMARY KEY,
    "path"          varchar        NOT NULL,
    "name"          varchar UNIQUE NOT NULL,
    "original_name" varchar,
    "size"          int8,
    "created_at"    timestamp,
    "created_by"    uuid
);

CREATE TABLE "offers"
(
    "id"         uuid PRIMARY KEY,
    "product_id" uuid           NOT NULL,
    "code"       varchar UNIQUE NOT NULL,
    "place_name" varchar        NOT NULL,
    "status"     varchar(32) DEFAULT 'OPEN',
    "created_at" timestamp      NOT NULL,
    "created_by" uuid           NOT NULL
);

CREATE TABLE "requests"
(
    "id"         uuid PRIMARY KEY,
    "product_id" uuid           NOT NULL,
    "code"       varchar UNIQUE NOT NULL,
    "place_name" varchar        NOT NULL,
    "status"     varchar(32) DEFAULT 'OPEN',
    "created_at" timestamp      NOT NULL,
    "created_by" uuid           NOT NULL
);

CREATE TABLE "transactions"
(
    "id"               uuid PRIMARY KEY,
    "score"            smallint       NOT NULL DEFAULT 0,
    "code"             varchar UNIQUE NOT NULL,
    "carrier_username" varchar        NOT NULL,
    "request_code"     varchar        NOT NULL,
    "offer_code"       varchar        NOT NULL,
    "perform_time"     timestamp,
    "created_at"       timestamp      NOT NULL,
    "created_by"       uuid           NOT NULL
);

CREATE UNIQUE INDEX ON "role_permissions" ("role_id", "permission");

CREATE UNIQUE INDEX ON "products" ("created_by", "name");

CREATE UNIQUE INDEX ON "products" ("created_by", "code");

COMMENT ON COLUMN "products"."name" IS 'Descriptive name of the product';

COMMENT ON COLUMN "products"."code" IS 'Unique product code';

COMMENT ON COLUMN "images"."name" IS 'Generated unique name';

COMMENT ON COLUMN "images"."original_name" IS 'Original file name';

COMMENT ON COLUMN "images"."size" IS 'File size';

COMMENT ON COLUMN "transactions"."perform_time" IS 'The courier completes the transaction after delivering the product';

ALTER TABLE "users"
    ADD FOREIGN KEY ("role_id") REFERENCES "roles" ("id");

ALTER TABLE "users"
    ADD FOREIGN KEY ("created_by") REFERENCES "users" ("id");

ALTER TABLE "users"
    ADD FOREIGN KEY ("image_id") REFERENCES "images" ("id");

ALTER TABLE "role_permissions"
    ADD FOREIGN KEY ("role_id") REFERENCES "roles" ("id");

ALTER TABLE "roles"
    ADD FOREIGN KEY ("created_by") REFERENCES "users" ("id");

ALTER TABLE "products"
    ADD FOREIGN KEY ("image_id") REFERENCES "images" ("id");

ALTER TABLE "products"
    ADD FOREIGN KEY ("created_by") REFERENCES "users" ("id");

ALTER TABLE "offers"
    ADD FOREIGN KEY ("product_id") REFERENCES "products" ("id");

ALTER TABLE "offers"
    ADD FOREIGN KEY ("created_by") REFERENCES "users" ("id");

ALTER TABLE "offers"
    ADD FOREIGN KEY ("place_name") REFERENCES "places" ("name");

ALTER TABLE "requests"
    ADD FOREIGN KEY ("product_id") REFERENCES "products" ("id");

ALTER TABLE "requests"
    ADD FOREIGN KEY ("created_by") REFERENCES "users" ("id");

ALTER TABLE "requests"
    ADD FOREIGN KEY ("place_name") REFERENCES "places" ("name");

ALTER TABLE "transactions"
    ADD FOREIGN KEY ("carrier_username") REFERENCES "users" ("username");

ALTER TABLE "transactions"
    ADD FOREIGN KEY ("request_code") REFERENCES "requests" ("code");

ALTER TABLE "transactions"
    ADD FOREIGN KEY ("offer_code") REFERENCES "offers" ("code");

ALTER TABLE "transactions"
    ADD FOREIGN KEY ("created_by") REFERENCES "users" ("id");

ALTER TABLE "places"
    ADD FOREIGN KEY ("region_id") REFERENCES "regions" ("id");

ALTER TABLE "carrier_regions"
    ADD FOREIGN KEY ("carrier_id") REFERENCES "users" ("id");

ALTER TABLE "carrier_regions"
    ADD FOREIGN KEY ("region_id") REFERENCES "regions" ("id");

ALTER TABLE "access_tokens"
    ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "images"
    ADD FOREIGN KEY ("created_by") REFERENCES "users" ("id");
