package cr.ufide.practica01.repository;

import cr.ufide.practica01.domain.Arbol;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ArbolRepository extends JpaRepository<Arbol, Long> {

    List<Arbol> findByNombreComunContainingIgnoreCaseOrNombreCientificoContainingIgnoreCase(String nc, String nci);
}
