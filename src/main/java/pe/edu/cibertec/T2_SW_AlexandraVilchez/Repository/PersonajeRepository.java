package pe.edu.cibertec.T2_SW_AlexandraVilchez.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.T2_SW_AlexandraVilchez.model.bd.Personaje;

public interface PersonajeRepository extends JpaRepository<Personaje, Integer> {
}
