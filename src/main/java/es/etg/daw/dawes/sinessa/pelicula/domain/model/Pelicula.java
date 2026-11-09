package es.etg.daw.dawes.sinessa.pelicula.domain.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Pelicula {

    private int id;
    private String titulo;
    private String imagen;
    private String detalles;
    private String sinopsis;
    private String genero;
    private int duracion;
    private LocalDate fechaEstreno;
    private LocalDate fechaCreacion;

}
