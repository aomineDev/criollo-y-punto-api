package pe.edu.utp.criollo_y_punto_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.utp.criollo_y_punto_api.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
