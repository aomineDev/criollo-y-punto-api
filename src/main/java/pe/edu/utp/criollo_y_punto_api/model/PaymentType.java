package pe.edu.utp.criollo_y_punto_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payment_types")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_type_id")
    private Integer paymentTypeId;

    @Column(name = "name")
    private String name;

}
