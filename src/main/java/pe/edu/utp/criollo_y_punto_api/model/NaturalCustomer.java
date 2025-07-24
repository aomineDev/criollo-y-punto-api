package pe.edu.utp.criollo_y_punto_api.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa a un cliente natural en el sistema, es decir, una persona
 * individual.
 * Hereda atributos comunes desde la clase {@link Person}.
 * 
 * Incluye información personal como DNI, nombre completo y fecha de nacimiento.
 * 
 * Esta clase está mapeada a la tabla "natural_customers" en la base de datos,
 * y utiliza anotaciones de JPA para la persistencia de datos,
 * así como Lombok para generar automáticamente los métodos boilerplate.
 * 
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "natural_customers")
public class NaturalCustomer extends Person {

    /**
     * Documento Nacional de Identidad del cliente.
     * Debe ser único, no nulo y tener una longitud de 8 caracteres.
     */
    @Column(name = "dni", length = 8, unique = true, nullable = false)
    private String dni;
    /**
     * Nombre(s) del cliente.
     * No puede ser nulo y tiene una longitud máxima de 100 caracteres.
     */
    @Column(name = "name", length = 100, nullable = false)
    private String name;
    /**
     * Apellido paterno del cliente.
     * No puede ser nulo y tiene una longitud máxima de 100 caracteres.
     */
    @Column(name = "paternal_last_name", length = 100, nullable = false)
    private String paternalLastName;
    /**
     * Apellido materno del cliente.
     * No puede ser nulo y tiene una longitud máxima de 100 caracteres.
     */
    @Column(name = "maternal_last_name", length = 100, nullable = false)
    private String maternalLastName;
    /**
     * Fecha de nacimiento del cliente.
     * Es obligatoria (no puede ser nula).
     */
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;
}
