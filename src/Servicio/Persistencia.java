package Servicio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Persistencia {
    private ObjectMapper mapper;

    public Persistencia() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule()); // soporte para LocalDateTime
    }

    // Guarda una lista en un archivo JSON
    public <T> void guardar(String ruta, List<T> lista) {
        try {
            mapper.writeValue(new File(ruta), lista);
        } catch (Exception e) {
            System.err.println("Error al guardar en " + ruta + ": " + e.getMessage());
        }
    }

    // Lee un archivo JSON y lo convierte en lista
    public <T> List<T> leer(String ruta, Class<T[]> clase) {
        try {
            T[] datos = mapper.readValue(new File(ruta), clase);
            return new ArrayList<>(Arrays.asList(datos));
        } catch (Exception e) {
            // Si el archivo no existe aún, retorna lista vacía
            return new ArrayList<>();
        }
    }
}
