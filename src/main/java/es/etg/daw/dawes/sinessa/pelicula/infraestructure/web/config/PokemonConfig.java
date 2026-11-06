package es.etg.daw.dawes.sinessa.pelicula.infraestructure.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.sinessa.pelicula.application.service.CreatePeliculaService;
import es.etg.daw.dawes.sinessa.pelicula.application.service.DeletePeliculaService;
import es.etg.daw.dawes.sinessa.pelicula.application.service.EditPeliculaService;
import es.etg.daw.dawes.sinessa.pelicula.application.service.FindPeliculaService;
import es.etg.daw.dawes.sinessa.pelicula.application.usecase.CreatePeliculaUseCase;
import es.etg.daw.dawes.sinessa.pelicula.application.usecase.DeletePeliculaUseCase;
import es.etg.daw.dawes.sinessa.pelicula.application.usecase.EditPeliculaUseCase;
import es.etg.daw.dawes.sinessa.pelicula.application.usecase.FindPeliculaUseCase;
import es.etg.daw.dawes.sinessa.pelicula.domain.repository.PeliculaRepository;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class PokemonConfig {

    private final PeliculaRepository peliculaRepository;

    @Bean
    public CreatePeliculaUseCase createPeliculaUseCase(){
        return new CreatePeliculaUseCase(peliculaRepository);
    }

    @Bean 
    public CreatePeliculaService createPeliculaService(){
        return new CreatePeliculaService(createPeliculaUseCase());
    }

    @Bean
    public FindPeliculaUseCase findPeliculaUseCase() {
        return new FindPeliculaUseCase();
    }

    @Bean
    public FindPeliculaService findPeliculaService() {
        return new FindPeliculaService(findPeliculaUseCase());
    }

    @Bean
    public DeletePeliculaUseCase deletePeliculaUseCase() {
        return new DeletePeliculaUseCase();
    }

    @Bean
    public DeletePeliculaService deletePeliculaService() {
        return new DeletePeliculaService(deletePeliculaUseCase());
    }

    @Bean
    public EditPeliculaUseCase editPeliculaUseCase() {
        return new EditPeliculaUseCase();
    }

    @Bean
    public EditPeliculaService editPeliculaService() {
        return new EditPeliculaService(editPeliculaUseCase());
    }

}