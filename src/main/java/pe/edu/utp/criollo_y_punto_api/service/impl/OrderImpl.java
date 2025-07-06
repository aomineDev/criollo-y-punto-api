package pe.edu.utp.criollo_y_punto_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.criollo_y_punto_api.model.Order;
import pe.edu.utp.criollo_y_punto_api.repository.OrderRepository;
import pe.edu.utp.criollo_y_punto_api.service.OrderService;

@Service
public class OrderImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order get(Integer orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void delete(Integer orderId) {
        orderRepository.deleteById(orderId);
    }

}
