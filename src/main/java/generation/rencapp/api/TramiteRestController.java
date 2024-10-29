package generation.rencapp.api;
import generation.rencapp.models.Servicio;
import generation.rencapp.models.Tramite;
import generation.rencapp.services.ServicioService;
import generation.rencapp.services.TramiteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tramites")
public class TramiteRestController {

    @Autowired
    private TramiteServiceImpl tramiteServiceImpl;

    @Autowired
    private ServicioService servicioService;

    /** OBTENER LISTA DE TODOS LOS TRAMITES CREADOS **/
    //Clase ResponseEntity<List<Tramite>> permite manipular el status de la respuesta
    @GetMapping("/lista")
    public ResponseEntity<List<Tramite>> findAllTramites() {
        List<Tramite> listaTramites = tramiteServiceImpl.findAll();
        //Retornamos una nueva instancia de ResponseEntity
        //return new ResponseEntity<>(tramiteService.findAll(), HttpStatus.OK)
        return new ResponseEntity<>(listaTramites, HttpStatus.OK);
    }

    /** OBTENER TRAMITE POR ID **/
    //Al no conocer el tipo de dato que se va a retornar podemos indicar que se retorna un responseEntity<?>
    //@PathVariable = localhost/api/horarios/5
    @GetMapping("/{id}")
    public ResponseEntity<?> findTramiteById(@PathVariable Long id) {
        return new ResponseEntity<>(tramiteServiceImpl.findById(id), HttpStatus.OK);
    }

    /** ELIMINAR TRAMITE POR ID **/
    //DELETE es el metodo HTTP que me permite eliminar registros
    //ID del trámite va a ser el atributo por el que voy a filtrar
    //Vamos a recibir un dato de tipo Long que es el ID a través de la ruta
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> deleteTrámiteById(@PathVariable Long id) {
        //LLamamos al metodo del service para borrar por ID
        tramiteServiceImpl.deleteById(id);
        //Retornamos un nuevo ResponseEntity indicando un mensaje en el cuerpo de la respuesta
        return new ResponseEntity<>("El trámite ha sido eliminado", HttpStatus.OK);
    }

    /** CREAR NUEVO TRAMITE PARA SERVICIO CON EL ID DE SERVICIO **/
    @PostMapping("/nuevo/{servicioId}")
    public ResponseEntity<?> saveTramiteNuevo(@RequestBody Tramite tramiteNuevo,
                                              @PathVariable Long servicioId) {
        //Buscamos el servicio por su id y lo guardamos en una variable
        Servicio servicioSeleccionado = servicioService.findById(servicioId);
        //Al trámite que se está enviando en la petición le seteamos el servicio con la variable creada
        tramiteNuevo.setServicio(servicioSeleccionado);
        //Finalmente, guardamos el trámite llamando al metodo en el service
        tramiteServiceImpl.saveTramite(tramiteNuevo);
        return new ResponseEntity<>("El trámite se ha creado exitosamente.", HttpStatus.CREATED);
    }



}
