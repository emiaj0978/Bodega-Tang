// EVENTOS EN JAVASCRIPT (CLICK, CARGAR, KEY,)
document.addEventListener("DOMContentLoaded", () => {
    fetch('http://localhost:8080/api/servicios')
        .then(response => response.json())
        .then(data => {

            //console.log('Datos:', data);
            const elemento = document.getElementById("table-cliente")

            for (let i = 0; i < data.length; i++) {
                let Servicio = data[i];
                let fila = `
                <tr>
                        <td>${Servicio.id}</td>
                        <td>${Servicio.cliente.nombre}</td>
                        <td>${Servicio.plan.nombre}</td>
                        <td>${Servicio.fecha_instalacion}</td>
                        <td>${Servicio.estado}</td>
                        <td>
                                <!-- Botón Editar -->
                                <button class="btn btn-outline-primary me-2">
                                    <i class="fas fa-edit"></i> Editar
                                </button>

                                <!-- Botón Eliminar -->
                                <button id="btnEliminar" data-idcliente = ${Servicio.id} class="btn btn-outline-danger">
                                    <i class="fas fa-trash"></i> Eliminar
                                </button>
                            </td>
                </tr>
                        `
                elemento.innerHTML += fila;
                //console.log(cliente)

            }
            //elemento.innerHTML = JSON.stringify(data);
            //console.log(elemento)
        })
});

//evento de click en javascript
//creamos una variable que almacene el DOM de ese elemento
document.addEventListener("click", function (e) {
    const btnDelete = e.target.closest("#btnEliminar");
    if (btnDelete) {
        alert("Eliminando...");
        const id = btnDelete.dataset.idcliente;
        //console.log(id); //para en cosole que id es nada mas
        //fletch("http://localhost:8080/api/clientes/"+id, {
        fetch(`http://localhost:8080/api/servicios/${id}`, {
            method: 'DELETE'
        })
        .then(response => {
            if (response.ok) {
                alert('Servicio eliminado correctamente.');
                // Recargar la página o actualizar la tabla
                location.reload();
            }else {
                alert('Error al eliminar el Servicio.');
            }
        });
    }
});


