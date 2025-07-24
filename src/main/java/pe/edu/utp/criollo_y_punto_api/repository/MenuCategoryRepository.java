package pe.edu.utp.criollo_y_punto_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.utp.criollo_y_punto_api.model.MenuCategory;

/**
 * Repositorio para la entidad {@link MenuCategory}.
 *
 * Proporciona operaciones CRUD, paginación y ordenamiento
 * sobre objetos de tipo {@code MenuCategory}.
 *
 * {@code Integer} representa el tipo del identificador primario de la entidad
 * {@code MenuCategory}.
 */
@Repository
public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Integer> {

}
