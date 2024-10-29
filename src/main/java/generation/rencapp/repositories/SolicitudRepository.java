package generation.rencapp.repositories;
import generation.rencapp.models.Solicitud;
import generation.rencapp.models.Tramite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository//Spring va a tomar esta interfaz como un componente que puedo luego inyectar en otras capas
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {

    //Los repositorios son interfaces porque sólo definen métodos
    /**La clase JpaRepository, contiene metodos para hacer el CRUD**/

    // Metodo para buscar solicitud por id
    Solicitud findById(long id);

    // Metodo para buscar solicitud por nombre
    List<Solicitud> findAllByEstado(Solicitud.EstadoSolicitud estado);

    // Metodo para buscar solicitud por tramiteId
    List<Solicitud> findByTramiteId(Long tramiteId);

    // Metodo para buscar solicitud por fechaCreación
    List<Solicitud> findByCreatedAt(LocalDate fecha);

}
