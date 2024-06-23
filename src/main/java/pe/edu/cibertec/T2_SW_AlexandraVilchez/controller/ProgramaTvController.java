package pe.edu.cibertec.T2_SW_AlexandraVilchez.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.T2_SW_AlexandraVilchez.exception.ResourceNotFoundException;
import pe.edu.cibertec.T2_SW_AlexandraVilchez.model.bd.ProgramaTv;
import pe.edu.cibertec.T2_SW_AlexandraVilchez.service.ProgramaTvService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/programatv")
public class ProgramaTvController {
    private ProgramaTvService programaTvService;

    @GetMapping("")
    public ResponseEntity<List<ProgramaTv>> listarProgramaTv(){
        List<ProgramaTv> programaTvList = new ArrayList<>(programaTvService.listarProgramaTv());
        if(programaTvList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(programaTvList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramaTv> obtenerProgramaTvXId(
            @PathVariable Integer id){
        ProgramaTv programaTv = programaTvService
                .obtenerProgramaTvxId(id).orElseThrow(
                        () -> new ResourceNotFoundException("El programa con Id " +
                                id + " no existe"));
        return new ResponseEntity<>(programaTv, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ProgramaTv> registrarProgramaTv(
            @RequestBody ProgramaTv programaTv
    ){
        return new ResponseEntity<>(
                programaTvService.guardarProgramaTv(programaTv), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramaTv> actualizarProgramaTv(
            @PathVariable Integer id,
            @RequestBody ProgramaTv programaTv
    ){
        ProgramaTv newProgramaTv = programaTvService.obtenerProgramaTvxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El programa con Id "
                        + id +" no existe"));
        newProgramaTv.setTitulo(programaTv.getTitulo());
        newProgramaTv.setResumen(programaTv.getResumen());
        newProgramaTv.setFechaInicio(programaTv.getFechaInicio());
        return new ResponseEntity<>(
                programaTvService.guardarProgramaTv(newProgramaTv),
                HttpStatus.OK);
    }
}