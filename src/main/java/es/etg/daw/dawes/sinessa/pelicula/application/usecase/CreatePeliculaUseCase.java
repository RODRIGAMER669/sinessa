package es.etg.daw.dawes.sinessa.pelicula.application.usecase;

import java.time.LocalDateTime;

import es.etg.daw.dawes.sinessa.pelicula.application.command.CreatePeliculaCommand;
import es.etg.daw.dawes.sinessa.pelicula.domain.model.Pelicula;

public class CreatePeliculaUseCase {

    public Pelicula create(CreatePeliculaCommand comando){

        Pelicula pelicula = Pelicula.builder()
                                    .titulo(comando.titulo())
                                    .imagen(comando.imagen())
                                    .detalles(comando.detalles())
                                    .sinopsis(comando.sinopsis())
                                    .genero(comando.genero())
                                    .duracion(comando.duracion())
                                    .fechaEstreno(comando.fechaEstreno())
                                    .fechaCreacion(LocalDateTime.now()).build();
        return pelicula;
    }
}
