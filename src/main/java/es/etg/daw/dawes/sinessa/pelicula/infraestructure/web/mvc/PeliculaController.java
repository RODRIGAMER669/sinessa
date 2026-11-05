package es.etg.daw.dawes.sinessa.pelicula.infraestructure.web.mvc;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import es.etg.daw.dawes.sinessa.pelicula.application.command.CreatePeliculaCommand;
import es.etg.daw.dawes.sinessa.pelicula.application.command.service.CreatePeliculaService;
import es.etg.daw.dawes.sinessa.pelicula.application.command.service.FindPeliculaService;
import es.etg.daw.dawes.sinessa.pelicula.domain.model.Pelicula;
import es.etg.daw.dawes.sinessa.pelicula.infraestructure.web.mapper.PeliculaMapper;
import es.etg.daw.dawes.sinessa.pelicula.infraestructure.web.mvc.dto.PeliculaRequest;
import es.etg.daw.dawes.sinessa.pelicula.infraestructure.web.mvc.dto.PeliculaResponse;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/peliculas")
@RequiredArgsConstructor
public class PeliculaController {

    private final CreatePeliculaService createPeliculaService;
    private final FindPeliculaService findPeliculaService;

    @ResponseBody 
    @PostMapping
    public PeliculaResponse createPelicula(PeliculaRequest request) {
        CreatePeliculaCommand comando = PeliculaMapper.toCommand(request);
        Pelicula pelicula = createPeliculaService.createPelicula(comando);
         return PeliculaMapper.toResponse(pelicula);
    }

    @GetMapping
    @ResponseBody
    public List<PeliculaResponse> allPeliculas() {
        return findPeliculaService.findAll()
                .stream()
                .map(PeliculaMapper::toResponse)
                .toList();
    }

}