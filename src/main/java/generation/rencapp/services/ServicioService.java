package generation.rencapp.services;

import generation.rencapp.models.Servicio;
import generation.rencapp.models.Tramite;
import generation.rencapp.repositories.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    // Metodo para buscar servicios por id
    public Servicio findById(Long id){
        return servicioRepository.findById(id).get();
    }

}
