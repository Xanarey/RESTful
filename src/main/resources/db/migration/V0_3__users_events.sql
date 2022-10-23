CREATE TABLE IF NOT EXISTS users_events
(
    id serial
        constraint users_events_pk
            primary key,
    user_id int not null
        constraint user_id
            references users,
    event_id int
        constraint event_id
            references events
);