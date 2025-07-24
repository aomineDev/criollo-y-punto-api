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
 * Representa una mesa en el sistema del restaurante.
 * 
 * Contiene información como el número de la mesa, su disponibilidad
 * y la capacidad de personas que puede atender.
 * 
 * Esta clase está mapeada a la tabla "board" de la base de datos.
 * 
 * Utiliza anotaciones de JPA para definir la persistencia de los datos.
 */
@Entity
@Table(name = "boards")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Board {
  /**
   * Identificador único de la mesa.
   * Es generado automáticamente por la base de datos.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "board_id")
  private Integer boardId;
  /**
   * Número de la mesa (por ejemplo, "M1", "M2").
   * Debe ser único y no puede ser nulo.
   */
  @Column(name = "number", unique = true, nullable = false)
  private String number;
  /**
   * Indica si la mesa está disponible (true) o no (false).
   * No puede ser nulo.
   */
  @Column(name = "available", nullable = false)
  private boolean available;

  /**
   * Capacidad máxima de personas que puede sentarse en esta mesa.
   * No puede ser nula.
   */
  @Column(name = "capacity", nullable = false)
  private Integer capacity;
}
