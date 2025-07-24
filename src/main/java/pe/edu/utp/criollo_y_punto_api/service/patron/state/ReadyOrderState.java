package pe.edu.utp.criollo_y_punto_api.service.patron.state;

import pe.edu.utp.criollo_y_punto_api.model.Order;

public class ReadyOrderState implements OrderState {

    @Override
    public void startPreparation(Order order) {
        System.out.println("El pedido ya fue preparado");
    }

    @Override
    public void markList(Order order) {
        System.out.println("El pedido ya está listo");
    }

    @Override
    public void deliver(Order order) {
        System.out.println("Entregando pedido ID: " + order.getOrderId());
        order.setState(new DeliveredOrderState());
        order.setStatus("ENTREGADO");
        System.out.println("Pedido entregado exitosamente");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Cancelando pedido listo ID: " + order.getOrderId());
        order.setState(new CancelledOrderState());
        order.setStatus("CANCELADO");
        System.out.println("Pedido cancelado (estaba listo)");
    }

    @Override
    public String getStateName() {
        return "LISTO";
    }

}
