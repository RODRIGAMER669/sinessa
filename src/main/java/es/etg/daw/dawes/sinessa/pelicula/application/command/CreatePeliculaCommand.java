package es.etg.daw.dawes.sinessa.pelicula.application.command;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class CreatePeliculaCommand {

    private String titulo;
    private String imagen;
    private String detalles;
    private String sinopsis;
    private String genero;
    private int duracion;
    private LocalDate fechaEstreno;
}
