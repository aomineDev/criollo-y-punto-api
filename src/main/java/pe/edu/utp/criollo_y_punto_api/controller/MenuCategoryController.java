package pe.edu.utp.criollo_y_punto_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.utp.criollo_y_punto_api.model.MenuCategory;
import pe.edu.utp.criollo_y_punto_api.service.MenuCategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/menu-category")
public class MenuCategoryController {
  @Autowired
  private MenuCategoryService menuCategoryService;

  @GetMapping
  public ResponseEntity<List<MenuCategory>> getMenuCategoryList() {
    return ResponseEntity.ok(menuCategoryService.getAll());
  }

  @PostMapping
  public ResponseEntity<MenuCategory> createMenuCategory(@RequestBody MenuCategory menuCategory) {
    return ResponseEntity.status(HttpStatus.CREATED).body(menuCategoryService.save(menuCategory));
  }

}
