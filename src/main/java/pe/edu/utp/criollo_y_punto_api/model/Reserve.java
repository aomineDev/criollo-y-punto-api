package pe.edu.utp.criollo_y_punto_api.model;

import java.time.LocalDate;
import java.time.LocalTime;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reserves")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserve_id")
    private Integer reserveId;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "time", nullable = false)
    private LocalTime time;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "board_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Board board;

    @ManyToOne
    @JoinColumn(name = "natural_customer_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private NaturalCustomer naturalCustomer;
}
