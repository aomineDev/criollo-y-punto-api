package pe.edu.utp.criollo_y_punto_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa un rol dentro del sistema, como por ejemplo "ADMIN", "USER", etc.
 * Cada rol tiene un identificador único y un nombre.
 *
 * Esta clase está mapeada a la tabla "roles" en la base de datos.
 * Se utiliza para gestionar los permisos y accesos de los usuarios.
 * 
 * Usa anotaciones de JPA para la persistencia y de Lombok para la generación de
 * código boilerplate.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Role {
    /**
     * Identificador único del rol.
     * Generado automáticamente por la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * Nombre del rol.
     * No puede ser nulo y tiene una longitud máxima de 50 caracteres.
     */
    @Column(name = "name", length = 50, nullable = false)
    private String name;
}