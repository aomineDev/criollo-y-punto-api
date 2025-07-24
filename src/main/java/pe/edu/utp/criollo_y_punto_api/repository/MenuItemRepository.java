package pe.edu.utp.criollo_y_punto_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.utp.criollo_y_punto_api.model.MenuItem;

/**
 * Repositorio para la entidad {@link MenuItem}.
 *
 * Permite realizar operaciones CRUD, paginación y ordenamiento
 * sobre los objetos de tipo {@code MenuItem}.
 *
 * {@code Integer} representa el tipo del identificador primario de la entidad.
 * {@code MenuItem}.
 */
@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {

}
