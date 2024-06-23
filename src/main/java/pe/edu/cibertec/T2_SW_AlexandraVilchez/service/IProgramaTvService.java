package pe.edu.cibertec.T2_SW_AlexandraVilchez.service;

import pe.edu.cibertec.T2_SW_AlexandraVilchez.model.bd.ProgramaTv;

import java.util.List;
import java.util.Optional;

public interface IProgramaTvService {
        List<ProgramaTv> listarProgramaTv();
        ProgramaTv guardarProgramaTv(ProgramaTv programaTv);
        Optional<ProgramaTv> obtenerProgramaTvxId(Integer id);
}