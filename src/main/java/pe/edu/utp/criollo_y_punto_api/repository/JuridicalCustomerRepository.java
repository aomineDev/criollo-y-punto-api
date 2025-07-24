package pe.edu.utp.criollo_y_punto_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.utp.criollo_y_punto_api.model.JuridicalCustomer;

/**
 * Repositorio para la entidad {@link JuridicalCustomer}.
 *
 * Permite realizar operaciones CRUD, así como paginación y ordenamiento
 * sobre objetos de tipo {@code JuridicalCustomer}.
 *
 * {@code Integer} representa el tipo de dato del identificador primario de la
 * entidad.
 * {@code JuridicalCustomer}.
 */
@Repository
public interface JuridicalCustomerRepository extends JpaRepository<JuridicalCustomer, Integer> {

}
