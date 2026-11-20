package es.etg.daw.dawes.sinessa.pelicula.infraestructure.web.mvc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.HtmlUtils;

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
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/peliculas")
@RequiredArgsConstructor
public class PeliculaController {

    private final CreatePeliculaService createPeliculaService;
    private final FindPeliculaService findPeliculaService;
    private final DeletePeliculaService deletePeliculaService;
    private final EditPeliculaService editPeliculaService;
    private final PeliculaMapper peliculaMapper;

    @PostMapping
    @ResponseBody
    public String createPelicula(@Valid PeliculaRequest request) {
        CreatePeliculaCommand comando = peliculaMapper.toCommand(request);
        Pelicula pelicula = createPeliculaService.createPelicula(comando);
        return """
                <!DOCTYPE html>
                <html lang="es">
                  <head>
                    <meta charset="UTF-8">
                    <title>Película</title>
                  </head>
                  <body>
                    <h1>Película: %s - %s</h1>
                    <img src="%s" alt="Imagen de %s">
                    <p>Detalles: %s</p>
                    <p>Sinopsis: %s</p>
                    <p>Género: %s</p>
                    <p>Duración: %s minutos</p>
                    <p>Fecha de estreno: %s</p>
                    <p>Creada el: %s</p>
                  </body>
                </html>
                """.formatted(
                pelicula.getId(),
                pelicula.getTitulo(),
                pelicula.getImagen(),
                pelicula.getTitulo(),
                pelicula.getDetalles(),
                pelicula.getSinopsis(),
                pelicula.getGenero(),
                pelicula.getDuracion(),
                pelicula.getFechaEstreno(),
                pelicula.getFechaCreacion());
    }

    @GetMapping
    @ResponseBody
    public List<PeliculaResponse> allPeliculas() {
        return findPeliculaService.findAll()
                .stream()
                .map(peliculaMapper::toResponse)
                .toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePelicula(@PathVariable int id) {
        deletePeliculaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @ResponseBody
    @PutMapping("/{id}")
    public PeliculaResponse editPelicula(@PathVariable int id, @RequestBody PeliculaRequest peliculaRequest) {
        EditPeliculaCommand comando = peliculaMapper.toCommand(id, peliculaRequest);
        Pelicula pelicula = editPeliculaService.update(comando);
        return peliculaMapper.toResponse(pelicula);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public String handleValidationExceptions(MethodArgumentNotValidException ex) {

        StringBuilder html = new StringBuilder(256);
        html.append("<!DOCTYPE html>")
                .append("<html lang=\"es\"><head><meta charset=\"UTF-8\">")
                .append("<title>Errores de validación</title></head><body>")
                .append("<h1>Errores de validación</h1>")
                .append("<ul>");

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String field = (error instanceof FieldError fe) ? fe.getField() : error.getObjectName();
            String message = error.getDefaultMessage();

            html.append("<li><strong>")
                    .append(HtmlUtils.htmlEscape(field))
                    .append("</strong>: ")
                    .append(HtmlUtils.htmlEscape(message))
                    .append("</li>");
        });

        html.append("</ul></body></html>");
        return html.toString();
    }
}
