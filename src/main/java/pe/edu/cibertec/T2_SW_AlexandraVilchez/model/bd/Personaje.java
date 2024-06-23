package pe.edu.cibertec.T2_SW_AlexandraVilchez.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "personaje")
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String NomPersonaje;
    private String ApePersonaje;
    private Date FechNacPersonaje;
}