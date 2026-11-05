package es.etg.daw.dawes.sinessa.pelicula.infraestructure.web.mapper;

import es.etg.daw.dawes.sinessa.pelicula.application.command.CreatePeliculaCommand;
import es.etg.daw.dawes.sinessa.pelicula.application.command.EditPeliculaCommand;
import es.etg.daw.dawes.sinessa.pelicula.domain.model.Pelicula;
import es.etg.daw.dawes.sinessa.pelicula.infraestructure.web.mvc.dto.PeliculaRequest;
import es.etg.daw.dawes.sinessa.pelicula.infraestructure.web.mvc.dto.PeliculaResponse;

public class PeliculaMapper {

    public static CreatePeliculaCommand toCommand(PeliculaRequest request) {
        return new CreatePeliculaCommand(request.titulo(), request.imagen(),
                request.detalles(), request.sinopsis(),
                request.genero(), request.duracion(),
                request.fechaEstreno());
    }

    public static PeliculaResponse toResponse(Pelicula pelicula) {
        return new PeliculaResponse(pelicula.getId(), pelicula.getTitulo(),
                pelicula.getImagen(), pelicula.getDetalles(),
                pelicula.getSinopsis(), pelicula.getGenero(),
                pelicula.getDuracion(), pelicula.getFechaEstreno(),
                pelicula.getFechaCreacion());
    }

    public static EditPeliculaCommand toCommand(int id, PeliculaRequest request) {
        return new EditPeliculaCommand(id, request.imagen(), request.sinopsis(), request.duracion());
    }
}