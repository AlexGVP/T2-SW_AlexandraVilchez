package pe.edu.cibertec.T2_SW_AlexandraVilchez.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Personaje")
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPersonaje")
    private Integer idPersonaje;

    @Column(name = "NomPersonaje", nullable = false)
    private String nomPersonaje;

    @Column(name = "ApePersonaje", nullable = false)
    private String apePersonaje;

    @Column(name = "FechNacPersonaje", nullable = false)
    private Date fechNacPersonaje;

    public Personaje(String nomPersonaje, String apePersonaje, Date fechNacPersonaje) {
        this.nomPersonaje = nomPersonaje;
        this.apePersonaje = apePersonaje;
        this.fechNacPersonaje = fechNacPersonaje;
    }
}