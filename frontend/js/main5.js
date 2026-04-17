// EVENTOS EN JAVASCRIPT (CLICK, CARGAR, KEY,)
document.addEventListener("DOMContentLoaded", () => {
    fetch('http://localhost:8080/api/soporte_tecnicos')
        .then(response => response.json())
        .then(data => {

            //console.log('Datos:', data);
            const elemento = document.getElementById("table-cliente")

            for (let i = 0; i < data.length; i++) {
                let Soporte_tecnico = data[i];
                let fila = `
                <tr>
                        <td>${Soporte_tecnico.id}</td>
                        <td>${Soporte_tecnico.servicio.id}</td>
                        <td>${Soporte_tecnico.fecha_reporte}</td>
                        <td>${Soporte_tecnico.descripcion}</td>
                        <td>${Soporte_tecnico.estado}</td>
                        <td>
                                <!-- Botón Editar -->
                                <button class="btn btn-outline-primary me-2">
                                    <i class="fas fa-edit"></i> Editar
                                </button>

                                <!-- Botón Eliminar -->
                                <button id="btnEliminar" data-idcliente = ${Soporte_tecnico.id} class="btn btn-outline-danger">
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
        fetch(`http://localhost:8080/api/soporte_tecnicos/${id}`, {
            method: 'DELETE'
        })
        .then(response => {
            if (response.ok) {
                alert('Queja eliminado correctamente.');
                // Recargar la página o actualizar la tabla
                location.reload();
            }else {
                alert('Error al eliminar la Queja.');
            }
        });
    }
});