package com.senati.Bodega_Tang.controller;

import com.senati.Bodega_Tang.entity.Cliente;
import com.senati.Bodega_Tang.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//3 ANOTACIONES
//Indica que esta clase maneja peticiones HTTPS y DEVUELVE JSON
@RestController
// Define la URL Base de todos los END-POINT de esta clase
@RequestMapping("api/clientes")
// Esta anotacion permite que el front-end pueda llamar a esta API
// Si no ponemos esto, el navegador bloquea las peticiones por politicas CORS
@CrossOrigin(origins = "*")
public class ClienteController {
    //DECLARAMOS UNA VARIABLE DEFINIDA
    // Inyectamos el servicio para acceder a la logica del negocio
    private final ClienteService clienteService;
    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }
    //GET /api/clientes -> devuelve todos los clientes en formato JSON
    @GetMapping
    public List<Cliente> listar() {return clienteService.listarTodos();}

    //POST /api/clientes -> para guardar un cliente
    @PostMapping
    public ResponseEntity<Cliente> crear(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.crearCliente(cliente));
    }

    //delete/api/clientes/{id} -> elimina un cliente por su id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable long id){

        clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();

    }
}
