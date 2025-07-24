package pe.edu.utp.criollo_y_punto_api.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa un usuario del sistema con credenciales de acceso.
 * 
 * Cada usuario tiene un nombre de usuario único y una contraseña.
 * Además, está asociado a un rol que define sus permisos y nivel de acceso
 * dentro del sistema.
 * 
 * Esta clase está mapeada a la tabla "users" de la base de datos.
 * Utiliza anotaciones de JPA para definir las relaciones y restricciones,
 * así como anotaciones de Lombok para generar automáticamente getters, setters
 * y constructores.
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * Identificador único del usuario.
     * Se genera automáticamente en la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    /**
     * Nombre de usuario único.
     * Es obligatorio y tiene un máximo de 30 caracteres.
     */
    @Column(name = "username", length = 30, nullable = false, unique = true)
    private String username;

    /**
     * Contraseña del usuario.
     * Es obligatoria y puede tener hasta 100 caracteres.
     */
    @Column(name = "password", length = 100, nullable = false)
    private String password;

    /**
     * Rol asignado al usuario.
     * Define los permisos de acceso del usuario en el sistema.
     * Si el rol se elimina, esta relación se establece en NULL.
     */
    @ManyToOne
    @JoinColumn(name = "role_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Role role;
}
