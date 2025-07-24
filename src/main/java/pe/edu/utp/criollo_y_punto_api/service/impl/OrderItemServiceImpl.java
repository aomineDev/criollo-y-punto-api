package pe.edu.utp.criollo_y_punto_api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.criollo_y_punto_api.model.OrderItem;
import pe.edu.utp.criollo_y_punto_api.repository.OrderItemRepository;
import pe.edu.utp.criollo_y_punto_api.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> getAll() {
        return orderItemRepository.findAll();
    }

    @Override
    public Optional<OrderItem> get(Integer orderItemId) {
        return orderItemRepository.findById(orderItemId);
    }

    @Override
    public OrderItem save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public Optional<OrderItem> update(Integer id, OrderItem orderItem) {
        return orderItemRepository.findById(id).map(existingOrderItem -> {
            orderItem.setOrderItemId(id);

            return orderItemRepository.save(orderItem);
        });
    }

    @Override
    public void delete(Integer orderItemId) {
        orderItemRepository.deleteById(orderItemId);
    }
}
