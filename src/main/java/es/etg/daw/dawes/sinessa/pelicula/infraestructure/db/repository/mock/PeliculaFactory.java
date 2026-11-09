package es.etg.daw.dawes.sinessa.pelicula.infraestructure.db.repository.mock;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import es.etg.daw.dawes.sinessa.pelicula.domain.model.Pelicula;

public class PeliculaFactory {

    public static final Map<Integer, Pelicula> getDemoData() {
        Map<Integer, Pelicula> datos = new LinkedHashMap<>();

        datos.put(1, new Pelicula(1, "Pelicula1", "imagen1", "detalles1", "sinopsis1",
                "genero1", 90, LocalDate.of(1984, 7, 21), LocalDate.now()));
        datos.put(2, new Pelicula(2, "Pelicula2", "imagen2", "detalles2", "sinopsis2",
                "genero2", 100, LocalDate.of(1997, 10, 13), LocalDate.now()));
        datos.put(3, new Pelicula(3, "Pelicula3", "imagen3", "detalles3", "sinopsis3",
                "genero3", 110, LocalDate.of(2003, 12, 02), LocalDate.now()));

        return datos;
    }
}