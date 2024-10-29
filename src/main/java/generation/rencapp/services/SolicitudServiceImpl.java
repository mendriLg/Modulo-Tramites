package generation.rencapp.services;
import generation.rencapp.models.Servicio;
import generation.rencapp.models.Solicitud;
import generation.rencapp.models.Tramite;
import generation.rencapp.models.Vecino;
import generation.rencapp.repositories.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    // Metodo para buscar solicitudes por el estado
    @Override
    public List<Solicitud> findByEstado( String estado) {
        List <Solicitud.EstadoSolicitud> estados = List.of(Solicitud.EstadoSolicitud.values());
        for (int i = 0; i <= estados.size(); i++ ) {
            if (estados.get(i).toString().equals(estado)) {
                return solicitudRepository.findAllByEstado(estados.get(i));
            }
        }
            return null;
    }

    // Metodo para buscar solicitudes por id
    public Solicitud findById(Long id){
        return solicitudRepository.findById(id).get();
    }

    // Metodo para buscar todas las solicitudes
    @Override
    public List<Solicitud> findAll() {
        return solicitudRepository.findAll();
    }

    // Metodo para crear una nueva solicitud
    @Override
    public Solicitud saveSolicitud(Solicitud solicitudNueva) {
        return solicitudRepository.save(solicitudNueva);
    }

    // Metodo para buscar solicitud por el tramiteId
    @Override
    public List<Solicitud> findByTramiteId(Tramite tramite) {
        if (tramite != null) {
            return solicitudRepository.findByTramiteId(tramite.getId());
        }
        return new ArrayList<>(); // Retorna una lista vacía si el servicio es null
    }

    // Metodo para buscar por fecha de creación del trámite
    @Override
    public List<Solicitud> findByFechaCreacion(LocalDate fecha) {
        if (fecha != null) {
            return solicitudRepository.findByCreatedAt(fecha);
        }
        return new ArrayList<>(); // Retorna una lista vacía si el servicio es null
    }

    // Metodo para eliminar solicitud por id
    @Override
    public void deleteById(Long id) {
        solicitudRepository.deleteById(id);
    }

    @Override
    public List<Solicitud> findByVecinoId(Vecino vecino) {
        return List.of();
    }

    /*// Metodo para borrar solicitud por id
    @Override
    public void deleteById(Long id) {
        solicitudRepository.deleteById(id);
    }*/


}
