package generation.rencapp.models;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "tramites")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tramite {

    /*solicitudes van dentro de los tramites
    -> Usuario conectado a Solicitud, solicitud conectado al Tramite
    -> Usar boolean para los requerimientos de cada Trámite:
       Agendamiento, pago asociado, cargo de archivos, términos y condiciones
    -> Debe estar asociado a la tabla de subida de Documentos*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("_id")
    private long id;

    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    private Boolean agendamiento;

    private Boolean pagoAsociado;

    private Boolean terminosYCondiciones;

    private Boolean cargaDeArchivo;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    /*@Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoTramite estado;

    public enum EstadoTramite {
        PENDIENTE,
        EVALUADO,
        PAGADO,
        FINALIZADO
    }*/


    /*// REVISAR SI FECHA Y HORA CORRESPONDE O ES NECESARIO CREAR RELACIÓN CON TABLA DE AGENDAMIENTO
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fecha;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime horaInicio;*/


    // RELACIONES FOREIGN KEY
    @JsonIgnore//Ignorar en la respuesta JSON este campo
    @ManyToOne//Many to one permite crear una relación de uno a muchos (1 a n)
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

    @JsonIgnore
    @OneToMany(mappedBy = "tramite", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Solicitud> solicitudes;



}
