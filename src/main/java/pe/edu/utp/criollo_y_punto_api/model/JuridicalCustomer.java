package pe.edu.utp.criollo_y_punto_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "juridical_customers")
public class JuridicalCustomer extends Person {

    @Column(name = "ruc", length = 11, nullable = false, unique = true)
    private String ruc;

    @Column(name = "social_reasson", length = 100, nullable = false)
    private String socialReasson;

    @Column(name = "type")
    private String type;

    @Column(name = "activity_economic", length = 400)
    private String activityEconomic;

    @Column(name = "type_billing", nullable = false, length = 100)
    private String typeBilling;

}
