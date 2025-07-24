package pe.edu.utp.criollo_y_punto_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.utp.criollo_y_punto_api.model.MenuCategory;
import pe.edu.utp.criollo_y_punto_api.service.MenuCategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/menu-category")
public class MenuCategoryController {
  @Autowired
  private MenuCategoryService service;

  @GetMapping
  public ResponseEntity<List<MenuCategory>> getMenuCategoryList() {
    return ResponseEntity.ok(service.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<MenuCategory> getMenuCategory(@PathVariable Integer id) {
    return service.get(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<MenuCategory> createMenuCategory(@RequestBody MenuCategory menuCategory) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(menuCategory));
  }

  @PutMapping("/{id}")
  public ResponseEntity<MenuCategory> updateMenuCategory(@PathVariable Integer id,
      @RequestBody MenuCategory menuCategory) {
    return service.update(id, menuCategory)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteMenuCategory(@PathVariable Integer id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
