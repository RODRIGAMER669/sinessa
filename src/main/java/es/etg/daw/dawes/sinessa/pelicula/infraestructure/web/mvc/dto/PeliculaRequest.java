package es.etg.daw.dawes.sinessa.pelicula.infraestructure.web.mvc.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull (message = "{pelicula.valid.duracion.no_vacio}")
    int duracion, 
    
    @NotNull(message = "{pelicula.valid.fecha.no_vacia")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    LocalDate fechaEstreno) {

}