package pe.edu.utp.criollo_y_punto_api.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import pe.edu.utp.criollo_y_punto_api.service.patron.state.CancelledOrderState;
import pe.edu.utp.criollo_y_punto_api.service.patron.state.DeliveredOrderState;
import pe.edu.utp.criollo_y_punto_api.service.patron.state.OrderState;
import pe.edu.utp.criollo_y_punto_api.service.patron.state.PendingOrderState;
import pe.edu.utp.criollo_y_punto_api.service.patron.state.PreparingOrderState;
import pe.edu.utp.criollo_y_punto_api.service.patron.state.ReadyOrderState;

/**
 * Representa un pedido realizado en el sistema.
 * Un pedido puede contener múltiples ítems y tener distintos estados en su
 * ciclo de vida.
 * 
 * Implementa el patrón de comportamiento State para manejar las transiciones de
 * estado del pedido.
 * Los estados posibles incluyen: Pendiente, En Preparación, Listo, Entregado y
 * Cancelado.
 * 
 * Esta clase está mapeada a la tabla "orders" en la base de datos y utiliza
 * anotaciones de JPA y Lombok.
 */
@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

  /**
   * Identificador único del pedido.
   * Se genera automáticamente en la base de datos.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_id")
  private Integer orderId;

  /**
   * Fecha en la que se realizó el pedido.
   * No puede ser nula.
   */
  @Column(name = "date", nullable = false)
  private LocalDate date;

  /**
   * Hora en la que se realizó el pedido.
   * No puede ser nula.
   */
  @Column(name = "time", nullable = false)
  private LocalTime time;

  /**
   * Estado actual del pedido (como texto).
   * Se inicializa por defecto como "Pendiente".
   */
  @Column(name = "status", nullable = false)
  private String status = "Pendiente";

  /**
   * Lista de ítems incluidos en el pedido.
   * Relación uno a muchos con la entidad OrderItem.
   * La cascada permite que los ítems se persistan o eliminen con el pedido.
   */
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "order_id")
  private List<OrderItem> orderItemList = new ArrayList<>();

  /**
   * Estado interno del pedido según el patrón State.
   * No se persiste en base de datos.
   */
  @Transient
  @JsonIgnore
  private OrderState state;

  /**
   * Inicializa el estado del pedido después de cargarlo desde la base de datos,
   * según el valor del campo de texto `status`.
   */
  @PostLoad
  public void initializeState() {
    switch (this.status.toUpperCase()) {
      case "PENDIENTE":
        this.state = new PendingOrderState();
        break;
      case "EN PREPARACION":
        this.state = new PreparingOrderState();
        break;
      case "LISTO":
        this.state = new ReadyOrderState();
        break;
      case "PEDIDO ENTREGADO AL CLIENTE":
        this.state = new DeliveredOrderState();
        break;
      case "CANCELADO":
        this.state = new CancelledOrderState();
        break;
      default:
        this.state = new PendingOrderState();
        break;
    }
  }

  /**
   * Constructor personalizado para crear una orden rápidamente con estado inicial
   * pendiente.
   * 
   * @param date Fecha del pedido.
   * @param time Hora del pedido.
   */
  public Order(LocalDate date, LocalTime time) {
    this.date = date;
    this.time = time;
    this.status = "PENDIENTE";
    this.state = new PendingOrderState();
  }

  /**
   * Marca el pedido como "En Preparación", delegando la lógica al estado actual.
   */
  public void startPreparation() {
    if (state == null)
      initializeState();
    state.startPreparation(this);
  }

  /**
   * Marca el pedido como "Listo", delegando la lógica al estado actual.
   */
  public void markAsReady() {
    if (state == null)
      initializeState();
    state.markList(this);
  }

  /**
   * Marca el pedido como "Entregado al Cliente", delegando la lógica al estado
   * actual.
   */
  public void deliver() {
    if (state == null)
      initializeState();
    state.deliver(this);
  }

  /**
   * Cancela el pedido, delegando la lógica al estado actual.
   */
  public void cancel() {
    if (state == null)
      initializeState();
    state.cancel(this);
  }
}