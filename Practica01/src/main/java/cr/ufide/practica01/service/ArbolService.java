package cr.ufide.practica01.service;

import cr.ufide.practica01.domain.Arbol;
import java.util.*;

public interface ArbolService {

    List<Arbol> listar(String q);

    Optional<Arbol> buscarPorId(Long id);

    Arbol guardar(Arbol a);

    void eliminar(Long id);
}
