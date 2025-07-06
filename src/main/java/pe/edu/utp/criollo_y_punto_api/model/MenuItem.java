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
@Table(name = "menu_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "menu_item_id")
  private Integer menuItemId;

  @Column(name = "name", unique = true, nullable = false)
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "available", nullable = false)
  private boolean available;

  @Column(name = "image")
  private String image;

  @Column(name = "price", nullable = false)
  private Double price;

  @ManyToOne
  @JoinColumn(name = "menu_category_id")
  @OnDelete(action = OnDeleteAction.SET_NULL)
  private MenuCategory menuCategory;

}
