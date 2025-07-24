package pe.edu.utp.criollo_y_punto_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.utp.criollo_y_punto_api.model.User;

/**
 * Repositorio para la entidad {@link Reserve}.
 *
 * Permite realizar operaciones CRUD, paginación y ordenamiento sobre las
 * reservas registradas en el sistema.
 * La entidad {@code Reserve} representa una reserva realizada por un cliente.
 *
 * {@code Integer} indica el tipo del identificador primario de la entidad
 * {@code Reserve}.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
