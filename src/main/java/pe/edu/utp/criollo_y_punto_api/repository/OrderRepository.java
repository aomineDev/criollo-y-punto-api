package pe.edu.utp.criollo_y_punto_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.utp.criollo_y_punto_api.model.Order;

/**
 * Repositorio para la entidad {@link Order}.
 *
 * Permite realizar operaciones CRUD, ordenamiento y paginación sobre las
 * órdenes
 * registradas en la base de datos del sistema.
 *
 * {@code Integer} representa el tipo del identificador primario de la entidad
 * {@code Order}.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
