package com.senati.Bodega_Tang.repository;

// IMPORTAMOS LOS DRIVERS, METODOS
import com.senati.Bodega_Tang.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Anotacion @repository INTERFAZ COMO LA CAPA DE ACCESO A LA BASE DE DATOS
@Repository

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    //No necesitamos escribir nada aqui
    // JpaRepository ya tiene_todo_lo_basico

}


