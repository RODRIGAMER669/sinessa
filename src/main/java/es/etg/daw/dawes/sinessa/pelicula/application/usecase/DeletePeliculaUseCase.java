package es.etg.daw.dawes.sinessa.pelicula.application.usecase;

import es.etg.daw.dawes.sinessa.pelicula.domain.repository.PeliculaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor 
public class DeletePeliculaUseCase {

    public PeliculaRepository peliculaRepository;

    public void delete(int id) {
        peliculaRepository.deleteById(id);
    }
}
