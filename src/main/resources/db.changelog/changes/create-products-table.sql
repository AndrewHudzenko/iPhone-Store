--liquibase formatted sql
--changeset <root>:<create-products-table>
CREATE TABLE IF NOT EXIST products
(
    id bigint auto_increment,
    title varchar(255) not null,
    price decimal not null,
    CONSTRAINT products_pk PRIMARY KEY (id)
);

--rollback DROP TABLE products;