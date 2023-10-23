CREATE TABLE basket (
    id BIGINT NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE basket_products (
    basket_id BIGINT NOT NULL,
    products_id BIGINT NOT NULL UNIQUE,
    PRIMARY KEY (basket_id, products_id)
);
CREATE TABLE customer (
    DATE DATE DEFAULT CURRENT_TIMESTAMP,
    basket_id BIGINT UNIQUE,
    id BIGSERIAL NOT NULL,
    name VARCHAR(255),
    password VARCHAR(255),
    surname VARCHAR(255),
    username VARCHAR(255),
    PRIMARY KEY (id)
);
CREATE TABLE product (
    barcode INTEGER,
    id BIGSERIAL NOT NULL,
    name VARCHAR(255),
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
    if EXISTS customer
    ADD
        CONSTRAINT fk_basket_id FOREIGN KEY (basket_id) REFERENCES basket;