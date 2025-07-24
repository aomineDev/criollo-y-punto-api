package pe.edu.utp.criollo_y_punto_api.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;
import lombok.*;

/**
 * Representa una factura emitida a un cliente jurídico en el sistema.
 * Hereda de la clase {@link Voucher}, lo que indica que es un tipo de
 * comprobante de pago.
 *
 * Está asociada a un cliente jurídico, cuya relación es opcional (puede ser
 * null si se elimina).
 *
 * Esta clase está mapeada a la tabla "invoices" en la base de datos y utiliza
 * anotaciones de JPA para definir relaciones y persistencia de datos.
 * También usa anotaciones de Lombok para generar automáticamente
 * constructores, getters y setters.
 * 
 */
@Entity
@Table(name = "invoices")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice extends Voucher {
    /**
     * Referencia al cliente jurídico que recibe la factura.
     * 
     * La relación es de muchos a uno, ya que un cliente puede tener muchas
     * facturas.
     * Si el cliente es eliminado, esta relación se establece como null en la base
     * de datos.
     */
    @ManyToOne
    @JoinColumn(name = "juridical_customer_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private JuridicalCustomer juridicalCustomer;
}
