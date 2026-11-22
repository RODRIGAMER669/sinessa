package es.etg.daw.dawes.sinessa.pelicula.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class EditPeliculaCommand {

    private int id;
    private String imagen;
    private String sinopsis;
    private int duracion;
}