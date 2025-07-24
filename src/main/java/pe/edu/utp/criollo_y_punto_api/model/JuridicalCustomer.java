package pe.edu.utp.criollo_y_punto_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa un cliente jurídico en el sistema, como una empresa o institución.
 * Hereda de la clase {@link Person}, compartiendo atributos comunes con otras
 * entidades personales.
 * 
 * Contiene información relevante como el RUC, razón social, tipo de entidad,
 * actividad económica y tipo de facturación.
 * 
 * Esta clase está mapeada a la tabla "juridical_customers" en la base de datos.
 * Utiliza anotaciones de JPA para definir la persistencia, y Lombok para
 * generar
 * automáticamente getters, setters y constructores.
 * 
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "juridical_customers")
public class JuridicalCustomer extends Person {
    /**
     * Registro Único de Contribuyentes (RUC) del cliente.
     * Debe tener 11 caracteres, ser único y no nulo.
     */
    @Column(name = "ruc", length = 11, nullable = false, unique = true)
    private String ruc;
    /**
     * Razón social del cliente jurídico.
     * No puede ser nula.
     */
    @Column(name = "social_reasson", length = 100, nullable = false)
    private String socialReasson;
    /**
     * Tipo de entidad jurídica (por ejemplo, S.A.C., S.A., ONG, etc.).
     */
    @Column(name = "type")
    private String type;
    /**
     * Descripción de la actividad económica que realiza el cliente jurídico.
     * Es un campo opcional y puede tener hasta 400 caracteres.
     */
    @Column(name = "activity_economic", length = 400)
    private String activityEconomic;
    /**
     * Tipo de facturación que maneja el cliente jurídico (electrónica, física,
     * etc.).
     * Es obligatorio y tiene un límite de 100 caracteres.
     */
    @Column(name = "type_billing", nullable = false, length = 100)
    private String typeBilling;
}
