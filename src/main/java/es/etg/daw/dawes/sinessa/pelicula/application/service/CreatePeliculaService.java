package es.etg.daw.dawes.sinessa.pelicula.application.service;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.sinessa.pelicula.application.command.CreatePeliculaCommand;
import es.etg.daw.dawes.sinessa.pelicula.application.usecase.CreatePeliculaUseCase;
import es.etg.daw.dawes.sinessa.pelicula.domain.model.Pelicula;
import lombok.AllArgsConstructor;

@AllArgsConstructor 
@Service 
public class CreatePeliculaService {

    private final CreatePeliculaUseCase createPeliculaUseCase;

    public Pelicula createPelicula(CreatePeliculaCommand comando) {
        Pelicula pelicula = createPeliculaUseCase.create(comando);
        return pelicula;
    }
}
