package generation.rencapp.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


// Anotación @RestController le indica a Spring que esta clase es un controlador (es un componente de mi aplicación
@RestController
// Anotación @RequestMapping permite indicar las rutas hacia las que hay que realizar la petición
@RequestMapping("/")
public class AppRestController {

    // Con el RequestMapping puedo indicar el metodo de la petición, puedo indicar su será post, delete, get, etc.
    @RequestMapping(path = "/saludo",method = RequestMethod.GET)
    public String saludar(){
        return "Hola, bienvenido a Rencapp!";
    }

}
