
INSERT INTO admins (email, name) VALUES
  ('admin@loja.com', 'Admin Principal'),
  ('ops@loja.com', 'Operações');

INSERT INTO clients (email, name) VALUES
  ('cliente1@ex.com', 'Cliente Um'),
  ('cliente2@ex.com', 'Cliente Dois');

INSERT INTO products (name, price, stock) VALUES
  ('Caneca Laranja', 29.9, 20),
  ('Camiseta Preta', 49.9, 15),
  ('Fone Sem Fio', 199.9, 8);

INSERT INTO carts (description, total, created_on) VALUES
  ('Cart for cliente1', 0, CURRENT_TIMESTAMP),
  ('Cart for cliente2', 0, CURRENT_TIMESTAMP);

INSERT INTO cart_products (cart_id, product_id) VALUES
  (1, 1),
  (2, 2);

INSERT INTO payments (type, amount, fee) VALUES
  ('Cartão', 250.00, 7.5),
  ('Pix', 180.00, 1.8);
