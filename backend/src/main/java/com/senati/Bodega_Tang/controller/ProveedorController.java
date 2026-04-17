package com.senati.Bodega_Tang.controller;

import com.senati.Bodega_Tang.entity.Proveedor;
import com.senati.Bodega_Tang.service.ProveedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//3 ANOTACIONES
//Indica que esta clase maneja peticiones HTTPS y DEVUELVE JSON
@RestController
// Define la URL Base de todos los END-POINT de esta clase
@RequestMapping("api/proveedores")
// Esta anotacion permite que el front-end pueda llamar a esta API
// Si no ponemos esto, el navegador bloquea las peticiones por politicas CORS
@CrossOrigin(origins = "*")
public class ProveedorController {
    //DECLARAMOS UNA VARIABLE DEFINIDA
    // Inyectamos el servicio para acceder a la logica del negocio
    private final ProveedorService proveedorService;
    public ProveedorController(ProveedorService proveedorService){
        this.proveedorService = proveedorService;
    }
    //GET /api/clientes -> devuelve todos los clientes en formato JSON
    @GetMapping
    public List<Proveedor> listar() {return proveedorService.listarTodos();}

    //POST /api/clientes -> para guardar un cliente
    @PostMapping
    public ResponseEntity<Proveedor> crear(@RequestBody Proveedor proveedor){
        return ResponseEntity.ok(proveedorService.crearProveedor(proveedor));
    }

    //delete/api/clientes/{id} -> elimina un cliente por su id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable long id){

        proveedorService.eliminarProveedor(id);
        return ResponseEntity.noContent().build();

    }
}
