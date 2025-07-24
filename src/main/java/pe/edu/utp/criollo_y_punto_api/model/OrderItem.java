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
 * Representa un ítem específico dentro de una orden realizada en el sistema.
 * Cada ítem corresponde a un plato del menú y contiene la cantidad solicitada.
 * 
 * Esta clase está mapeada a la tabla "order_items" en la base de datos.
 * Utiliza anotaciones de JPA para la persistencia de datos,
 * y Lombok para generar automáticamente getters, setters y constructores.
 * 
 * Se relaciona con la entidad {@link MenuItem}, que representa el producto del
 * menú.
 */
@Entity
@Table(name = "order_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
  /**
   * Identificador único del ítem de la orden.
   * Generado automáticamente por la base de datos.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_item_id")
  private Integer orderItemId;
  /**
   * Cantidad del ítem solicitada en la orden.
   * Es obligatorio (no puede ser nulo).
   */
  @Column(name = "quantity", nullable = false)
  private Integer quantity;
  /**
   * Descripción adicional del ítem en la orden.
   * Campo opcional.
   */
  @Column(name = "description")
  private String description;
  /**
   * Producto del menú asociado a este ítem.
   * Se elimina la referencia (se asigna null) si el menú es eliminado.
   */
  @ManyToOne
  @JoinColumn(name = "menu_item_id")
  @OnDelete(action = OnDeleteAction.SET_NULL)
  private MenuItem menuItem;
}
