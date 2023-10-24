CREATE TABLE if not exists basket (
    id BIGSERIAL NOT NULL,
    customer_id BIGINT,
    PRIMARY KEY (id)
);
CREATE TABLE basket_products (
    basket_id BIGINT NOT NULL,
    products_id BIGINT NOT NULL,
    PRIMARY KEY (basket_id, products_id)
);
CREATE TABLE if not exists customer (
    id BIGSERIAL NOT NULL UNIQUE,
    DATE DATE DEFAULT CURRENT_TIMESTAMP,
    name VARCHAR(255),
    password VARCHAR(255),
    surname VARCHAR(255),
    username VARCHAR(255),
    PRIMARY KEY (id)
);
CREATE TABLE product (
    id BIGSERIAL NOT NULL UNIQUE,
    barcode INTEGER,
    name VARCHAR(255),
    price INTEGER,
    PRIMARY KEY (id)
);
ALTER TABLE
    if EXISTS basket_products
    ADD
        CONSTRAINT fk_basket_id FOREIGN KEY (products_id) REFERENCES product;
ALTER TABLE
    if EXISTS basket_products
    ADD
        CONSTRAINT fk_product_id FOREIGN KEY (basket_id) REFERENCES basket;
ALTER TABLE
    if EXISTS basket
    ADD
        CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES basket;