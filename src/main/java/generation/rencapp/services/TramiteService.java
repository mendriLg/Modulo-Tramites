package generation.rencapp.services;
import generation.rencapp.models.Servicio;
import generation.rencapp.models.Tramite;
import java.time.LocalDate;
import java.util.List;

public interface TramiteService {

    // Metodo para encontrar trámite por servicioId
    List<Tramite> findByServicioId(Servicio servicio);

    // Metodo para buscar todos los trámites
    List<Tramite> findAll();

    // Metodo para borrar trámite por id
    void deleteById(Long id);

    // Metodo para crear un nuevo trámite
    Tramite saveTramite(Tramite tramiteNuevo);

    // Metodo para buscar por fecha de creación del trámite
    List<Tramite> findByFechaCreacion(LocalDate fecha);

}
