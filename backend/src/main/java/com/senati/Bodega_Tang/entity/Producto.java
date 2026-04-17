package com.senati.Bodega_Tang.entity;

import jakarta.persistence.*;
// @Entity le dice a Hibernate que esta clase representa una tabla en la BD
@Entity
// @Table indica el nombre exacto de tabla en MYSQL o MariaDB
@Table(name = "producto")
public class Producto {
    // @Id marca este campo como la clave primaria de la tabla
    // @GeneratedValue hace que el ID se genere automaticamente (AutoIncrement)
    // @Column(name="cliente_id") indica el nombre exacto de la columna en mysql
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id;
    // nullable=false significa que este campo no puede estar vacio en la BD
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String descripcion;
    //unique=true significa que no puede haber dos clientes con el mismo DNI
    //length=8 significa limita el campo a 8 caracteres
    @Column(nullable = false,unique = true,length = 8)
    private String precio;
    //Sin anotaciones ( @ ) extra: columna normal, puede ser nula
    private String stock;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_proveedor")  // Esto es la llave foránea
    private Proveedor proveedor;

    //GETTER a SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
