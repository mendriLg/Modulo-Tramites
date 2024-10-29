package generation.rencapp.services;
import generation.rencapp.models.Servicio;
import generation.rencapp.models.Solicitud;
import generation.rencapp.models.Tramite;
import generation.rencapp.models.Vecino;

import java.time.LocalDate;
import java.util.List;

public interface SolicitudService {

    // Metodo para buscar todas las solicitudes
    List<Solicitud> findAll();

    // Metodo para borrar solicitud por id
    void deleteById(Long id);

    // Metodo para crear una nueva solicitud
    Solicitud saveSolicitud(Solicitud solicitudNueva);

    // Metodo para buscar por fecha de creación de la solicitud
    List<Solicitud> findByFechaCreacion(LocalDate fecha);

    // Metodo para buscar solicitud por el vecinoId
    List<Solicitud> findByVecinoId(Vecino vecino);

    // Metodo para buscar solicitudes por estado
    List<Solicitud> findByEstado(String estado);

    // Metodo para encontrar solicitud por tramiteId
    List<Solicitud> findByTramiteId(Tramite tramite);


}
