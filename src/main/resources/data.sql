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
INSERT INTO productos (nombre_producto, descripcion, color, talla, precio_producto, categoria)
VALUES ('Sudadera Casual', 'Sudadera cálida y confortable en diferentes colores', 'Negro', 'XXL', 2000000, 'Ropa Deportiva' );

INSERT INTO Productos (nombre_producto, descripcion, color, talla, precio_producto, categoria)
VALUES ('Sudadera Deportiva', 'Sudadera suave y cálida para el ejercicio', 'Azul', 'XL', 25000, 'Ropa Deportiva');

INSERT INTO Productos (nombre_producto, descripcion, color, talla, precio_producto, categoria)
VALUES ('Buso deportivo', 'Buso casual para hombre calido y confortable', 'Gris', 'XXXL', '15000', 'Ropa Deportiva');

INSERT INTO Productos (nombre_producto, descripcion, color, talla, precio_producto, categoria)
VALUES ('Buso deportivo', 'Buso casual para hombre calido y confortable', 'Beis', 'XXXL', '15000', 'Ropa Deportiva');

INSERT INTO Productos (nombre_producto, descripcion, color, talla, precio_producto, categoria)
VALUES ('Buso deportivo', 'Buso casual para hombre calido y confortable', 'Negro', 'XXXL', '15000', 'Ropa Deportiva');

INSERT INTO Productos (nombre_producto, descripcion, color, talla, precio_producto, categoria)
VALUES ('Conjunto Pantaloneta', 'Conjunto para hombre comodo y confortable', 'Rojo', 'XXL', '10000', 'Ropa Deportiva');

-- INSERT
-- Tabla Ventas
-- Ventas para el primer usuario (id_usuario = 1)
--INSERT INTO Ventas (fecha_venta, precio_total, valor_envio)
--VALUES ('2024-07-01', 20000, 10000);
--
--INSERT INTO Ventas (fecha_venta, precio_total, valor_envio)
--VALUES ('2024-07-01', 20000, 10000);
--
--INSERT INTO Ventas (fecha_venta, precio_total, valor_envio)
--VALUES ('2024-07-01', 15000, 10000);
--
---- Ventas para el segundo usuario (id_usuario = 2)
--INSERT INTO Ventas (fecha_venta, precio_total, valor_envio)
--VALUES ('2024-07-01', 75000, 10000);
--
--INSERT INTO Ventas (fecha_venta, precio_total, valor_envio)
--VALUES ('2024-07-01', 60000, 10000);
--
---- Venta para el tercer usuario (id_usuario = 3)
--INSERT INTO Ventas (fecha_venta, precio_total, valor_envio)
--VALUES ('2024-07-01', 15000, 10000);