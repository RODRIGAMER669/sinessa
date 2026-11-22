package es.etg.daw.dawes.sinessa.pelicula.application.usecase;

import java.util.Optional;

import es.etg.daw.dawes.sinessa.pelicula.domain.model.Pelicula;
import es.etg.daw.dawes.sinessa.pelicula.domain.repository.PeliculaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FindPeliculaByIdUseCase {

    public final PeliculaRepository peliculaRepository;

    public Pelicula findById(int id) {
        Optional<Pelicula> opt = peliculaRepository.getById(id);

        return opt.get();
    }
}
