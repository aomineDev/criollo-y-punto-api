package pe.edu.utp.criollo_y_punto_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.utp.criollo_y_punto_api.model.Blog;
import pe.edu.utp.criollo_y_punto_api.service.BlogService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/blog")
public class BlogController {
  @Autowired
  private BlogService service;

  @GetMapping
  public ResponseEntity<List<Blog>> getBlogList() {
    return ResponseEntity.ok(service.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Blog> getBlog(@PathVariable Integer id) {
    return service.get(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
    Blog createdBlog = service.save(blog);

    return ResponseEntity.status(HttpStatus.CREATED).body(createdBlog);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Blog> updateBlog(@PathVariable Integer id,
      @RequestBody Blog blog) {
    return service.update(id, blog)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteBlog(@PathVariable Integer id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

}
