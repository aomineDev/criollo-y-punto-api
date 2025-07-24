package pe.edu.utp.criollo_y_punto_api.model;

import java.time.LocalDate;
import java.time.LocalTime;

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
 * Representa una entrada de blog en el sistema.
 * Contiene información sobre la fecha, hora, título, contenido e imagen del
 * blog.
 * 
 * Esta clase está mapeada a la tabla "blogs" de la base de datos.
 * Utiliza anotaciones de JPA para definir la persistencia de los datos.
 * 
 * Se usan anotaciones de Lombok para generar automáticamente getters, setters,
 * constructores con y sin argumentos.
 */
@Entity
@Table(name = "blogs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    /**
     * Identificador único del blog.
     * Es generado automáticamente por la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private Integer blogId;

    /**
     * Fecha en la que se publica el blog.
     * No puede ser nula.
     */
    @Column(name = "date", nullable = false)
    private LocalDate date;

    /**
     * Hora en la que se publica el blog.
     * No puede ser nula.
     */
    @Column(name = "time", nullable = false)
    private LocalTime time;

    /**
     * Título del blog.
     * No puede ser nulo.
     */
    @Column(name = "title", nullable = false)
    private String title;

    /**
     * Contenido principal del blog.
     * No puede ser nulo.
     */
    @Column(name = "content", nullable = false)
    private String content;

    /**
     * URL o nombre del archivo de la imagen asociada al blog.
     * No puede ser nulo.
     */
    @Column(name = "image", nullable = false)
    private String image;
}
