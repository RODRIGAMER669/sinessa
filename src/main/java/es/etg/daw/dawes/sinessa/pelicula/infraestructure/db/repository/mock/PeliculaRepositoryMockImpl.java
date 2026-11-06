package es.etg.daw.dawes.sinessa.pelicula.infraestructure.db.repository.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import es.etg.daw.dawes.sinessa.pelicula.domain.model.Pelicula;
import es.etg.daw.dawes.sinessa.pelicula.domain.repository.PeliculaRepository;

public class PeliculaRepositoryMockImpl implements PeliculaRepository{

    private final Map<Integer, Pelicula> pokemons = PeliculaFactory.getDemoData();

    @Override
    public Pelicula save(Pelicula t) {
        if(t.getId()==0)
            t.setId(obtenerSiguienteId());
        pokemons.put(t.getId(), t);

        return t;
    }

    private int obtenerSiguienteId(){
        int ultimo = 0;
        if(!pokemons.isEmpty()){
            Collection<Pelicula> lista = pokemons.values();
            
            for (Pelicula p : lista) {
                ultimo = p.getId();
            }

        }
        return ultimo+1;
    }

    @Override
    public List<Pelicula> getAll() {
        return new ArrayList<>(pokemons.values());
    }

    @Override
    public Optional<Pelicula> getById(Integer id) {
        return Optional.ofNullable(pokemons.get(id));
    }

    @Override
    public void deleteById(Integer id) {
        pokemons.remove(id);
    }

    @Override
    public Optional<Pelicula> getByName(String name) {
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }
    
}