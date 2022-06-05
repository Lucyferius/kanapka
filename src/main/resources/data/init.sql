-- drop type if exists room_type;
-- create type room_type as enum ('ECONOM', 'STANDARD', 'HALF_LUX', 'LUX', 'PRESIDENT');

drop type if exists guest_role;
create type guest_role as enum ('ROLE_ADMIN', 'ROLE_GUEST');

-- drop type if exists dish_type;
-- create type dish_type as enum ('LUNCH', 'SOUP', 'SNACK', 'PIZZA', 'SALAD', 'DESERT', 'DRINK');

drop table if exists guests;
create table guests
(
    id           bigserial    not null
        constraint guests_pkey
            primary key,
    address      varchar(60),
    email        varchar(60),
    full_name    varchar(60) not null,
    phone_number varchar(10) not null,
    guest_role   guest_role not null
);

alter table guests
    owner to postgres;

drop table if exists rooms;
create table rooms
(
    id                bigserial    not null
        constraint rooms_pkey
            primary key,
    capacity          integer      not null,
    presentation_name varchar(255) not null,
    price_per_night   real         not null,
    room_number       varchar(255) not null,
    room_type         room_type    not null
);

alter table rooms
    owner to postgres;

drop table if exists reservation;
create table reservation
(
    id                    bigserial    not null
        constraint reservation_pkey
            primary key,
    reservation_cancelled boolean,
    reservation_from      timestamp    not null,
    reservation_code      varchar(6) not null,
    reservation_to        timestamp    not null,
    guest_id              bigint
        constraint f_guest_id
            references guests,
    room_id               bigint
        constraint f_room_id
            references rooms
);
create unique index reservation_code_uindex on reservation (reservation_code);

alter table reservation
    owner to postgres;

drop table if exists dishes;
create table dishes
(
    id            bigserial    not null
        constraint dishes_pkey
            primary key,
    description   varchar(255),
    image_path    varchar(255) not null,
    name          varchar(255) not null,
    price         real         not null,
    weight        real         not null
);

alter table dishes
    owner to postgres;

drop table if exists orders;
create table orders
(
    id             bigserial not null
        constraint orders_pkey
            primary key,
    cancelled      boolean   not null,
    contact_number varchar(255),
    done           boolean   not null,
    expected_at    timestamp not null,
    ordered_at     timestamp not null,
    urgent         boolean   not null,
    reservation_id bigint
        constraint f_reservation_id
            references reservation
);

alter table orders
    owner to postgres;

