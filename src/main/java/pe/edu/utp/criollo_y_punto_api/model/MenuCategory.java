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
 * Representa una categoría del menú en el sistema del restaurante.
 * Cada categoría agrupa distintos platos o ítems del menú (por ejemplo:
 * Entradas, Bebidas, Postres).
 *
 * Esta clase está mapeada a la tabla "menu_categories" en la base de datos.
 * Utiliza anotaciones de JPA para definir cómo se persiste cada campo.
 * También se usa Lombok para generar automáticamente getters, setters
 * y constructores con/sin argumentos.
 * 
 */
@Entity
@Table(name = "menu_categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuCategory {
  /**
   * Identificador único de la categoría de menú.
   * Es generado automáticamente por la base de datos.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "menu_category_id")
  private Integer menuCategoryId;

  /**
   * Nombre de la categoría del menú (por ejemplo, "Bebidas").
   * Debe ser único y no puede ser nulo.
   */
  @Column(name = "name", unique = true, nullable = false)
  private String name;

  /**
   * Descripción opcional de la categoría, utilizada para dar más contexto.
   */
  @Column(name = "description")
  private String description;
  /**
   * Imagen asociada a la categoría, puede ser una URL o nombre de archivo.
   */
  @Column(name = "image")
  private String image;
}
