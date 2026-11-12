package es.etg.daw.dawes.sinessa.pelicula.infraestructure.web.mvc.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record PeliculaRequest(
    
    @NotBlank 
    String titulo, String imagen, 
    
    @NotBlank
    String detalles,

    @NotBlank 
    String sinopsis, 
    
    @NotBlank 
    String genero, 
    
    @Positive 
    @NotBlank 
    int duracion, LocalDate fechaEstreno) {

}