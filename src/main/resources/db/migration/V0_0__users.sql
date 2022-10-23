CREATE TABLE IF NOT EXISTS users
(
    id serial
        constraint table_name_pk
            primary key,
    name varchar
);