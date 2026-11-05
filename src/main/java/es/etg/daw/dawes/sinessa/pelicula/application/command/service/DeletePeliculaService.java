package es.etg.daw.dawes.sinessa.pelicula.application.command.service;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.sinessa.pelicula.application.command.usecase.DeletePeliculaUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeletePeliculaService {

    private final DeletePeliculaUseCase deletePeliculaUseCase;

    public void delete(int id) {
        deletePeliculaUseCase.delete(id);
    }
}
