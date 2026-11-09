package es.etg.daw.dawes.sinessa.pelicula.domain.repository;

import java.util.Optional;

import es.etg.daw.dawes.sinessa.pelicula.domain.model.Pelicula;

public interface PeliculaRepository extends CRUDRepository<Pelicula, Integer> {
    public Optional<Pelicula> getByName(String name);
}