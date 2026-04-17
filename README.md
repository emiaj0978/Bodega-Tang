## TRELLO
mi tablero de trello
![TRELLO](https://github.com/emiaj0978/Bodega-Tang/blob/main/frontend/imagen/image.png)

---

# Sistema de Gestión - Bodega Tang
Sistema web para la gestión de una bodega, permitiendo administrar productos, proveedores, clientes y ventas de manera eficiente. Desarrollado como proyecto final del curso de Java Web en SENATI.

---

## Descripción del negocio
Nombre: Bodega Tang  
Giro: Comercio de productos  
Tamaño: Pequeña empresa  
Contexto: Negocio donde se venden distintos productos y se requiere llevar un control de inventario, ventas y proveedores.  
Justificación: Digitalizar el control manual para mejorar la organización, reducir errores y tener un control en tiempo real.

---

## Identificación del problema y solución

Problema:  
El negocio lleva el control de productos, ventas y clientes de forma manual, lo que genera errores, pérdida de información y descontrol del inventario.

Solución tecnológica:  
Desarrollar un sistema web usando Java Spring Boot y MySQL que permita registrar, consultar y controlar todas las operaciones de la tienda.

---

## Requerimientos Funcionales

| Código | Descripción |
|---|---|
| RF01 | Registrar proveedores |
| RF02 | Registrar productos con stock y precio |
| RF03 | Registrar clientes |
| RF04 | Registrar ventas |
| RF05 | Mostrar listado de productos |
| RF06 | Mostrar historial de ventas |

---

## Requerimientos No Funcionales

| Código | Tipo | Descripción |
|---|---|---|
| RNF01 | Rendimiento | Respuesta menor a 3 segundos |
| RNF02 | Usabilidad | Interfaz intuitiva |
| RNF03 | Seguridad | Acceso con autenticación |

---

## Stack completo
1. Trello             → Gestión del proyecto  
2. Draw.io            → Diagramas  
3. Figma              → Diseño UI/UX  
4. MySQL Workbench    → Base de datos  
5. IntelliJ IDEA      → Backend + Frontend  
6. XAMPP              → Servidor  

---

## Tecnologías utilizadas
- Java 17
- Spring Boot 3
- MySQL 8
- HTML5, CSS3, JavaScript
- IntelliJ IDEA
- XAMPP
- MySQL Workbench
- Draw.io
- Figma

---

## Estructura del proyecto

```
JavaWeb-GotaGota/
├── backend/          → Spring Boot (Java)
│   ├── src/
│   ├── pom.xml
│   └── ...
├── frontend/         → HTML, CSS, JS
│   ├── css/
│   ├── js/
│   └── index.html
```
 
---
 
## Base de datos

El sistema cuenta con 4 tablas principales:

| Tabla | Descripción |
|---|---|
| PROVEEDOR | Empresas que suministran productos |
| PRODUCTO | Productos disponibles en la tienda |
| CLIENTE | Personas que compran |
| VENTA | Registro de ventas |

### Diagrama Entidad-Relacion (DER)
![Diagrama Entidad Relacion](https://github.com/ojitoslanda/testing/blob/master/img/javaweb/Diagrama_Entidad_Relacion.png)
 
### Modelo Relacional (MR)
![Modelo Relacional](https://github.com/ojitoslanda/testing/blob/master/img/javaweb/Modelo_Relacional.png)

---

## Cardinalidades

| Entidad A | Relación | Entidad B | Cardinalidad |
|---|---|---|---|
| PROVEEDOR | suministra | PRODUCTO | 1:N |
| CLIENTE | realiza | VENTA | 1:N |

PROVEEDOR — PRODUCTO (1:N)  
Un proveedor puede tener muchos productos, pero un producto pertenece a un solo proveedor.

CLIENTE — VENTA (1:N)  
Un cliente puede realizar muchas compras, pero cada venta pertenece a un solo cliente.

---

## Modelo SQL

```sql
CREATE DATABASE bodega_tang;
USE bodega_tang;

-- Tabla PROVEEDOR
CREATE TABLE proveedor (
    id_proveedor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(15),
    direccion VARCHAR(150)
);

-- Tabla PRODUCTO
CREATE TABLE producto (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(150),
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL,
    id_proveedor INT,
    FOREIGN KEY (id_proveedor) REFERENCES proveedor(id_proveedor)
);

-- Tabla CLIENTE
CREATE TABLE cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(15),
    direccion VARCHAR(150)
);

-- Tabla VENTA
CREATE TABLE venta (
    id_venta INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    id_cliente INT,
    total DECIMAL(10,2),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);


-- INSERT PROVEEDOR
INSERT INTO proveedor (nombre, telefono, direccion) VALUES
('Distribuidora Lima', '987654321', 'Av. Lima 123'),
('Comercial Norte', '912345678', 'Jr. Amazonas 456'),
('Importadora Perú', '998877665', 'Av. Perú 789'),
('Mayorista Central', '976543210', 'Jr. Callao 321'),
('Almacenes Unidos', '955443322', 'Av. Arequipa 654'),
('Suministros SAC', '933221144', 'Jr. Piura 987'),
('Productos del Sur', '911223344', 'Av. Tacna 159');

-- INSERT PRODUCTO
INSERT INTO producto (nombre, descripcion, precio, stock, id_proveedor) VALUES
('Arroz 1kg', 'Arroz superior', 4.50, 100, 1),
('Azúcar 1kg', 'Azúcar rubia', 3.80, 80, 2),
('Leche Gloria', 'Leche evaporada', 4.20, 60, 3),
('Aceite 1L', 'Aceite vegetal', 8.90, 50, 4),
('Fideos', 'Fideos largos', 2.50, 120, 5),
('Galletas', 'Galletas dulces', 1.80, 200, 6),
('Atún', 'Atún en lata', 5.50, 70, 7);

-- INSERT CLIENTE
INSERT INTO cliente (nombre, telefono, direccion) VALUES
('Juan Pérez', '900111222', 'Jr. Pucallpa 123'),
('María López', '900333444', 'Av. Ucayali 456'),
('Carlos Ruiz', '900555666', 'Jr. Iquitos 789'),
('Ana Torres', '900777888', 'Av. Amazonas 321'),
('Luis García', '900999000', 'Jr. Loreto 654'),
('Sofía Mendoza', '901112233', 'Av. Perú 987'),
('Pedro Castillo', '902223344', 'Jr. Lima 159');

-- INSERT VENTA
INSERT INTO venta (fecha, id_cliente, total) VALUES
('2026-04-01', 1, 15.50),
('2026-04-02', 2, 23.00),
('2026-04-03', 3, 10.80),
('2026-04-04', 4, 45.20),
('2026-04-05', 5, 18.90),
('2026-04-06', 6, 27.30),
('2026-04-07', 7, 12.60);
```

---

## Como correr el proyecto
 
### Requisitos previos
- Tener instalado IntelliJ IDEA
- Tener instalado XAMPP (para MySQL)
- Tener instalado MySQL Workbench
- Tener instalado JDK 21 o superior
 
### Backend
1. Abrir la carpeta `backend/` en IntelliJ IDEA
2. Configurar `application.properties` con los datos de MySQL
3. Iniciar XAMPP y activar MySQL
4. Ejecutar `GotagotaApplication.java`
5. El backend corre en: `http://localhost:8080`
 
### Frontend
1. Abrir la carpeta `frontend/` en VsCode
2. Abrir `index.html` con Live Server
3. El frontend se comunica con el backend via fetch()
 
> El frontend y el backend corren por separado.
> El backend debe estar iniciado antes de abrir el frontend.
 
### Configuracion de base de datos
```
spring.application.name=gotagota
# CONEXION A MYSQL
spring.datasource.url=jdbc:mysql://localhost:3306/bodega_tang
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

#JPA / HIBERNATE
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

# Puerto del servidor
server.port=8080

```
 