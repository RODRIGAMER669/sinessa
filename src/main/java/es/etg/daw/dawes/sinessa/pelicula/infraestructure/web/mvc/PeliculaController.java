package es.etg.daw.dawes.sinessa.pelicula.infraestructure.web.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.etg.daw.dawes.sinessa.pelicula.application.command.CreatePeliculaCommand;
import es.etg.daw.dawes.sinessa.pelicula.application.command.service.CreatePeliculaService;
import es.etg.daw.dawes.sinessa.pelicula.domain.model.Pelicula;
import es.etg.daw.dawes.sinessa.pelicula.infraestructure.web.mapper.PeliculaMapper;
import es.etg.daw.dawes.sinessa.pelicula.infraestructure.web.mvc.dto.PeliculaRequest;
import es.etg.daw.dawes.sinessa.pelicula.infraestructure.web.mvc.dto.PeliculaResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/peliculas")
@RequiredArgsConstructor
public class PeliculaController {

    private final CreatePeliculaService createPeliculaService;

    @PostMapping
    public PeliculaResponse createPelicula(PeliculaRequest request) {
        CreatePeliculaCommand comando = PeliculaMapper.toCommand(request);
        Pelicula pelicula = createPeliculaService.createPelicula(comando);
         return PeliculaMapper.toResponse(pelicula);
    }

}