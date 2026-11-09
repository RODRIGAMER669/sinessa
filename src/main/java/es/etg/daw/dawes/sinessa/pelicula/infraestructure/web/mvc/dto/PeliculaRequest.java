package es.etg.daw.dawes.sinessa.pelicula.infraestructure.web.mvc.dto;

import java.time.LocalDateTime;

public record PeliculaRequest(String titulo, String imagen, String detalles,
                String sinopsis, String genero, int duracion,
                LocalDateTime fechaEstreno) {

}