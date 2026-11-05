package es.etg.daw.dawes.sinessa.pelicula.application.usecase;

import java.time.LocalDateTime;

import es.etg.daw.dawes.sinessa.pelicula.application.command.EditPeliculaCommand;
import es.etg.daw.dawes.sinessa.pelicula.domain.model.Pelicula;

public class EditPeliculaUseCase {

    public Pelicula update(EditPeliculaCommand command) {
        return new Pelicula(command.id(), "Pelicula" + command.id(), command.imagen(),
                "detalles", command.sinopsis(), "genero", command.duracion(),
                "2026-12-01", LocalDateTime.now());
    }
}