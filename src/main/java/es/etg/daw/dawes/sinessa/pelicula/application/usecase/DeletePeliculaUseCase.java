package es.etg.daw.dawes.sinessa.pelicula.application.usecase;

import es.etg.daw.dawes.sinessa.pelicula.domain.repository.PeliculaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeletePeliculaUseCase {

    private final PeliculaRepository peliculaRepository;
    private final FindPeliculaByIdUseCase findPeliculaByIdUseCase;

    public void delete(int id) {
        findPeliculaByIdUseCase.findById(id);
        peliculaRepository.deleteById(id);
    }
}
