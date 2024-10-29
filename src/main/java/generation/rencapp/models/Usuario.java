package generation.rencapp.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Usuario {

    // columnas: roles_id int pk / nombre varchar 20 / n_documento varchar 20 / fecha_nacimiento date / numero_telefono int / correo varchar 25 not null / contrasenia varchar 20 not null

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("_id")
    private long id;

    private String nombre;

    /*private String apellido;

    @Column(nullable = false, unique = true)//Restricciones para la columna, no permitir null y sólo registros únicos
    private String email;

    @Column(nullable = false)
    private String password;*/

}
