package es.etg.daw.dawes.sinessa.pelicula.application.usecase;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import es.etg.daw.dawes.sinessa.pelicula.domain.model.Pelicula;

public class FindPeliculaUseCase {
    public List<Pelicula> findAll(){
        List<Pelicula> lista = new ArrayList<>();
        lista.add(new Pelicula(1, "Pelicula1", "imagen1", "detalles1", "sinopsis1",
                "genero1", 90, "2026-12-01", LocalDateTime.now()));
        lista.add(new Pelicula(2, "Pelicula2", "imagen2", "detalles2", "sinopsis2",
                "genero2", 100, "2026-12-02", LocalDateTime.now()));
        lista.add(new Pelicula(3, "Pelicula3", "imagen3", "detalles3", "sinopsis3",
                "genero3", 110, "2026-12-03", LocalDateTime.now()));
        return lista;
    }
}
