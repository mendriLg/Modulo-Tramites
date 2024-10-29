package generation.rencapp.services;
import generation.rencapp.models.Servicio;
import generation.rencapp.models.Tramite;
import generation.rencapp.repositories.TramiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TramiteServiceImpl implements TramiteService {

    @Autowired
    private TramiteRepository tramiteRepository;

    // Metodo para buscar trámites por id
    public Tramite findById(Long id){
        return tramiteRepository.findById(id).get();
    }

    // Metodo para buscar todos los trámites
    @Override
    public List<Tramite> findAll() {
        return tramiteRepository.findAll();
    }

    // Metodo para crear un nuevo trámite
    @Override
    public Tramite saveTramite(Tramite tramiteNuevo) {
        return tramiteRepository.save(tramiteNuevo);
    }

    // Metodo para borrar trámite por id
    @Override
    public void deleteById(Long id) {
        tramiteRepository.deleteById(id);
    }

    // Metodo para buscar trámite por el servicioId
    @Override
    public List<Tramite> findByServicioId(Servicio servicio) {
        if (servicio != null) {
            return tramiteRepository.findByServicioId(servicio.getId());
        }
        return new ArrayList<>(); // Retorna una lista vacía si el servicio es null
    }

    // Metodo para buscar por fecha de creación del trámite
    @Override
    public List<Tramite> findByFechaCreacion(LocalDate fecha) {
        if (fecha != null) {
            return tramiteRepository.findByCreatedAt(fecha);
        }
        return new ArrayList<>(); // Retorna una lista vacía si el servicio es null
    }

    // Metodo para buscar trámites por el id de servicio
    /*public Tramite findByServicioId(Long servicioId) {
        return tramiteRepository.findByServicioId();
    }*/




}
