CREATE TABLE IF NOT EXISTS files
(
    id serial
        constraint files_pk
            primary key,
    url varchar
);

