package es.etg.daw.dawes.sinessa.pelicula.infraestructure.web.mvc.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record PeliculaRequest(
    
    @NotBlank (message = "{pelicula.valid.titulo.no_vacio}")
    String titulo, String imagen, 
    
    @NotBlank (message = "{pelicula.valid.detalles.no_vacio}")
    String detalles,

    @NotBlank (message = "{pelicula.valid.sinopsis.no_vacio}")
    String sinopsis, 
    
    @NotBlank (message = "{pelicula.valid.genero.no_vacio}")
    String genero, 
    
    @Positive (message = "{pelicula.valid.duracion.positiva}")
    @NotBlank (message = "{pelicula.valid.duracion.no_vacio}")
    int duracion, LocalDate fechaEstreno) {

}