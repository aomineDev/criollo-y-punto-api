package pe.edu.utp.criollo_y_punto_api.service;

import pe.edu.utp.criollo_y_punto_api.model.Order;

public interface OrderService extends ApiService<Order> {
    Order startPreparation(Integer orderId);

    Order markAsReady(Integer orderId);

    Order deliverOrder(Integer orderId);

    Order cancelOrder(Integer orderId);
}
