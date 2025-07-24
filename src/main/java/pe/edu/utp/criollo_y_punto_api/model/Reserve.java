package pe.edu.utp.criollo_y_punto_api.model;

import java.time.LocalDate;
import java.time.LocalTime;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;
import lombok.*;

/**
 * Representa una reserva realizada por un cliente en el sistema.
 * Contiene la fecha, hora, número de personas, la mesa reservada y el cliente
 * que hizo la reserva.
 * 
 * Está mapeada a la tabla "reserves" en la base de datos.
 * Utiliza anotaciones JPA para la persistencia y relaciones con otras
 * entidades.
 * También usa Lombok para generar constructores, getters y setters.
 */
@Entity
@Table(name = "reserves")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reserve {

    /**
     * Identificador único de la reserva.
     * Generado automáticamente por la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserve_id")
    private Integer reserveId;

    /**
     * Fecha programada para la reserva.
     * Este campo es obligatorio.
     */
    @Column(name = "date", nullable = false)
    private LocalDate date;

    /**
     * Hora programada para la reserva.
     * Este campo es obligatorio.
     */
    @Column(name = "time", nullable = false)
    private LocalTime time;

    /**
     * Cantidad de personas incluidas en la reserva.
     * Este campo es obligatorio.
     */
    @Column(name = "amount", nullable = false)
    private Integer amount;

    /**
     * Mesa asociada a la reserva.
     * Puede establecerse en null si la mesa es eliminada del sistema.
     */
    @ManyToOne
    @JoinColumn(name = "board_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Board board;

    /**
     * Cliente natural que realizó la reserva.
     * Puede establecerse en null si el cliente es eliminado del sistema.
     */
    @ManyToOne
    @JoinColumn(name = "natural_customer_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private NaturalCustomer naturalCustomer;
}
