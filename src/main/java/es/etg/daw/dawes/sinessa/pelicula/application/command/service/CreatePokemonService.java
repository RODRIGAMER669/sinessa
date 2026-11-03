package es.etg.daw.dawes.sinessa.pelicula.application.command.service;

import es.etg.daw.dawes.sinessa.pelicula.application.command.CreatePeliculaCommand;
import es.etg.daw.dawes.sinessa.pelicula.application.command.usecase.CreatePeliculaUseCase;
import es.etg.daw.dawes.sinessa.pelicula.domain.model.Pelicula;

public class CreatePokemonService {

    private final CreatePeliculaUseCase createPeliculaUseCase;

    public Pelicula createPelicula(CreatePeliculaCommand comando) {
        Pelicula pelicula = createPeliculaUseCase.create(comando);
        return pelicula;
    }
}
