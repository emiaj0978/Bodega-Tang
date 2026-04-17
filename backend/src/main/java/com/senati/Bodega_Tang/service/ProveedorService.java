package com.senati.Bodega_Tang.service;

import com.senati.Bodega_Tang.entity.Proveedor;
import com.senati.Bodega_Tang.repository.ProveedorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
//Importamos la anotacion @service
//Esto es la capa de la logica de negocio, aqui van las validaciones, calculos, etc.
@Service
public class ProveedorService {
    //Inyectamos el repositorio para poder acceder a la base de datos
    private final ProveedorRepository proveedorRepository;

    //Contructor: Spring inyecta automaticamente el repositorio(las dependencias)
    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }
    //Retorna o recive la lista de todos los clientes
    public List<Proveedor> listarTodos(){
        return proveedorRepository.findAll();
    }

    //Eliminar el cliente por el id
    public void eliminarProveedor(long id){
        proveedorRepository.deleteById(id);
    }
}
