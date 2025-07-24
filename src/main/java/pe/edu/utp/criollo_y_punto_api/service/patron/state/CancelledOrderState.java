package pe.edu.utp.criollo_y_punto_api.service.patron.state;

import pe.edu.utp.criollo_y_punto_api.model.Order;

public class CancelledOrderState implements OrderState {

    @Override
    public void startPreparation(Order order) {
        System.out.println("No se puede preparar un pedido cancelado");
    }

    @Override
    public void markList(Order order) {
        System.out.println("No se puede marcar como listo un pedido cancelado");
    }

    @Override
    public void deliver(Order order) {
        System.out.println("No se puede entregar un pedido cancelado");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("El pedido ya está cancelado");
    }

    @Override
    public String getStateName() {
        return "CANCELADO";
    }

}
