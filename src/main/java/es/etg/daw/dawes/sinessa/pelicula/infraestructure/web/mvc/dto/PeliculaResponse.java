package es.etg.daw.dawes.sinessa.pelicula.infraestructure.web.mvc.dto;

import java.time.LocalDateTime;

public record PeliculaResponse(int id, String titulo, String imagen, String detalles,
                               String sinopsis, String genero, int duracion,
                               String fechaEstreno, LocalDateTime fechaCreacion) {

}