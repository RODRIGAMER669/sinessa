package es.etg.daw.dawes.sinessa.pelicula.infraestructure.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.sinessa.pelicula.application.command.service.CreatePeliculaService;
import es.etg.daw.dawes.sinessa.pelicula.application.command.usecase.CreatePeliculaUseCase;
import lombok.RequiredArgsConstructor;

@Configuration 
@RequiredArgsConstructor 
public class PokemonConfig {

    @Bean 
    public CreatePeliculaUseCase createPeliculaUseCase(){
        return new CreatePeliculaUseCase();
    }

    @Bean 
    public CreatePeliculaService createPeliculaService(){
        return new CreatePeliculaService(createPeliculaUseCase());
    }
    
}