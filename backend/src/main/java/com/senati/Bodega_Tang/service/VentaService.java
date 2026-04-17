package com.senati.Bodega_Tang.service;

import com.senati.Bodega_Tang.entity.Venta;
import com.senati.Bodega_Tang.repository.VentaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
//Importamos la anotacion @service
//Esto es la capa de la logica de negocio, aqui van las validaciones, calculos, etc.
@Service
public class VentaService {
    //Inyectamos el repositorio para poder acceder a la base de datos
    private final VentaRepository ventaRepository;

    //Contructor: Spring inyecta automaticamente el repositorio(las dependencias)
    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }
    //Retorna o recive la lista de todos los clientes
    public List<Venta> listarTodos(){
        return ventaRepository.findAll();
    }

    //Eliminar el cliente por el id
    public void eliminarVenta(long id){
        ventaRepository.deleteById(id);
    }
}
