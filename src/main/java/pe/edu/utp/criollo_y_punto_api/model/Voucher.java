package pe.edu.utp.criollo_y_punto_api.model;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vouchers")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voucher_id")
    protected Integer voucherId;

    @Column(name = "date", nullable = false)
    protected LocalDate date;

    @Column(name = "time", nullable = false)
    protected LocalTime time;

    @Column(name = "taxed", nullable = false)
    protected Double taxed;

    @Column(name = "total_price", nullable = false)
    protected Double totalPrice;

    @Column(name = "discount")
    protected Double discount = null;

    @Column(name = "additional_payments")
    protected Double additionalPayments;

    @Column(name = "igv", nullable = false)
    protected Double igv;

    @OneToOne
    @JoinColumn(name = "order_id")
    protected Order order;

}
