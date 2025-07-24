package pe.edu.utp.criollo_y_punto_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.utp.criollo_y_punto_api.model.Board;

/**
 * Repositorio para la entidad {@link Board}.
 *
 * Proporciona operaciones CRUD, así como funcionalidades de paginación y
 * ordenamiento
 * sobre objetos de tipo {@code Board}.
 *
 * {@code Integer} representa el tipo de dato del identificador primario de la
 * entidad
 * {@code Board}.
 */
@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

}
