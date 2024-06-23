package pe.edu.cibertec.T2_SW_AlexandraVilchez.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.T2_SW_AlexandraVilchez.Repository.PersonajeRepository;
import pe.edu.cibertec.T2_SW_AlexandraVilchez.model.bd.Personaje;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PersonajeService implements IPersonajeService{
    private PersonajeRepository personajeRepository;

    @Override
    public List<Personaje> listarPersonaje() {
        return personajeRepository.findAll();
    }

    @Override
    public Personaje guardarPersonaje(Personaje personaje) {
        return personajeRepository.save(personaje);
    }

    @Override
    public Optional<Personaje> obtenerPersonajexId(Integer id) {
        Optional<Personaje> personaje
                = personajeRepository.findById(id);
        if(personaje.isEmpty()){
            return Optional.empty();
        }
        return personaje;
    }
}