package pe.edu.cibertec.T2_SW_AlexandraVilchez.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.T2_SW_AlexandraVilchez.exception.ResourceNotFoundException;
import pe.edu.cibertec.T2_SW_AlexandraVilchez.model.bd.Personaje;
import pe.edu.cibertec.T2_SW_AlexandraVilchez.service.PersonajeService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/personaje")
public class PersonajeController {
    private PersonajeService personajeService;

    @GetMapping("")
    public ResponseEntity<List<Personaje>> listarPersonaje(){
        List<Personaje> personajeList = new ArrayList<>(personajeService.listarPersonaje());
        if(personajeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(personajeList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personaje> obtenerPersonajeXId(
            @PathVariable Integer id){
        Personaje personaje = personajeService
                .obtenerPersonajexId(id).orElseThrow(
                        () -> new ResourceNotFoundException("El personaje con Id " +
                                id + " no existe"));
        return new ResponseEntity<>(personaje, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Personaje> registrarPersonaje(
            @RequestBody Personaje personaje
    ){
        return new ResponseEntity<>(
                personajeService.guardarPersonaje(personaje), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personaje> actualizarPersonaje(
            @PathVariable Integer id,
            @RequestBody Personaje personaje
    ){
        Personaje newPersonaje = personajeService.obtenerPersonajexId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El personaje con Id "
                        + id +" no existe"));
        newPersonaje.setNomPersonaje(personaje.getNomPersonaje());
        newPersonaje.setApePersonaje(personaje.getApePersonaje());
        newPersonaje.setFechNacPersonaje(personaje.getFechNacPersonaje());
        return new ResponseEntity<>(
                personajeService.guardarPersonaje(newPersonaje),
                HttpStatus.OK);
    }
}