package pe.edu.cibertec.T2_SW_AlexandraVilchez.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.T2_SW_AlexandraVilchez.Repository.ProgramaTvRepository;
import pe.edu.cibertec.T2_SW_AlexandraVilchez.model.bd.ProgramaTv;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProgramaTvService implements IProgramaTvService{
    private ProgramaTvRepository programaTvRepository;

    @Override
    public List<ProgramaTv> listarProgramaTv() {
        return programaTvRepository.findAll();
    }

    @Override
    public ProgramaTv guardarProgramaTv(ProgramaTv programaTv) {
        return programaTvRepository.save(programaTv);
    }

    @Override
    public Optional<ProgramaTv> obtenerProgramaTvxId(Integer id) {
        Optional<ProgramaTv> programaTv
                = programaTvRepository.findById(id);
        if(programaTv.isEmpty()){
            return Optional.empty();
        }
        return programaTv;
    }
}