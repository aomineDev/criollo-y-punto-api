package pe.edu.utp.criollo_y_punto_api.model;

import java.time.LocalDate;
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

@Table(name = "natural_customers")
public class NaturalCustomer extends Person {

    @Column(name = "dni", length = 8, unique = true, nullable = false)
    private String dni;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "paternal_last_name", length = 100, nullable = false)
    private String paternalLastName;

    @Column(name = "maternal_last_name", length = 100, nullable = false)
    private String maternalLastName;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;
}
