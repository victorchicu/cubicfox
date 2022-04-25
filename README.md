# Run application

## Install JDK 8

https://docs.datastax.com/en/jdk-install/doc/jdk-install/installOpenJdkDeb.html

## To run tests please following steps

1. Navigate to the root dir and **docker-compose up -d**
2. Open pg_admin **http://localhost:5050**
3. Create **cubicfox** database and schema
4. Create tables according json schema

```
create table "user"
(
    id       integer not null
        constraint user_pk
            primary key,
    name     text,
    username text,
    email    text,
    phone    text,
    website  text
);

alter table "user"
    owner to postgres;

create table address
(
    street  text,
    suite   text,
    city    text,
    zipcode text,
    id      integer
        constraint address_users_id_fk
            references "user"
);

alter table address
    owner to postgres;

create unique index address_user_id_uindex
    on address (id);

create unique index user_id_uindex
    on "user" (id);

create table geo
(
    lat numeric,
    lng numeric,
    id  integer
        constraint geo_address_user_id_fk
            references address (user_id)
);

alter table geo
    owner to postgres;

create table company
(
    name          text,
    "catchPhrase" text,
    bs            text,
    id            integer
        constraint company_users_id_fk
            references "user"
);

alter table company
    owner to postgres;
```
