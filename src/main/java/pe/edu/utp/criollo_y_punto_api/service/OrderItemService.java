package pe.edu.utp.criollo_y_punto_api.service;

import java.util.List;

import pe.edu.utp.criollo_y_punto_api.model.OrderItem;

public interface OrderItemService {

    List<OrderItem> getAll();

    OrderItem get(Integer orderItemId);

    OrderItem save(OrderItem orderItem);

    OrderItem update(OrderItem orderItem);

    void delete(Integer orderItemId);

}
