package es.etg.daw.dawes.sinessa.pelicula.infraestructure.web.mvc.dto;

import java.time.LocalDate;

public record PeliculaResponse(int id, String titulo, String imagen, String detalles,
                String sinopsis, String genero, int duracion,
                LocalDate fechaEstreno, LocalDate fechaCreacion) {

}