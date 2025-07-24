package pe.edu.utp.criollo_y_punto_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PutMapping("/{id}")
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable Integer id, @RequestBody MenuItem updatedMenuItem) {
        MenuItem existingMenuItem = menuItemService.get(id);

        if (existingMenuItem == null) {
            return ResponseEntity.notFound().build();
        }

        if (updatedMenuItem.getName() != null && !updatedMenuItem.getName().trim().isEmpty()) {
            existingMenuItem.setName(updatedMenuItem.getName());
        }

        if (updatedMenuItem.getDescription() != null && !updatedMenuItem.getDescription().trim().isEmpty()) {
            existingMenuItem.setDescription(updatedMenuItem.getDescription());
        }

        if (updatedMenuItem.getImage() != null && !updatedMenuItem.getImage().trim().isEmpty()) {
            existingMenuItem.setImage(updatedMenuItem.getImage());
        }

        if (updatedMenuItem.getPrice() != null && updatedMenuItem.getPrice() > 0) {
            existingMenuItem.setPrice(updatedMenuItem.getPrice());
        }

        if (updatedMenuItem.getMenuCategory() != null) {
            existingMenuItem.setMenuCategory(updatedMenuItem.getMenuCategory());
        }

        MenuItem savedMenuItem = menuItemService.save(existingMenuItem);
        return ResponseEntity.ok(savedMenuItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Integer id) {
        MenuItem menuItem = menuItemService.get(id);

        if (menuItem == null) {
            return ResponseEntity.notFound().build();
        }

        menuItemService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
