package pe.edu.utp.criollo_y_punto_api.service.patron.state;

import pe.edu.utp.criollo_y_punto_api.model.Order;

public class PendingOrderState implements OrderState {

    @Override
    public void startPreparation(Order order) {
        System.out.println("Iniciando preparacion del pedido ID" + order.getOrderId());
        order.setState(new PendingOrderState());
        order.setStatus("EN PREPARACION");
        System.out.println("Pedido en preparacion");

    }

    @Override
    public void markList(Order order) {
        System.out.println("No se puede marcar como listo un pedido pendiente");
    }

    @Override
    public void deliver(Order order) {
        System.out.println("No se puede entregar un pedido pendiente");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Cancelando pedido pendiente ID" + order.getOrderId());
        order.setState(new CancelledOrderState());
        order.setStatus("CANCELADO");
        System.out.println("Pedido cancelado exitosamente");
    }

    @Override
    public String getStateName() {
        return "PENDIENTE";
    }

}
