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

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_id")
  private Integer orderId;

  @Column(name = "date", nullable = false)
  private LocalDate date;

  @Column(name = "time", nullable = false)
  private LocalTime time;

  @Column(name = "status", nullable = false)
  private String status = "Pendiente";

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "order_id")
  private List<OrderItem> orderItemList = new ArrayList<>();

  @Transient
  @JsonIgnore
  private OrderState state;

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

  // Constructor con inicialización directa del estado
  public Order(LocalDate date, LocalTime time, String tableNumber, String customerName) {
    this.date = date;
    this.time = time;
    this.status = "PENDIENTE";
    this.state = new PendingOrderState();
  }

  // Métodos de comportamiento delegados al state
  public void startPreparation() {
    if (state == null)
      initializeState();
    state.startPreparation(this);
  }

  public void markAsReady() {
    if (state == null)
      initializeState();
    state.markList(this);
  }

  public void deliver() {
    if (state == null)
      initializeState();
    state.deliver(this);
  }

  public void cancel() {
    if (state == null)
      initializeState();
    state.cancel(this);
  }
}
