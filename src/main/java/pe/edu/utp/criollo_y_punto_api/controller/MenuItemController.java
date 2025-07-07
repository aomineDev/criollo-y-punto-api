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

import pe.edu.utp.criollo_y_punto_api.model.MenuItem;
import pe.edu.utp.criollo_y_punto_api.service.MenuItemService;

@RestController
@RequestMapping("/api/menu-item")
public class MenuItemController {
    @Autowired
    private MenuItemService menuItemService;

    @GetMapping()
    public ResponseEntity<List<MenuItem>> getMenuItem() {
        return ResponseEntity.ok(menuItemService.getAll());
    }

    @PostMapping()
    public ResponseEntity<MenuItem> createMenuItem(@RequestBody MenuItem menuItem) {
        return ResponseEntity.status(HttpStatus.CREATED).body(menuItemService.save(menuItem));
    }

}
