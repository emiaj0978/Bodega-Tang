package com.senati.Bodega_Tang.entity;

import jakarta.persistence.*;
// @Entity le dice a Hibernate que esta clase representa una tabla en la BD
@Entity
// @Table indica el nombre exacto de tabla en MYSQL o MariaDB
@Table(name = "venta")
public class Venta {
    // @Id marca este campo como la clave primaria de la tabla
    // @GeneratedValue hace que el ID se genere automaticamente (AutoIncrement)
    // @Column(name="cliente_id") indica el nombre exacto de la columna en mysql
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Long id;
    // nullable=false significa que este campo no puede estar vacio en la BD
    @Column(nullable = false)
    private String fecha;
    @Column(nullable = false)
    private String total;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cliente")  // Esto es la llave foránea
    private Cliente cliente;

    //GETTER a SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
