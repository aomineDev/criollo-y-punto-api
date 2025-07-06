package pe.edu.utp.criollo_y_punto_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.utp.criollo_y_punto_api.model.JuridicalCustomer;

@Repository
public interface JuridicalCustomerRepository extends JpaRepository<JuridicalCustomer, Integer> {

}
