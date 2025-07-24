package pe.edu.utp.criollo_y_punto_api.model;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.*;
import lombok.*;

/**
 * Clase abstracta que representa un comprobante de pago en el sistema,
 * como una factura o un ticket. Contiene la información común que comparten
 * todos los tipos de comprobantes.
 * 
 * Esta clase está mapeada a la tabla "vouchers" en la base de datos y se
 * utiliza
 * una estrategia de herencia JOINED para permitir que las subclases (como
 * Invoice o Ticket)
 * almacenen su información específica en tablas separadas.
 * 
 * Utiliza anotaciones de JPA para definir relaciones y restricciones, y
 * anotaciones de Lombok
 * para generar automáticamente constructores, getters y setters.
 */
@Entity
@Table(name = "vouchers")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Voucher {
    /**
     * Identificador único del comprobante.
     * Se genera automáticamente en la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voucher_id")
    protected Integer voucherId;

    /**
     * Fecha en que se emite el comprobante.
     * No puede ser nula.
     */
    @Column(name = "date", nullable = false)
    protected LocalDate date;

    /**
     * Hora exacta en la que se genera el comprobante.
     * No puede ser nula.
     */
    @Column(name = "time", nullable = false)
    protected LocalTime time;

    /**
     * Monto gravado (base imponible).
     * No puede ser nulo.
     */
    @Column(name = "taxed", nullable = false)
    protected Double taxed;

    /**
     * Precio total del comprobante, incluyendo impuestos y descuentos.
     * No puede ser nulo.
     */
    @Column(name = "total_price", nullable = false)
    protected Double totalPrice;

    /**
     * Descuento aplicado al total (si existe).
     * Puede ser nulo.
     */
    @Column(name = "discount")
    protected Double discount = null;

    /**
     * Pagos adicionales que se suman al total.
     * Puede ser nulo.
     */
    @Column(name = "additional_payments")
    protected Double additionalPayments;

    /**
     * Monto del IGV (Impuesto General a las Ventas).
     * No puede ser nulo.
     */
    @Column(name = "igv", nullable = false)
    protected Double igv;

    /**
     * Pedido asociado al comprobante.
     * Relación uno a uno con la entidad Order.
     */
    @OneToOne
    @JoinColumn(name = "order_id")
    protected Order order;
}