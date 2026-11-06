package es.etg.daw.dawes.sinessa.pelicula.application.usecase;

import java.time.LocalDateTime;

import es.etg.daw.dawes.sinessa.pelicula.application.command.EditPeliculaCommand;
import es.etg.daw.dawes.sinessa.pelicula.domain.model.Pelicula;
import es.etg.daw.dawes.sinessa.pelicula.domain.repository.PeliculaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor 
public class EditPeliculaUseCase {

    public PeliculaRepository peliculaRepository;

    public Pelicula update(EditPeliculaCommand command) {
        
        return new Pelicula(command.id(), "Pelicula" + command.id(), command.imagen(),
                "detalles", command.sinopsis(), "genero", command.duracion(),
                LocalDateTime.of(1999, 9, 29, 23, 59), LocalDateTime.now());
    }
}