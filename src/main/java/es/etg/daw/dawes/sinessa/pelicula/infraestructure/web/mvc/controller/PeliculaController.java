package es.etg.daw.dawes.sinessa.pelicula.infraestructure.web.mvc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import es.etg.daw.dawes.sinessa.pelicula.application.command.CreatePeliculaCommand;
import es.etg.daw.dawes.sinessa.pelicula.application.command.EditPeliculaCommand;
import es.etg.daw.dawes.sinessa.pelicula.application.service.CreatePeliculaService;
import es.etg.daw.dawes.sinessa.pelicula.application.service.DeletePeliculaService;
import es.etg.daw.dawes.sinessa.pelicula.application.service.EditPeliculaService;
import es.etg.daw.dawes.sinessa.pelicula.application.service.FindPeliculaService;
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
    private final DeletePeliculaService deletePeliculaService;
    private final EditPeliculaService editPeliculaService;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePelicula(@PathVariable int id) {
        deletePeliculaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public PeliculaResponse editPelicula(@PathVariable int id, @RequestBody PeliculaRequest peliculaRequest) {
        EditPeliculaCommand comando = PeliculaMapper.toCommand(id, peliculaRequest);
        Pelicula pelicula = editPeliculaService.update(comando);
        return PeliculaMapper.toResponse(pelicula);
    }

}