package es.etg.daw.dawes.sinessa.pelicula.application.usecase;

import java.util.List;

import es.etg.daw.dawes.sinessa.pelicula.domain.model.Pelicula;
import es.etg.daw.dawes.sinessa.pelicula.domain.repository.PeliculaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FindPeliculaUseCase {

        public PeliculaRepository peliculaRepository;

        public List<Pelicula> findAll() {

                return peliculaRepository.getAll();

        }
}
