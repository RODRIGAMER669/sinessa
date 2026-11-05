package es.etg.daw.dawes.sinessa.pelicula.infraestructure.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.sinessa.pelicula.application.command.service.CreatePeliculaService;
import es.etg.daw.dawes.sinessa.pelicula.application.command.service.DeletePeliculaService;
import es.etg.daw.dawes.sinessa.pelicula.application.command.service.FindPeliculaService;
import es.etg.daw.dawes.sinessa.pelicula.application.command.usecase.CreatePeliculaUseCase;
import es.etg.daw.dawes.sinessa.pelicula.application.command.usecase.DeletePeliculaUseCase;
import es.etg.daw.dawes.sinessa.pelicula.application.command.usecase.FindPeliculaUseCase;
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

    @Bean 
    public FindPeliculaUseCase findPeliculaUseCase(){
        return new FindPeliculaUseCase();
    }

    @Bean 
    public FindPeliculaService findPeliculaService(){
        return new FindPeliculaService(findPeliculaUseCase());
    }

    @Bean 
    public DeletePeliculaUseCase deletePeliculaUseCase(){
        return new DeletePeliculaUseCase();
    }

    @Bean 
    public DeletePeliculaService deletePeliculaService(){
        return new DeletePeliculaService(deletePeliculaUseCase());
    }

    
}