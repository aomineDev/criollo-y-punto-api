package pe.edu.utp.criollo_y_punto_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.utp.criollo_y_punto_api.model.Reserve;

/**
 * Repositorio para la entidad {@link User}.
 *
 * Permite realizar operaciones CRUD, paginación y ordenamiento sobre los
 * usuarios del sistema.
 * La entidad {@code User} representa a los usuarios con credenciales de acceso
 * y roles asignados.
 *
 * {@code Integer} es el tipo del identificador primario de la entidad
 * {@code User}.
 */
@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Integer> {

}