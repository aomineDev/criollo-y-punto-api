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

@Entity
@Table(name = "order_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_item_id")
  private Integer orderItemId;

  @Column(name = "quantity", nullable = false)
  private Integer quantity;

  @Column(name = "description")
  private String description;

  @ManyToOne
  @JoinColumn(name = "menu_item_id")
  @OnDelete(action = OnDeleteAction.SET_NULL)
  private MenuItem menuItem;
}
