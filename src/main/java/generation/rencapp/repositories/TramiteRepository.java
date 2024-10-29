package generation.rencapp.repositories;
import generation.rencapp.models.Tramite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;


@Repository//Spring va a tomar esta interfaz como un componente que puedo luego inyectar en otras capas
public interface TramiteRepository extends JpaRepository<Tramite, Long> {

    //Los repositorios son interfaces porque sólo definen métodos
    /**La clase JpaRepository, contiene metodos para hacer el CRUD**/

    // Metodo para buscar trámite por id
    Tramite findById(long id);

    List<Tramite> findByNombre(String nombre);

    List<Tramite> findByServicioId(Long servicioId);

    List<Tramite> findByCreatedAt(LocalDate fecha);

}
