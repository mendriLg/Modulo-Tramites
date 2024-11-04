package generation.rencapp.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_usuario", discriminatorType = DiscriminatorType.STRING)
public class Usuario {

    // columnas: roles_id int pk / nombre varchar 20 / n_documento varchar 20 / fecha_nacimiento date / numero_telefono int / correo varchar 25 not null / contrasenia varchar 20 not null

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("_id")
    private long id;

    private String nombre;

    private String apellido;


    @Column(nullable = false, unique = true)//Restricciones para la columna, no permitir null y sólo registros únicos
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)//Anotación para indicar que el valor del atributo va a tomarse de una enumeración
    @Column(nullable = false)
    private TipoUsuario tipo;

    //Atributos de auditoría, me permiten conocer la fecha de creación y de la última edición
    @CreationTimestamp//Anotación para generar el almacenamiento de la fecha de creación
    private LocalDateTime createdAt;

    @UpdateTimestamp//Anotación para generar el almacenamiento de la fecha de actualización
    private LocalDateTime updatedAt;

}

