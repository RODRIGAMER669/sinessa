package es.etg.daw.dawes.sinessa.pelicula.application.usecase;

import es.etg.daw.dawes.sinessa.pelicula.application.command.EditPeliculaCommand;
import es.etg.daw.dawes.sinessa.pelicula.domain.model.Pelicula;
import es.etg.daw.dawes.sinessa.pelicula.domain.repository.PeliculaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EditPeliculaUseCase {

    private final PeliculaRepository peliculaRepository;
    private final FindPeliculaByIdUseCase findPeliculaByIdUseCase;

    public Pelicula update(EditPeliculaCommand command) {
        Pelicula pelicula = findPeliculaByIdUseCase.findById(command.id());

        pelicula.setImagen(command.imagen());
        pelicula.setSinopsis(command.sinopsis());
        pelicula.setDuracion(command.duracion());

        return peliculaRepository.save(pelicula);
    }
}