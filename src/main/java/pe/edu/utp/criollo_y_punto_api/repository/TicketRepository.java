package pe.edu.utp.criollo_y_punto_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.utp.criollo_y_punto_api.model.Ticket;

/**
 * Repositorio para la entidad {@link Ticket}.
 *
 * Permite realizar operaciones CRUD, paginación y ordenamiento sobre los
 * tickets,
 * los cuales representan comprobantes de pago emitidos a clientes naturales.
 *
 * {@code Integer} representa el tipo del identificador primario de la entidad
 * {@code Ticket}.
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
