package es.etg.daw.dawes.sinessa.pelicula.application.usecase;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import es.etg.daw.dawes.sinessa.pelicula.domain.model.Pelicula;

public class FindPeliculaUseCase {
        public List<Pelicula> findAll() {
                List<Pelicula> lista = new ArrayList<>();
                lista.add(new Pelicula(1, "Pelicula1", "imagen1", "detalles1", "sinopsis1",
                                "genero1", 90, LocalDateTime.of(1984, 7, 21, 7, 53), LocalDateTime.now()));
                lista.add(new Pelicula(2, "Pelicula2", "imagen2", "detalles2", "sinopsis2",
                                "genero2", 100, LocalDateTime.of(1997, 10, 13, 16, 22), LocalDateTime.now()));
                lista.add(new Pelicula(3, "Pelicula3", "imagen3", "detalles3", "sinopsis3",
                                "genero3", 110, LocalDateTime.of(2003, 12, 02, 21, 02), LocalDateTime.now()));
                return lista;
        }
}
