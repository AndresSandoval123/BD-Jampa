-- INSERT
-- Tabal Usuarios
INSERT INTO Usuarios (nombre_usuario, apellido_usuario, correo_usuario, contrasena_usuario)
VALUES ('Juan', 'Pérez', 'juan.perez@example.com', 'contraseña123');

INSERT INTO Usuarios (nombre_usuario, apellido_usuario, correo_usuario, contrasena_usuario)
VALUES ('María', 'González', 'maria.gonzalez@example.com', 'segura456');

INSERT INTO Usuarios (nombre_usuario, apellido_usuario, correo_usuario, contrasena_usuario)
VALUES ('Carlos', 'Ramírez', 'carlos.ramirez@example.com', 'password789');

INSERT INTO Usuarios (nombre_usuario, apellido_usuario, correo_usuario, contrasena_usuario)
VALUES ('Ana', 'Martínez', 'ana.martinez@example.com', 'secure012');

INSERT INTO Usuarios (nombre_usuario, apellido_usuario, correo_usuario, contrasena_usuario)
VALUES ('Luis', 'García', 'luis.garcia@example.com', 'clave345');



-- INSERT
-- Tabla productos
INSERT INTO productos (nombre_producto, descripcion, color, talla, stock_disponible, precio_producto, categoria)
VALUES ('Sudadera Casual', 'Sudadera cálida y confortable en diferentes colores', 'Negro', 'XXL', 10,  2000000, 'Ropa Deportiva' );

INSERT INTO Productos (nombre_producto, descripcion, color, talla, stock_disponible, precio_producto, categoria)
VALUES ('Sudadera Deportiva', 'Sudadera suave y cálida para el ejercicio', 'Azul', 'XL', 10, 25000, 'Ropa Deportiva');

INSERT INTO Productos (nombre_producto, descripcion, color, talla, stock_disponible, precio_producto, categoria)
VALUES ('Buso deportivo', 'Buso casual para hombre calido y confortable', 'Gris', 'XXXL', 20, '15000', 'Ropa Deportiva');

INSERT INTO Productos (nombre_producto, descripcion, color, talla, stock_disponible, precio_producto, categoria)
VALUES ('Buso deportivo', 'Buso casual para hombre calido y confortable', 'Beis', 'XXXL', 5, '15000', 'Ropa Deportiva');

INSERT INTO Productos (nombre_producto, descripcion, color, talla, stock_disponible, precio_producto, categoria)
VALUES ('Buso deportivo', 'Buso casual para hombre calido y confortable', 'Negro', 'XXXL', 8, '15000', 'Ropa Deportiva');

INSERT INTO Productos (nombre_producto, descripcion, color, talla, stock_disponible, precio_producto, categoria)
VALUES ('Conjunto Pantaloneta', 'Conjunto para hombre comodo y confortable', 'Rojo', 'XXL', 15, '10000', 'Ropa Deportiva');


-- INSERT
-- Tabla Pediedos
-- Pedidos para el primer usuario (id_usuario = 1)
INSERT INTO Pedidos (cantidad, producto_id, id_usuario)
VALUES (1, 2, 1),
		(5, 3, 1);
--		(2, 6, 2),
--        (2, 5, 3),
--        (2, 2, 4);



-- INSERT
-- Tabla Ventas
-- Ventas para el primer usuario (id_usuario = 1)
--INSERT INTO Ventas (fecha_venta, valor_envio, id_pedido)
--VALUES ('2024-07-01', 10000, 1);
--
--INSERT INTO Ventas (fecha_venta, valor_envio, id_pedido)
--VALUES ('2024-05-01', 15000, 2);
--
--INSERT INTO Ventas (fecha_venta, valor_envio, id_pedido)
--VALUES ('2021-02-01', 10000, 3);
--INSERT INTO Ventas (fecha_venta, valor_envio, id_pedido)
--VALUES ('2024-07-01', 10000, 4);
--
--INSERT INTO Ventas (fecha_venta, valor_envio, id_pedido)
--VALUES ('2024-05-01', 15000, 5);


-- INSERT
-- Tabla Detalle_entrega
--INSERT INTO Detalle_entrega (id_entrega, persona_que_recibe, direccion_entrega, ciudad, telefono_quien_recibe, id_venta)
--VALUES (1, 'Juan Pérez', 'Calle 12 3-20', 'Bogotá', '3203456789', 1);
--
--INSERT INTO Detalle_entrega (persona_que_recibe, direccion_entrega, ciudad, telefono_quien_recibe, id_venta)
--VALUES ('Juan Pérez', 'Calle 12 3-20', 'Bogotá', 3203456789, 2);
--
--INSERT INTO Detalle_entrega (persona_que_recibe, direccion_entrega, ciudad, telefono_quien_recibe, id_venta)
--VALUES ('María López', 'Cr 25 # 75 C1', 'Medellin', 3103656289, 3);
--
--INSERT INTO Detalle_entrega (persona_que_recibe, direccion_entrega, ciudad, telefono_quien_recibe, id_venta)
--VALUES ('María López', 'Cr 25 # 75 C1', 'Medellin', 3103656289, 5);
--

-- INSERT
-- Tabla Imagenes
--INSERT INTO Imagen (url_imagen, id_producto)
--VALUES ('https://i.postimg.cc/zf1mbbkX/Ref-1-Casual-Negro.png', 1),
--		('https://i.postimg.cc/0NGTpktG/Ref-1-Casual-Gris-Claro.png', 1);

-- Imágenes para el producto con id_producto = 2
--INSERT INTO Imagen (url_imagen, id_producto)
--VALUES ('https://i.postimg.cc/6QhP8H3Y/Ref-3-Conj-Pantaloneta-Azul.png', 2),
--		('https://i.postimg.cc/BnHk0ZGW/Ref-3-Conj-Pantaloneta-Negro.png', 2);
--
--
---- Imágenes para el producto con id_producto = 3
--INSERT INTO Imagen (url_imagen, id_producto)
--VALUES ('https://i.postimg.cc/HsfRRcR4/Ref-2-Buso-Capota-Gris.png', 3),
--		('https://i.postimg.cc/442rvF10/Ref-2-Buso-Capota-Beige.png', 3);
--
---- Imágenes para el producto con id_producto = 4
--INSERT INTO Imagen (url_imagen, id_producto)
--VALUES ('https://i.postimg.cc/6QhP8H3Y/Ref-3-Conj-Pantaloneta-Azul.png', 4),
--		('https://i.postimg.cc/BnHk0ZGW/Ref-3-Conj-Pantaloneta-Negro.png', 4);
--
---- Imágenes para el producto con id_producto = 5
--INSERT INTO Imagen (url_imagen, id_producto)
--VALUES ('https://i.postimg.cc/6QhP8H3Y/Ref-3-Conj-Pantaloneta-Azul.png', 5),
--		('https://i.postimg.cc/BnHk0ZGW/Ref-3-Conj-Pantaloneta-Negro.png', 5);