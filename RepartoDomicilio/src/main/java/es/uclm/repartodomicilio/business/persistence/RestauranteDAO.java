package es.uclm.repartodomicilio.business.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import es.uclm.repartodomicilio.business.entity.Restaurante;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestauranteDAO extends JpaRepository<Restaurante, Long> {
    boolean existsBycif(String cif); // Para verificar si existe CIF
    Optional<Restaurante> findBycif(String cif);
    List<Restaurante> findAllByNombre(String nombre);

    // Nueva consulta para búsqueda flexible por nombre o dirección
    @Query("SELECT r FROM Restaurante r WHERE " +
            "LOWER(r.nombre) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
            "OR LOWER(r.direccion) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<Restaurante> findBySearchTerm(String searchTerm);
}
