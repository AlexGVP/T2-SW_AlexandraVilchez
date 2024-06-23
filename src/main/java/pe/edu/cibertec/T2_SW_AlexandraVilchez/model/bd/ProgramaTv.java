package pe.edu.cibertec.T2_SW_AlexandraVilchez.model.bd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@Table(name = "ProgramaTv")
public class ProgramaTv{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProgramaTv")
    private Integer idProgramaTv;

    @Column(name = "Titulo", nullable = false)
    private String titulo;

    @Column(name = "Resumen", nullable = false)
    private String resumen;

    @Column(name = "FechaInicio", nullable = false)
    private Date fechaInicio;

    @ManyToOne
    @JoinColumn(name = "IdPersonaje", nullable = false)
    private Personaje personaje;

    public ProgramaTv(String titulo, String resumen, Date fechaInicio, Personaje personaje) {
        this.titulo = titulo;
        this.resumen = resumen;
        this.fechaInicio = fechaInicio;
        this.personaje = personaje;
    }
}