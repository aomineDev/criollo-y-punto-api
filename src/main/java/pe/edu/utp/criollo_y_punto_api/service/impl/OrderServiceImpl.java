package pe.edu.utp.criollo_y_punto_api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.criollo_y_punto_api.model.Order;
import pe.edu.utp.criollo_y_punto_api.repository.OrderRepository;
import pe.edu.utp.criollo_y_punto_api.service.OrderService;

/*
 * Este servicio implementa la lógica de negocio para la entidad Order, permitiendo gestionar sus operaciones básicas
 *  como listar, obtener, guardar, actualizar y eliminar entradas de Order. Utiliza OrderRepository para interactuar
 *  con la base de datos, delegando las operaciones CRUD a través de métodos proporcionados por JpaRepository, 
 * lo que facilita el acceso a los datos sin necesidad de escribir consultas manuales.
 */
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
    public Optional<Order> get(Integer orderId) {
        return orderRepository.findById(orderId);
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
    public Optional<Order> update(Integer id, Order order) {
        return orderRepository.findById(id).map(existingOrder -> {
            order.setOrderId(id);

            order.initializeState();
            return orderRepository.save(order);
        });
    }

    @Override
    public void delete(Integer orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public Order startPreparation(Integer orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.startPreparation();
            return save(order);
        }
        return null;
    }

    @Override

    public Order markAsReady(Integer orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.markAsReady();
            return save(order);
        }
        return null;
    }

    @Override

    public Order deliverOrder(Integer orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.deliver();
            return save(order);
        }
        return null;
    }

    @Override
    public Order cancelOrder(Integer orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.cancel();
            return save(order);
        }
        return null;
    }

}
