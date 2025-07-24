package pe.edu.utp.criollo_y_punto_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.utp.criollo_y_punto_api.model.Invoice;

/**
 * Repositorio para la entidad {@link Invoice}.
 *
 * Proporciona operaciones CRUD, así como funcionalidades de paginación y
 * ordenamiento
 * sobre objetos de tipo {@code Invoice}.
 *
 * {@code Integer} representa el tipo de dato del identificador primario de la
 * entidad
 * {@code Invoice}.
 */
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
