package pe.edu.cibertec.T2_SW_AlexandraVilchez.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.cibertec.T2_SW_AlexandraVilchez.service.IFileService;

import java.util.Arrays;

@Controller
public class FileController {
    private final IFileService fileService;

    @Autowired
    public FileController(IFileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/files")
    public ResponseEntity<String> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        try {
            fileService.guardarArchivos(Arrays.asList(files));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return ResponseEntity.ok("Archivos subidos con éxito");
    }

    @PostMapping("/file")
    public ResponseEntity<String> uploadSingleFile(@RequestParam("file") MultipartFile file) {
        try {
            fileService.guardarArchivo(file);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return ResponseEntity.ok("Archivo subido con éxito");
    }
}