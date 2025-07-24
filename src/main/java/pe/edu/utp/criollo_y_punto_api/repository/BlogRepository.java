package pe.edu.utp.criollo_y_punto_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.utp.criollo_y_punto_api.model.Blog;

/**
 * Repositorio para la entidad {@link Blog}.
 *
 * Extiende JpaRepository para permitir operaciones CRUD, paginación y
 * ordenamiento sobre la clase Blog.
 *
 * {@code Integer} representa el tipo de dato del identificador primario de la
 * entidad
 * {@code Blog}.
 */
@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
