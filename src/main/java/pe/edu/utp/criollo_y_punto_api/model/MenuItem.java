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
 * Representa un ítem del menú en el sistema del restaurante.
 * Contiene detalles como el nombre, precio, descripción, disponibilidad e
 * imagen del platillo.
 * 
 * Está relacionado con una categoría de menú {@link MenuCategory},
 * lo que permite agrupar ítems por tipo (por ejemplo: Entradas, Bebidas, etc.).
 * 
 * Esta clase está mapeada a la tabla "menu_items" de la base de datos.
 * Utiliza anotaciones de JPA para definir su persistencia,
 * y Lombok para generar automáticamente getters, setters y constructores.
 * 
 */
@Entity
@Table(name = "menu_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem {
  /**
   * Identificador único del ítem de menú.
   * Es generado automáticamente por la base de datos.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "menu_item_id")
  private Integer menuItemId;
  /**
   * Nombre del ítem del menú (por ejemplo, "Ceviche Mixto").
   * Debe ser único y no nulo.
   */
  @Column(name = "name", unique = true, nullable = false)
  private String name;
  /**
   * Descripción opcional del ítem, puede incluir ingredientes o detalles del
   * platillo.
   */
  @Column(name = "description")
  private String description;
  /**
   * Indica si el ítem está disponible actualmente en el menú.
   * No puede ser nulo.
   */
  @Column(name = "available", nullable = false)
  private boolean available;
  /**
   * Imagen del ítem del menú. Puede ser una URL o nombre de archivo.
   */
  @Column(name = "image")
  private String image;
  /**
   * Precio del ítem del menú.
   * No puede ser nulo.
   */
  @Column(name = "price", nullable = false)
  private Double price;
  /**
   * Categoría del menú a la que pertenece este ítem.
   * Si la categoría es eliminada, se establece en null (SET_NULL).
   */
  @ManyToOne
  @JoinColumn(name = "menu_category_id")
  @OnDelete(action = OnDeleteAction.SET_NULL)
  private MenuCategory menuCategory;
}
