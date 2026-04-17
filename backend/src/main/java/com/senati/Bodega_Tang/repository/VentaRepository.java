package com.senati.Bodega_Tang.repository;

// IMPORTAMOS LOS DRIVERS, METODOS
import com.senati.Bodega_Tang.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Anotacion @repository INTERFAZ COMO LA CAPA DE ACCESO A LA BASE DE DATOS
@Repository

public interface VentaRepository extends JpaRepository<Venta, Long> {
    //No necesitamos escribir nada aqui
    // JpaRepository ya tiene_todo_lo_basico

}
