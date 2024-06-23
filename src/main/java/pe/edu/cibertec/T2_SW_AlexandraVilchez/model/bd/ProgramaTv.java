package pe.edu.cibertec.T2_SW_AlexandraVilchez.model.bd;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "programatv")
public class ProgramaTv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Titulo;
    private String Resumen;
    private Date FechaInicio;
}