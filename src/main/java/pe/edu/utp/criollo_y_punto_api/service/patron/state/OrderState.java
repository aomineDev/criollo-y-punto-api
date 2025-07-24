package pe.edu.utp.criollo_y_punto_api.service.patron.state;

import pe.edu.utp.criollo_y_punto_api.model.Order;

public interface OrderState {
    void startPreparation(Order order);

    void markList(Order order);

    void deliver(Order order);

    void cancel(Order order);

    String getStateName();
}