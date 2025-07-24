package pe.edu.utp.criollo_y_punto_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.utp.criollo_y_punto_api.model.Role;

/**
 * Repositorio para la entidad {@link Role}.
 *
 * Permite realizar operaciones CRUD, así como paginación y ordenamiento
 * sobre los roles de usuario registrados en la base de datos.
 *
 * {@code Integer} es el tipo del identificador primario de la entidad
 * {@code Role}.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
