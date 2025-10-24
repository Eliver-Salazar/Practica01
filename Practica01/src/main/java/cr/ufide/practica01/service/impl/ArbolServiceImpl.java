package cr.ufide.practica01.service.impl;

import cr.ufide.practica01.domain.Arbol;
import cr.ufide.practica01.repository.ArbolRepository;
import cr.ufide.practica01.service.ArbolService;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ArbolServiceImpl implements ArbolService {

    private final ArbolRepository repo;

    public ArbolServiceImpl(ArbolRepository repo) {
        this.repo = repo;
    }

    public List<Arbol> listar(String q) {
        if (q == null || q.isBlank()) {
            return repo.findAll();
        }
        return repo.findByNombreComunContainingIgnoreCaseOrNombreCientificoContainingIgnoreCase(q, q);
    }

    public Optional<Arbol> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public Arbol guardar(Arbol a) {
        return repo.save(a);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
