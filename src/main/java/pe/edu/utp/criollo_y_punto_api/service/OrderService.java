package pe.edu.utp.criollo_y_punto_api.service;

import java.util.List;

import pe.edu.utp.criollo_y_punto_api.model.Order;

public interface OrderService {

    List<Order> getAll();

    Order get(Integer orderId);

    Order save(Order order);

    Order update(Order order);

    void delete(Integer orderId);

}
