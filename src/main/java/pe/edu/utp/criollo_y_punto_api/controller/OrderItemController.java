package pe.edu.utp.criollo_y_punto_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.utp.criollo_y_punto_api.model.OrderItem;
import pe.edu.utp.criollo_y_punto_api.service.OrderItemService;

@RestController
@RequestMapping("/api/order-item")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping()
    public ResponseEntity<List<OrderItem>> getOrderItem() {
        return ResponseEntity.ok(orderItemService.getAll());
    }

    @PostMapping()
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderItemService.save(orderItem));
    }

}