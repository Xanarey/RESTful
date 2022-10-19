CREATE TABLE IF NOT EXISTS users
(
    id integer NOT NULL,
    firstname character varying(20),
    lastname character varying(20),
    CONSTRAINT users_pkey PRIMARY KEY (id)
);