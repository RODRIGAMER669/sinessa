package es.etg.daw.dawes.sinessa.pelicula.infraestructure.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import es.etg.daw.dawes.sinessa.pelicula.application.command.CreatePeliculaCommand;
import es.etg.daw.dawes.sinessa.pelicula.application.command.EditPeliculaCommand;
import es.etg.daw.dawes.sinessa.pelicula.domain.model.Pelicula;
import es.etg.daw.dawes.sinessa.pelicula.infraestructure.web.mvc.dto.PeliculaRequest;
import es.etg.daw.dawes.sinessa.pelicula.infraestructure.web.mvc.dto.PeliculaResponse;

@Mapper(componentModel = "spring")
public interface PeliculaMapper {

    CreatePeliculaCommand toCommand(PeliculaRequest request);

    PeliculaResponse toResponse(Pelicula pelicula);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "request.imagen", target = "imagen")
    @Mapping(source = "request.sinopsis", target = "sinopsis")
    @Mapping(source = "request.duracion", target = "duracion")
    EditPeliculaCommand toCommand(int id, PeliculaRequest request);
}