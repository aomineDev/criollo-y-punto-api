package pe.edu.utp.criollo_y_punto_api.service.patron.state;

import pe.edu.utp.criollo_y_punto_api.model.Order;

public class DeliveredOrderState implements OrderState {

    @Override
    public void startPreparation(Order order) {
        System.out.println("No se puede preparar un pedido ya entregado");
    }

    @Override
    public void markList(Order order) {
        System.out.println("No se puede marcar como listo un pedido ya entregado");
    }

    @Override
    public void deliver(Order order) {
        System.out.println("El pedido ya fue entregado");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("No se puede cancelar un pedido ya entregado");
    }

    @Override
    public String getStateName() {
        return "PEDIDO ENTREGADO AL CLIENTE";
    }

}
