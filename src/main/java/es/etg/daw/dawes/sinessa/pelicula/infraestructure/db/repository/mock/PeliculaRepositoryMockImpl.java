package es.etg.daw.dawes.sinessa.pelicula.infraestructure.db.repository.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.sinessa.pelicula.domain.model.Pelicula;
import es.etg.daw.dawes.sinessa.pelicula.domain.repository.PeliculaRepository;

@Repository
public class PeliculaRepositoryMockImpl implements PeliculaRepository {

    private final Map<Integer, Pelicula> peliculas = PeliculaFactory.getDemoData();

    @Override
    public Pelicula save(Pelicula t) {
        if (t.getId() == 0)
            t.setId(obtenerSiguienteId());
        peliculas.put(t.getId(), t);

        return t;
    }

    private int obtenerSiguienteId() {
        int ultimo = 0;
        if (!peliculas.isEmpty()) {
            Collection<Pelicula> lista = peliculas.values();

            for (Pelicula p : lista) {
                ultimo = p.getId();
            }

        }
        return ultimo + 1;
    }

    @Override
    public List<Pelicula> getAll() {
        return new ArrayList<>(peliculas.values());
    }

    @Override
    public Optional<Pelicula> getById(Integer id) {
        return Optional.ofNullable(peliculas.get(id));
    }

    @Override
    public void deleteById(Integer id) {
        peliculas.remove(id);
    }

    @Override
    public Optional<Pelicula> getByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }

}