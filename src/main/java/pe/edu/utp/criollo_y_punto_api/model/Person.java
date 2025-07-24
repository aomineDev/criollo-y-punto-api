package pe.edu.utp.criollo_y_punto_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase abstracta que representa una persona en el sistema.
 * Sirve como superclase para clientes naturales y jurídicos.
 * 
 * Está mapeada a la tabla "people" en la base de datos y utiliza
 * la estrategia de herencia {@code JOINED}, lo que permite que
 * cada subclase tenga su propia tabla relacionada por clave primaria.
 * 
 * Usa anotaciones de Lombok para generar constructores, getters y setters
 * automáticamente.
 */
@Entity
@Table(name = "people")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Person {

    /**
     * Identificador único de la persona.
     * Se genera automáticamente por la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    protected Integer personId;

    /**
     * Dirección física de la persona.
     * Campo opcional con longitud máxima de 100 caracteres.
     */
    @Column(name = "address", length = 100)
    protected String address;

    /**
     * Número de teléfono de la persona.
     * Debe ser único y tener una longitud máxima de 9 caracteres.
     */
    @Column(name = "phone_number", length = 9, unique = true)
    protected String phoneNumber;

    /**
     * Correo electrónico de la persona.
     * Debe ser único y tener una longitud máxima de 100 caracteres.
     */
    @Column(name = "email", unique = true, length = 100)
    protected String email;
}