package es.etg.daw.dawes.sinessa.pelicula.infraestructure.web.mvc.dto;

public record PeliculaRequest(String titulo, String imagen, String detalles,
                              String sinopsis, String genero, int duracion,
                              String fechaEstreno) {

}