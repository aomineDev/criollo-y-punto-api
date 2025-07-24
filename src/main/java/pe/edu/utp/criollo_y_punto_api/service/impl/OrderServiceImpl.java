package pe.edu.utp.criollo_y_punto_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.criollo_y_punto_api.model.Order;
import pe.edu.utp.criollo_y_punto_api.repository.OrderRepository;
import pe.edu.utp.criollo_y_punto_api.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        List<Order> orders = orderRepository.findAll();
        orders.forEach(Order::initializeState);
        return orders;
    }

    @Override
    public Order get(Integer orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.initializeState();
        }
        return order;
        // return orderRepository.findById(orderId).orElse(null);
    }

    @Override
    public Order save(Order order) {
        if (order.getStatus() == null) {
            order.setStatus("PENDIENTE");
        }
        order.initializeState();
        return orderRepository.save(order);
        // return orderRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        order.initializeState();
        return orderRepository.save(order);
    }

    @Override
    public void delete(Integer orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override

    public Order startPreparation(Integer orderId) {
        Order order = get(orderId);
        if (order != null) {
            order.startPreparation();
            return save(order);
        }
        return null;
    }

    @Override

    public Order markAsReady(Integer orderId) {
        Order order = get(orderId);
        if (order != null) {
            order.markAsReady();
            return save(order);
        }
        return null;
    }

    @Override

    public Order deliverOrder(Integer orderId) {
        Order order = get(orderId);
        if (order != null) {
            order.deliver();
            return save(order);
        }
        return null;
    }

    @Override
    public Order cancelOrder(Integer orderId) {
        Order order = get(orderId);
        if (order != null) {
            order.cancel();
            return save(order);
        }
        return null;
    }

}
