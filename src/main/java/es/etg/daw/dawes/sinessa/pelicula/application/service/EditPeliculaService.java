package es.etg.daw.dawes.sinessa.pelicula.application.service;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.sinessa.pelicula.application.command.EditPeliculaCommand;
import es.etg.daw.dawes.sinessa.pelicula.application.usecase.EditPeliculaUseCase;
import es.etg.daw.dawes.sinessa.pelicula.domain.model.Pelicula;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EditPeliculaService {

    private final EditPeliculaUseCase editPeliculaUseCase;

    public Pelicula update(EditPeliculaCommand command) {
        return editPeliculaUseCase.update(command);
    }
}