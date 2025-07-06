package pe.edu.utp.criollo_y_punto_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.utp.criollo_y_punto_api.model.Order;
import pe.edu.utp.criollo_y_punto_api.repository.OderRepository;
import pe.edu.utp.criollo_y_punto_api.service.OrderService;

public class OrderImpl implements OrderService{

    @Autowired
    private OderRepository oderRepository;

    @Override
    public List<Order> getAll() {
        
    }

    @Override
    public Order get(Integer orderId) {
        
    }

    @Override
    public Order save(Order order) {
        
    }

    @Override
    public Order update(Order order) {
        
    }

    @Override
    public void delete(Integer orderId) {
        
    }

    


}
