package generation.rencapp.api;
import generation.rencapp.models.Solicitud;
import generation.rencapp.models.Tramite;
import generation.rencapp.services.SolicitudServiceImpl;
import generation.rencapp.services.TramiteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudRestController {

    @Autowired
    private SolicitudServiceImpl solicitudServiceImpl;

    @Autowired
    private TramiteServiceImpl tramiteServiceImpl;

    /** OBTENER LISTA DE TODOS LAS SOLICITUDES CREADAS **/
    //Clase ResponseEntity<List<Tramite>> permite manipular el status de la respuesta
    @GetMapping("/lista")
    public ResponseEntity<List<Solicitud>> findAllSolicitudes() {
        List<Solicitud> listaSolicitudes = solicitudServiceImpl.findAll();
        //Retornamos una nueva instancia de ResponseEntity
        //return new ResponseEntity<>(solicitudServiceImpl.findAll(), HttpStatus.OK)
        return new ResponseEntity<>(listaSolicitudes, HttpStatus.OK);
    }

    /** OBTENER SOLICITUDES POR ESTADO **/
    @GetMapping("/estado")
    public ResponseEntity<?> findSolicitudByEstado(@RequestParam String estado) {

        return new ResponseEntity<>(solicitudServiceImpl.findByEstado(estado), HttpStatus.OK);
    }
    //RequestParam = localhost/api/solicitudes?estado=PENDIENTE


    /** EDITAR ESTADO DE LA SOLICITUD POR ID **/
    //PUT es el metodo HTTP para trabajar con edición
    //ID de la solicitud va a ser la variable o criterio de búsqueda de la solicitud a editar
    //Va a recibir un objeto de tipo Solicitud con los campos editados
    @PutMapping("/editarSolicitud/{id}")
    public ResponseEntity<Solicitud> updateSolicitudById(@PathVariable Long id,
                                                     @RequestBody Solicitud solicitudEditada) {
        //Buscamos primero, la solicitud por ID
        Solicitud solicitudSeleccionada = solicitudServiceImpl.findById(id);
        //A la solicitudEditada que viene en el cuerpo de la petición, le seteamos el ID de nuestra solicitudSeleccionada
        solicitudEditada.setId(solicitudSeleccionada.getId());
        //Retornamos una nueva ResponseEntity pasando como argumento el metodo de guardar solicitud
        return new ResponseEntity<>(solicitudServiceImpl.saveSolicitud(solicitudEditada), HttpStatus.OK);
    }

    /** CREAR NUEVA SOLICITUD PARA TRÁMITE CON EL ID DE TRÁMITE **/
    @PostMapping("/nuevo/{tramiteId}")
    public ResponseEntity<?> saveSolicitudNueva(@RequestBody Solicitud solicitudNueva,
                                                @PathVariable Long tramiteId) {
        // Buscamos el trámite por su id y lo guardamos en una variable
        Tramite tramiteSeleccionado = tramiteServiceImpl.findById(tramiteId);
        // A la solicitud que se está enviando en la petición le seteamos el trámite con la variable creada
        solicitudNueva.setTramite(tramiteSeleccionado);
        // Finalmente, guardamos la solicitud llamando al metodo en el service
        solicitudServiceImpl.saveSolicitud(solicitudNueva);
        return new ResponseEntity<>("La solicitud se ha creado exitosamente", HttpStatus.CREATED);
    }


}
