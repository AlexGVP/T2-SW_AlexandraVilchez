package pe.edu.cibertec.T2_SW_AlexandraVilchez.service;

import pe.edu.cibertec.T2_SW_AlexandraVilchez.model.bd.Personaje;

import java.util.List;
import java.util.Optional;

public interface IPersonajeService {
    List<Personaje> listarPersonaje();
    Personaje guardarPersonaje(Personaje personaje);
    Optional<Personaje> obtenerPersonajexId(Integer id);
}
