package pe.edu.utp.criollo_y_punto_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.utp.criollo_y_punto_api.model.NaturalCustomer;

/**
 * Repositorio para la entidad {@link NaturalCustomer}.
 *
 * Proporciona métodos para realizar operaciones CRUD, paginación y ordenamiento
 * sobre los registros de clientes naturales en la base de datos.
 *
 * {@code Integer} representa el tipo del identificador primario de la entidad.
 * {@code NaturalCustomer}.
 */
@Repository
public interface NaturalCustomerRepository extends JpaRepository<NaturalCustomer, Integer> {

}
