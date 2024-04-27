CREATE TABLE book (
    id SERIAL,
    author TEXT,
    launch_date TIMESTAMP NOT NULL,
    price NUMERIC(15,2) NOT NULL,
    title TEXT,
    PRIMARY KEY (id)
);