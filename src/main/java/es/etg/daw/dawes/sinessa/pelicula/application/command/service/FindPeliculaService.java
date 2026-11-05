package es.etg.daw.dawes.sinessa.pelicula.application.command.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.sinessa.pelicula.application.command.usecase.FindPeliculaUseCase;
import es.etg.daw.dawes.sinessa.pelicula.domain.model.Pelicula;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Service 
public class FindPeliculaService {
    private final FindPeliculaUseCase findPeliculaUseCase;

    public List<Pelicula> findAll(){
        return findPeliculaUseCase.findAll();
    }
}
