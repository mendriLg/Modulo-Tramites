package generation.rencapp.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vecinos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Vecino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("_id")
    private long id;
}
