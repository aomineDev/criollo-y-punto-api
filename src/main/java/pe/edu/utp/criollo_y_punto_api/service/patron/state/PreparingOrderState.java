package pe.edu.utp.criollo_y_punto_api.service.patron.state;

import pe.edu.utp.criollo_y_punto_api.model.Order;

public class PreparingOrderState implements OrderState {

    @Override
    public void startPreparation(Order order) {
        System.out.println("El pedido ya esta en preparacion con el ID " + order.getOrderId());
    }

    @Override
    public void markList(Order order) {
        System.out.println("Marcando pedido como listo ID: " + order.getOrderId());
        order.setState(new ReadyOrderState());
        order.setStatus("LISTO");
        System.out.println("Pedido listo para entregar");
    }

    @Override
    public void deliver(Order order) {
        System.out.println("No se puede entregar un pedido en preparación");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Cancelando pedido en preparación ID: " + order.getOrderId());
        order.setState(new CancelledOrderState());
        order.setStatus("CANCELADO");
        System.out.println("Pedido cancelado durante preparación");
    }

    @Override
    public String getStateName() {
        return "EN PREPARACION";
    }

}
