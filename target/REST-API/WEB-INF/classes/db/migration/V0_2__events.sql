CREATE TABLE IF NOT EXISTS events
(
    id serial
        constraint events_pk
            primary key,
    file_id int not null
        constraint file_id
            references files
);

