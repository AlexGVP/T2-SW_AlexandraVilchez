package pe.edu.cibertec.T2_SW_AlexandraVilchez.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@Service
public class FileService implements IFileService {

    private static final List<String> ALLOWED_EXTENSIONS = Arrays.asList("pdf", "png", "docx");

    @Override
    public void guardarArchivo(MultipartFile archivo) throws Exception {
        if (archivo.getSize() > 25 * 1024 * 1024) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El archivo excede el tamaño máximo permitido de 25MB");
        }
    }

    @Override
    public void guardarArchivos(List<MultipartFile> archivosList) throws Exception {
        if (archivosList.size() != 3) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Debe subir exactamente 3 archivos");
        }

        for (MultipartFile archivo : archivosList) {
            String extension = StringUtils.getFilenameExtension(archivo.getOriginalFilename()).toLowerCase();
            if (!ALLOWED_EXTENSIONS.contains(extension)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Archivo con extensión no permitida: " + extension);
            }
        }
    }
}