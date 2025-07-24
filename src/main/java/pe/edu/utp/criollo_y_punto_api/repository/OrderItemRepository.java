package pe.edu.utp.criollo_y_punto_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.utp.criollo_y_punto_api.model.OrderItem;

/**
 * Repositorio para la entidad {@link OrderItem}.
 *
 * Permite realizar operaciones CRUD, ordenamiento y paginación sobre los ítems
 * de pedidos
 * registrados en la base de datos.
 *
 * {@code Integer} representa el tipo del identificador primario de la entidad
 * {@code Order}.
 */
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}
