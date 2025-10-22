-- V4: add client_id to carts and foreign key

ALTER TABLE carts
ADD COLUMN client_id INTEGER NULL;

ALTER TABLE carts
ADD CONSTRAINT fk_carts_client FOREIGN KEY (client_id) REFERENCES clients(id) ON DELETE SET NULL;
