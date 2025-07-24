package pe.edu.utp.criollo_y_punto_api.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;
import lombok.*;

/**
 * Representa un ticket generado en el sistema como comprobante de venta.
 * Esta clase hereda de {@link Voucher}, por lo que contiene los campos comunes
 * de un comprobante.
 *
 * Está asociada a un cliente natural mediante una relación ManyToOne.
 * Si el cliente se elimina, la relación se establece como NULL.
 *
 * Esta clase está mapeada a la tabla "tickets" en la base de datos.
 * 
 * Utiliza anotaciones de JPA para el mapeo y de Lombok para la generación
 * automática
 * de getters, setters y constructores.
 */
@Entity
@Table(name = "tickets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket extends Voucher {
    /**
     * Cliente natural asociado al ticket.
     * Puede ser nulo si el cliente es eliminado del sistema.
     */
    @ManyToOne
    @JoinColumn(name = "natural_customer_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private NaturalCustomer naturalCustomer;
}